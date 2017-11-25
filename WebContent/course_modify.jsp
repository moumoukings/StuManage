<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="style/common.css" />
    <link rel="stylesheet" type="text/css" href="style/add.css" />
<body>
<script type="text/javascript" src="js/Calendar3.js"></script>

<div id="navi">
	<div id='naviDiv'>
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;课程管理<span>&nbsp;
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="CourseServlet?message=query">课程列表</a><span>&nbsp;
	</div>
</div>
<div id="tips">
</div>
<div id="mainContainer">
<strong>修改课程信息</strong>
<br>
<br>

<form name="modifyForm" action="CourseServlet?message=save" method="post">
<table width="400" >
  <tr>
    <td width="30%">课程编号：</td>
    <td><input type="text" name="courseId" value="${requestScope.course.courseId}" readonly="readonly"/></td>
  </tr>
  <tr>
    <td>课程名称：</td>
    <td><input type="text" name="courseName" value='${requestScope.course.courseName}'/></td>
  </tr>
   <tr>
    <td>上课地点：</td>
    <td><input type="text" name="position" value='${requestScope.course.position}'/></td>
  </tr>
   <tr>
    <td>课程学分：</td>
    <td><input type="text" name="score" value='${requestScope.course.score}'/></td>
  </tr>
   <tr>
    <td>上课教师：</td>
    <td><input type="text" name="teacher" value='${requestScope.course.teacher}'/></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><input class="button" type="submit" value="修改"></td>
  </tr>
</table>
</form>
</div>
</body>
</html>