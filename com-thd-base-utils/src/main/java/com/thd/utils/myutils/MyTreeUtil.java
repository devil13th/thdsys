package com.thd.utils.myutils;

public class MyTreeUtil {
	
	/**
	 * 获取树形代码最后一段的整形值 
	 * 例如:root.0001.0002.0015 则返回15
	 * @param treeCode
	 * @return
	 */
	public static int getCount(String treeCode){
		String str = treeCode.substring(treeCode.lastIndexOf(".")+1,treeCode.length());
		return Integer.parseInt(str);
	};
	
	/**
	 * 生成树形代码最后一段 
	 * 例如 createCode("0000",15) => 0015   createCode("00000",102) => 00102 ;
	 * @param baseCode 树形代码段的基础位数 例如:000或0000或00000根据这个位数生成新代码
	 * @param ct 树形代码值 
	 * @return 形代码最后一段
	 */
	public static String createCode(String baseCode,int ct){
		String allStr = baseCode + ct;
		return allStr.substring(allStr.length() - baseCode.length() , allStr.length());
	};
	
	/**
	 * 获取父节点的code
	 * 例如 root.0001.0002 => root.0001    root.0003.0005.002 => root.0003.0005
	 * @param code 属性编码
	 * @return
	 */
	public static String parentCode(String code){
		return code.substring(0,code.lastIndexOf("."));
	};
	
	public static void main(String[] args){
		//System.out.println(TreeUtil.getCount("root.0001.002.0003"));
		
		String str = MyTreeUtil.createCode("000000",2215);
		System.out.println(str);
		
		System.out.println("success");
		
		System.out.println(MyTreeUtil.parentCode("root.0002.0005.0004"));
	}
}
