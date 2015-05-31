<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>安装成功</title>
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
				初始化安装成功!&nbsp;初始用户名:&nbsp;admin,初始密码:&nbsp;123456&nbsp;&nbsp;&nbsp;&nbsp;<a href="mobile.jsp" >返回到登录页</a>
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