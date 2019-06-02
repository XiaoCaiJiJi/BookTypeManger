package it.aust.dao;

import it.aust.Util.StringUtil;
import it.aust.model.BookType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class BookTypeDao {
	
	public static int add(Connection con,BookType booktype) throws Exception{
			String sql ="insert into t_bookType values(null,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,booktype.getBookTypeName());
			pstmt.setString(2,booktype.getBookTypeDesc());
			return	pstmt.executeUpdate();
			}
	
	public ResultSet list(Connection con,BookType bookType) throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_bookType");
		if(StringUtil.isNotEmpty(bookType.getBookTypeName())){
			sb.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int delete(Connection con,int id) throws Exception{
		String sql = "delete  from t_booktype where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,id);
		return pstmt.executeUpdate();
	}
	
	public int update(Connection con,BookType bookType) throws Exception{
		String sql = "update t_bookType set bookTypeName = ?,bookTypeDesc = ? where id =? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2,bookType.getBookTypeDesc());
		pstmt.setInt(3,bookType.getId());
		return pstmt.executeUpdate();
	}
}