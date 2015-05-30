<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>修改密码</title>
<link rel="stylesheet" href="./js/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="./js/jqueryMobile/jquery.min.js"></script>
<script src="./js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="./js/common.js" ></script>
</head>
<body>
	<div data-role="page">
		<div data-role="header" align="center">
			<p>修改密码</p>
		</div>
		<div data-role="content">
		<form data-ajax="false">
			<div class="ui-field-contain">
				<label for="oldPass">原密码</label>
				<input type="password" name="oldPass" id="oldPass" data-clear-btn="true" value="" placeholder="请输入原密码" />
			</div>
			<div class="ui-field-contain">
				<label for="newPass">新密码</label>
				<input type="password" name="newPass" id="newPass" data-clear-btn="true" value="" placeholder="请输入新密码" />
			</div>
			<div class="ui-field-contain">
				<label for="upass">确认密码</label>
				<input type="password" name="upass" id="upass" data-clear-btn="true" value="" placeholder="请输入确认密码" />
			</div>
			<input type="button" class="ui-btn ui-corner-all"  onclick="editPass()" value="修改" />
		</form>
		<script type="text/javascript">
				//登记信息
				function editPass(){
					var oldPass=$('#oldPass').val();
					if(oldPass==null || oldPass.length==0){
						alert("请输入旧密码...");
						return;
					}
					var newPass=$('#newPass').val();
					if(newPass==null || newPass.length==0){
						alert("请输入新密码...");
						return;
					}
					var upass=$('#upass').val();
					if(upass==null || upass.length==0){
						alert("请输入确认密码...");
						return;
					}
					
					if(upass!=newPass){
						alert("两次密码输入不一致...");
						return;
					}
					
					var data={'oldPass':oldPass,'upass':upass};
					
					$.ajax({url:'/ParkCharge/Operator_editPass',
						type:'post',
						data:data,
						contentType:"application/x-www-form-urlencoded; charset=UTF-8",
						success:function(json){
							if(json.data==true){
								alert("修改密码成功...");
								$.mobile.changePage('/ParkCharge/mainFramePage');
							}else{
								alert("修改密码失败，旧密码不正确...");
							}
						},
						});
					
				}
				 
			</script>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href="#" data-rel="back" data-icon="back">返回</a></li>
					<li><a href="#" onclick="goHome()" data-icon="home">主页</a></li>
					<li><a href="#aboutJsonListPage" data-icon="comment" data-transition="flow" data-rel="popup" data-position-to="window">关于</a></li>
				</ul>
			</div>
			<div data-role="popup" id="aboutJsonListPage" class="ui-content">
				<p><s:property value="#application.projectName" /></p>
			</div>
		</div>
	</div>
</body>
</html>