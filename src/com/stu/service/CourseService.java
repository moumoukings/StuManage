package com.stu.service;

import java.util.List;

import com.stu.entity.Course;
import com.stu.entity.SelectCourse;



public interface CourseService {
	/**
	 * 查询所有课程
	 * @return
	 */
	List<Course> list();
	
	/**
	 * 查询已选课程
	 * @return
	 */
	List<SelectCourse> list2(String studentId);
	
	/**
	 * 选课
	 */
	int AddCourse(String studentId,String courseId,String date);
	
	/**
	 * 删除已选课程
	 */
	int DelCourse(String courseId);
	
	/**
	 * 学生是否已选改课程
	 */
	boolean ExistCourse(String studentId,String courseId);
}
