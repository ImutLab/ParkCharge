<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户修改</title>
<link rel="stylesheet" href="./js/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="./js/jqueryMobile/jquery.min.js"></script>
<script src="./js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="./js/common.js" ></script>
</head>
<body>
	<div data-role="page">
		<div data-role="header" align="center">
			<p>用户修改</p>
		</div>
		<div data-role="content">
		<form data-ajax="false">
			<input type="hidden" id="hidden_employee_id" value='<s:property value="employee.id" />' />
			<input type="hidden" id="hidden_car_id" value='<s:property value="car.id" />' />
			<input type="hidden" id="hidden_car_brand_id" value='<s:property value="carBrand.id" />' />
			<input type="hidden" id="hidden_car_color_id" value='<s:property value="carColor.id" />' />
			<div class="ui-field-contain">
				<label for="employee_name">姓名</label>
				<input type="text" name="employee.name" id="employee_name" data-clear-btn="true" value='<s:property value="employee.name" />' placeholder="请输入姓名" />
			</div>
			<div class="ui-field-contain">
				<label for="employee_id_card">身份证号</label>
				<input type="text" name="employee.id_card" id="employee_id_card" data-clear-btn="true" value='<s:property value="employee.id_card" />' placeholder="请输入身份证号" />
			</div>
			<div class="ui-field-contain">
				<label for="car.car_num">车辆号码</label>
				<input type="text" name="car.car_num" id="car_car_num" data-clear-btn="true" value='<s:property value="car.car_num" />' placeholder="请输入车辆号码" />
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
			<input type="button" class="ui-btn ui-corner-all"  onclick="editEmployee()" value="修改" />
		</form>
		<script type="text/javascript">
				
				//修改用户信息
				function editEmployee(){
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
					
					/**增加了车辆颜色检测**/
					var car_car_color_id=$('#car_car_color_id').val();
					if(car_car_color_id==null || car_car_color_id.length==0){
						alert("请选择车辆颜色...");
						return false;
					}
					
					/**增加了车辆品牌检测**/
					var car_car_brand_id=$('#car_car_brand_id').val();
					if(car_car_brand_id==null || car_car_brand_id.length==0){
						alert("请选择车辆品牌...");
						return false;
					}
					
					
					var data={
							'employee.id':$('#hidden_employee_id').val(),
							'employee.name':employee_name,
							'employee.id_card':employee_id_card,
							'employee.gender':$('#employee_gender').val(),
							'car.id':$('#hidden_car_id').val(),
							'car.car_num':$('#car_car_num').val(),
							'car.car_color.id':$('#car_car_color_id').val(),
							'car.car_brand.id':$('#car_car_brand_id').val(),
							'car.car_type':$('#car_car_type').val(),
							};
					
					$.ajax({url:'/ParkCharge/Employee_edit',
						type:'post',
						data:data,
						contentType:"application/x-www-form-urlencoded; charset=UTF-8",
						success:function(json){
							if(json.data==true){
								alert("修改用户信息成功...");
								location.href='/ParkCharge/Employee_jsonListPage';
							}else{
								alert("修改用户信息失败...");
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