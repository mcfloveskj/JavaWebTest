<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>test</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="scripts/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="scripts/easyui/themes/icon.css">
<script type="text/javascript" src="scripts/jquery-1.8.2.min.js"></script>
<script type="text/javascript"
	src="scripts/easyui/jquery.easyui-1.3.1.min.js"></script>
<script type="text/javascript" src="scripts/easyui/easyui-lang-zh_CN.js"></script>
<style type="text/css">
.north {
	background-image: url("image/login_bg.jpg");
}

.child {
	cursor: pointer;
	list-style: none;
	font-size: 12px;
	margin: 0px;
	padding: 0px;
}

.child li {
	height: 30px;
	line-height: 30px;
	padding-left: 30px;
	border: 1px solid white;
}

.child li:HOVER {
	background-color: #eee;
	border: 1px solid #dae6fc;
	font-weight: bold;
}
</style>
<script type="text/javascript">
	$(function() {
		//$("#tabs").height($(window).height() - 100);
		
		$("#parentMenu").accordion('getSelected').panel('collapse');
		
		$(".layout-panel-west").find(".layout-button-left").removeClass("layout-button-left").removeAttr("href");
	});

	function addTab(name, url) {
		if($("#tabs").tabs("exists",name)){
	    	$("#tabs").tabs("select",name);
	    	return;
	    }
		var content = '<iframe frameborder="0"  src="' + url
				+ '" style="width:100%;height:100%;"></iframe>';
		$('#tabs').tabs('add', {
			title : name,
			content : content,
			closable : true
		});
	}
	
	function exit(){
		$.messager.confirm('提示', '确定退出吗？', function(btn){
			if (btn){
				window.location.href = "logout.do";
			}
		});
	}
</script>
</head>

<body class="easyui-layout" style="width: 100%; height: 100%">
	<div class="north" region="north" title="" split="false"
		style="height: 96px;">
		<div style="float: right;">
			<a class="easyui-linkbutton" style="background-color: white;" data-options="iconCls:'icon-remove',plain:true" onclick="exit()">退出</a>
		</div>
	</div>
	<div id="menu" region="west" split="false" title="菜单"
		style="width: 200px;" data-options="collapsible:false">
		<div id="parentMenu" class="easyui-accordion" data-options="fit:true">
			<c:forEach var="menu" items="${menu}">
				<c:if test="${menu.parentdbidkey=='0'}">
					<div title="${menu.name}" style="margin: 0px; padding: 0px;">
						<c:if test="${!empty menu.children}">
							<ul class="child">
								<c:forEach var="child" items="${menu.children}">
									<li onclick="addTab('${child.name}', '${child.url}')">${child.name}</li>
								</c:forEach>
							</ul>
						</c:if>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
	<div region="center" style="padding: 0px;width: 100%;height:100%;">
		<div id="tabs" class="easyui-tabs" style="background: #eee;" data-options="fit:true"></div>
	</div>
</body>
</html>
