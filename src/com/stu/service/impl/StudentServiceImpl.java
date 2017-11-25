package com.stu.service.impl;

import java.util.List;

import com.stu.dao.GenericDao;
import com.stu.dao.impl.StudentDaoImpl;
import com.stu.entity.Student;
import com.stu.service.GenericService;

public class StudentServiceImpl implements GenericService<Student>{

	private GenericDao gen=new StudentDaoImpl();
	private StudentDaoImpl sd=new StudentDaoImpl();
	@Override
	public List<Student> list() {
		
		return this.gen.list();
	}

	@Override
	public int add(Student stu) {
		
		return this.gen.add(stu);
	}

	@Override
	public int delete(String id) {
		
		return this.gen.delete(id);
	}

	@Override
	public int modify(Student stu) {
		return this.gen.modify(stu);
	}

	@Override
	public Student get(String i) {
		return (Student) this.gen.get(i);
	}

	public List<Student> search(String type,String value){
		return this.sd.searchStudent(type, value);
	}

}
