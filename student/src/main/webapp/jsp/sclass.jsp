<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p style="text-align: center; font-size: 24px;">班级基本情况</p>
	<span>班级:</span><span></span>
	<table class="easyui-datagrid"  id="dg4" 
	data-options="url:'/student/user/selectbyclass.do',
        singleSelect:true,pagination:true">      
    <thead>   
        <tr>   
        	<th data-options="field:'id',fixed:true,width:100,editor:'textbox'">编号</th>
            <th data-options="field:'code',fixed:true,width:100,editor:'textbox'">学号</th>   
            <th data-options="field:'name',fixed:true,width:100,editor:'textbox'">姓名</th>  
            <th data-options="field:'sex',fixed:true,width:100,editor:'textbox'">性别</th>  
        </tr>   
    </thead>
</table>

</body>
</html>