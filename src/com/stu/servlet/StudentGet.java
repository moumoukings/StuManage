package com.stu.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class StudentGet
 */
@WebServlet("/StudentGet")
public class StudentGet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		StudentServiceImpl  ss=new StudentServiceImpl();
		String type=request.getParameter("type");
		String searchValue=request.getParameter("searchValue");
		String value='%'+searchValue+'%';
		List<Student> list=ss.search(type, value);
		System.out.println(list.size());
		request.setAttribute("list",list);
		
		request.getRequestDispatcher("student_query_success.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
