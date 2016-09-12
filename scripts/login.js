$(document).ready(function() {
	
	var tt = new Date().format("yyyy年MM月dd日");
	var day = new Date().getDay();
	if (day == 1){
		day = "一";
	} else if (day == 2){
		day = "二";
	} else if (day == 3){
		day = "三";
	} else if (day == 4){
		day = "四";
	} else if (day == 5){
		day = "五";
	} else if (day == 6){
		day = "六";
	} else if (day == 7){
		day = "日";
	}
	$("#dd").text(tt + " 星期" + day);

	$("#loginBtn").click(function(event) {
		var username = $("#username").val();
		var password = $("#password").val();
		if (username.trim() == "") {
			$("#errorIDorPWD").html("请输入帐号");
			return;
		}
		if (password.trim() == "") {
			$("#errorIDorPWD").html("请输入密码");
			return;
		}
		$.ajax({
			type : "POST",
			url : "login.do",
			dataType : 'json',
			data : {
				username : username,
				password : password
			},
			success : function(data) {
				if (data.login != "true") {
					$("#password").val("");
					$("#errorIDorPWD").html("帐号或密码错误");
				} else {
					window.location = "main.do";
				}
			}
		});
	});

	document.onkeydown = function(event) {
		var e = event || window.event || arguments.callee.caller.arguments[0];
		if (e && e.keyCode == 13) {
			document.getElementById("loginBtn").click();
		}
	};
});