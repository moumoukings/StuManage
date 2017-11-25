<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="style/common.css" />
<style type="text/css">
* {
    background: none repeat scroll 0 0 transparent;
    border: 1 none;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
	font-family:微软雅黑;
	overflow:hidden;
}
a:hover{text-decoration:none;}
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

#buttonGroup{
	padding-left:10px;
	float:left;
	height:35px;
}
.button{
	margin-top:20px;
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

	text-align:left;
	width:98%;
	font-size:18px;
}
.search{margin:0 auto;}
table{margin: 0 auto;}
</style>
<body>
<script type="text/javascript" src="js/Calendar3.js"></script>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;学生管理<span>&nbsp;
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="StudentQuery">学生列表</a><span>&nbsp;
	    <span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;学生信息查找<span>&nbsp;
	</div>
</div>

<div id="mainContainer">
<center><strong>搜索学生</strong></center>
<br>
<br>
<!-- <td><input type="text" name="studentId" /></td>
    <td>学生姓名</td>
    <td><input type="text" name="student" /></td>
    <td>性别</td>
    <td><input type="text" name="publisher" /></td>
    <td>年龄</td>
    <td><input type="text" name="bookName" /></td> -->
<form name="form" action="StudentGet" method="post">
<div id="searchBox">
<table  >
  <tr>
    <td>关键字:</td>
    <td>
        <select name="type" style="width:100px">
            <option value="studentId">
                                          学号
            </option>
            <option value="studentName">
                                        姓名
            </option>
            <option value="gender">
                                        性别
            </option>
            <option value="birthday">
                                         出生日期
            </option>
        </select>
        <input style="vertical-align:middle;width:150px;height:30px;;line-height:30px;" type="text" name="searchValue" />
    </td>
     <td ><input   class="button search" type="submit" value="查询"></td>
    </tr>
    
</table>
</div>
</form>
</div>
</body>
</html>