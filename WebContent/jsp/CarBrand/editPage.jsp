<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>修改车辆品牌</title>
<link rel="stylesheet" href="./js/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="./js/jqueryMobile/jquery.min.js"></script>
<script src="./js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="./js/common.js" ></script>
</head>
<body>
	<div data-role="page">
		<div data-role="header" align="center">
			<p>修改车辆品牌</p>
		</div>
		<div data-role="content">
		<form data-ajax="false">
			<input type="hidden" id="hidden_car_brand_id" value='<s:property value="carBrand.id" />' />
			<div class="ui-field-contain">
				<label for="car_brand_name">车辆品牌</label>
				<input type="text" name="car_brand_name" id="car_brand_name" data-clear-btn="true" value='<s:property value="carBrand.name" />' placeholder="请输入车辆品牌" />
			</div>
			<input type="button" class="ui-btn ui-corner-all"  onclick="editCarBrand()" value="修改" />
		</form>
		<script type="text/javascript">
				//修改车辆品牌
				function editCarBrand(){
					var car_brand_name=$('#car_brand_name').val();
					var hidden_car_brand_id=$('#hidden_car_brand_id').val();
					
					if(car_brand_name==null || car_brand_name.length==0){
						alert("请输入车辆品牌...");
						return;
					}
					
					var data={'carBrand.id':hidden_car_brand_id,'carBrand.name':car_brand_name};
					
					$.ajax({url:'/ParkCharge/CarBrand_edit',
						type:'post',
						data:data,
						contentType:"application/x-www-form-urlencoded; charset=UTF-8",
						success:function(json){
							if(json.data==true){
								alert("修改车辆品牌成功...");
								$.mobile.changePage('/ParkCharge/mainFramePage');
							}else{
								alert("修改失败,已有相同的车辆品牌...");
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