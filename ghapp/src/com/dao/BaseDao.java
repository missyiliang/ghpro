package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {

	Connection  conn=null;
	PreparedStatement p=null;
	ResultSet res=null;
	
	public static final String DRIVER="oracle.jdbc.driver.OracleDriver";  
    public static final String URL="jdbc:oracle:thin:@10.110.47.1:1521:oatestdb"; 
    public static final String USERNAME="oagcglxt";  
    public static final String PWD="oagcglxt";
//  public static final String URL="jdbc:oracle:thin:@(description=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.110.40.21)(PORT=1521)))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=zsgxoltp)))";
//
//	public static final String USERNAME="oamh";  
//	public static final String PWD="oamh"; 
  
    public Connection getConn() throws ClassNotFoundException,SQLException{  
        Class.forName(DRIVER);  
        conn=DriverManager.getConnection(URL, USERNAME, PWD);
        return conn;
    }  
      
    public void closeAll(Connection conn,PreparedStatement p,ResultSet res){  
        try {  
            if(res!=null){ res.close();}  
            if(p!=null){ p.close();}  
            if(conn!=null){ conn.close();}  
        } catch (Exception e) {  
            e.printStackTrace();  
              
        }  
          
    }  
      
    public int executeSQL(String sql,String [] args){  
        int rs=0;  
        Connection conn=null;  
        PreparedStatement state=null;  
        try {  
            conn=getConn();  
            state=conn.prepareStatement(sql);
            if(args!=null&&args.length>0){  
                for (int i = 0; i < args.length; i++) {  
                    state.setString(i+1, args[i]);  
                }  
                  
            }  
            rs=state.executeUpdate();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally{closeAll(conn, state, null);  
            }  
        return rs;  
          
    }  
  
}  
