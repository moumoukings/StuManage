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

@WebServlet("/StudentDelete")
public class StudentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		GenericService ss = new StudentServiceImpl();

		String id=request.getParameter("studentId");
		if (ss.delete(id)> 0) {
			request.setAttribute("info","É¾³ý³É¹¦");
		} else {
			request.setAttribute("info","É¾³ýÊ§°Ü");
		}
		request.getRequestDispatcher("StudentQuery").forward(request, response);
		//System.out.println(request.getParameter("studentId"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
