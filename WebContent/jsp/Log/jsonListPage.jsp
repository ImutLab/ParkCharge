<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>操作记录</title>
<link rel="stylesheet" href="./js/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="./js/jqueryMobile/jquery.min.js"></script>
<script src="./js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="./js/common.js" ></script>
</head>
<body>
	<div data-role="page">
		<div data-role="header" align="center">
			<p>操作记录</p>
		</div>
		<div data-role="content">
			<table data-role="table" id="table-collumn-toggle" data-mode="columntoggle" class="ui-responsive table-stroke" >
				<thead>
					<tr>
						<th data-priority="1">编号</th>
						<th data-priority="2">操作类型</th>
						<th data-priority="3">操作内容</th>
						<th data-priority="4">操作时间</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="list_log">
					<tr>
						<td><s:property value="sys_log_id" /></td>
						<td><s:property value="actionName" /></td>
						<td><s:property value="otherInfo" /></td>
						<td><s:property value="actionDate" /></td>
					</tr>
					</s:iterator>
				</tbody>
			</table>
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