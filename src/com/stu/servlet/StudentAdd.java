package com.stu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.entity.Student;
import com.stu.service.GenericService;
import com.stu.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentAdd
 */
@WebServlet("/StudentAdd")
public class StudentAdd extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		GenericService<Student>  ss=new StudentServiceImpl();
		String studentId=request.getParameter("studentId");
		String studentName=request.getParameter("studentName");
		String gender=request.getParameter("gender");
		String birthday=request.getParameter("birthday");
		String phoneId=request.getParameter("phoneId");
		String password=request.getParameter("password");
		System.out.println(studentId+" "+studentName+" "+" "+gender+" "+birthday+" "+phoneId+" "+password);
		
		Student stu=new Student();
		stu.setStudentId(studentId);
		stu.setStudentName(studentName);
		stu.setGender(gender);
		stu.setBirthday(birthday);
		stu.setPhoneId(phoneId);
		stu.setPassword(password);
		if (ss.get(studentId).getStudentId() != null) {
			//System.out.println(ss.get(studentId).getStudentId());
			request.setAttribute("info", "该学生已存在，请更换一个学号！");
		}else{
			
			if (ss.add(stu) > 0) {
				request.setAttribute("info", "添加成功");
			} else {
				request.setAttribute("info", "添加失败");
			}
			
		}
		request.getRequestDispatcher("student_add.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
