package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PhotoManageDao;
import com.form.PhotoManage;
import com.util.IOUtil;

public class queryWriteServlet extends HttpServlet {

	private static final long serialVersionUID = -6139356350763978436L;

	public static final String FILEURL = "d:\\photo\\";
	public static final String ENDSTR = ".jpg";
	
	/**
	 * 备份URL
	 */
	public static final String BAK_URL = "d:\\photo_bak\\";
	
	public queryWriteServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resq){
		/********1、读取所有照片数据*********/
		List<PhotoManage> listp = null;
		try {
			listp = new PhotoManageDao().findALLWrite();
		} catch (Exception e) {
			System.out.println("af_photo_manage读取照片数据失败");
			e.printStackTrace();
		}
		/********2、对比是否存在 做备份 IO流写入*********/
		 String purl ;
		 String pname;
		 try {
			 for (PhotoManage pm : listp) {
					pname = pm.getIdcard().replace("A", "00").replace("B", "00").replace("C", "00").replace("D", "00");
					purl = FILEURL + pname + ENDSTR;
					IOUtil.isPhotoAndCopy(purl, BAK_URL + pname + ENDSTR);
					IOUtil.writeBytesToFile(pm.getPhoto(), purl);
				}
		} catch (IOException e) {
			System.out.println("af_photo_manage照片操作照片IO异常。。");
			e.printStackTrace();
		}
		/********3、更新后清空表*********/
		 try {
			 int n = new PhotoManageDao().delAll();
			 System.out.println("af_photo_manage删除零时数据共------" + n);
		} catch (Exception e) {
			System.out.println("af_photo_manage删除照片数据失败");
			e.printStackTrace();
		}
		
	}
	
	
	public void init() throws ServletException {
		// Put your code here
	}

//	private String convertIdcard(String idcard){
//		idcard.replace("A", "").replace("B", "").replace("C", "").replace("D", "");
//	}
}
