package com.stu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stu.dao.impl.StudentDaoImpl;
import com.stu.entity.Student;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentId=request.getParameter("studentId");
         String password=request.getParameter("password");
         Student s=new Student();
         s.setStudentId(studentId);
         s.setPassword(password);
         StudentDaoImpl sdao=new StudentDaoImpl();
         Student student=sdao.login(s);
         HttpSession session=request.getSession();
         if(student!=null){
			session.setAttribute("studentName", student.getStudentName());
			session.setAttribute("gender", student.getGender());
			session.setAttribute("birthday", student.getBirthday());
			session.setAttribute("phoneId",student.getPhoneId());
			session.setAttribute("studentId", student.getStudentId());
			session.setAttribute("password", student.getPassword());
        	request.getRequestDispatcher("indexStudent.jsp").forward(request, response);

         }else{
            request.setAttribute("info","用户名或密码输入错误！");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
         }
         
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
