package com.stu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.stu.dao.BaseDao;
import com.stu.dao.GenericDao;
import com.stu.entity.Student;


public class StudentDaoImpl extends BaseDao implements GenericDao<Student> {

	@Override
	public List<Student> list() {
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from Student";
		Object[] params = null;
		ResultSet rs = this.executeQuery(sql, params);
		
		try {
			while (rs.next()) {
				Student stu = new Student();
				stu.setStudentId(rs.getString("studentId"));
				stu.setStudentName(rs.getString("studentName"));
				stu.setGender(rs.getString("gender"));
				stu.setBirthday(rs.getDate("birthday").toString());
				stu.setPhoneId(rs.getString("phoneId"));
				stu.setPassword(rs.getString("password"));

				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs, null, null);
		}
		return list;
	}

	@Override
	public int add(Student stu) {
		String sql = "insert into Student values(?,?,?,?,?,?)";
        if(stu.getBirthday()==""){
        	stu.setBirthday("1996-01-01");
        }
       
		Object[] params = { stu.getStudentId(), stu.getStudentName(), stu.getGender(), stu.getBirthday(),
				stu.getPhoneId(), stu.getPassword() };
		return this.executeUpdate(sql, params);
	}

	@Override
	public int delete(String id) {
		String sql = "delete from Student where studentId=?";
		Object[] params = { id };
		return this.executeUpdate(sql, params);
	}

	@Override
	public int modify(Student stu) {
		 if(stu.getBirthday()==""){
	        	stu.setBirthday("1996-01-01");
	        }
	       
		String sql = "update Student set studentName=?,gender=?,birthday=?,phoneId=?,password=? where studentId=?";
		Object[] params = {stu.getStudentName(),stu.getGender(),stu.getBirthday(),stu.getPhoneId(),stu.getPassword(),stu.getStudentId()};
		return this.executeUpdate(sql, params);
	}

	@Override
	public Student get(String i) {
		Student stu = new Student();
		String sql = "select * from Student where studentId=?";
		Object[] params = { i };
		ResultSet rs = this.executeQuery(sql, params);
		try {
			if (rs.next()) {
				//System.out.println(rs.getString("studentId"));
				stu.setStudentId(rs.getString("studentId"));
				stu.setStudentName(rs.getString("studentName"));
				stu.setGender(rs.getString("gender"));
				stu.setBirthday(rs.getDate("birthday").toString());
				stu.setPhoneId(rs.getString("phoneId"));
				stu.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(rs, null, null);
		}
		return stu;
	}

	public List<Student> searchStudent(String type,String value) {
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from Student where "+type+" like ? ";
		Object[] params ={value};
		ResultSet rs = this.executeQuery(sql, params);
		try {
			while (rs.next()) {
				Student stu = new Student();
				stu.setStudentId(rs.getString("studentId"));
				stu.setStudentName(rs.getString("studentName"));
				stu.setGender(rs.getString("gender"));
				stu.setBirthday(rs.getDate("birthday").toString());
				stu.setPhoneId(rs.getString("phoneId"));
				stu.setPassword(rs.getString("password"));

				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs, null, null);
		}
		return list;
	}
	
	
	public Student login(Student s) {
		// TODO Auto-generated method stub
		Student student = null;
		String sql = "select * from student where studentid= ? and password = ?";
		Object[] params = { s.getStudentId(), s.getPassword() };
		ResultSet rs = this.executeQuery(sql, params);
		try {
			if (rs.next()) {
				student=new Student();
				student.setStudentId(rs.getString(1));
				student.setStudentName(rs.getString(2));
				student.setGender(rs.getString(3));
				student.setBirthday(rs.getString("birthday"));
				student.setPhoneId(rs.getString("phoneId"));
				student.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, null, null);
		}
		return student;
	}
	
	
	
	
}
