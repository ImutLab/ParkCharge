<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>缴费记录查询</title>
<link rel="stylesheet" href="./js/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="./js/jqueryMobile/jquery.min.js"></script>
<script src="./js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page">
		<div data-role="header" align="center">
			<p>缴费记录查询</p>
		</div>
		<div data-role="content">
			<table data-role="table" id="table-collumn-toggle" data-mode="columntoggle" class="ui-responsive table-stroke" >
				<thead>
					<tr>
						<th data-priority="4">缴费编号</th>
						<th data-priority="3">缴费时间</th>
						<th data-priority="2">到期时间</th>
						<th data-priority="1">缴费金额</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="list_car_charge">
					<tr>
						<td><s:property value="car_charge_id" /></td>
						<td><s:property value="charge_date" /></td>
						<td><s:property value="expire_date" /></td>
						<td><s:property value="money" /></td>
					</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
		
		<script type="text/javascript">
		//返回到主页
		function goHome(){
			$.mobile.changePage('/ParkCharge/mainFramePage'); 
		}
		</script>
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