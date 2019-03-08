package com.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtil {

	/**
	 * byte 照片流 写入文件
	 * @param bs
	 * @param url
	 * @throws IOException
	 */
	public static void writeBytesToFile(byte[] bs, String url) throws IOException {
		if(bs != null){
			InputStream is = null;
			OutputStream out = null;
			try {
				out = new FileOutputStream(url);
				is = new ByteArrayInputStream(bs);
				byte[] buff = new byte[1024];
				int len = 0;
				while ((len = is.read(buff)) != -1) {
					out.write(buff, 0, len);
				}
			}finally{
				if(is != null){
					is.close();
				}
				if(out != null){
					out.close();
				}
			}
		}
	}

	/**
	 * 照片是否存在 存在就copy到备份然后删除
	 * 
	 * @param url
	 * @param newurl
	 * @throws IOException
	 */
	public static void isPhotoAndCopy(String url, String newurl) throws IOException {
		File f = new File(url);
		if (f.exists()) {// 存在就COPY--然后删除
			InputStream input = null;
			OutputStream out = null;
			try {
				input = new FileInputStream(f);
				File f2 = new File(newurl);
				if(!f2.exists()){
					f2.createNewFile();
				}
				out = new FileOutputStream(f2);
				byte[] b = new byte[1024];
				int bread;
				while ((bread = input.read(b)) > 0) {
					out.write(b, 0, bread);
				}
			} finally {
				if(input != null){
					input.close();
				}
				if(out != null){
					out.close();
				}
			}
			f.delete();
		}
	}
}
