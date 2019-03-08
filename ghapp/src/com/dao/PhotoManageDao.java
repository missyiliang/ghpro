package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.form.PhotoManage;

public class PhotoManageDao extends BaseDao{

	/**
	 * ����������Ҫ������Ƭ������
	 * @return
	 */
	public List<PhotoManage> findALLWrite(){
		String sql = "select t.ID, t.IDCARD, t.PHOTO from AFP_PHOTO_MANAGE t ";
		
		List<PhotoManage> plist = new ArrayList<PhotoManage>();
		PhotoManage pto = null;
		try {
			conn = super.getConn();
			p = conn.prepareStatement(sql);
			res = p.executeQuery();
			while(res != null && res.next()){
				pto = new PhotoManage();
				pto.setId(res.getInt("ID"));
				pto.setIdcard(res.getString("IDCARD"));
				pto.setPhoto(res.getBytes("PHOTO"));
				plist.add(pto);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll(conn, p, res);
		}
		return plist;
	}
	
	/**
	 * ɾ����ʱ����
	 * @return
	 */
	public int delAll(){
		return  super.executeSQL("delete AFP_PHOTO_MANAGE", null);
	}
}
