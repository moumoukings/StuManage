package com.stu.entity;

public class Course {
	private String courseId;
	private String courseName;
	private String position;
	private double score;
	private String teacher;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	 
	public Course(String courseId, String courseName, String position, double score, String teacher) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.position = position;
		this.score = score;
		this.teacher = teacher;
	}

	public Course(String courseId, String courseName, String position, float score, String teacher) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.position = position;
		this.score = score;
		this.teacher = teacher;
	}
	public String getCourseId() {
		return courseId;
	}


	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

}
