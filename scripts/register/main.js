var win;
$(function() {
	
	var hunthess = $("#hunthess").combobox("getData");
	console.log(hunthess);
	
	$("#list").datagrid({
		title : "",
		url : "getRegisterList.do",
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
			field : 'sahbaddate',
			title : 'SAH发病日期',
			formatter : function(value, row, index){
				if (value != null && value != ""){
					return new Date(value).format("yyyy-MM-dd hh:mm:ss");
				} else {
					return value;
				}
			}
		}, {
			field : 'hunthess',
			title : 'Hunt/Hess分级',
			formatter : function(value, row, index){
				if (value != null && value != "" || value == "0"){
					for (var i in hunthess){
						if (hunthess[i].value != "" && hunthess[i].value == value){
							return hunthess[i].text;
						}
					}
				} else {
					return value;
				}
			}
		}, {
			field : 'islive',
			title : '入选本研究时是否存活',
			formatter : function(value, row, index){
				if (value != null){
					if (value == "0"){
						return "否";
					} else {
						return "是";
					}
				} else {
					return value;
				}
			}
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
		patientnum : $("#patientnum").val(),
		hunthess : $("#hunthess").combobox("getValue")
	};
	
	$("#list").datagrid("load", param);
}

function doClearForm(){
	$('#searchForm')[0].reset();
	$("#hunthess").combobox("setValue", "");
}