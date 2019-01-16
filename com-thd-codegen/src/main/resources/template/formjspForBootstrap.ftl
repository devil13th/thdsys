<#assign get="${" />

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="../../../pub/TagLib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<%@ include file="../../pub/pubCssJsForBootstrap.jsp"%>
		<title></title>
	
<style type="text/css">
</style>
<script>
var validation${cfg.tableCodeForClass}Tool;
$(function(){


<#list cfg.columnList as col>
 <#if col.columnType=="java.util.Date">
 $('#${col.columnCodeForProperty}').datetimepicker({
		    language:'zh-CN',
			format:'yyyy-mm-dd',
			weekStart: 1,
			todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: "month",
			minView: "month",
			forceParse: 0
		}).on("changeDate", function(e) {
			 validation${cfg.tableCodeForClass}Tool.data("formValidation").revalidateField("${cfg.tableCodeForProperty}.${col.columnCodeForProperty}");
	    });;
 </#if>
</#list>


validation${cfg.tableCodeForClass}Tool = $('#the${cfg.tableCodeForClass}Form').formValidation({
	err: {
	    container: ''
	   //container: 'popover'
	},
	icon: {
	    valid: 'glyphicon glyphicon-ok',
	    invalid: 'glyphicon glyphicon-remove',
	    validating: 'glyphicon glyphicon-refresh'
	},
	locale:"zh_CN", //国际化
	fields: {
		
		
		<#list cfg.columnList as col> 
		"${cfg.tableCodeForProperty}.${col.columnCodeForProperty}": {
			row:'.form-group',//变红色字体的范围容器
	                validators: {
			    <#if col.columnType=="java.lang.String">
			     stringLength: {
	                        max: 64,
	                        message: '长度64以内'
	                     },
			     notEmpty: {
	                        message: 'The field is required'
	                     }
			    </#if>
	                    <#if col.columnType=="java.util.Date">
			     notEmpty: {
	                        message: 'The field is required'
	                     }
	                    </#if>
			    <#if col.columnType=="java.lang.Integer" || col.columnType=="java.lang.Long" || col.columnType=="java.lang.Float" || col.columnType=="java.lang.Double">
			     lessThan: {
					value: 9999,
					inclusive: true,
					message: 'The Field has to be less than 9999'
			     },
			     greaterThan: {
					value: 0,
					inclusive: false,
					message: 'The Field has to be greater than or equals to 0'
			     },
			     notEmpty: {
	                        message: 'The field is required'
	                     }
			    </#if>
	                }
		},
		</#list>

		"${cfg.tableCodeForProperty}.${cfg.pkColumn.columnCodeForProperty}": {
			row:'.form-group',//变红色字体的范围容器
	                validators: {
			    <#if cfg.pkColumn.columnType=="java.lang.String">
			     stringLength: {
	                        max: 64,
	                        message: '长度64以内'
	                     },
			     notEmpty: {
	                        message: 'The field is required'
	                     }
			    </#if>
	                    <#if cfg.pkColumn.columnType=="java.util.Date">
			     notEmpty: {
	                        message: 'The field is required'
	                     }
	                    </#if>
			    <#if cfg.pkColumn.columnType=="java.lang.Integer" || cfg.pkColumn.columnType=="java.lang.Long" || cfg.pkColumn.columnType=="java.lang.Float" || cfg.pkColumn.columnType=="java.lang.Double">
			     lessThan: {
				value: 9999,
				inclusive: true,
				message: 'The Field has to be less than 9999'
			     },
			     greaterThan: {
				value: 0,
				inclusive: false,
				message: 'The Field has to be greater than or equals to 0'
			     },
			     notEmpty: {
	                        message: 'The field is required'
	                     }
			    </#if>
	                }
		}
		
	}
});


$("#submitButton").click(function(){
    	validation${cfg.tableCodeForClass}Tool.data("formValidation").validate();
    	var validateResult = validation${cfg.tableCodeForClass}Tool.data("formValidation").isValid();
    	if(validateResult){
    		document.getElementById("the${cfg.tableCodeForClass}Form").submit();
    	};
});
})
</script>
	</head>

	<body>
		<h3> --- Page Title</h3>
		<hr/>
		<div class="container-fluid">
		<s:form cssClass="form-horizontal" action="${cfg.urlActionName}!${cfg.tableCodeForProperty}FormSubmit" namespace="/${cfg.nameSpace}" method="post" id="the${cfg.tableCodeForClass}Form">
		
		<div class="row">
		<div class="col-xs-1"></div>
		<div class="col-xs-10">
			
				<div style="display: none;">
					操作种类 save为保存 update为更新：<input type="text" name="operate" value="${get}operate}"/><br/>
				</div>

				
				
				<div class="form-group" <#if cfg.generator=="uuid.hex">style="display:none;"</#if>>
					<label class="col-xs-3 control-label">${cfg.pkColumn.columnName}</label>
					<div class="col-xs-9">
					   <div class="input-inline input-medium">
					       <div class="input-group">
						   <span class="input-group-addon">
						       <#if cfg.pkColumn.columnType=="java.lang.String">
						   			<i class="glyphicon glyphicon-console"></i>
						   		</#if>	
						   		<#if cfg.pkColumn.columnType=="java.lang.Integer" || cfg.pkColumn.columnType=="java.lang.Long" || cfg.pkColumn.columnType=="java.lang.Float" || cfg.pkColumn.columnType=="java.lang.Double">
						   			<i class="glyphicon glyphicon-dashboard"></i>
						   		</#if>	
						   		<#if cfg.pkColumn.columnType=="java.util.Date">
						   			<i class="glyphicon glyphicon-calendar"></i>
						   		</#if>
						   </span>
						   <input 
							id="${cfg.pkColumn.columnCodeForProperty}"  
							name="${cfg.tableCodeForProperty}.${cfg.pkColumn.columnCodeForProperty}"
							class="form-control" 
							placeholder="${cfg.pkColumn.columnName}"
							value="${get}${cfg.tableCodeForProperty}.${cfg.pkColumn.columnCodeForProperty}}"/> 
						</div>
					   </div>
						<span class="help-inline"> 
						</span>
					</div>
				</div>

				<#list cfg.columnList as col>
				<div class="form-group">
					<label class="col-xs-3 control-label">${col.columnName}</label>
					<div class="col-xs-9">
					   <div class="input-inline input-medium">
					       <div class="input-group">
						   <span class="input-group-addon">
						   		<#if col.columnType=="java.lang.String">
						   			<i class="glyphicon glyphicon-console"></i>
						   		</#if>	
						   		<#if col.columnType=="java.lang.Integer" || col.columnType=="java.lang.Long" || col.columnType=="java.lang.Float" || col.columnType=="java.lang.Double">
						   			<i class="glyphicon glyphicon-dashboard"></i>
						   		</#if>	
						   		<#if col.columnType=="java.util.Date">
						   			<i class="glyphicon glyphicon-calendar"></i>
						   		</#if>
						   </span>
						   <input 
							class="form-control" 
							name="${cfg.tableCodeForProperty}.${col.columnCodeForProperty}"
							id="${col.columnCodeForProperty}" 
							type="text"
							<#if col.columnType!="java.util.Date">
							value="${get}${cfg.tableCodeForProperty}.${col.columnCodeForProperty}}" /> 
							</#if>
							<#if col.columnType=="java.util.Date">
							value="<fmt:formatDate value="${get}${cfg.tableCodeForProperty}.${col.columnCodeForProperty}}"  pattern="yyyy-MM-dd"/>"  />
							</#if>	    
						  
					       </div>
					   </div>
					   <span class="help-inline">
					   </span>
					</div>
				</div>
				</#list>
		</div>
	

	




</div>
<div class="row text-center">
            <button type="button" id="submitButton" class="btn green">Submit</button>
            <button type="button" class="btn default">Cancel</button>
</div>
</s:form>
</div>

					
	</body>
</html>
