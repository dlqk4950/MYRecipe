package net.utility;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBOpen {	
	public Connection getConnection(){
		Connection  con=null;		
		try {
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="system";
			String password="1234";
			String driver="oracle.jdbc.driver.OracleDriver";//ojdbx8.jar
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			
		}catch(Exception e) {
			System.out.println("오라클 DB연결실패"+e);
		}
		return con;	
	
	}
}

