package com.stu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Proscenium_ToModify
 */
@WebServlet("/Proscenium_ToModify")
public class Proscenium_ToModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String studentId=request.getParameter("studentId");
		String studentName=request.getParameter("studentName");
		String gender=request.getParameter("gender");
		String birthday=request.getParameter("birthday");
		String phoneId=request.getParameter("phoneId");
		//String password=request.getParameter("password");
		System.out.println(studentName);
		request.setAttribute("studentId",studentId);
		request.setAttribute("studentName",studentName);
		request.setAttribute("gender",gender);
		request.setAttribute("birthday",birthday);
		request.setAttribute("phoneId",phoneId);
		//System.out.println(studentId+studentName+gender+birthday+phoneId);
		//System.out.println(password);
		request.getRequestDispatcher("proscenium_student_modify.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
