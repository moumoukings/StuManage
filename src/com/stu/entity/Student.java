package com.stu.entity;

public class Student {
     String studentId;
     String studentName;
     String gender;
     String birthday;
     String phoneId;
     String password;
     public Student(){
    	 
     }
     public Student(String studentId, String gender, String studentName, String birthday, String phoneId, String password) {
    		super();
    		this.studentId = studentId;
    		this.gender = gender;
    		this.studentName = studentName;
    		this.birthday = birthday;
    		this.phoneId = phoneId;
    		this.password = password;
    	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
     
}
