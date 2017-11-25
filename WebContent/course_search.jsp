<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
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
<strong>搜索课程</strong>
<br>
<br>
<form name="form" action="CourseServlet?message=search" onSubmit="return checkEmpty(form)" method="post">
<table width="1200" >
  <tr>
    <td>课程编号:</td>
    <td><input type="text" name="courseId" /></td>
    <td>课程名称:</td>
    <td><input type="text" name="courseName" /></td>
    <td>上课地点:</td>
    <td><input type="text" name="position" /></td>
    <td>上课教师:</td>
    <td><input type="text" name="teacher" /></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><input class="button" type="submit" value="查询"></td>
  </tr>
</table>
</form>
</div>
</body>
</html>