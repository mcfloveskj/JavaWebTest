<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/pages/common/common.jsp"%>
<script type="text/javascript" src="${ctp}/scripts/data/columndetail.js"></script>
</head>
<body>

	<div id="toolbarId">
		<a class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" onclick="save()">保存</a>
		<a class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true" onclick="closeWin()">关闭</a>
	</div>
	<div style="height: 5px;"></div>

	<form id="detailForm" name="detailForm" action="saveColumn.do"
		method="post">
		<input type="hidden" id="dbidkey" name="dbidkey"
			value="${dataColumn.dbidkey}"> <input type="hidden"
			id="datadbidkey" name="datadbidkey" value="${dataColumn.datadbidkey}">
		<input type="hidden" id="operate" name="operate" value="${operate}">

		<fieldset>
			<legend>基础数据信息</legend>
			<table>
				<tr>
					<td style="width: 100px;" align="right">编码：</td>
					<td><input type="text" id="code" name="code"
						style="width: 300px;" value="${dataColumn.code}"></td>
				</tr>
				<tr>
					<td style="width: 100px;" align="right">名称：</td>
					<td><textarea id="name" style="width: 300px;" name="name"
							rows="5" cols="">${dataColumn.name}</textarea></td>
				</tr>
			</table>
		</fieldset>

	</form>

</body>
</html>