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
@WebServlet("/StudentQuery")
public class StudentQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		GenericService  ss=new StudentServiceImpl();
		List<Student> list=ss.list();
		request.setAttribute("list",list);
		request.getRequestDispatcher("student_query_success.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
