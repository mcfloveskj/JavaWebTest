<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%@include file="/pages/common/common.jsp"%>
<script type="text/javascript" src="${ctp}/scripts/data/datacolumn.js"></script>
</head>
<body>

	<div id="toolbarId" class="toolbarId">
		<a class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" onclick="add()">增加</a><a
			class="easyui-linkbutton"
			data-options="iconCls:'icon-edit',plain:true" onclick="edit()">修改</a>
		<a class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true" onclick="del()">删除</a>
	</div>
	<input type="hidden" value="${dbidkey}" id="dataColumnDbidkey">
	<table id="list"></table>

	<div id="window"></div>

</body>
</html>