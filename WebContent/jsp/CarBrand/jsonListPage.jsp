<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>车辆品牌管理</title>
<link rel="stylesheet" href="./js/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="./js/jqueryMobile/jquery.min.js"></script>
<script src="./js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page" id="">
		<div data-role="header" align="center">
			<p>车辆品牌管理</p>
		</div>
		<div data-role="content">
			<a href="#" onclick="addCarBrandPage()" >添加车辆品牌</a>
			<table data-role="table" id="table-collumn-toggle" data-mode="columntoggle" class="ui-responsive table-stroke" >
				<thead>
					<tr>
						<th data-priority="1">编号</th>
						<th data-priority="2">车辆品牌</th>
						<th data-priority="3">修改</th>
						<th data-priority="4">删除</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="list_carBrand">
					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="name" /></td>
						<td><a onclick='editPage(<s:property value="id" />)'>修改</a></td>
						<td><a onclick='del(<s:property value="id" />)'>删除</a></td>
					</tr>
					</s:iterator>
				</tbody>
			</table>
			<script type="text/javascript">
				//修改车辆品牌
				function editPage(car_brand_id){
					var data={'id':car_brand_id};
					$.mobile.changePage('/ParkCharge/CarBrand/editPage',{
						type:'post',
						data:data,
					}); 
				}
				
				//删除车辆品牌
				function del(car_brand_id){
					var data={'id':car_brand_id};
					var isdel=confirm("是否要删除该车辆品牌?");
					if(isdel==true){
						$.getJSON('/ParkCharge/CarBrand/del',data,function(json){
							if(json.data==true){
								alert("删除车辆品牌成功...");
								$.mobile.changePage('/ParkCharge/mainFramePage');
							}else{
								alert("删除失败,该品牌已经被使用...");
							}
						});
					}
					
					
					
				}
				
				//添加车辆品牌页面
				function addCarBrandPage(){
					$.mobile.changePage('/ParkCharge/CarBrand/addPage'); 
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