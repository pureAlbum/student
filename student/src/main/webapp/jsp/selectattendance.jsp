<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="easyui-datagrid"  id="dg2"
        data-options="url:'/student/attendance/selectuser.do?userid=${code}',
        singleSelect:true,pagination:true,toolbar: '#tb'">      
    <thead>   
        <tr>   
        	<th data-options="field:'id',fixed:true,width:100,editor:'textbox'">编号</th>
            <th data-options="field:'date',fixed:true,width:100,editor:'textbox'">时间</th>   
            <th data-options="field:'date1st',fixed:true,width:100,editor:'textbox'">1st</th>   
            <th data-options="field:'date2nd',fixed:true,width:100,editor:'textbox'">2nd</th>  
            <th data-options="field:'date3rd',fixed:true,width:100,editor:'textbox'">3rd</th>  
            <th data-options="field:'date4th',fixed:true,width:100,editor:'textbox'">4th</th>
            <th data-options="field:'date5th',fixed:true,width:100,editor:'textbox'">5th</th>
            <th data-options="field:'date6th',fixed:true,width:100,editor:'textbox'">6th</th>
        </tr>   
    </thead>
</table>
<div id="tb" style="height:auto;">
	<input  id="dd"  type= "text" class= "easyui-datebox" required ="required"/>
</div> 
<script type="text/javascript">
$('#dd').datebox({
    onSelect: function(date){
    	var y = date.getFullYear();
    	var m = date.getMonth()+1;
    	var d = date.getDate();
    	if(m<10){
    		m="0"+m;
    	}
    	if(d<10){
    		d="0"+d;
    	}
    	var date2 = y+'/'+m+'/'+d;
    	$('#dg2').datagrid('load',{date:date2});
    	//$('#dg2').datagrid('reload');
    	//window.location.href = "/student/attendance/selectuser.do?userid=${code}&date="+date2;
        //$('#dg2').datagrid('reload');    
    }
});
</script>
</body>
</html>