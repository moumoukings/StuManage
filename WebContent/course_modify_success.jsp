<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
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
</div>
<div id="mainContainer" style="font-size:18px;">
   <strong>修改成功，<a href="CourseServlet?message=query">返回课程列表</a></strong>
</div>
</body>
</html>