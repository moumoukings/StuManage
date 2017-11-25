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
 * Servlet implementation class StudentModify
 */
@WebServlet("/StudentModify")
public class StudentModify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		GenericService  ss=new StudentServiceImpl();
		String studentId=request.getParameter("studentId");
		String studentName=request.getParameter("studentName");
		String gender=request.getParameter("gender");
		String birthday=request.getParameter("birthday");
		String phoneId=request.getParameter("phoneId");
		String password=request.getParameter("password");
		Student stu=new Student();
		stu.setStudentId(studentId);
		stu.setStudentName(studentName);
		stu.setGender(gender);
		stu.setBirthday(birthday);
		stu.setPhoneId(phoneId);
		stu.setPassword(password);
		if(ss.modify(stu)>0){			
			request.setAttribute("studentId",studentId);
			request.setAttribute("studentName",studentName);
			request.setAttribute("gender",gender);
			request.setAttribute("birthday",birthday);
			request.setAttribute("phoneId",phoneId);
			request.setAttribute("password",password);
			request.setAttribute("info","修改成功");
		}else{
			request.setAttribute("info","修改失败");
		}
		request.getRequestDispatcher("student_modify.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
