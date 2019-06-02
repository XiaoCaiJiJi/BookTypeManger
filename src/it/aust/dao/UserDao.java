package it.aust.dao;



import it.aust.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	public User login(Connection con,User user) throws Exception{
		User resultuser = null;
		String sql ="select * from t_user where userName=? and passWord=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,user.getUserName() );
		pstmt.setString(2,user.getPassWord());
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			resultuser = new User();
			resultuser.setId(rs.getInt("id"));
			resultuser.setUserName(rs.getString("userName"));
			resultuser.setPassWord(rs.getString("passWord"));
		}
		return resultuser;
	}	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
