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

@WebServlet("/FindTeacherServlet")
public class FindTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindTeacherServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String way=request.getParameter("way");
		ManageDaoImpl tdao=new ManageDaoImpl();
		if(way.equals("tid")){
			String tid=request.getParameter("tin");
			GenericDao<Manage> gdao = new ManageDaoImpl();
			List<Manage> list = tdao.findid(tid);
			request.setAttribute("list",list);
			request.getRequestDispatcher("su_findteacher_success.jsp").forward(request, response);
		}
		else if(way.equals("tname")){
			String tname=request.getParameter("tin");
			GenericDao<Manage> gdao = new ManageDaoImpl();
			List<Manage> list = tdao.findname(tname);
			request.setAttribute("list", list);
			request.getRequestDispatcher("su_findteacher_success.jsp").forward(request, response);
		}
		
	}

}
