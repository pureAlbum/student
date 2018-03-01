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
<!-- 	账号、密码、姓名、角色的code，班级code -->
<table class="easyui-datagrid"  id="dg"
        data-options="url:'/student/user/select.do',singleSelect:true,pagination:true,toolbar: '#tb', onDblClickRow : onClickRow">      
    <thead>   
        <tr>   
        	<th data-options="field:'id',fixed:true,width:100,editor:'textbox'">编号</th>
            <th data-options="field:'code',fixed:true,width:100,editor:'textbox'">账号</th>   
            <th data-options="field:'pass',fixed:true,width:100,editor:'textbox'">密码</th>   
            <th data-options="field:'name',fixed:true,width:100,editor:'textbox'">姓名</th>  
            <th data-options="field:'sex',fixed:true,width:100,editor:'textbox'">性别</th>  
            <th data-options="field:'role',fixed:true,width:100,editor:'textbox'">角色code</th>
            <th data-options="field:'classCode',fixed:true,width:100,editor:'textbox'">班级code</th>
        </tr>   
    </thead>
</table>
	<div id="tb" style="height:auto;">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">增加</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">移除</a>
	</div> 
<div id="win" class="easyui-window" title="修改信息" style="width:600px;height:400px"   
        data-options="modal:true,closed:true">   
	<form id="ff" method="post">
<!-- 	id, name, sex, code, pass, classCode, role -->
		<div style="width:300px;margin: 20px;" >
		<div style="float: right;margin: 6px;">   
        	<label for="id">ID:</label>   
        	<input class="easyui-validatebox" type="text" name="id" data-options="required:false" />   
    	</div> 
    	<div style="float: right;margin: 6px;">   
        	<label for="code">账号:</label>   
        	<input class="easyui-validatebox" type="text" name="code" data-options="required:false" />   
    	</div> 
    	<div style="float: right;margin: 6px;">   
        	<label for="pass">密码:</label>   
        	<input class="easyui-validatebox" type="text" name="pass" data-options="required:false" />   
    	</div> 
    	<div style="float: right;margin: 6px;">   
        	<label for="name">姓名:</label>   
        	<input class="easyui-validatebox" type="text" name="name" data-options="required:false" />   
    	</div> 
    	<div style="float: right;margin: 6px;">   
        	<label for="sex">性别:</label>   
        	<input class="easyui-validatebox" type="text" name="sex" data-options="required:false" />   
    	</div> 
    	<div style="float: right;margin: 6px;">   
        	<label for="role">角色code:</label>   
        	<input class="easyui-validatebox" type="text" name="role" data-options="required:false" />   
    	</div>
    	<div style="float: right;margin: 6px;">   
        	<label for="classCode">班级code:</label>   
        	<input class="easyui-validatebox" type="text" name="classCode" data-options="required:false" />   
    	</div>
    	<div style="clear: both;"></div>
    		<a id="btn" href="javascript:void(0)" class="easyui-linkbutton"
    		style="float: right;margin-right: 80px;padding: 0 20px;">提交</a>
		</div>
</form>  
</div>  
<script type="text/javascript">

	//$('#win').window('close');
var url;
function onClickRow(index){
	$('#win').window('open');
	var row = $('#dg').datagrid('getSelected');
	$('#ff').form('load',row);
	$('#btn').bind('click',{url:'/student/user/update.do'},send);
	
}
function append(index){
	$('#win').window('open');
	$('#btn').bind('click',{url:'/student/user/insert.do'},send);
}
function removeit(index){
	var row = $('#dg').datagrid('getSelected');
	url='/student/user/del.do';
	$.post(url,{'id':row.id},function(data){
		 $('#dg').datagrid('reload');
	})
}
function send(event){
	url = event.data.url;
	$('#ff').form({    
	    url:url,    
	    onSubmit:function(){
	        // do some check    
	        // return false to prevent submit;    
	    },    
	    success:function(data){
	        $('#win').window('close');
	        $('#dg').datagrid('reload');
	        $('#ff').form('clear');
	    }    
	});    
	// submit the form    
	$('#ff').submit();
}
</script>  
</body>
</html>