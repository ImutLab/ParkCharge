<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>软件功能建议</title>
<link rel="stylesheet" href="./js/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="./js/jqueryMobile/jquery.min.js"></script>
<script src="./js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="./js/common.js" ></script>
</head>
<body>
	<div data-role="page">
		<div data-role="header" align="center">
			<p>软件功能建议</p>
		</div>
		<div data-role="content">
		<form data-ajax="false">
			<div class="ui-field-contain">
				<label for="suggest_type">建议类型</label>
				<select name="suggest_type" id="suggest_type">
					<option value="使用问题">使用问题</option>
					<option value="功能不够">功能不够</option>
					<option value="软件错误">软件错误</option>
				</select>
			</div>
			<div class="ui-field-contain">
				<label for="suggest_content">建议内容</label>
				<textarea name="suggest_content" id="suggest_content" cols="40" rows="8" data-clear-btn="true" value="" placeholder="请输入建议内容..."></textarea>
			</div>
			<input type="button" class="ui-btn ui-corner-all"  onclick="sendSuggest()" value="发送建议" />
		</form>
		<script type="text/javascript">
				//登记信息
				function sendSuggest(){
					var suggest_type=$('#suggest_type').val();
					if(suggest_type==null || suggest_type.length==0){
						alert("请选择建议类型...");
						return;
					}
					
					var suggest_content=$('#suggest_content').val();
					if(suggest_content==null || suggest_content.length==0){
						alert("请输入建议内容...");
						return;
					}
					
					var data={'suggest_type':suggest_type,'suggest_content':suggest_content};
					
					$.ajax({url:'/ParkCharge/Operator_sendSuggest',
						type:'post',
						data:data,
						contentType:"application/x-www-form-urlencoded; charset=UTF-8",
						success:function(json){
							if(json.data==true){
								alert("发送建议成功...");
								location.href='/ParkCharge/mainFramePage';
							}else{
								alert("发送失败...");
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