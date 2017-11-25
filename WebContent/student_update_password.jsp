<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
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
  	  alert("填入信息不完整");
  	  return false;
  	}
    }
  } 
</script>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;修改密码<span>&nbsp;
	</div>
</div>
<div id="tips">
</div>
<div id="mainContainer">
<form name="form" action="StudentPassworUpdate" onSubmit="return checkEmpty(form)" method="post">
<table width="400" >
  <tr>
    <td width="30%">学生姓名：</td>
    <td><input type="text" name="name" value="${sessionScope.studentName}"  readonly="readonly"/></td>
  </tr>
  <tr>
    <td>旧密码：</td>
    <td><input type="text" name="password" value="" /></td>
  </tr>
  <tr>
    <td>新密码：</td>
    <td><input type="text" name="newpassword" value="" /></td>
  </tr>
  <tr>
    <td>确认密码：</td>
    <td><input type="text" name="repassword" value="" /></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><input class="button" type="submit" value="确认修改"></td>
  </tr>
</table>
</form>
<script type="text/javascript">
var info="${info}"
if(info!=""){
	alert(info);
}
</script>
</div>

</body>
</html>