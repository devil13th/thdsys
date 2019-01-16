<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<title>${cfg.tableCodeForClass}</title>

<script th:inline="javascript">    
	var ctx = [[@{/}]];  
	
	function queryAll${cfg.tableCodeForClass}(){
		fetch(`${r'${ctx}'}${cfg.nameSpace}/${cfg.jspPath}/`,{
			method:"GET",
			headers:{
				Accept:"application/json;charset=UTF-8"
			}
		}).then(function(res){
			console.log(res);
			return res.json();
		}).then(function(res){
			console.log(res);
			document.getElementById("result").value = JSON.stringify(res);
		});
		
	}
	
	
	function save${cfg.tableCodeForClass}(){
		eval("var person = " + document.getElementById("personInfoForSave").value);
		fetch(`${r'${ctx}'}${cfg.nameSpace}/${cfg.jspPath}/`,{
			method:"POST",
			headers:{
				Accept:"application/json;charset=UTF-8",
				"Content-Type":"application/json;charset=UTF-8"
			},
			body:JSON.stringify(person)
		}).then(function(res){
			console.log(res);
			return res.json();
		}).then(function(res){
			console.log(res);
			document.getElementById("result").value = JSON.stringify(res);
		});
	}
	
	
	function update${cfg.tableCodeForClass}(){
		eval("var person = " + document.getElementById("personInfoForUpdate").value);
		fetch(`${r'${ctx}'}${cfg.nameSpace}/${cfg.jspPath}/`,{
			method:"PUT",
			headers:{
				Accept:"application/json;charset=UTF-8",
				"Content-Type":"application/json;charset=UTF-8"
			},
			body:JSON.stringify(person)
		}).then(function(res){
			console.log(res);
			return res.json();
		}).then(function(res){
			console.log(res);
			document.getElementById("result").value = JSON.stringify(res);
		});
	}
	
	function query${cfg.tableCodeForClass}ById(){
		var pid = document.getElementById("pid").value;
		fetch(`${r'${ctx}'}${cfg.nameSpace}/${cfg.jspPath}/${r'${pid}'}`,{
			method:"GET",
			headers:{
				Accept:"application/json;charset=UTF-8"
			}
		}).then(function(res){
			console.log(res);
			return res.json();
		}).then(function(res){
			console.log(res);
			document.getElementById("result").value = JSON.stringify(res);
		});
	}
	
	
	function delete${cfg.tableCodeForClass}ById(){
		var pid = document.getElementById("pid").value;
		fetch(`${r'${ctx}'}${cfg.nameSpace}/${cfg.jspPath}/${r'${pid}'}`,{
			method:"DELETE",
			headers:{
				Accept:"application/json;charset=UTF-8"
			}
		}).then(function(res){
			console.log(res);
			return res.json();
		}).then(function(res){
			console.log(res);
			document.getElementById("result").value = JSON.stringify(res);
		});
	}
</script>

</head>
<body id="body" >
    
<textarea id="result" style="width:100%;height:150px"></textarea>
<input type="button" value="查询列表" onclick="queryAll${cfg.tableCodeForClass}()"/>
&nbsp;&nbsp;
|&nbsp;&nbsp;
输入ID<input type="text" id="pid" name="pid"/> 
<input type="button" value="根据ID查询" onclick="query${cfg.tableCodeForClass}ById()"/> 
<input type="button" value="根据ID删除" onclick="delete${cfg.tableCodeForClass}ById()"/>

 


<br/>
<table width="100%"> 
<tr>
	<td width="50%" align="right">
	<textarea id="personInfoForSave" style="width:100%;height:120px">
{
"${cfg.pkColumn.columnCodeForProperty}":"xx",
<#list cfg.columnList as col> 
"${col.columnCodeForProperty}":"${col.columnCodeForUpper}"<#if col_has_next>,</#if>
</#list>
}
</textarea><br/>
<input type="button" value="保存" onclick="save${cfg.tableCodeForClass}()"/><br/>
	</td>
	<td width="50%" align="right">

<textarea id="personInfoForUpdate" style="width:95%;height:120px">
{
"${cfg.pkColumn.columnCodeForProperty}":"xx",
<#list cfg.columnList as col> 
"${col.columnCodeForProperty}":"${col.columnCodeForUpper}"<#if col_has_next>,</#if>
</#list>
}
</textarea><br/>
<input type="button" value="修改实体" onclick="update${cfg.tableCodeForClass}()"/><br/>	
	</td>
<tr/>
<table>

</body>

</html>