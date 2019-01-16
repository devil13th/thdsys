<#assign get="${" />

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="../../../pub/TagLib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<%@ include file="../../../pub/pubCssJs.jsp"%>
		<title><s:text name="title.applyName"></s:text>
		</title>
	
<style type="text/css">
</style>
<script>

var the${cfg.tableCodeForClass}Form;
$(function(){
	the${cfg.tableCodeForClass}Form = $('#the${cfg.tableCodeForClass}Form').form({
		ajax:false
	});
})

function reset${cfg.tableCodeForClass}Form(){
	the${cfg.tableCodeForClass}Form.form("clear");
	loadDg();
}

function submitForm(){
	var b = the${cfg.tableCodeForClass}Form.form("validate");
	if(b){
		document.getElementById("the${cfg.tableCodeForClass}Form").submit();
	}else{
		alert("请根据表单红色提示进行修改");
	};
	
}
function cw(){
	top.closeWin();
}


</script>
	</head>

	<body>
		<div id="pbody">
			<s:form action="${cfg.urlActionName}!${cfg.tableCodeForProperty}FormSubmit" namespace="/${cfg.nameSpace}" method="post" id="the${cfg.tableCodeForClass}Form">
				<div style="display: none;">
					操作种类 save为保存 update为更新：<input type="text" name="operate" value="${get}operate}"/><br/>
					
				</div>
				<table class="common submit" border="1" width="100%">
					
					<#if cfg.pkColumn.columnType=="java.lang.Integer" || cfg.pkColumn.columnType=="java.lang.Long">
					<tr>
						<th>
							${cfg.pkColumn.columnName}
						</th>
						<td>
							<input 
							class="easyui-numberbox" 
							name="${cfg.tableCodeForProperty}.${cfg.pkColumn.columnCodeForProperty}"
							id="${cfg.pkColumn.columnCodeForProperty}" 
							type="text" 
							precision="0" max="100" min="0"
							style="width:50px;"
							data-options="required:true"
							value="${get}${cfg.tableCodeForProperty}.${cfg.pkColumn.columnCodeForProperty}}" />
						</td>
					</tr>
					</#if>
					<#if cfg.pkColumn.columnType=="java.lang.Float" || cfg.pkColumn.columnType=="java.lang.Double">
					<tr>
						<th>
							${cfg.pkColumn.columnName}
						</th>
						<td>
							<input 
							class="easyui-numberbox" 
							name="${cfg.tableCodeForProperty}.${cfg.pkColumn.columnCodeForProperty}"
							id="${cfg.pkColumn.columnCodeForProperty}" 
							type="text" 
							precision="1" max="100" min="0"
							style="width:50px;"
							data-options="required:true"
							value="${get}${cfg.tableCodeForProperty}.${cfg.pkColumn.columnCodeForProperty}}" />
						</td>
					</tr>
					</#if>
					<#if cfg.pkColumn.columnType=="java.lang.String">
					<tr>
						<th>
							${cfg.pkColumn.columnName}
						</th>
						<td>
							<input 
							class="easyui-textbox" 
							name="${cfg.tableCodeForProperty}.${cfg.pkColumn.columnCodeForProperty}"
							id="${cfg.pkColumn.columnCodeForProperty}" 
							type="text"
							data-options="required:true"
							value="${get}${cfg.tableCodeForProperty}.${cfg.pkColumn.columnCodeForProperty}}" />
						</td>
					</tr>
					</#if>
					<#if cfg.pkColumn.columnType=="java.util.Date">
					<tr>
						<th>
							${cfg.pkColumn.columnName}
						</th>
						<td>
							<input 
							class="easyui-datebox" 
							name="${cfg.tableCodeForProperty}.${cfg.pkColumn.columnCodeForProperty}"
							id="${cfg.pkColumn.columnCodeForProperty}" 
							type="text"
							data-options="required:true"
							value="${get}${cfg.tableCodeForProperty}.${cfg.pkColumn.columnCodeForProperty}}" />
						</td>
					</tr>
					</#if>



					<#list cfg.columnList as col> 
					<#if col.columnType=="java.lang.Integer" || col.columnType=="java.lang.Long">
					<tr>
						<th>
							${col.columnName}
						</th>
						<td>
							<input 
							class="easyui-numberbox" 
							name="${cfg.tableCodeForProperty}.${col.columnCodeForProperty}"
							id="${col.columnCodeForProperty}" 
							type="text" 
							precision="0" max="100" min="0"
							style="width:50px;"
							value="${get}${cfg.tableCodeForProperty}.${col.columnCodeForProperty}}" />
						</td>
					</tr>
					</#if>
					<#if col.columnType=="java.lang.Float" || col.columnType=="java.lang.Double">
					<tr>
						<th>
							${col.columnName}
						</th>
						<td>
							<input 
							class="easyui-numberbox" 
							name="${cfg.tableCodeForProperty}.${col.columnCodeForProperty}"
							id="${col.columnCodeForProperty}" 
							type="text" 
							precision="1" max="100" min="0"
							style="width:50px;"
							value="${get}${cfg.tableCodeForProperty}.${col.columnCodeForProperty}}" />
						</td>
					</tr>
					</#if>
					<#if col.columnType=="java.lang.String">
					<tr>
						<th>
							${col.columnName}
						</th>
						<td>
							<input 
							class="easyui-textbox" 
							name="${cfg.tableCodeForProperty}.${col.columnCodeForProperty}"
							id="${col.columnCodeForProperty}" 
							type="text"
							data-options="required:true"
							value="${get}${cfg.tableCodeForProperty}.${col.columnCodeForProperty}}" />
						</td>
					</tr>
					</#if>
					<#if col.columnType=="java.util.Date">
					<tr>
						<th>
							${col.columnName}
						</th>
						<td>
							<input 
							class="easyui-datebox" 
							name="${cfg.tableCodeForProperty}.${col.columnCodeForProperty}"
							id="${col.columnCodeForProperty}" 
							type="text"
							data-options="required:true"
							value="${get}${cfg.tableCodeForProperty}.${col.columnCodeForProperty}}" />
						</td>
					</tr>
					</#if>
					</#list>
					
				</table>
				<br />
				<center>
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="submitForm()">提交</a>  
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-clear'" onclick="reset${cfg.tableCodeForClass}Form()">重置</a>  
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-clear'" onclick="window.close()">关闭</a>  
					
				</center>
			</s:form>
		</div>
	</body>
</html>
