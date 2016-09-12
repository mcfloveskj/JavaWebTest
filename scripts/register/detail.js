$(function() {
	$("#detailForm").ajaxForm({
		url: $("#detailForm").attr('action'),
		dataType:'json',
		/*contentType:"application/json",
		type: 'POST',*/
		beforeSubmit:function() {
			var isValid = $("#detailForm").form("validate");
			return isValid;
		},
		success:function(d){
			var code = d.code;
			var msg = d.message;
			
			if(code == 'success'){
				$.messager.alert('提示', msg, 'info',function(){
					parent.win.window("close");
					parent.reload();
				});
				
			}else{
				$.messager.alert('提示', msg, 'error');
			}
		},
		error:function(){
			$.messager.alert('提示','保存失败，请联系系统管理员．','error');
		}
	});
});

function save(){
	$("#detailForm").submit();
}

function closeWin(){
	parent.win.window("close");
}