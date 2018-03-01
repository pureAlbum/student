<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="easyui-datagrid" id="dg3"
		data-options="url:'/student/leave/selectbyclass.do',fitColumns:true,singleSelect:true">
		<!--id, user_code, why, time, begin_time, end_time, status-->
		<thead>
			<tr>
				<th data-options="field:'id',width:100">编码</th>
				<th data-options="field:'user_code',width:100">姓名</th>
				<th data-options="field:'why',width:100">原因</th>
				<th data-options="field:'time',width:100">日期</th>
				<th data-options="field:'begin_time',width:100">开始时间</th>
				<th data-options="field:'end_time',width:100">结束时间</th>
				<th data-options="field:'status',width:100">状态</th>
			</tr>
		</thead>
	</table>
	<div id="tb2">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-edit',plain:true" onclick="update()">更改状态</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-help',plain:true"></a>
	</div>
	<div id="win" class="easyui-window" title="修改信息"
		style="width: 600px; height: 400px"
		data-options="modal:true,closed:true">
		<form id="ff" method="post">
			<!-- 	id, name, sex, code, pass, classCode, role -->
			<div style="width: 300px; margin: 20px;">
				<div style="float: right; margin: 6px;">
					<label for="status">请假审批:</label> <select id="cc"
						class="easyui-combobox" name="status" style="width: 200px;">
						<option value="批准">批准</option>
						<option value="驳回">驳回</option>
					</select>
				</div>
				<div style="clear: both;"></div>
				<a id="btn" href="javascript:void(0)" class="easyui-linkbutton"
					style="float: right; margin-right: 80px; padding: 0 20px;">提交</a>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		$('#dg3').datagrid({
			toolbar : '#tb2'
		});
		var row=null;
		function update(index) {
			row = $('#dg3').datagrid('getSelected');
			$('#win').window('open');
			$('#btn').bind('click',{url:'/student/leave/updatestatus.do'},send);
		}
		function send(event){
			url = event.data.url;
			//
			$('#ff').form({    
			    url:url,    
			    onSubmit:function(param){
			    	param.id=row.id;
			        // do some check    
			        // return false to prevent submit;    
			    },    
			    success:function(data){
			        $('#win').window('close');
			        $('#dg3').datagrid('reload');
			        $('#ff').form('clear');
			        row=null;
			    }    
			});    
			// submit the form    
			$('#ff').submit();
		}
	</script>
</body>
</html>