package com.stu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.service.CourseService;
import com.stu.service.impl.CourseServiceImpl;

@WebServlet(name = "getteam4", urlPatterns = { "/DelCourseServlet" })
public class DelCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
			
	/**
	 * 删除已选课程
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String alreadycourseid=request.getParameter("alreadyid");
		CourseService cs = new CourseServiceImpl();
		cs.DelCourse(alreadycourseid);
		request.setAttribute("message", "删除成功");
		request.getRequestDispatcher("AlreadyServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}