<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户缴费</title>
<link rel="stylesheet" href="./js/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="./js/jqueryMobile/jquery.min.js"></script>
<script src="./js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="./js/common.js" ></script>
</head>
<body>
	<div data-role="page">
		<div data-role="header" align="center">
			<p>用户缴费</p>
		</div>
		<div data-role="content">
		<form data-ajax="false">
			<input type="hidden" id="car_car_id" name="car.car_id" value="" />
			<div class="ui-field-contain">
				<label for="employee_id">姓名</label>
				<select name="employee.id" id="employee_id">
					<s:iterator value="list_employee">
						<option value='<s:property value="employee_id"/>'><s:property value="name"/></option>
					</s:iterator>
				</select>
			</div>
			<div class="ui-field-contain">
				<label for="carCharge_money">缴费金额</label>
				<input type="number" name="carCharge.money" id="carCharge_money" data-clear-btn="true" placeholder="请输入缴费金额" />
			</div>
			<div class="ui-field-contain">
				<label for="carCharge_charge_date">缴费日期</label>
				<input type="date" data-clear-btn="true" name="carCharge.charge_date" id="carCharge_charge_date" placeholder="请输入缴费日期" />
			</div>
			<div class="ui-field-contain">
				<label for="employee_id_card">身份证号</label>
				<input type="text" name="employee.id_card" id="employee_id_card" value="" readonly="readonly" placeholder="请输入身份证号" />
			</div>
			<div class="ui-field-contain">
				<label for="employee_gender">性别</label>
				<input type="text" name="employee.gender" id="employee_gender" readonly="readonly" />
			</div>
			<div class="ui-field-contain">
				<label for="car.car_num">车辆号码</label>
				<input type="text" name="car.car_num" id="car_car_num" value="" readonly="readonly" placeholder="请输入车辆号码" />
			</div>
			<div class="ui-field-contain">
				<label for="car.car_color_id">车辆颜色</label>
				<input type="text" name="car.car_color_id" id="car_car_color_id" readonly="readonly" />
			</div>
			<div class="ui-field-contain">
				<label for="car.car_brand_id">车辆品牌</label>
				<input type="text" name="car.car_brand_id" id="car_car_brand_id" readonly="readonly" />
			</div>
			<div class="ui-field-contain">
				<label for="car.car_brand">车辆类型</label>
				<input type="text" name="car.car_type" id="car_car_type" readonly="readonly" />
			</div>
			<input type="button" class="ui-btn ui-corner-all"  onclick="addCharge()" value="缴费" />
		</form>
		<script type="text/javascript">
				$(function(){
					//绑定人员选择事件，当选择人员的时候，就向后台发送人员id获取人员json数据
					$('#employee_id').change(function(){
						getEmployeeInfo();
					});
					
					//获取用户的信息
					function getEmployeeInfo(){
						var employee_id=$('#employee_id').val();
						$.getJSON('/ParkCharge/Employee_getJsonEmployeeCarByEmpId?id='+employee_id,null,function(json){
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
					}
					
					//首次进入界面的时候，初始化第一个用户的信息
					getEmployeeInfo();
				});
				
				//缴费
				function addCharge(){
					var employee_id_card=$('#employee_id_card').val();
					if(employee_id_card==null || employee_id_card.length==0){
						alert("请选择缴费人员...");
						return false;
					}
					
					var carCharge_money=$('#carCharge_money').val();
					if(carCharge_money==null || carCharge_money.length==0){
						alert("请输入缴费金额...");
						return false;
					}
					
					var carCharge_charge_date=$('#carCharge_charge_date').val();
					if(carCharge_charge_date==null || carCharge_charge_date.length==0){
						alert("请输入登记日期...");
						return false;
					}
					
					var data={
							'car.id':$('#car_car_id').val(),
							'carCharge.money':carCharge_money,
							'carCharge.charge_date':$('#carCharge_charge_date').val()
							};
					
					$.ajax({url:'/ParkCharge/CarCharge_add',
						type:'post',
						data:data,
						contentType:"application/x-www-form-urlencoded; charset=UTF-8",
						success:function(json){
							var isQueryCarCharge=confirm("缴费成功，是否查看该车主缴费记录?");
							if(isQueryCarCharge==true){
								location.href='/ParkCharge/CarCharge_jsonListByCarIdPage?car.id='+json.car_id;
							}else{
								$.mobile.changePage('/ParkCharge/mainFramePage');
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