<#assign get="${" />
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../../pub/TagLib.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ include file="../../../pub/pubCssJs.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript">
	var the${cfg.tableCodeForClass}Tab;

	var the${cfg.tableCodeForClass}Form;
	//刷新表格
	function reload${cfg.tableCodeForClass}Dg() {
		the${cfg.tableCodeForClass}Tab.datagrid("reload");
	}
	//重新查询
	function load${cfg.tableCodeForClass}Dg() {
		var jsonData = $("#the${cfg.tableCodeForClass}Form").serializeArray();
		var params = formToJson(jsonData);
		params.a = Math.random();
		//showObj(params);
		the${cfg.tableCodeForClass}Tab.datagrid("load", params);
	}
	//重置表单后查询
	function reset${cfg.tableCodeForClass}Form(){
		the${cfg.tableCodeForClass}Form.form("clear");
		load${cfg.tableCodeForClass}Dg();
	}

	//弹出保存页面方法
	function add${cfg.tableCodeForClass}Obj(t) {
		showWin("${get}ctx}/${cfg.nameSpace}/${cfg.urlActionName}!${cfg.tableCodeForProperty}Form.do", 900, 600);
	}
	//弹出编辑页面
	function edit${cfg.tableCodeForClass}Date(id) {
		showWin("${get}ctx}/${cfg.nameSpace}/${cfg.urlActionName}!${cfg.tableCodeForProperty}Form.do?${cfg.tableCodeForProperty}.${cfg.pkColumn.columnCodeForProperty}=" + id,900, 600);
	}
	//弹出编辑页面
	function edit${cfg.tableCodeForClass}Date2() {
		var data = the${cfg.tableCodeForClass}Tab.datagrid("getSelected");
		if(data){
			edit${cfg.tableCodeForClass}Date(data.${cfg.pkColumn.columnCodeForUpper});
		}else{
			alert("请选择数据");
		}
	}
	
	
	function delete${cfg.tableCodeForClass}Dates(){
		var checkedIds = getCheckedIds();
		if(checkedIds == ""){
			alert("请勾选数据后再进行删除");
			return ;
		}
		if(confirm("确定删除勾选的数据么?")){
			$.ajax("${get}ctx}/${cfg.nameSpace}/${cfg.urlActionName}!delete${cfg.tableCodeForClass}ByIds.do?ids=" + checkedIds + "&_r="+Math.random,
				{
					type:"GET",
					success:function(r){
						var str = $.trim(r);
						if(str == "success"){
							alert('操作成功');
							the${cfg.tableCodeForClass}Tab.datagrid("clearChecked");
							load${cfg.tableCodeForClass}Dg();
						}else{
							alert(str);
						};
					}
				}
			)
		}
		
	}
	//获取勾选的行
	function getCheckedIds(){
		var data = the${cfg.tableCodeForClass}Tab.datagrid("getChecked");
		var str = ""
		for(var i = 0 , j = data.length ; i < j ; i++){
			//alert(data[i].${cfg.pkColumn.columnCodeForUpper});
			str += (data[i].${cfg.pkColumn.columnCodeForUpper} + ",");
		};
		if(str != ""){
			str = str.substring(0,str.length - 1);
			return str;
		}else{
			return "";
		}
		
	}
	//删除操作
	function deleteData(id){
		if(confirm("确定删除此条记录么?")){
			$.ajax("${get}ctx}/${cfg.nameSpace}/${cfg.urlActionName}!delete${cfg.tableCodeForClass}ById.do?${cfg.tableCodeForProperty}.${cfg.pkColumn.columnCodeForProperty}=" + id + "&_r="+Math.random,
				{
					type:"GET",
					success:function(r){
						var str = $.trim(r);
						if(str == "success"){
							alert('操作成功');
							load${cfg.tableCodeForClass}Dg();
						}else{
							alert(str);
						};
					}
				}
			)
		}
	}
	
	
	

	$(function() {
		the${cfg.tableCodeForClass}Form = $('#the${cfg.tableCodeForClass}Form').form({
			ajax:false
		})
		
		
		the${cfg.tableCodeForClass}Tab = $('#the${cfg.tableCodeForClass}dataTable')
				.datagrid(
						{
							//title:'数据列表',
							iconCls : 'icon-ok',
							//数据来源
							url : '${get}ctx}/${cfg.nameSpace}/${cfg.urlActionName}!${cfg.tableCodeForProperty}ListGetDate.do?r=' + Math.random(),
							//斑马纹
							striped : true,
							//主键字段
							idField : "${cfg.pkColumn.columnCodeForUpper}",
							//宽度自适应
							//fitColumns: true,
							//表单提交方式
							method : "post",
							//是否只能选择一行
							singleSelect : true,
							nowrap : false,
							fit:true,
							border:false,
							//高度
							//height:450,
							//宽度
							//width:860,
							//是否分页
							pagination : true,
							//分页信息
							pageSize : 10,
							//每页显示条目下拉菜单
							pageList : [ 5, 10, 20, 50, 100 ],
							//排序的列
							sortName : '${cfg.pkColumn.columnCodeForUpper}',
							//排序方式
							sortOrder : "desc",
							//pageNumber:5,s
							rownumbers : true,//行号 
							//分页工具所在位置
							pagePosition : "bottom",
							checkOnSelect:false,
							selectOnCheck:false,
							//冻结的列
							frozenColumns : [ [
							//选择框		
									/*{
										field : '${cfg.pkColumn.columnCodeForUpper}',
										title : 'fid',
										checkbox : true,
										align : 'center'
									},*/
									{
										field : '${cfg.pkColumn.columnCodeForUpper}',
										title : '${cfg.pkColumn.columnName}',
										checkbox : true,
										align : 'center'
									}
									] ],
							columns : [ [
									<#list cfg.columnList as col> 
									{
										field : '${col.columnCodeForUpper}',
										title : '${col.columnName}',
										width : 100,
										sortable : true
									},
									</#list>
									{
										field : 'OPER',
										title : '操作',
										width : 80,
										align : 'center',
										formatter : function(value, row, index) {
											var editStr =  '<a  href="#" title="编辑" onclick="edit${cfg.tableCodeForClass}Date(\'' + row.${cfg.pkColumn.columnCodeForUpper} + '\')" >编辑</a>'
											var deleteStr = '<a  href="#" title="删除" onclick="deleteData(\'' + row.${cfg.pkColumn.columnCodeForUpper} + '\')" >删除</a>';
											return editStr +"&nbsp;"+ deleteStr;
										}
									} 
									] ]

							,
							toolbar :[{
								text:'收起搜索',
								iconCls:'icon-search',
								handler:function(){hide${cfg.tableCodeForClass}Query()}
							},{
								text:'Add',
								iconCls:'icon-add',
								handler:function(){add${cfg.tableCodeForClass}Obj()} 
							},{
								text:'Edit',
								iconCls:'icon-edit',
								handler:function(){edit${cfg.tableCodeForClass}Date2()}
							},'-',{
								text:'Delete',
								iconCls:'icon-remove',
								handler:function(){delete${cfg.tableCodeForClass}Dates()}
							}],
							//在用户排序一列的时候触发参数包括：sort：排序列字段名称。order：排序列的顺序(ASC或DESC)
							onSortColumn : function(sort, order) {
								$('#sort').val(sort);
								$('#order').val(order);
							}
							,
							
							onDblClickRow : function(rowIndex, rowData) {
								//不能选中条件中的行
								edit${cfg.tableCodeForClass}Date(rowData.${cfg.pkColumn.columnCodeForUpper});
							}
							
						})

	})

	

