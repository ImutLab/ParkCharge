<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.chenjie.util.FileUtils" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>IPAD端登录</title>
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
					<input type="text" name="uname" id="uname" value="admin" placeholder="请输入用户名" data-clear-btn="true" /> 
					<label for="upass">密码</label>
					<input type="password" name="upass" id="upass" value="" placeholder="请输入密码" data-clear-btn="true" />
					<div data-inline=true align="center">
						<input type="button" class="ui-btn ui-btn-inline ui-corner-all" onclick="checkLogin()" value="登录" />
						<input type="button" class="ui-btn ui-btn-inline ui-corner-all" onclick="forgetPassPage()" value="找回密码" />
					</div>
				</form>
				<script type="text/javascript">
					function forgetPassPage(){
						location.href="/ParkCharge/Operator_forgetPassPage";
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
			<p>
				<%
					//如果在当前文件夹下存在install.inf则显示初始化安装连接
					String filePath = request.getRealPath("/");
					String fileName = "install.inf";
					String fullFileName = filePath + fileName;

					if (FileUtils.fileExists(fullFileName)) {
				%>
					<a href="/ParkCharge/install?fileName=<%=fullFileName %>">初始化安装</a>
				<%
					}
				%>
			</p>
		</div>
	</div>
</body>
</html>