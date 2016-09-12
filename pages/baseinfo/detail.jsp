<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/pages/common/common.jsp"%>
<script type="text/javascript" src="${ctp}/scripts/baseinfo/detail.js"></script>
</head>
<body>

	<div id="toolbarId">
		<a class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" onclick="save()">保存</a>
		<a class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true" onclick="closeWin()">关闭</a>
	</div>
	<div style="height: 5px;"></div>

	<form  id="detailForm" name="detailForm" action="save.do" method="post">
		<input type="hidden" id="dbidkey" name="dbidkey" value="${baseInfo.dbidkey}">
		<input type="hidden" id="operate" name="operate" value="${operate}">
		
		<fieldset>
			<legend>基本信息</legend>
			<table>
				<tr>
					<td style="width: 100px;" align="right">姓名：</td>
					<td><input type="text" id="name" name="name"
						style="width: 150px;" value="${baseInfo.name}"></td>
					<td style="width: 100px;" align="right">性别：</td>
					<td><select id="sex" name="sex" class="easyui-combobox"
						style="width: 154px;">
							<option value="1"
								<c:if test="${baseInfo.sex == '1'}">selected</c:if>>男</option>
							<option value="2"
								<c:if test="${baseInfo.sex == '2'}">selected</c:if>>女</option>
					</select></td>
				</tr>
				<tr>
					<td style="width: 100px;" align="right">出生日期：</td>
					<td><input type="text" id="birth" name="birth" editable="false"
						class="easyui-datebox" style="width: 154px;"
						value="<fmt:formatDate pattern="yyyy-MM-dd" value="${baseInfo.birth}" type="both"/>" /></td>
					<td style="width: 100px;" align="right">身份证号码：</td>
					<td><input type="text" id="idCard" name="idCard"
						style="width: 150px;" value="${baseInfo.idCard}"></td>
				</tr>
				<tr>
					<td></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend>患者联系方式</legend>
			<table>
				<tr>
					<td style="width: 100px;" align="right">医院编号：</td>
					<td><input type="text" id="hospitalnum" name="hospitalnum"
						style="width: 150px;" value="${baseInfo.hospitalnum}"></td>
					<td style="width: 100px;" align="right">患者编号：</td>
					<td><input type="text" id="patientnum" name="patientnum"
						style="width: 150px;" value="${baseInfo.patientnum}"></td>
				</tr>
				<tr>
					<td style="width: 100px;" align="right">家庭住址：</td>
					<td><input type="text" id="address" name="address"
						style="width: 150px;" value="${baseInfo.address}"></td>
					<td style="width: 100px;" align="right">移动电话：</td>
					<td><input type="text" id="tel" name="tel"
						style="width: 150px;" value="${baseInfo.tel}"></td>
				</tr>
				<tr>
					<td style="width: 100px;" align="right">电话号码：</td>
					<td><input type="text" id="phone" name="phone"
						style="width: 150px;" value="${baseInfo.phone}"></td>
					<td style="width: 100px;" align="right">邮箱：</td>
					<td><input type="text" id="mail" name="mail"
						style="width: 150px;" value="${baseInfo.mail}"></td>
				</tr>
				<tr>
					<td style="width: 100px;" align="right">愿意加入研究：</td>
					<td><select id="agreecontact" name="agreecontact" class="easyui-combobox"
						style="width: 154px;">
							<option value="1"
								<c:if test="${baseInfo.agreecontact == '1'}">selected</c:if>>是</option>
							<option value="0"
								<c:if test="${baseInfo.agreecontact == '0'}">selected</c:if>>否</option>
					</select></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend>亲友联系方式</legend>
			<table>
				<tr>
					<td style="width: 100px;" align="right">姓名：</td>
					<td><input type="text" id="othername" name="othername"
						style="width: 150px;" value="${baseInfo.othername}"></td>
					<td style="width: 100px;" align="right">与患者关系：</td>
					<td><input type="text" id="relation" name="relation"
						style="width: 150px;" value="${baseInfo.relation}"></td>
				</tr>
				<tr>
					<td style="width: 100px;" align="right">家庭住址：</td>
					<td><input type="text" id="otheraddress" name="otheraddress"
						style="width: 150px;" value="${baseInfo.otheraddress}"></td>
					<td style="width: 100px;" align="right">移动电话：</td>
					<td><input type="text" id="othertel" name="othertel"
						style="width: 150px;" value="${baseInfo.othertel}"></td>
				</tr>
				<tr>
					<td style="width: 100px;" align="right">电话号码：</td>
					<td><input type="text" id="otherphone" name="otherphone"
						style="width: 150px;" value="${baseInfo.otherphone}"></td>
					<td style="width: 100px;" align="right">邮箱：</td>
					<td><input type="text" id="othermail" name="othermail"
						style="width: 150px;" value="${baseInfo.othermail}"></td>
				</tr>
			</table>
		</fieldset>
	</form>

</body>
</html>