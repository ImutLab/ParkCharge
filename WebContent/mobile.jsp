<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>手机端登录</title>
<link rel="stylesheet" href="./js/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="./js/jqueryMobile/jquery.min.js"></script>
<script src="./js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page">
		<div data-role="header" align="center">
			<p><s:property value="#application.projectName" /></p>
		</div>
		<div data-role="content">
			<div data-role="filedcontain">
				<form id="frmLogin" method="POST"  data-ajax="false">
					<input type="hidden" name="hidden_login_flag" value="loginCheckMobile" />
					<label for="login_area_code">用户名</label>
					<input type="text" name="login_area.code" id="login_area_code" placeholder="请输入用户名" data-clear-btn="true" /> 
					<label for="login_area_pass">密码</label> 
					<input type="password" name="login_area.pass" id="login_area_pass" placeholder="请输入密码" data-clear-btn="true" />
					<div data-inline="true" align="center">
						<button onclick="check()" class="ui-btn ui-btn-icon-left ui-shadow ui-corner-all ui-icon-user" >登录</button>
					</div>
				<form>
			</div>
		</div>
		<div data-role="footer" align="center" data-position="fixed">
			<p><s:property value="#application.teamName" /></p>
			<p>version <s:property value="#application.version" /></p>
		</div>
	</div>
	<script type="text/javascript">
		//提交前的校验
		function check() {
			if ($('#login_area_code').val() == null || $('#login_area_code').val() == '') {
				alert("用户名不能为空...");
				return false;
			}
			if ($('#login_area_pass').val() == null || $('#login_area_pass').val() == '') {
				alert("密码不能为空...");
				return false;
			}
			
			$('#frmLogin').submit();
		}
		
		/**
		 * 生成随机字符串
		 * @param dstObj
		 * @param charsLength
		 * @param chars
		 */
		function randomString(charsLength) { 
		    var length=charsLength;
		    var chars="abcdefghijkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789";
		    var randomChars="";
		
		    for(var x=0; x<length; x++) {
		        var i=Math.floor(Math.random()*chars.length);
		        randomChars+=chars.charAt(i);
		    }
		    
		    return randomChars;
		}
		
	</script>
</body>
</html>