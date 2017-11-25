package com.stu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.dao.GenericDao;
import com.stu.dao.impl.ManageDaoImpl;
import com.stu.entity.Manage;

@WebServlet("/AddTeacherServlet")
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddTeacherServlet() {
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
		Manage t=new Manage();
		t.setmanageId(request.getParameter("tid"));
		t.setmanageName(request.getParameter("tname"));
		t.setmanagePassword(request.getParameter("tpwd"));
		t.setmanageAuthority("ΩÃ ¶");
		if(gdao.add(t)==-1){
			request.getRequestDispatcher("su_addteacher_fail.jsp").forward(request, response);
		}
		else{
		/*for (int i = 0; i < list.size(); i++) {
			Course c = list.get(i);
			System.out.println(c.getCourseid() + "\t" + c.getCoursename());
		}*/
		request.getRequestDispatcher("TeacherServlet").forward(request, response);
		}
	}

}
