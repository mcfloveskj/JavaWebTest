<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css"
	href="${ctp}/scripts/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctp}/css/common.css">
<link rel="stylesheet" type="text/css"
	href="${ctp}/scripts/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${ctp}/css/default.css">
<script type="text/javascript" src="${ctp}/scripts/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="${ctp}/scripts/jquery.form.js"></script>
<script type="text/javascript"
	src="${ctp}/scripts/easyui/jquery.easyui-1.3.1.min.js"></script>
<script type="text/javascript"
	src="${ctp}/scripts/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	Date.prototype.format = function(fmt) { //author: meizz 
		var o = {
			"M+" : this.getMonth() + 1, //月份 
			"d+" : this.getDate(), //日 
			"h+" : this.getHours(), //小时 
			"m+" : this.getMinutes(), //分 
			"s+" : this.getSeconds(), //秒 
			"q+" : Math.floor((this.getMonth() + 3) / 3), //季度 
			"S" : this.getMilliseconds() //毫秒 
		};
		if (/(y+)/.test(fmt))
			fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		for ( var k in o)
			if (new RegExp("(" + k + ")").test(fmt))
				fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
						: (("00" + o[k]).substr(("" + o[k]).length)));
		return fmt;
	};
	
	function deleteRow(url){
		$.messager.confirm('提示', '确认删除所选记录吗？', function(btn){
			if (btn){
				$.ajax({
					url: url,
					dataType:'json',
					//data: jsonData,
					success:function(d){
						var code = d.code;
						var msg = d.message;
						
						if(code == 'success'){
							$.messager.alert('提示', '删除 成功', 'info', function(){
								reload();
							});
						}else{
							$.messager.alert('提示', msg, 'error');
						}
					},
					error:function(){
						$.messager.alert('提示','删除异常，请联系系统管理员．','error');
					}
				});
			}
		});
	}
</script>