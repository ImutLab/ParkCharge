//提交前的校验
function checkLogin() {
	var uname = $('#uname').val();
	var upass = $('#upass').val();
	if (uname == null || uname.length == 0) {
		alert("用户名不能为空...");
		return;
	}

	if (upass == null || upass.length == 0) {
		alert("密码不能为空...");
		return;
	}

	var data = {
		'uname' : uname,
		'upass' : upass
	};
	$.getJSON('/ParkCharge/login', data, function(json) {
		$('#frmLogin').submit();
	});
}

// 数据备份
function backupDB() {
	$.getJSON('/ParkCharge/SystemManager_backupDB', null, function(json) {
		alert(json.data);
	});
}

// 返回到主页
function goHome() {
	$.mobile.changePage('/ParkCharge/mainFramePage');
}