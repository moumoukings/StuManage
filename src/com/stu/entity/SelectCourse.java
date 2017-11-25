package com.stu.entity;

import java.util.Date;

public class SelectCourse extends Course{
	private String date;
	
	public SelectCourse(String courseId, String courseName, String position, float score, String teacher,String date) {
		super(courseId, courseName, position, score, teacher);
		this.date=date;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
