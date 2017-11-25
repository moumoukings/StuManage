<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="style/common.css" />
    <link rel="stylesheet" type="text/css" href="style/add.css" />
<body>
<script type="text/javascript" src="js/Calendar3.js"></script>
<script type="text/javascript">
function checkEmpty(form){
    for(i=0;i<form.length;i++){
  	//alert(form.elements[i].value);
  	if(form.elements[i].value==""){
  	  alert("教师信息不完整");
  	  return false;
  	}
    }
  }
</script>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;教师管理&nbsp;
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="TeacherServlet">教师列表</a>&nbsp;
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;添加教师&nbsp;
	</div>
</div>
<div id="tips">
</div>
<div id="mainContainer">
<strong>添加教师</strong>
<br>
<br>
<form name=form action=AddTeacherServlet onSubmit="return checkEmpty(form)" method="post">
<table  width="400" >
<tr>
<td>教师工号</td><td><input type="text" name="tid" ></td>
</tr>
<tr>
<td>教师姓名</td><td><input type="text" name="tname"></td>
</tr>
<tr>
<td>教师密码</td><td><input type="text" name="tpwd"></td>
</tr>
 <tr>
    <td colspan="2" align="center"><input class="button" type="submit" value="添加"></td>
  </tr>
</table>
</form>
</div>
</body>
</html>