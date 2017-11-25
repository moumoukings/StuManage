package com.stu.service.impl;

import java.util.List;

import com.stu.dao.GenericDao;
import com.stu.dao.impl.CourseDaoImpl;
import com.stu.entity.Course;
import com.stu.entity.SelectCourse;
import com.stu.service.CourseService;
import com.stu.service.GenericService;

public class CourseServiceImpl implements GenericService<Course>,CourseService {
	GenericDao<Course> gdao=new CourseDaoImpl();
	CourseDaoImpl cdao=new CourseDaoImpl();
	@Override
	public List<Course> list() {
		// CourseODO Auto-generated method stub
		return this.gdao.list();
	}

	@Override
	public int add(Course c) {
		// CourseODO Auto-generated method stub
		return this.gdao.add(c);
	}

	@Override
	public int delete(String id) {
		// CourseODO Auto-generated method stub
		return this.gdao.delete(id);
	}

	@Override
	public int modify(Course c) {
		// CourseODO Auto-generated method stub
		return this.gdao.modify(c);
	}

	@Override
	public Course get(String i) {
		// CourseODO Auto-generated method stub
		return this.gdao.get(i);
	}

	
	public List<Course> findMessage(Course c) {
		// TODO Auto-generated method stub
		return this.cdao.findMessage(c);
	}

	@Override
	public List<SelectCourse> list2(String studentId) {
		// TODO Auto-generated method stub
		return cdao.list2(studentId);
	}

	@Override
	public int AddCourse(String studentId, String courseId, String date) {
		// TODO Auto-generated method stub
		return cdao.AddCourse(studentId, courseId, date);
	}

	@Override
	public int DelCourse(String courseId) {
		// TODO Auto-generated method stub
		return cdao.DelCourse(courseId);
	}

	@Override
	public boolean ExistCourse(String studentId, String courseId) {
		// TODO Auto-generated method stub
		return cdao.ExistCourse(studentId, courseId);
	}


}
