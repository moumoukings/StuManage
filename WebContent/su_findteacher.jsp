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
		function check() {
			var name = document.getElementById("tin").value;//用户名
			if (name=="") {
				alert('输入教师信息不能为空');
				return false;
			}
		}
	</script>
	<div id="navi">
		<div id='naviDiv'>
			<span><img src="images/arror.gif" width="7" height="11"
				border="0" alt=""></span>&nbsp;教师管理&nbsp; <span><img
				src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a
				href="TeacherServlet">教师列表</a>&nbsp; <span><img
				src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;查找教师&nbsp;
		</div>
	</div>
	<div id="tips"></div>
	<div id="mainContainer">
		<strong>查找教师</strong>
		<form action=FindTeacherServlet method="post"
			onSubmit="return check()" method="post">
			<table width="400">
				<tr>
					<td>查找方式</td>
					<td><select name="way">
							<option value="tid">工号</option>
							<option value="tname">姓名</option>
					</select></td>
				</tr>
				<tr>
					<td>查找内容</td>
					<td><input type="text" name="tin" id="tin"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input class="button"
						type="submit" value="查询"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>