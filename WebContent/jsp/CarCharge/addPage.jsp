<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户缴费</title>
<link rel="stylesheet" href="./js/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="./js/jquery.min.js"></script>
<script src="./js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page" id="">
		<div data-role="header" align="center">
			<p>用户缴费</p>
		</div>
		<div data-role="content">
		<form id="form_Employee_add">
			<input type="hidden" id="car_car_id" name="car.car_id" value="" />
			<div class="ui-field-contain">
				<label for="employee_id">姓名</label>
				<select name="employee.id" id="employee_id"></select>
			</div>
			<div class="ui-field-contain">
				<label for="employee_id_card">身份证号</label>
				<input type="text" name="employee.id_card" id="employee_id_card" data-clear-btn="true" value="" disabled="disabled" placeholder="请输入身份证号" />
			</div>
			<div class="ui-field-contain">
				<label for="employee_gender">性别</label>
				<input type="text" name="employee.gender" id="employee_gender" disabled="disabled" />
			</div>
			<div class="ui-field-contain">
				<label for="car.car_num">车辆号码</label>
				<input type="text" name="car.car_num" id="car_car_num" data-clear-btn="true" value="" disabled="disabled" placeholder="请输入车辆号码" />
			</div>
			<div class="ui-field-contain">
				<label for="car.car_color_id">车辆颜色</label>
				<input type="text" name="car.car_color_id" id="car_car_color_id" disabled="disabled" />
			</div>
			<div class="ui-field-contain">
				<label for="car.car_brand_id">车辆品牌</label>
				<input type="text" name="car.car_brand_id" id="car_car_brand_id" disabled="disabled" />
			</div>
			<div class="ui-field-contain">
				<label for="car.car_brand">车辆类型</label>
				<input type="text" name="car.car_type" id="car_car_type" disabled="disabled" />
			</div>
			<div class="ui-field-contain">
				<label for="carCharge_money">缴费金额</label>
				<input type="number" name="carCharge.money" id="carCharge_money" data-clear-btn="true" placeholder="请输入缴费金额" />
			</div>
			<div class="ui-field-contain">
				<label for="carCharge_charge_date">缴费日期</label>
				<input type="datetime" data-clear-btn="true" name="carCharge.charge_date" id="carCharge_charge_date" placeholder="请输入缴费日期" />
			</div>
			<input type="button" class="ui-btn ui-corner-all"  onclick="addCharge()" value="缴费" />
		</form>
		<script type="text/javascript">
				$(function(){
					//初始化人员选择
					$.getJSON('/ParkCharge/Employee/getJsonList',null,function(json){
						var employee_id=$('#employee_id');
						var rows=json.rows;
						$(rows).each(function(i){
							var x=rows[i];
							employee_id.append("<option value='"+x.employee_id+"'>"+x.name+"</option>");
						});
					});
					
					
					//绑定人员选择事件，当选择人员的时候，就向后台发送人员id获取人员json数据
					$('#employee_id').change(function(){
						var employee_id=$('#employee_id').val();
						
						$.getJSON('/ParkCharge/Employee/getJsonEmployeeCarByEmpId?id='+employee_id,null,function(json){
							var data=json.data;
							$('#employee_id_card').val(data.id_card);
							$('#employee_gender').val(data.gender_name);
							$('#car_car_num').val(data.car_num);
							$('#car_car_brand_id').val(data.car_brand_name);
							$('#car_car_color_id').val(data.car_color_name);
							$('#car_car_type').val(data.car_type_name);
							$('#carCharge_charge_date').val(json.charge_date);
							$('#car_car_id').val(data.car_id);
							
							
						});
					});
				});
				
				//缴费
				function addCharge(){
					var data={
							'car.id':$('#car_car_id').val(),
							'carCharge.money':$('#carCharge_money').val(),
							'carCharge.charge_date':$('#carCharge_charge_date').val()
							};
					
					$.ajax({url:'/ParkCharge/CarCharge/add',
						type:'post',
						data:data,
						contentType:"application/x-www-form-urlencoded; charset=UTF-8",
						});
					
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