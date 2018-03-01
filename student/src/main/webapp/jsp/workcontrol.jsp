<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- id, userid, workcode, oneself_score, teacher_score -->
	<table class="easyui-datagrid" id="dg77"
		data-options="url:'/student/work/selecthw2.do',singleSelect:true,pagination:true,toolbar: '#tb33', onDblClickRow : onClickRow">
		<thead>
			<tr>
				<th data-options="field:'id',fixed:true,width:100,editor:'textbox'">编号</th>
				<th data-options="field:'userid',fixed:true,width:100,editor:'textbox'">学生id</th>
				<th
					data-options="field:'workcode',fixed:true,width:100,editor:'textbox'">作业编号</th>
				<th
					data-options="field:'oneselfScore',fixed:true,width:100,editor:'textbox'">自评</th>
				<th
					data-options="field:'teacherScore',fixed:true,width:100,editor:'textbox'">教师评价</th>
			</tr>
		</thead>
	</table>
	<div id="tb33" style="height: auto;">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" onclick="append()">增加</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">移除</a>
	</div>
	<div id="win66" class="easyui-window" title="修改信息"
		style="width: 600px; height: 400px"
		data-options="modal:true,closed:true">
		<form id="ff33" method="post">
			<!-- 	id, name, sex, code, pass, classCode, role -->
			<div style="width: 300px; margin: 20px;">
				<div style="float: right; margin: 6px;">
					<label for="id">编号:</label> <input class="easyui-validatebox"
						type="text" name="id" data-options="required:false" />
				</div>
				<div style="float: right; margin: 6px;">
					<label for="userid">学生id:</label> <input class="easyui-validatebox"
						type="text" name="userid" data-options="required:false" />
				</div>
				<div style="float: right; margin: 6px;">
					<label for="workcode">作业id:</label> <input
						class="easyui-validatebox" type="text" name="workcode"
						data-options="required:false" />
				</div>
				<div style="float: right; margin: 6px;">
					<label for="oneselfScore">自评:</label> <input class="easyui-validatebox"
						type="text" name="oneselfScore" data-options="required:false" />
				</div>
				<div style="float: right; margin: 6px;">
					<label for="teacherScore">教师评价:</label> <input class="easyui-validatebox"
						type="text" name="teacherScore" data-options="required:false" />
				</div>
				<div style="clear: both;"></div>
				<a id="btn111" href="javascript:void(0)" class="easyui-linkbutton"
					style="float: right; margin-right: 80px; padding: 0 20px;">提交</a>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		//$('#win').window('close');
		var url;
		function onClickRow(index) {
			$('#win66').window('open');
			var row = $('#dg77').datagrid('getSelected');
			$('#ff33').form('load', row);
			$('#btn111').bind('click', {
				url : '/student/work/update2.do'
			}, send);

		}
		function append(index) {
			$('#win66').window('open');
			$('#btn111').bind('click', {
				url : '/student/work/insert2.do'
			}, send);
		}
		function removeit(index) {
			var row = $('#dg77').datagrid('getSelected');
			url = '/student/work/del2.do';
			$.post(url, {
				'id' : row.id
			}, function(data) {
				$('#dg77').datagrid('reload');
			})
		}
		function send(event) {
			url = event.data.url;
			$('#ff33').form({
				url : url,
				onSubmit : function() {
					// do some check    
					// return false to prevent submit;    
				},
				success : function(data) {
					$('#win66').window('close');
					$('#dg77').datagrid('reload');
					$('#ff33').form('clear');
				}
			});
			// submit the form    
			$('#ff33').submit();
		}
	</script>
</body>
</html>