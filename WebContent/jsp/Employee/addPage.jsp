<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>新户登记</title>
<link rel="stylesheet" href="./js/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="./js/jqueryMobile/jquery.min.js"></script>
<script src="./js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page" id="">
		<div data-role="header" align="center">
			<p>新户登记</p>
		</div>
		<div data-role="content">
		<form id="form_Employee_add" action="/ParkCharge/Employee/add" method="POST" data-ajax="false">
			<div class="ui-field-contain">
				<label for="employee_name">姓名</label>
				<input type="text" name="employee.name" id="employee_name" data-clear-btn="true" value="" placeholder="请输入姓名" />
			</div>
			<div class="ui-field-contain">
				<label for="employee_id_card">身份证号</label>
				<input type="text" name="employee.id_card" id="employee_id_card" data-clear-btn="true" value="" placeholder="请输入身份证号" />
			</div>
			<div class="ui-field-contain">
				<label for="car.car_num">车辆号码</label>
				<input type="text" name="car.car_num" id="car_car_num" data-clear-btn="true" value="" placeholder="请输入车辆号码" />
			</div>
			<div class="ui-field-contain">
				<label for="carCharge_money">缴费金额</label>
				<input type="number" name="carCharge.money" id="carCharge_money" data-clear-btn="true" pattern="[0-9]*" placeholder="请输入缴费金额" />
			</div>
			<div class="ui-field-contain">
				<label for="carCharge_charge_date">登记日期</label>
				<input type="date" data-clear-btn="true" name="carCharge.charge_date" id="carCharge_charge_date" placeholder="请输入登记日期" value='<s:property value="charge_date" />' />
			</div>
			<div class="ui-field-contain">
				<label for="employee_gender">性别</label>
				<select name="employee.gender" id="employee_gender">
					<option value="0">男</option>
					<option value="1">女</option>
				</select>
			</div>
			<div class="ui-field-contain">
				<label for="car.car_color_id">车辆颜色</label>
				<select name="car.car_color_id" id="car_car_color_id">
					<s:iterator value="list_carColor">
						<option value='<s:property value="id"/>'
						<s:if test="id==carColor.id">selected='selected'</s:if>
						><s:property value="name"/></option>
					</s:iterator>
				</select>
			</div>
			<div class="ui-field-contain">
				<label for="car.car_brand_id">车辆品牌</label>
				<select name="car.car_brand_id" id="car_car_brand_id">
					<s:iterator value="list_carBrand">
						<option value='<s:property value="id"/>' 
						<s:if test="id==carBrand.id">selected='selected'</s:if>
						><s:property value="name"/></option>
					</s:iterator>
				</select>
			</div>
			<div class="ui-field-contain">
				<label for="car.car_brand">车辆类型</label>
				<select name="car.car_type" id="car_car_type">
					<option value="0">电动车</option>
					<option value="1">摩托车</option>
					<option value="2">小汽车</option>
				</select>
			</div>
			<input type="button" class="ui-btn ui-corner-all"  onclick="regInfo()" value="登记" />
		</form>
		<script type="text/javascript">
				/* $(function(){
					//初始化车辆颜色
					$.getJSON('/ParkCharge/CarColor/getJsonList',null,function(json){
						var car_car_color_id=$('#car_car_color_id');
						var rows=json.rows;
						$(rows).each(function(i){
							var x=rows[i];
							car_car_color_id.append("<option value='"+x.car_color_id+"'>"+x.name+"</option>");
						});
					});
					
					//初始化车辆品牌
					$.getJSON('/ParkCharge/CarBrand/getJsonList',null,function(json){
						var car_car_brand_id=$('#car_car_brand_id');
						var rows=json.rows;
						$(rows).each(function(i){
							var x=rows[i];
							car_car_brand_id.append("<option value='"+x.car_brand_id+"'>"+x.name+"</option>");
						});
					});
				});
				 */
				//登记信息
				function regInfo(){
					var employee_name=$('#employee_name').val();
					if(employee_name==null || employee_name.length==0){
						alert("请输入用户名称...");
						return false;
					}
					
					var employee_id_card=$('#employee_id_card').val();
					if(employee_id_card==null || employee_id_card.length==0){
						alert("请输入身份证号...");
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
							'employee.name':employee_name,
							'employee.id_card':employee_id_card,
							'employee.gender':$('#employee_gender').val(),
							'car.car_num':$('#car_car_num').val(),
							'car.car_color.id':$('#car_car_color_id').val(),
							'car.car_brand.id':$('#car_car_brand_id').val(),
							'car.car_type':$('#car_car_type').val(),
							'carCharge.money':carCharge_money,
							'carCharge.charge_date':carCharge_charge_date
							};
					
					$.ajax({url:'/ParkCharge/Employee/add',
						type:'post',
						data:data,
						contentType:"application/x-www-form-urlencoded; charset=UTF-8",
						success:function(json){
							if(json.data==true){
								alert("新户登记成功...");
								$.mobile.changePage('/ParkCharge/mainFramePage');
							}else{
								alert("新户登记失败...");
							}
						},
						});
					
				}
				 
				//返回到主页
				function goHome(){
					$.mobile.changePage('/ParkCharge/mainFramePage'); 
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