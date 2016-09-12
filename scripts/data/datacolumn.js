var win;
$(function() {
	
	var dataColumnDbidkey = $("#dataColumnDbidkey").val();

	$("#list").datagrid({
		title : "",
		url : "getDataColumnList.do?datadbidkey=" + dataColumnDbidkey,
		nowrap : true,
		autoRowHeight : true,
		striped : true,
		pagination : true,
		singleSelect : true,
		idField : 'dbidkey',
		height : $(window).height() - 42,
		columns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'code',
			title : '编号',
			width : 200
		}, {
			field : 'name',
			title : '名称',
			width : 300
		} ] ],
		onLoadSuccess : function(data) {
			// delete $(this).treegrid('options').queryParams['id'];
		}
	});
	
	win = $("#window").window({
		width: 600,
		height: 300,
		top: ($(window).height() - 300) / 2,
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
	var dataColumnDbidkey = $("#dataColumnDbidkey").val();
	var url = "datacolumndetail.do?operate=add&dataDbidkey=" + dataColumnDbidkey;
	win.html('<iframe frameborder="0" src="' + url + '" height="100%" width="100%" scrolling="false"></iframe>');
}

function edit(){
	var node = $("#list").datagrid("getSelected");
	if (node){
		var url = "datacolumndetail.do?operate=update&dbidkey=" + node.dbidkey;
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
		var url = "deleteColumn.do?dbidkey=" + node.dbidkey;
		deleteRow(url);
	} else {
		$.messager.alert('提示', '请选择一条记录', 'info');
	}
}