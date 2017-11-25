package com.stu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.entity.Course;
import com.stu.service.CourseService;
import com.stu.service.impl.CourseServiceImpl;




@WebServlet("/CourseQueryServlet")
public class CourseQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 查询课程列表
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		//System.out.println(123);
		CourseService cs = new CourseServiceImpl();
		List<Course> list=cs.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("select_main.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
