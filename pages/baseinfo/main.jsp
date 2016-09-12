<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%@include file="/pages/common/common.jsp"%>
<script type="text/javascript" src="${ctp}/scripts/baseinfo/main.js"></script>
</head>
<body>

	<div id="toolbarId" class="toolbarId">
		<a class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" onclick="add()">增加</a> <a
			class="easyui-linkbutton"
			data-options="iconCls:'icon-edit',plain:true" onclick="edit()">修改</a>
		<a class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true" onclick="del()">删除</a>
	</div>

	<div id="searchArea">
		<form id="searchForm" method="post">
			<table style="border: 1px solid #E4EDFE;">
				<tr>
					<td style="width: 100px;" align="right">患者编号：</td>
					<td><input name="patientnum" id="patientnum" style="width: 150px" /></td>
					<td style="width: 100px;" align="right">姓名：</td>
					<td><input name="name" id="name" style="width: 150px" /></td>
					<td style="width: 100px;" align="right">性别：</td>
					<td><select id="sex" name="sex" class="easyui-combobox"
						style="width: 154px;">
							<option value="" selected="selected">- -</option>
							<option value="1">男</option>
							<option value="2">女</option>
					</select></td>
				</tr>
				<tr>
					<td></td><td></td>
					<td></td><td></td>
					<td colspan="2" style="text-align: right;"><img alt="查询"
						src="${ctp}/scripts/easyui/themes/icons/button_search.png"
						onclick="doSearchForm()"></img> <img alt="清空"
						src="${ctp}/scripts/easyui/themes/icons/button_reset.png"
						onclick="doClearForm()"></img></td>
				</tr>
			</table>
		</form>
	</div>

	<table id="list"></table>

	<div id="window"></div>

</body>
</html>