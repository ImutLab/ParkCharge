<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>新户登记</title>
<link rel="stylesheet" href="./js/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="./js/jquery.min.js"></script>
<script src="./js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page" id="">
		<div data-role="header" align="center">
			<p>新户登记</p>
		</div>
		<div data-role="content">
		<form action="">
			<div class="ui-field-contain">
				<label for="employee.name">姓名</label>
				<input type="text" name="employee.name" id="employee_name" data-clear-btn="true" value="" placeholder="请输入姓名" />
			</div>
			<div class="ui-field-contain">
				<label for="employee.id_card">身份证号</label>
				<input type="text" name="employee.id_card" id="employee_id_card" data-clear-btn="true" value="" placeholder="请输入身份证号" />
			</div>
			<div class="ui-field-contain">
				<label for="employee.gender">性别</label>
				<select name="employee.gender" id="employee_gender">
					<option value="男">男</option>
					<option value="女">女</option>
				</select>
			</div>
			<div class="ui-field-contain">
				<label for="car.car_num">车辆号码</label>
				<input type="text" name="car.car_num" id="car_car_num" data-clear-btn="true" value="" placeholder="请输入车辆号码" />
			</div>
			<div class="ui-field-contain">
				<label for="car.car_color">车辆颜色</label>
				<select name="car.car_color" id="car_car_color"></select>
			</div>
			<div class="ui-field-contain">
				<label for="car.car_brand">车辆品牌</label>
				<select name="car.car_brand" id="car_car_brand"></select>
			</div>
			<div class="ui-field-contain">
				<label for="car.car_brand">车辆类型</label>
				<select name="car.car_type" id="car_car_type">
					<option value="0">电动车</option>
					<option value="1">摩托车</option>
					<option value="2">小汽车</option>
				</select>
			</div>
			<div class="ui-field-contain">
				<label for="money">缴费金额</label>
				<input type="number" name="money" id="money" data-clear-btn="true" placeholder="请输入缴费金额" />
			</div>
			<div class="ui-field-contain">
				<label for="reg_date">登记日期</label>
				<input type="datetime" data-clear-btn="true" name="reg_date" id="reg_date" placeholder="请输入登记日期" >
			</div>
			<a href="#" class="ui-btn ui-corner-all"  onclick="regInfo()">登记</a>
		</form>
		<script type="text/javascript">
				$(function(){
					//初始化车辆颜色
					$.getJSON('/ParkCharge/CarColor/getJsonList',null,function(json){
						var car_car_color=$('#car_car_color');
						var rows=json.rows;
						$(rows).each(function(i){
							var x=rows[i];
							car_car_color.append("<option value='"+x.car_color_id+"'>"+x.name+"</option>");
						});
					});
					
					//初始化车辆品牌
					$.getJSON('/ParkCharge/CarBrand/getJsonList',null,function(json){
						var car_car_brand=$('#car_car_brand');
						var rows=json.rows;
						$(rows).each(function(i){
							var x=rows[i];
							car_car_brand.append("<option value='"+x.car_brand_id+"'>"+x.name+"</option>");
						});
					});
				});
				
				//登记信息
				function regInfo(){
					alert("按了下登记按钮");
				}
			</script>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href="#" data-rel="back" data-icon="back">返回</a></li>
					<li><a href="/ParkCharge/mainFramePage" data-icon="home">主页</a></li>
					<li><a href="#aboutJsonListPage" data-icon="comment" data-transition="flow" data-rel="popup" data-position-to="window">关于</a></li>
				</ul>
			</div>
			<div data-role="popup" id="aboutJsonListPage" class="ui-content">
				<p><s:property value="#application.teamName" /></p>
			</div>
		</div>
	</div>
</body>
</html>