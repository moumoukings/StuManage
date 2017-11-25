package com.stu.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.dao.BaseDao;
import com.stu.dao.GenericDao;
import com.stu.dao.impl.CourseDaoImpl;
import com.stu.entity.Course;
import com.stu.service.GenericService;
import com.stu.service.impl.CourseServiceImpl;

@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CourseServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String message=request.getParameter("message");
		//System.out.println(message);
		GenericService<Course> gs= new CourseServiceImpl();
		
		/*for (int i = 0; i < list.size(); i++) {
			Course c = list.get(i);
			System.out.println(c.getCourseid() + "\t" + c.getCoursename());
		}*/
		switch(message){
		case "query":
			List<Course> list = gs.list();
			request.setAttribute("list", list);
			request.getRequestDispatcher("course_query_success.jsp").forward(request, response);
			break;
		case "add":
			//System.out.println("添加课程");
			gs.add(getInput(request, response));
			request.getRequestDispatcher("course_add_success.jsp").forward(request, response);
			break;
		case "modify":
			System.out.println("修改课程");
			Course course=gs.get(request.getParameter("courseId"));
			request.setAttribute("course", course);
			request.getRequestDispatcher("course_modify.jsp").forward(request, response);
			break;
		case "save":
			System.out.println("保存修改课程");
			Course c=new Course();
			c.setCourseId(request.getParameter("courseId"));
			c.setCourseName(request.getParameter("courseName"));
			c.setPosition(request.getParameter("position"));
			c.setScore(Float.parseFloat(request.getParameter("score")));
			c.setTeacher(request.getParameter("teacher"));
			gs.modify(c);
			request.getRequestDispatcher("course_modify_success.jsp").forward(request, response);
			break;
		case "delete":
			gs.delete(request.getParameter("courseId"));
			request.getRequestDispatcher("course_delete_success.jsp").forward(request, response);
			break;
		case "search":
			System.out.println("查询课程");
			CourseServiceImpl cs=new CourseServiceImpl();
			Course c2=new Course();
			c2.setCourseId(request.getParameter("courseId"));
			c2.setCourseName(request.getParameter("courseName"));
			c2.setPosition(request.getParameter("position"));
			c2.setTeacher(request.getParameter("teacher"));
			List<Course> list2 = cs.findMessage(c2);
			request.setAttribute("list", list2);
			request.getRequestDispatcher("course_query_success.jsp").forward(request, response);
		default:
				break;
		}
		   
	}
	public Course getInput(HttpServletRequest request, HttpServletResponse response){
		Course c=new Course();
		BaseDao bdao=new BaseDao();
		c.setCourseId(bdao.getNewcourseId());
		c.setCourseName(request.getParameter("courseName"));
		c.setPosition(request.getParameter("position"));
		c.setScore(Float.parseFloat(request.getParameter("score")));
		c.setTeacher(request.getParameter("teacher"));
		return c;
	}
	

}
