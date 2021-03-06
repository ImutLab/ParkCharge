<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>欠费查询</title>
<link rel="stylesheet" href="./js/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="./js/jqueryMobile/jquery.min.js"></script>
<script src="./js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="./js/common.js" ></script>
</head>
<body>
	<div data-role="page">
		<div data-role="header" align="center">
			<p>欠费查询</p>
		</div>
		<div data-role="content">
			<table data-role="table" id="table-collumn-toggle" data-mode="columntoggle" class="ui-responsive table-stroke" >
				<thead>
					<tr>
						<th data-priority="1">车主编号</th>
						<th data-priority="1">姓名</th>
						<th data-priority="2">到期时间</th>
						<th data-priority="3">车辆品牌</th>
						<th data-priority="4">车辆颜色</th>
						<th data-priority="5">车辆注销</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="list_car_charge">
					<tr>
						<td><s:property value="employee_id" /></td>
						<td><s:property value="emp_name" /></td>
						<td><s:property value="expire_date" /></td>
						<td><s:property value="car_brand_name" /></td>
						<td><s:property value="car_color_name" /></td>
						<td><a onclick='destoryCar(<s:property value="car_id" />)'>注销</a></td>
					</tr>
					</s:iterator>
				</tbody>
			</table>
			<script type="text/javascript">
				//用户注销
				function destoryCar(car_id){
					var isdel=confirm("是否要注销此车辆?");
					if(isdel==true){
						var data={
								'car.id':car_id,
								};
						
						$.mobile.changePage('/ParkCharge/Car_destoryCar',{
							type:'post',
							data:data,
						});
					}
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