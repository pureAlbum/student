<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- id, teachercode, tm, grade_standard, type -->
	<table class="easyui-datagrid" id="dg7"
		data-options="url:'/student/work/selecthw.do',singleSelect:true,pagination:true,toolbar: '#tb3', onDblClickRow : onClickRow">
		<thead>
			<tr>
				<th data-options="field:'id',fixed:true,width:100,editor:'textbox'">编号</th>
				<th data-options="field:'tm',fixed:true,width:100,editor:'textbox'">题目</th>
				<th
					data-options="field:'gradeStandard',fixed:true,width:100,editor:'textbox'">评分标准</th>
				<th
					data-options="field:'type',fixed:true,width:100,editor:'textbox'">类型</th>
			</tr>
		</thead>
	</table>
	<div id="tb3" style="height: auto;">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" onclick="append()">增加</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">移除</a>
	</div>
	<div id="win6" class="easyui-window" title="修改信息"
		style="width: 600px; height: 400px"
		data-options="modal:true,closed:true">
		<form id="ff" method="post">
			<!-- 	id, name, sex, code, pass, classCode, role -->
			<div style="width: 300px; margin: 20px;">
				<div style="float: right; margin: 6px;">
					<label for="id">ID:</label> <input class="easyui-validatebox"
						type="text" name="id" data-options="required:false" />
				</div>
				<div style="float: right; margin: 6px;">
					<label for="tm">题目:</label> <input class="easyui-validatebox"
						type="text" name="tm" data-options="required:false" />
				</div>
				<div style="float: right; margin: 6px;">
					<label for="gradeStandard">评分标准:</label> <input
						class="easyui-validatebox" type="text" name="gradeStandard"
						data-options="required:false" />
				</div>
				<div style="float: right; margin: 6px;">
					<label for="type">类型:</label> <input class="easyui-validatebox"
						type="text" name="type" data-options="required:false" />
				</div>
				<div style="clear: both;"></div>
				<a id="btn11" href="javascript:void(0)" class="easyui-linkbutton"
					style="float: right; margin-right: 80px; padding: 0 20px;">提交</a>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		//$('#win').window('close');
		var url;
		function onClickRow(index) {
			$('#win6').window('open');
			var row = $('#dg7').datagrid('getSelected');
			$('#ff').form('load', row);
			$('#btn11').bind('click', {
				url : '/student/work/update.do'
			}, send);

		}
		function append(index) {
			$('#win6').window('open');
			$('#btn11').bind('click', {
				url : '/student/work/insert.do'
			}, send);
		}
		function removeit(index) {
			var row = $('#dg7').datagrid('getSelected');
			url = '/student/work/del.do';
			$.post(url, {
				'id' : row.id
			}, function(data) {
				$('#dg7').datagrid('reload');
			})
		}
		function send(event) {
			url = event.data.url;
			$('#ff').form({
				url : url,
				onSubmit : function() {
					// do some check    
					// return false to prevent submit;    
				},
				success : function(data) {
					$('#win6').window('close');
					$('#dg7').datagrid('reload');
					$('#ff').form('clear');
				}
			});
			// submit the form    
			$('#ff').submit();
		}
	</script>
</body>
</html>