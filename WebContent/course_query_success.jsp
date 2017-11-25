<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="style/default.css" />
	<link rel="stylesheet" type="text/css" href="style/common.css" />
	<link rel="stylesheet" type="text/css" href="style/query.css" />
<body>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;课程管理<span>&nbsp;
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="CourseServlet?message=query">课程列表</a><span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="course_add.jsp">添加课程</a>
		</div>
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="course_search.jsp">查找课程</a>
		</div>
	</div>
</div>
<div id="mainContainer">

<table class="default" width="100%">
	<col width="17%">
	<col width="17%">
	<col width="17%">
	<col width="17%">
	<col width="17%">
	<col width="15%">
	<tr class="title">
		<td>课程编号</td>
		<td>课程名称</td>
		<td>上课地点</td>
		<td>课程学分</td>
		<td>上课教师</td>
		<td>操作</td>
	</tr>
	
	<c:forEach var="course" items="${requestScope.list}">
	  <tr class="list">
	     <td>${course.courseId}</td>
	     <td>
	        <a href="CourseServlet?courseId=${course.courseId}&message=modify">
	        ${course.courseName}</a>
	     </td>
	     <td>${course.position}</td>
	     <td>${course.score}</td>
	     <td>${course.teacher}</td>
	     <td><a href="CourseServlet?courseId=${course.courseId}&message=delete" onclick="javascript: return confirm('真的要删除吗？');">删除</a></td>
	  </tr>
	</c:forEach>
	
</table>
</div>
</body>
</html>