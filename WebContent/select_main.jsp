<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="style/default.css" />
	<link rel="stylesheet" type="text/css" href="style/common.css" />
<style type="text/css">
* {
    background: none repeat scroll 0 0 transparent;
    border: 0 none;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
	font-family:微软雅黑;
	overflow:hidden;
}
#navi{
	width:100%;
	position:relative;
	word-wrap:break-word;
	border-bottom:1px solid #065FB9;
	margin:0;
	padding:0;
	height:40px;
	line-height:40px;
	vertical-align:middle;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, 
#BFBFBF));
}
#naviDiv{
	font-size:14px;
	color:#333;
	padding-left:10px;
}
#tips{
	margin-top:10px;
	width:100%;
	height:40px;
}
#buttonGroup{
	padding-left:10px;
	float:left;
	height:35px;
}
.button{
	float:left;
	margin-right:10px;
	padding-left:10px;
	padding-right:10px;
	font-size:14px;
	width:70px;
	height:30px;
	line-height:30px;
	vertical-align:middle;
	text-align:center;
	cursor:pointer;
    border-color: #77D1F6;
    border-width: 1px;
    border-style: solid;
    border-radius: 6px 6px;
    -moz-box-shadow: 2px 2px 4px #282828;
    -webkit-box-shadow: 2px 2px 4px #282828;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, #BFBFBF));
}
#mainContainer{
	padding-left:10px;
	padding-right:10px;
	text-align:center;
	width:98%;
	font-size:12px;
}
</style>
<body>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;课程管理<span>&nbsp;
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="CourseQueryServlet.jsp">课程列表</a><span>&nbsp;
	</div>
</div>

<div id="mainContainer">

<table class="default" width="100%">
	<col width="10%">
	<col width="18%">
	<col width="18%">
	<col width="18%">
	<col width="18%">
	<col width="18%">
	<tr class="title">
		<td>选课</td>	
		<td>课程编号</td>
		<td>课程名称</td>
		<td>上课位置</td>
		<td>学分</td>
		<td>授课教师</td>
	</tr>
	
	<c:forEach var="course" items="${requestScope.list }">
	  <tr class="list">
	  	 <td><a href="SelcetCourseServlet?selectid=${course.courseId}&courseid=${course.courseId}" onclick="javascript: return confirm('确认选择该选课？');"><font color="red">选课</font></a></td>
	     <td>${course.courseId}</td>
	     <td>${course.courseName}</td>
	     <td>${course.position}</td>
	     <td>${course.score}</td>
	     <td>${course.teacher}</td>
	  </tr>
	</c:forEach>
	
		<%
   		  Object message = request.getAttribute("message");
    	 if(message!=null && !"".equals(message)){
  			%>
     	 <script type="text/javascript">
       	   alert("<%=message%>");
    	 </script>
  		<%} %>
</table>
</div>
</body>
</html>