var query${cfg.tableCodeForClass}State = "open"
function hide${cfg.tableCodeForClass}Query(){
	if("open" == query${cfg.tableCodeForClass}State){
		$('body').layout('collapse','north');
		query${cfg.tableCodeForClass}State = "close";
	}else{
		$('body').layout('expand','north');
		query${cfg.tableCodeForClass}State = "open";
	}
	
}
		




</script>
	</head>
	<body class="easyui-layout">
		<div data-options="region:'north'" style="height:35px;">
			<form action="" id="the${cfg.tableCodeForClass}Form" method="post">
					<!-- 是否全部导出 -->
					<input type="hidden" id="isExportAll" name="isExportAll" value="true" />
					<input type="hidden" id="sort" name="sort" value="status" />
					<input type="hidden" id="order" name="order" value="desc" />
					
					
						<div class="complex_search_area" id="search_all">
							<!-- 显示的查询条件 -->
							<table border="0"  class="table_none_border">
								<tr>
									<!-- ${cfg.pkColumn.columnName} -->
									<td>
										<span class="Fieldname">${cfg.pkColumn.columnName}：</span>
									</td>
									<td>
										<#if cfg.pkColumn.columnType=="java.lang.Integer" || cfg.pkColumn.columnType=="java.lang.Long">
											<input 
											type="text"
											class="easyui-numberbox" 
											name="${cfg.pkColumn.columnCodeForUpper}"
											id="${cfg.pkColumn.columnCodeForUpper}"
											type="text" 
											precision="0" max="100" min="0"
											style="width:150px;"
											 />
										</#if>
										<#if cfg.pkColumn.columnType=="java.lang.Float" || cfg.pkColumn.columnType=="java.lang.Double">
											<input 
											type="text"
											class="easyui-numberbox" 
											name="${cfg.pkColumn.columnCodeForUpper}"
											id="${cfg.pkColumn.columnCodeForUpper}"
											type="text" 
											precision="1" max="100" min="0"
											style="width:150px;"
											 />
										</#if>
										<#if cfg.pkColumn.columnType=="java.lang.String">
											<input 
											type="text"
											class="easyui-textbox" 
											name="${cfg.pkColumn.columnCodeForUpper}"
											id="${cfg.pkColumn.columnCodeForUpper}"
											type="text" 
											style="width:150px;"
											 />
										</#if>
										<#if cfg.pkColumn.columnType=="java.util.Date">
											<input 
											type="text"
											class="easyui-datebox" 
											name="${cfg.pkColumn.columnCodeForUpper}"
											id="${cfg.pkColumn.columnCodeForUpper}"
											type="text" 
											style="width:100px;"
											 />
										</#if>
									</td>


									<#list cfg.columnList as col> 
									<!-- ${col.columnName} -->
									<td>
										<span class="Fieldname">${col.columnName}：</span>
									</td>
									<td>
										<#if col.columnType=="java.lang.Integer" || col.columnType=="java.lang.Long">
											<input 
											type="text"
											class="easyui-numberbox" 
											name="${col.columnCodeForUpper}"
											id="${col.columnCodeForUpper}"
											type="text" 
											precision="0" max="100" min="0"
											style="width:150px;"
											 />
										</#if>
										<#if col.columnType=="java.lang.Float" || col.columnType=="java.lang.Double">
											<input 
											type="text"
											class="easyui-numberbox" 
											name="${col.columnCodeForUpper}"
											id="${col.columnCodeForUpper}"
											type="text" 
											precision="1" max="100" min="0"
											style="width:150px;"
											 />
										</#if>
										<#if col.columnType=="java.lang.String">
											<input 
											type="text"
											class="easyui-textbox" 
											name="${col.columnCodeForUpper}"
											id="${col.columnCodeForUpper}"
											type="text" 
											style="width:150px;"
											 />
										</#if>
										<#if col.columnType=="java.util.Date">
											<input 
											type="text"
											class="easyui-datebox" 
											name="${col.columnCodeForUpper}"
											id="${col.columnCodeForUpper}"
											type="text" 
											style="width:100px;"
											 />
										</#if>
									</td>
									</#list>
								</tr>
							</table>
						</div>
						<div class="btnArea">
							<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="load${cfg.tableCodeForClass}Dg()">查询</a>  
							<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-clear'" onclick="reset${cfg.tableCodeForClass}Form()">重置</a>  
						</div>
				</form>
		</div>
		<div data-options="region:'center'">
			
				<table id="the${cfg.tableCodeForClass}dataTable">

				</table>
		</div>
		
				
				
		
	</body>

</html>
