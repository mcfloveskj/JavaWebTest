var win;
$(function() {

	$("#list").datagrid({
		title : "",
		url : "getPatientList.do",
		nowrap : true,
		autoRowHeight : true,
		striped : true,
		pagination : true,
		singleSelect : true,
		idField : 'dbidkey',
		height : $(window).height() - 112,
		columns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'patientnum',
			title : '患者编号',
			width : 120
		}, {
			field : 'name',
			title : '姓名',
			width : 120
		}, {
			field : 'sex',
			title : '性别',
			width : 120,
			formatter : function(value, row, index){
				if (value != null && value != ""){
					return value == "1" ? "男" : "女";
				} else {
					return value;
				}
			}
		}, {
			field : 'birth',
			title : '出生日期',
			width : 120,
			formatter : function(value, row, index){
				if (value != null && value != ""){
					return new Date(value).format("yyyy-MM-dd");
				} else {
					return value;
				}
			}
		}, {
			field : 'idCard',
			title : '身份证号',
			width : 160
		}, {
			field : 'address',
			title : '住址',
			width : 200
		}, {
			field : 'tel',
			title : '移动电话',
			width : 110
		} ] ],
		onLoadSuccess : function(data) {
			// delete $(this).treegrid('options').queryParams['id'];
		}
	});
	
	win = $("#window").window({
		width: 600,
		height: $(window).height() - 50,
		top: 25,
		left: ($(window).width() - 600) / 2,
		modal: true,
		closed: true,
		iconCls: 'icon-add',
		minimizable: false,
		maximizable: false,
		collapsible: false
	});

});

function reload(){
	$('#list').datagrid('clearSelections');
	$("#list").datagrid("reload");
}

function add(){
	win.window({title: '新增'});
	win.window("open");
	win.html('<iframe frameborder="0" src="detail.do?operate=add" height="100%" width="100%" scrolling="false"></iframe>');
}

function edit(){
	var node = $("#list").datagrid("getSelected");
	if (node){
		var url = "detail.do?operate=update&dbidkey=" + node.dbidkey;
		win.window({title: '修改'});
		win.window("open");
		win.html('<iframe frameborder="0" src="' + url + '" height="100%" width="100%" scrolling="false"></iframe>');
	} else {
		$.messager.alert('提示', '请选择一条记录', 'info');
	}
}

function del(){
	var node = $("#list").datagrid("getSelected");
	if (node){
		var url = "delete.do?dbidkey=" + node.dbidkey;
		deleteRow(url);
	} else {
		$.messager.alert('提示', '请选择一条记录', 'info');
	}
}

function doSearchForm(){
	var param = {
		name : $("#name").val(),
		patientnum : $("#patientnum").val(),
		sex : $("#sex").combobox("getValue")
	};
	
	$("#list").datagrid("load", param);
}

function doClearForm(){
	$('#searchForm')[0].reset();
	$("#sex").combobox("setValue", "");
}