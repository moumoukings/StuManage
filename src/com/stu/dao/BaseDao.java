package com.stu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class BaseDao {
	
	String url = "jdbc:mysql://localhost:3306/studentinfomanage?user=root&password=root&characterEncoding=utf8";
	
	public Connection getConnection() {
		Connection conn = null;
	   
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			if(conn!=null){
				System.out.println("数据库连接成功");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
   
	 /**
	  * 添加修改
	  * @param rs
	  * @param ps
	  * @param conn
	  */
	public int executeUpdate(String sql,Object...params){
		int result=-1;
		PreparedStatement ps=null;
		try {
			ps=this.getConnection().prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				ps.setObject((i+1),params[i]);
			}System.out.println(ps);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(null, ps, null);
		}
		
		return  result;
	}
	
	public ResultSet executeQuery(String sql,Object...params){
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		try {
			conn=this.getConnection();
			ps=conn.prepareStatement(sql);
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					// System.out.println(123);
					ps.setObject((i + 1), params[i]);
					
				}
			}
		System.out.println(ps.toString());
			rs=ps.executeQuery();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static void closeAll(ResultSet rs, PreparedStatement ps  , Connection conn) {
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
			conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	public String getNewcourseId(){
		Connection conn = this.getConnection();
		String sql = "select max(courseid) from course";
		String courseId = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				courseId = rs.getString(1);
			}
			if (courseId == null) {
				courseId = "C0001";
			} else {
				String temp = courseId.substring(1);
				int i = Integer.parseInt(temp);
				i++;
				// 再还原为字符串
				temp = String.valueOf(i);
				int len = temp.length();
				for (int j = 0; j < 4 - len; j++) {
					temp = "0" + temp;
				}
				courseId = "C" + temp;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			this.closeAll(rs, ps, conn);
		}
		return courseId;
	}
	
}
