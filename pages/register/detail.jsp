<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/pages/common/common.jsp"%>
<script type="text/javascript" src="${ctp}/scripts/register/detail.js"></script>
</head>
<body>

	<div id="toolbarId">
		<a class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" onclick="save()">保存</a>
		<a class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true" onclick="closeWin()">关闭</a>
	</div>
	<div style="height: 5px;"></div>

	<form id="detailForm" name="detailForm" action="save.do" method="post">
		<input type="hidden" id="dbidkey" name="dbidkey"
			value="${register.dbidkey}"> <input type="hidden"
			id="operate" name="operate" value="${operate}">

		<fieldset>
			<legend>基本信息</legend>
			<table>
				<tr>
					<td style="width: 100px;" align="right">患者编号：</td>
					<td><input type="text" id="patientnum" name="patientnum"
						style="width: 150px;" value="${register.patientnum}"></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend>入选标准：</legend>
			<table>
				<c:forEach var="column" items="${selected.dataColumn}">
					<tr>
						<td style="width: 30px;"><input type="checkbox" id="selected"
							name="selected" value="${column.code}"
							<c:if test="${register.selected.contains(column.code) == true}">checked</c:if> /></td>
						<td>${column.name}</td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>

		<fieldset>
			<legend>排除标准：</legend>
			<table>
				<c:forEach var="column" items="${removed.dataColumn}">
					<tr>
						<td style="width: 30px;"><input type="checkbox" id=removed
							name="removed" value="${column.code}"
							<c:if test="${register.removed.contains(column.code) == true}">checked</c:if> /></td>
						<td>${column.name}</td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>

		<fieldset>
			<legend>SAH发病的日期与时间：</legend>
			<table>
				<tr>
					<td style="width: 30px;"></td>
					<td><input class="easyui-datetimebox" type="text"
						id="sahbaddate" editable="false" name="sahbaddate"
						style="width: 200px"
						value="<fmt:formatDate value="${register.sahbaddate}"  type="both" />"></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend>入院时Hunt和Hess分级：</legend>
			<table>
				<c:forEach var="column" items="${hunthess.dataColumn}">
					<tr>
						<td style="width: 30px;"><input type="radio" id=hunthess
							name="hunthess" value="${column.code}"
							<c:if test="${register.hunthess == column.code}">checked</c:if> /></td>
						<td>${column.name}</td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>

		<fieldset>
			<legend>告知日期：</legend>
			<table>
				<tr>
					<td style="width: 30px;"></td>
					<td><input class="easyui-datebox" type="text" id="informdate"
						editable="false" name="informdate" style="width: 200px"
						value="<fmt:formatDate pattern="yyyy-MM-dd" value="${register.informdate}" type="both"/>"></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend>告知入选本研究时是否存活：</legend>
			<table>
				<tr>
					<td style="width: 30px;"></td>
					<td><select id="islive" name="islive" class="easyui-combobox"
						style="width: 200px;">
							<option value="1" <c:if test="${register.islive == '1'}">selected</c:if>>是</option>
							<option value="0" <c:if test="${register.islive == '0'}">selected</c:if>>否</option>
					</select></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend>研究者姓名：</legend>
			<table>
				<tr>
					<td style="width: 30px;">甲</td>
					<td><input type="text" id="studenta" name="studenta" value="${register.studenta}"
						style="width: 200px;"></td>
				</tr>
				<tr>
					<td style="width: 30px;">乙</td>
					<td><input type="text" id="studentb" name="studentb" value="${register.studentb}"
						style="width: 200px;"></td>
				</tr>
			</table>
		</fieldset>
	</form>

</body>
</html>