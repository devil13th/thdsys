package com.thd.utils.myutils;

import org.apache.commons.lang3.StringEscapeUtils;

public class MyStringUtils {
	/**
	 * 判断字符串是否是null或空串
	 * @param str 字符串
	 * @return 是：true  否：false
	 */
	public static boolean isEmpty(String str){
		return (str == null || str.trim().equals(""));
	} 
	/**
	 * 判断字符串是否不是null或空串
	 * @param str 字符串
	 * @return 是：true  否：false
	 */
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
	/**
	 * Method Description : null返回空字符串
	 * @param str 字符串
	 * @return 如果是null则返回"" 否则直接返回
	 */
	public static String getStr(String str){
		return str == null ? "" : str;
	}
	
	
	
	
	public static void main(String[] args){
		String sql="1' or '1'='1";  
        /*System.out.println("防SQL注入:"+StringEscapeUtils.escapeSql(sql)); //防SQL注入  
          
        System.out.println("转义HTML,注意汉字:"+StringEscapeUtils.escapeHtml("<font>chen磊  xing</font>"));    //转义HTML,注意汉字  
        System.out.println("反转义HTML:"+StringEscapeUtils.unescapeHtml("<font>chen磊  xing</font>"));  //反转义HTML  
          
        System.out.println("转成Unicode编码："+StringEscapeUtils.escapeJava("陈磊兴"));     //转义成Unicode编码  
          
        System.out.println("转义XML："+StringEscapeUtils.escapeXml("<name>陈磊兴</name>"));   //转义xml  
        System.out.println("反转义XML："+StringEscapeUtils.unescapeXml("<name>陈磊兴</name>"));    //转义xml  
        System.out.println( StringEscapeUtils.escapeHtml("王磊"));
	*/
	}
	
	
}
