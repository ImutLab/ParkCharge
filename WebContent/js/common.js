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
		if (json.data == true) {
			alert("登录成功!");
			$('#frmLogin').submit();
		} else {
			alert("用户名或密码错误,登录失败");
		}
	});
}

// 数据备份
function backupDB() {
	$('#btn_backup').attr("style", "display:none");
	$.getJSON('/ParkCharge/SystemManager_backupDB', null, function(json) {
		alert(json.data);
	});
}

// 返回到主页
function goHome() {
	$.mobile.changePage('/ParkCharge/mainFramePage');
}

// 忘记密码页
function forgetPassPage() {
	$.mobile.changePage('/ParkCharge/forgetPassPage.jsp');
}

// 操作手册下载
function downCzsc() {
	location.href = "czsc.doc";
}

// 找回密码
function forgetPass() {
	var uname = $('#forget_uname').val();
	var uemail = $('#forget_uemail').val();

	if (uname == null || uname.length == 0) {
		alert("用户名不能为空...");
		return;
	}

	if (uemail == null || uemail.length == 0) {
		alert("邮箱不能为空...");
		return;
	}

	var data = {
		'uname' : uname,
		'uemail' : uemail
	};

	$.getJSON('/ParkCharge/Operator_forgetPass', data, function(json) {
		if (json.data == true) {
			alert("取回密码成功！请登录注册邮箱取得新密码.");
			location.href = '/ParkCharge/mobile.jsp';
		} else {
			alert("用户名或注册邮箱错误，取回密码失败!");
		}
	});

}