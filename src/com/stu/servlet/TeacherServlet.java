package com.stu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.dao.GenericDao;
import com.stu.dao.impl.ManageDaoImpl;
import com.stu.entity.Manage;

@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TeacherServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		GenericDao<Manage> gdao = new ManageDaoImpl();
		List<Manage> list = gdao.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("su_main.jsp").forward(request, response);
	}

}
