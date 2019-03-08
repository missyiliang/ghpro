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
	 * ����URL
	 */
	public static final String BAK_URL = "d:\\photo_bak\\";
	
    @Override  
    public void run() {  
    	/********1����ȡ������Ƭ����*********/
		List<PhotoManage> listp = null;
		try {
			listp = new PhotoManageDao().findALLWrite();
		} catch (Exception e) {
			System.out.println("af_photo_manage��ȡ��Ƭ����ʧ��");
			e.printStackTrace();
		}
		/********2���Ա��Ƿ���� ������ IO��д��*********/
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
			System.out.println("af_photo_manage��Ƭ������ƬIO�쳣����");
			e.printStackTrace();
		}
		System.out.println("af_photo_manage��Ƭ����������Ƭ��-----" + num);
		/********3�����º���ձ�*********/
		 try {
			 int n = new PhotoManageDao().delAll();
			 System.out.println("af_photo_manageɾ����ʱ���ݹ�------" + n);
		} catch (Exception e) {
			System.out.println("af_photo_manageɾ����Ƭ����ʧ��");
			e.printStackTrace();
		}
    }  

}
