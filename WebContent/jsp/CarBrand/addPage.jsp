<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>新增车辆品牌</title>
<link rel="stylesheet" href="./js/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="./js/jqueryMobile/jquery.min.js"></script>
<script src="./js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page" id="">
		<div data-role="header" align="center">
			<p>新增车辆品牌</p>
		</div>
		<div data-role="content">
		<form id="form_Employee_add" action="/ParkCharge/Employee/add" method="POST" data-ajax="false">
			<div class="ui-field-contain">
				<label for="car_brand_name">车辆品牌</label>
				<input type="text" name="car_brand_name" id="car_brand_name" data-clear-btn="true" value="" placeholder="请输入车辆品牌" />
			</div>
			<input type="button" class="ui-btn ui-corner-all"  onclick="addCarBrand()" value="添加" />
		</form>
		<script type="text/javascript">
				//登记信息
				function addCarBrand(){
					var car_brand_name=$('#car_brand_name').val();
					if(car_brand_name==null || car_brand_name.length==0){
						alert("请输入车辆品牌...");
						return;
					}
					
					var data={'carBrand.name':car_brand_name};
					
					$.ajax({url:'/ParkCharge/CarBrand/add',
						type:'post',
						data:data,
						contentType:"application/x-www-form-urlencoded; charset=UTF-8",
						success:function(json){
							if(json.data==true){
								alert("新增车辆品牌成功...");
								$.mobile.changePage('/ParkCharge/mainFramePage');
							}else{
								alert("新增车辆品牌失败，已有相同名称的车辆品牌...");
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
				<p><s:property value="#application.teamName" /></p>
			</div>
		</div>
	</div>
</body>
</html>