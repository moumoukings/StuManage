package com.stu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stu.entity.SelectCourse;
import com.stu.service.CourseService;
import com.stu.service.impl.CourseServiceImpl;



@WebServlet(name = "getteam2", urlPatterns = { "/AlreadyServlet" })
public class AlreadyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 查询已选课程列表
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		HttpSession sesison=request.getSession();
		CourseService cs = new CourseServiceImpl();
		String studentId=(String)sesison.getAttribute("studentId");
		List <SelectCourse>list1=cs.list2(studentId);//学号，studentno
		request.setAttribute("list1", list1);
		request.getRequestDispatcher("delselect_main.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
