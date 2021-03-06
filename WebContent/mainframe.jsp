<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><s:property value="#application.projectName" /></title>
<link rel="stylesheet" href="./js/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="./js/jqueryMobile/jquery.min.js"></script>
<script src="./js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="./js/common.js" ></script>
</head>
<body>

	<div data-role="page">
		<div data-role="header" align="center">
			<p><s:property value="#application.projectName" /></p>
		</div>
		<div data-role="content">
			<div data-role="collapsible" data-inset="true">
				<h2>信息登记</h2>
				<ul data-role="listview" >
					<li><a href="/ParkCharge/Employee_addPage">新户登记</a></li>
					<li><a href="/ParkCharge/Employee_jsonListPage">人员管理</a></li>
					<li><a href="/ParkCharge/CarBrand_jsonListPage">车辆品牌</a></li>
					<li><a href="/ParkCharge/CarColor_jsonListPage">车辆颜色</a></li>
				</ul>
			</div>
			<div data-role="collapsible" data-inset="true">
				<h2>缴费管理</h2>
				<ul data-role="listview" >
					<li><a href="/ParkCharge/CarCharge_addPage">用户缴费</a></li>
					<li><a href="/ParkCharge/CarCharge_jsonListPage">缴费记录</a></li>
					<li><a href="/ParkCharge/CarCharge_expireListPage">欠费查询</a></li>
				</ul>
			</div>
			<div data-role="collapsible" data-inset="true">
				<h2>系统管理</h2>
				<ul data-role="listview" >
					<li><a href="/ParkCharge/Operator_editPassPage">修改密码</a></li>
					<li><a href="/ParkCharge/Operator_sendSuggestPage">功能建议</a></li>
					<li><a id="btn_backup" href="#" onclick="backupDB()">数据备份</a></li>
					<li><a href="/ParkCharge/Log_jsonListPage">操作记录</a></li>
				</ul>
			</div>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href="#messageIsTopPage" data-icon="back" data-transition="flow" data-rel="popup" data-position-to="window">返回</a></li>
					<li><a href="#messageIsmainframe_mobile" data-icon="home" data-transition="flow" data-rel="popup" data-position-to="window">主页</a></li>
					<li><a href="#aboutMainframe_mobile" data-icon="comment" data-transition="flow" data-rel="popup" data-position-to="window">关于</a></li>
				</ul>
			</div>
		</div>
		<div data-role="popup" id="aboutMainframe_mobile" class="ui-content">
			<p>
				<s:property value="#application.projectName" />
			</p>
		</div>
		<div data-role="popup" id="messageIsmainframe_mobile" class="ui-content">
			<p>已回到主页了</p>
		</div>
		<div data-role="popup" id="messageIsTopPage" class="ui-content">
			<p>已经是首页了，不能再返回了</p>
		</div>
	</div>
</body>
</html>