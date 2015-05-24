<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>修改车辆颜色</title>
<link rel="stylesheet" href="./js/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="./js/jqueryMobile/jquery.min.js"></script>
<script src="./js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page" id="">
		<div data-role="header" align="center">
			<p>修改车辆颜色</p>
		</div>
		<div data-role="content">
		<form id="form_Employee_add" >
			<input type="hidden" id="hidden_car_color_id" value='<s:property value="carColor.id" />' />
			<div class="ui-field-contain">
				<label for="car_color_name">车辆颜色</label>
				<input type="text" name="car_color_name" id="car_color_name" data-clear-btn="true" value='<s:property value="carColor.name" />' placeholder="请输入车辆颜色" />
			</div>
			<input type="button" class="ui-btn ui-corner-all"  onclick="editCarColor()" value="修改" />
		</form>
		<script type="text/javascript">
				//修改车辆品牌
				function editCarColor(){
					var car_color_name=$('#car_color_name').val();
					var hidden_car_color_id=$('#hidden_car_color_id').val();
					
					if(car_color_name==null || car_color_name.length==0){
						alert("请输入车辆颜色...");
						return;
					}
					
					var data={'carColor.id':hidden_car_color_id,'carColor.name':car_color_name};
					
					$.ajax({url:'/ParkCharge/CarColor/edit',
						type:'post',
						data:data,
						contentType:"application/x-www-form-urlencoded; charset=UTF-8",
						success:function(json){
							if(json.data==true){
								alert("修改车辆颜色成功...");
								$.mobile.changePage('/ParkCharge/mainFramePage');
							}else{
								alert("修改车辆颜色失败，已有相同名称的车辆颜色...");
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