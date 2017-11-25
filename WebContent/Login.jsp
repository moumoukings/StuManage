<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆界面</title>
<link href="style/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jQuery1.7.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var $tab_li = $('#tab ul li');
	$tab_li.hover(function(){
		$(this).addClass('selected').siblings().removeClass('selected');
		var index = $tab_li.index(this);
		$('div.tab_box > div').eq(index).show().siblings().hide();
	});	
});
</script>
<script type="text/javascript">
$(function(){
/*学生登录信息验证*/
$("#stu_username_hide").focus(function(){
 var username = $(this).val();
 if(username=='输入学号'){
 $(this).val('');
 }
});
$("#stu_username_hide").focusout(function(){
 var username = $(this).val();
 if(username==''){
 $(this).val('输入学号');
 }
});
$("#stu_password_hide").focus(function(){
 var username = $(this).val();
 if(username=='输入密码'){
 $(this).val('');
 }
});
$("#stu_password_hide").focusout(function(){
 var username = $(this).val();
 if(username==''){
 $(this).val('输入密码');
 }
});
$("#stu_code_hide").focus(function(){
 var username = $(this).val();
 if(username=='输入验证码'){
 $(this).val('');
 }
});
$("#stu_code_hide").focusout(function(){
 var username = $(this).val();
 if(username==''){
 $(this).val('输入验证码');
 }
});
/*导师登录信息验证*/
$("#tea_username_hide").focus(function(){
 var username = $(this).val();
 if(username=='输入教工号'){
 $(this).val('');
 }
});
$("#tea_username_hide").focusout(function(){
 var username = $(this).val();
 if(username==''){
 $(this).val('输入教工号');
 }
});
$("#tea_password_hide").focus(function(){
 var username = $(this).val();
 if(username=='输入密码'){
 $(this).val('');
 }
});
$("#tea_password_hide").focusout(function(){
 var username = $(this).val();
 if(username==''){
 $(this).val('输入密码');
 }
});
$("#tea_code_hide").focus(function(){
 var username = $(this).val();
 if(username=='输入验证码'){
 $(this).val('');
 }
});
$("#tea_code_hide").focusout(function(){
 var username = $(this).val();
 if(username==''){
 $(this).val('输入验证码');
 }
});

/*教务登录信息验证*/
$("#sec_username_hide").focus(function(){
 var username = $(this).val();
 if(username=='输入教务号'){
 $(this).val('');
 }
});
$("#sec_username_hide").focusout(function(){
 var username = $(this).val();
 if(username==''){
 $(this).val('输入教务号');
 }
});
$("#sec_password_hide").focus(function(){
 var username = $(this).val();
 if(username=='输入密码'){
 $(this).val('');
 }
});
$("#sec_password_hide").focusout(function(){
 var username = $(this).val();
 if(username==''){
 $(this).val('输入密码');
 }
});
$("#sec_code_hide").focus(function(){
 var username = $(this).val();
 if(username=='输入验证码'){
 $(this).val('');
 }
});
$("#sec_code_hide").focusout(function(){
 var username = $(this).val();
 if(username==''){
 $(this).val('输入验证码');
 }
});

</script>
<script type="text/javascript">
$(function(){
	$(".screenbg ul li").each(function(){
		$(this).css("opacity","0");
	});
	$(".screenbg ul li:first").css("opacity","1");
	var index = 0;
	var t;
	var li = $(".screenbg ul li");	
	var number = li.size();
	function change(index){
		li.css("visibility","visible");
		li.eq(index).siblings().animate({opacity:0},3000);
		li.eq(index).animate({opacity:1},3000);
	}
	function show(){
		index = index + 1;
		if(index<=number-1){
			change(index);
		}else{
			index = 0;
			change(index);
		}
	}
	t = setInterval(show,8000);
	//根据窗口宽度生成图片宽度
	var width = $(window).width();
	$(".screenbg ul img").css("width",width+"px");
});
</script>
</head>

<body>
<div id="tab">
  <ul class="tab_menu">
    <li class="selected">学生登录</li>
    <li>教师登录</li>
    <li>管理员登录</li>
  </ul>
  <div class="tab_box"> 
    <!-- 学生登录开始 -->
    <div>
      <div class="stu_error_box"></div>
      <form action="LoginServlet" method="post" class="stu_login_error">
        <div id="username">
          <label>学&nbsp;&nbsp;&nbsp;号：</label>
          <input type="text" id="stu_username_hide" name="studentId" placeholder="输入学号" nullmsg="学号不能为空！" datatype="s6-18" errormsg="学号范围在6~18个字符之间！" sucmsg="学号验证通过！"/>
          <!--ajaxurl="demo/valid.jsp"--> 
        </div>
        <div id="password">
          <label>密&nbsp;&nbsp;&nbsp;码：</label>
          <input type="password" id="stu_password_hide" name="password" placeholder="输入密码" nullmsg="密码不能为空！" datatype="*6-16" errormsg="密码范围在6~16位之间！" sucmsg="密码验证通过！"/>
        </div>
        <div id="remember">
          <input type="checkbox" name="remember">
          <label>记住密码</label>
        </div>
<div id="login">
          <button type="submit">登录</button>
        </div>
      </form>
    </div>
   <!-- 学生登录结束-->
   <!-- 导师登录开始-->
    <div class="hide">
     <div class="tea_error_box"></div>
      <form action="ManageServlet" method="post" class="tea_login_error">
        <div id="username">
          <label>教工号：</label>
          <input type="text" id="tea_username_hide" name="manageId" placeholder="输入教工号" nullmsg="教工号不能为空！" datatype="s6-18" errormsg="教工号范围在6~18个字符之间！" sucmsg="教工号验证通过！"/>
          <!--ajaxurl="demo/valid.jsp"--> 
        </div>
        <div id="password">
          <label>密&nbsp;&nbsp;&nbsp;码：</label>
          <input type="password" id="tea_password_hide" name="managePassword" placeholder="输入密码" nullmsg="密码不能为空！" datatype="*6-16" errormsg="密码范围在6~16位之间！" sucmsg="密码验证通过！"/>
        </div>
        <div id="remember">
          <input type="checkbox" name="remember">
          <label>记住密码</label>
        </div>
        <div id="login">
          <button type="submit">登录</button>
        </div>
      </form>
    </div>
     <!-- 导师登录结束-->
     <!-- 教务登录开始-->
    <div class="hide">
    <div class="sec_error_box"></div>
      <form action="VManageServlet" method="post" class="sec_login_error">
        <div id="username">
          <label>管理员号：</label>
          <input type="text" id="sec_username_hide" name="manageId" placeholder="输入管理员号" nullmsg="管理员号不能为空！" datatype="s6-18" errormsg="教务号范围在6~18个字符之间！" sucmsg="教务号验证通过！"/>
          <!--ajaxurl="demo/valid.jsp"--> 
        </div>
        <div id="password">
          <label>密&nbsp;&nbsp;&nbsp;码：</label>
          <input type="password" id="sec_password_hide" name="managePassword" placeholder="输入密码" nullmsg="密码不能为空！" datatype="*6-16" errormsg="密码范围在6~16位之间！" sucmsg="密码验证通过！"/>
        </div>
        <div id="remember">
          <input type="checkbox" name="remember">
          <label>记住密码</label>
        </div>
        <div id="login">
          <button type="submit">登录</button>
        </div>
      </form>
    </div>
     <!-- 教务登录结束-->
  </div>
</div>

<div class="screenbg">
  <ul>
    <li><a href="javascript:;"><img src="images/5.jpg"></a></li>
    <li><a href="javascript:;"><img src="images/6.jpg"></a></li>
    <li><a href="javascript:;"><img src="images/7.jpg"></a></li>
    <li><a href="javascript:;"><img src="images/8.jpg"></a></li>
  </ul>
</div>
<script type="text/javascript">
var info="${info}";
if(info!=""){
	alert(info);
}
</script>
</body>
</html>
