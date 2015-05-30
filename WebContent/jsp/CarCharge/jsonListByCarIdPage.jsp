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
<script type="text/javascript" src="./js/common.js" ></script>
</head>
<body>
	<div data-role="page">
		<div data-role="header" align="center">
			<p>缴费记录查询,车主:<s:property value="employee.name"/>,车辆编号:<s:property value="car.id"/></p>
		</div>
		<div data-role="content">
			<table data-role="table" id="table-collumn-toggle" data-mode="columntoggle" class="ui-responsive table-stroke" >
				<thead>
					<tr>
						<th data-priority="1">缴费编号</th>
						<th data-priority="2">缴费时间</th>
						<th data-priority="3">到期时间</th>
						<th data-priority="4">缴费金额</th>
						<th data-priority="5">删除</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="list_car_charge">
					<tr>
						<td><s:property value="car_charge_id" /></td>
						<td><s:property value="charge_date" /></td>
						<td><s:property value="expire_date" /></td>
						<td><s:property value="money" /></td>
						<td><a href="#" onclick='delCharge(<s:property value="car_charge_id" />)'>删除</a></td>
					</tr>
					</s:iterator>
				</tbody>
			</table>
			<input type="hidden" id="hidden_car_id" value='<s:property value="car.id"/>'>
		</div>
		
		<script type="text/javascript">
		
		//删除收费记录
		function delCharge(car_charge_id){
			var isDel=confirm("是否要删除缴费编号为: "+car_charge_id+" 的记录?");
			if(isDel==true){
				var data={'id':car_charge_id};
				$.getJSON('ParkCharge/CarCharge_del',data,function(json){
					alert(json.data);
					location.href='/ParkCharge/CarCharge_jsonListByCarIdPage?car.id='+$('#hidden_car_id').val(); 
				});
			}
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