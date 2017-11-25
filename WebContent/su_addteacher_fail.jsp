<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="style/common.css" />
    <link rel="stylesheet" type="text/css" href="style/add.css" />
<body>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;教师管理&nbsp;
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="TeacherServlet">教师列表</a>&nbsp;
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;添加教师&nbsp;
	</div>
</div>
<div id="tips">
</div>
<div id="mainContainer" style="font-size:18px;">
   <strong>添加失败，原因:该教师工号已存在！<a href="TeacherServlet">返回课程列表？</a></strong>
</div>
</body>
</html>