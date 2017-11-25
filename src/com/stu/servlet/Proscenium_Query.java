package com.stu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.entity.Student;
import com.stu.service.GenericService;
import com.stu.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentQuery
 */
@WebServlet("/Proscenium_Query")
public class Proscenium_Query extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		StudentServiceImpl  ss=new StudentServiceImpl();
		String id=request.getSession().getAttribute("studentId").toString();
		Student student=ss.get(id);
		
		request.setAttribute("student",student);
		
		System.out.println(student.getStudentName());
		
		request.getRequestDispatcher("proscenium_student_query_success.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
