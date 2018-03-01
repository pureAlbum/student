<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="easyui-datagrid" id="dg6"
		data-options="url:'/student/attendance/selectteacher.do',
        singleSelect:true,pagination:true,toolbar: '#tb',onDblClickRow : onClickRow">
		<thead>
			<tr>
				<th
					data-options="field:'id',fixed:true,width:100,editor:'textbox'">编号</th>
				<th
					data-options="field:'userid',fixed:true,width:100,editor:'textbox'">学号</th>
				<th
					data-options="field:'name',fixed:true,width:100,editor:'textbox'">姓名</th>
				<th
					data-options="field:'date1st',fixed:true,width:100,editor:'textbox'">1st</th>
				<th
					data-options="field:'date2nd',fixed:true,width:100,editor:'textbox'">2nd</th>
				<th
					data-options="field:'date3rd',fixed:true,width:100,editor:'textbox'">3rd</th>
				<th
					data-options="field:'date4th',fixed:true,width:100,editor:'textbox'">4th</th>
				<th
					data-options="field:'date5th',fixed:true,width:100,editor:'textbox'">5th</th>
				<th
					data-options="field:'date6th',fixed:true,width:100,editor:'textbox'">6th</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="height: auto;">
		<input id="dd" type="text" class="easyui-datebox" required="required" />
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-edit',plain:true" onclick="append()">记录考勤</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">移除</a>
	</div>
	<div id="win2" class="easyui-window" title="修改信息"
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
					<label for="userid">学号:</label> <input class="easyui-validatebox"
						type="text" name="userid" data-options="required:false" />
				</div>
				<div style="float: right; margin: 6px;">
					<label for="name">姓名:</label> <input class="easyui-validatebox"
						type="text" name="name" data-options="required:false" />
				</div>
				<div style="float: right; margin: 6px;">
					<label for="date">日期:</label> <input class="easyui-validatebox"
						type="text" name="date" data-options="required:false" />
				</div>
				<div style="float: right; margin: 6px;">
					<label for="date1st">1st:</label> <input class="easyui-validatebox"
						type="text" name="date1st" data-options="required:false" />
				</div>
				<div style="float: right; margin: 6px;">
					<label for="date2nd">2nd:</label> <input
						class="easyui-validatebox" type="text" name="date2nd"
						data-options="required:false" />
				</div>
				<div style="float: right; margin: 6px;">
					<label for="date3rd">3rd:</label> <input
						class="easyui-validatebox" type="text" name="date3rd"
						data-options="required:false" />
				</div>
				<div style="float: right; margin: 6px;">
					<label for="date4th">4th:</label> <input
						class="easyui-validatebox" type="text" name="date4th"
						data-options="required:false" />
				</div>
				<div style="float: right; margin: 6px;">
					<label for="date5th">5th:</label> <input
						class="easyui-validatebox" type="text" name="date5th"
						data-options="required:false" />
				</div>
				<div style="float: right; margin: 6px;">
					<label for="date6th">6th:</label> <input
						class="easyui-validatebox" type="text" name="date6th"
						data-options="required:false" />
				</div>
				<div style="clear: both;"></div>
				<a id="btn233" href="javascript:void(0)" class="easyui-linkbutton"
					style="float: right; margin-right: 80px; padding: 0 20px;">提交</a>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		//$('#win').window('close');
		var url;
		function onClickRow(index) {
			$('#win2').window('open');
			var row = $('#dg6').datagrid('getSelected');
			$('#ff').form('load', row);
			$('#btn233').bind('click', {
				url : '/student/attendance/upattr.do'
			}, send);

		}
		function append(index) {
			$('#win2').window('open');
			$('#btn233').bind('click', {
				url : '/student/attendance/addattend.do'
			}, send);
		}
		function removeit(index) {
			var row = $('#dg6').datagrid('getSelected');
			url = '/student/attendance/del.do';
			$.post(url, {
				'id' : row.id
			}, function(data) {
				$('#dg6').datagrid('reload');
			})
		}
		function send(event) {
			alert(1);
			url = event.data.url;
			$('#ff').form({
				url : url,
				onSubmit : function() {
					// do some check    
					// return false to prevent submit;    
				},
				success : function(data) {
					$('#win2').window('close');
					$('#dg6').datagrid('reload');
					$('#ff').form('clear');
				}
			});
			// submit the form    
			$('#ff').submit();
		}
		$('#dd').datebox({
			onSelect : function(date) {
				var y = date.getFullYear();
				var m = date.getMonth() + 1;
				var d = date.getDate();
				if (m < 10) {
					m = "0" + m;
				}
				if (d < 10) {
					d = "0" + d;
				}
				var date2 = y + '/' + m + '/' + d;
				$('#dg6').datagrid('load', {
					date : date2
				});
				//$('#dg2').datagrid('reload');
				//window.location.href = "/student/attendance/selectuser.do?userid=${code}&date="+date2;
				//$('#dg2').datagrid('reload');    
				///student/src/main/webapp/jsp/attendance.jsp
			}
		});
	</script>
</body>
</html>