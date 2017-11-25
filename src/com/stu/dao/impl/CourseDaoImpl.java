package com.stu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stu.dao.BaseDao;
import com.stu.dao.CourseDao;
import com.stu.dao.GenericDao;
import com.stu.entity.Course;
import com.stu.entity.SelectCourse;

public class CourseDaoImpl extends BaseDao implements GenericDao<Course>,CourseDao{

	@Override
	public List<Course> list() {
		// TODO Auto-generated method stub
		List<Course>list=new ArrayList<Course>();
		String sql="select * from course";
		Object[] params=null;
		ResultSet rs = this.executeQuery(sql, params);
		try {
			while(rs.next()){
				Course c = new Course(rs.getString(1), rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getString(5));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(rs, null, null);
		}
		return list;
	}

	@Override
	public int add(Course c) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Course(courseid,coursename,position,score,teacher) VALUES(?,?,?,?,?)";
		Object[] params = {c.getCourseId(),c.getCourseName(),c.getPosition(),c.getScore(),c.getTeacher()};
		return this.executeUpdate(sql, params);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM course WHERE courseid=?";
		Object[] params={id};
		return this.executeUpdate(sql, params);
	}

	@Override
	public int modify(Course c) {
		// TODO Auto-generated method stub
		String sql="UPDATE course SET coursename=?,position=?,score=?,teacher=? WHERE courseid=?";
		Object[] params={c.getCourseName(),c.getPosition(),c.getScore(),c.getTeacher(),c.getCourseId()};
		return this.executeUpdate(sql, params);
	}

	@Override
	public Course get(String courseId) {
		Course course=null;
		String sql="select * from course where courseId=?";
		Object[] params={courseId};
		ResultSet rs=this.executeQuery(sql, params);
		try {
			if(rs.next()){
				course= new Course(rs.getString(1), rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(rs, null, null);
		}
		return course;
	}

	public List<Course> findMessage(Course course) {
		// TODO 自动生成的方法存根
		List<Course>list=new ArrayList<Course>();
		
		String sql = "select * from course where courseid like ? and coursename like ? and position like ? and teacher like ?";
		Object[] params={"%"+course.getCourseId()+"%","%"+course.getCourseName()+"%"
		         ,"%"+course.getPosition()+"%","%"+course.getTeacher()+"%"};
		ResultSet rs = this.executeQuery(sql, params);
		try {
			while (rs.next()) {
				course = new Course(rs.getString(1), rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getString(5));
				list.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs, null, null);
		}
		return list;
	}

	@Override
	public List<SelectCourse> list2(String studentId) {// 查询已选课程列表
		List<SelectCourse> list = new ArrayList<SelectCourse>();
		String sql = "select course.courseId,course.courseName,course.position,course.score,course.teacher ,selectcourse.selectDate "
				+ "from course,selectcourse "
				+ "where selectcourse.studentId=? AND selectcourse.courseId=course.courseId";
		Object[] params = { studentId };
		ResultSet rs = this.executeQuery(sql, params);
		try {
			while (rs.next()) {
				SelectCourse sc = new SelectCourse(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4),
						rs.getString(5), rs.getDate(6).toString());
				list.add(sc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs, null, null);
		}
		return list;
	}

	
	

	@Override
	public int AddCourse(String studentId, String courseId, String date) {// 选课

		String sql = "INSERT INTO selectcourse(studentId,courseId,selectDate)VALUES(?,?,?)";
		Object[] params = { studentId, courseId, date };
		return this.executeUpdate(sql, params);
	}

	@Override
	public int DelCourse(String courseId) {// 删除已选课程
		String sql = "DELETE FROM selectcourse WhERE courseId=?";
		Object[] params = { courseId };
		return this.executeUpdate(sql, params);
	}

	@Override
	public boolean ExistCourse(String studentId, String courseId) {// 判断学生是否已经改课程
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = this.getConnection();
		ResultSet rs = null;
		String sql = "select * from selectcourse   where studentId=? and courseId=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentId);
			pstmt.setString(2, courseId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs, pstmt, conn);
		}
		return false;
	}

}
