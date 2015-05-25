<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				<form id="frmLogin" action="login" method="POST" data-ajax="false">
					<label for="uname">用户名</label> 
					<input type="text" name="uname" id="uname" value="admin" placeholder="请输入用户名" data-clear-btn="true" /> 
					<label for="upass">密码</label> 
					<input type="password" name="upass" id="upass" value="12345" placeholder="请输入密码" data-clear-btn="true" />
					<div data-inline="true" align="center">
						<input type="button" class="ui-btn ui-corner-all" onclick="checkLogin()" value="登录" />
					</div>
				</form>
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

	<script type="text/javascript">
		//提交前的校验
		function checkLogin() {
			var uname=$('#uname').val();
			var upass=$('#upass').val();
			if (uname == null || uname.length==0) {
				alert("用户名不能为空...");
				return;
			}
			
			if (upass == null || upass.length==0) {
				alert("密码不能为空...");
				return;
			}
			
			$('#frmLogin').submit();
		}
	</script>
</body>
</html>