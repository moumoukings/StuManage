<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="style/common.css" />
    <link rel="stylesheet" type="text/css" href="style/add.css" />
<body>
<style>
.red{color:red;font-size:15px;}
</style>
<script type="text/javascript" src="js/Calendar3.js"></script>
<script type="text/javascript">
 
  function checkName(){
	var courseName=document.getElementById("courseName").value;
	if(courseName==""){
		document.getElementById("courseName_tip").innerHTML="课程名称不能为空";
		return false;
	}else{
		document.getElementById("courseName_tip").innerHTML="";
		return true;
	}
	
   }  
   function checkScore(){
		var score=document.getElementById("score").value;
		var reg=/^\d{1,2}$/;
		if(score==""){
			document.getElementById("score_tip").innerHTML="学分不能为空";
			return false;
		}else if(!reg.test(score)){
			document.getElementById("score_tip").innerHTML="学分为1-2位数字组成";
			return false;
		}else{
			document.getElementById("score_tip").innerHTML="";
			return true;
		}
		
   }  
   function check(form){
	   if(checkName()&&checkScore()){
			return true;
		}else{
			return false;
		}
		for (i = 0; i < form.length; i++) {
			if (form.elements[i].value == "") {
				alert("课程信息不完整");
				return false;
			}
		}
   }
</script>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;课程管理<span>&nbsp;
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="CourseServlet?message=query">课程列表</a><span>&nbsp;
	</div>
</div>
<div id="tips">
</div>
<div id="mainContainer">
<strong>添加课程信息</strong>
<br>
<br>
<form name="form" action="CourseServlet?message=add" onSubmit="return check(form)" method="post">
<table width="420">
   <tr>
     <td width="26%">课程名称：</td>
     <td><input type="text" name="courseName" id="courseName" onblur="checkName()"/></td>
     <td><span id="courseName_tip" class="red"></span></td>
   </tr>
   <tr>
    <td>上课地点：</td>
    <td><input type="text" name="position" id="position" onblur="checkPosition()"/></td>
    <td><span id="position_tip" class="red"></span>
   </tr>
   <tr>
    <td>课程学分：</td>
    <td><input type="text" name="score" id="score" onblur="checkScore()"/></td>
    <td><span id="score_tip" class="red"></span></td>
   </tr>
  <tr>
    <td>上课教师：</td>
    <td><input type="text" name="teacher" id="teacher" onblur="checkTeacher()"/></td>
    <td><span id="teacher_tip" class="red"></span></td>
  </tr>
  
  <tr>
    <td colspan="3" align="center"><input class="button" type="submit" value="添加"></td>
  </tr>
</table>
</form>


</div>
</body>
</html>