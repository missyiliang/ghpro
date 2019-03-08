package com.task;

import java.io.IOException;
import java.util.List;
import java.util.TimerTask;

import com.dao.PhotoManageDao;
import com.form.PhotoManage;
import com.util.IOUtil;

public class TestTask extends TimerTask{
    
    private static boolean isRunning = false;  
    
	public static final String FILEURL = "d:\\photo\\";
	public static final String ENDSTR = ".jpg";
	
	/**
	 * 备份URL
	 */
	public static final String BAK_URL = "d:\\photo_bak\\";
	
    @Override  
    public void run() {  
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
		 int num = 0;
		 try {
			 for (PhotoManage pm : listp) {
					pname = pm.getIdcard().replace("A", "00").replace("B", "00")
								.replace("C", "00").replace("D", "00");
					purl = FILEURL + pname + ENDSTR;
					IOUtil.isPhotoAndCopy(purl, BAK_URL + pname + ENDSTR);
					IOUtil.writeBytesToFile(pm.getPhoto(), purl);
					num ++;
				}
			
		} catch (IOException e) {
			System.out.println("af_photo_manage照片操作照片IO异常。。");
			e.printStackTrace();
		}
		System.out.println("af_photo_manage照片共更新了照片数-----" + num);
		/********3、更新后清空表*********/
		 try {
			 int n = new PhotoManageDao().delAll();
			 System.out.println("af_photo_manage删除零时数据共------" + n);
		} catch (Exception e) {
			System.out.println("af_photo_manage删除照片数据失败");
			e.printStackTrace();
		}
    }  

}
