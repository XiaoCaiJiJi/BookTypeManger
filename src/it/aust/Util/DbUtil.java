package it.aust.Util;

import java.sql.Connection;
import java.sql.DriverManager;



public class DbUtil {
	
	private static String jdbcName="com.mysql.jdbc.Driver";
	//���ݿ��ַ
	private static String url = "jdbc:mysql://localhost:3306/db_book";
	//�û���
	private static String userName ="root";
	//����
	private static String upassword ="123456";
	
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con=null;
		con=(Connection) DriverManager.getConnection(url, userName, upassword);
		return con;
	}
	
	public void close(Connection connection) throws Exception{
		if(connection!=null){
			connection.close();
		}
	} 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
