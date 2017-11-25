package com.stu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stu.entity.Student;
import com.stu.service.GenericService;
import com.stu.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentPassworUpdate
 */
@WebServlet("/StudentPassworUpdate")
public class StudentPassworUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		GenericService ss = new StudentServiceImpl();
		String password=request.getParameter("password");
		String newpassword=request.getParameter("newpassword");
		String repassword=request.getParameter("repassword");
		
		HttpSession session=request.getSession();
		String studentId=(String)session.getAttribute("studentId");
		String studentName=(String)session.getAttribute("studentName");
		String gender=(String)session.getAttribute("gender");
		String birthday=(String)session.getAttribute("birthday");
		String phoneId=(String)session.getAttribute("phoneId");
		String oldpassword=(String)session.getAttribute("password");
		Student stu=new Student();
		stu.setStudentId(studentId);
		stu.setStudentName(studentName);
		stu.setGender(gender);
		stu.setBirthday(birthday);
		stu.setPhoneId(phoneId);
		stu.setPassword(newpassword);
		System.out.println(oldpassword+password);
		if(!oldpassword.equals(password)){
			request.setAttribute("info", "原密码错误！");
		}else if(!newpassword.equals(repassword)){
			request.setAttribute("info", "两次密码输入不一致！");
		}else{
			if(ss.modify(stu)>0){
				request.setAttribute("info", "修改成功！");
			}else{
				request.setAttribute("info", "修改失败！");
			}
		}
		request.getRequestDispatcher("student_update_password.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
