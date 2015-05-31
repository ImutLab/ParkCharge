<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>忘记密码</title>
<link rel="stylesheet" href="./js/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="./js/jqueryMobile/jquery.min.js"></script>
<script src="./js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="./js/common.js" ></script>
</head>
<body>
	<div data-role="page">
		<div data-role="header" align="center">
			<p>
				<s:property value="#application.projectName" />
			</p>
		</div>
		<div data-role="content">
			<div data-role="filedcontain">
				<form id="frmLogin" action="/ParkCharge/mainFramePage" method="POST" data-ajax="false">
					<label for="uname">用户名</label> 
					<input type="text" id="forget_uname" value="" placeholder="请输入用户名" data-clear-btn="true" /> 
					<label for="uemail">邮箱地址</label> 
					<input type="text" id="forget_uemail" value="" placeholder="请输入邮箱地址" data-clear-btn="true" />
					<div data-inline="true" align="center">
						<input type="button" class="ui-btn ui-corner-all" onclick="forgetPass()" value="找回密码" />
						<input type="button" class="ui-btn ui-corner-all" onclick="goMobile()" value="返回登录" />
					</div>
				</form>
				<script type="text/javascript">
					function goMobile(){
						location.href="mobile.jsp";
					}
				</script>
			</div>
		</div>
		<div data-role="footer" align="center" data-position="fixed">
			<p>
				<s:property value="#application.teamName" />
			</p>
			<p>
				version
				<s:property value="#application.version" />
			</p>
		</div>
	</div>
	
</body>
</html>