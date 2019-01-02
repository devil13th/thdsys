package com.thd.utils.myutils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.thd.utils.myutils.bean.Option;

public class MyListUtils {
	/**
	 * 获取List中的第一个元素
	 * @param l List对象
	 * @return List中的第一个元素
	 */
	public static Object getOne(List<Object> l ){
		if( (l!=null) && !l.isEmpty()){
			if(l.get(0)!=null){
				return l.get(0);
			}else{
				return null;
			}			
		}else{
			return null;
		}
	}
	/**
	 * 判断List是否不空
	 * @param l List对象
	 * @return 是：true 否：false
	 */
	public static boolean isNotEmpty(List l){
		return (l!=null && !l.isEmpty());
	}
	
	public static List<Option> convertOptionList(List<Map<String,Object>> list,String keyProName,String valProName){
		List<Option> r = new ArrayList<Option>();
		if(MyListUtils.isNotEmpty(list)){
			for(Map<String,Object> map : list){
				String k = map.get(keyProName)== null ? null :  map.get(keyProName).toString();
				String v = map.get(keyProName)== null ? null :  map.get(valProName).toString();
				Option opt = new Option(v,k);
				r.add(opt);
			}
		}
		return r;
	};
	/**
	 * 判断List是否空
	 * @param l List对象
	 * @return 是：true 否：false
	 */
	public static boolean isEmpty(List l){
		return (l==null || l.isEmpty());
	}
	
	/**
	 * 字符串转List
	 * @param str 字符串
	 * @param mark 分隔符
	 * @return
	 */
	public static List<String> stringToList(String str , String mark){
		if(null == mark || "".equals(mark)){
			mark = ",";
		}
		if(null != str && !"".equals(str)){
			String[] strs = str.split(mark);
			List<String> r = new ArrayList<String>();
			for(String aStr : strs){
				r.add(aStr);
			}
			return r;
		}else{
			return null;
		}
	}
	
	/**
	 * 字符串转List
	 * @param str 字符串
	 * @param mark 分隔符
	 * @return
	 */
	public static String listToString(List l , String mark){
		if(MyListUtils.isNotEmpty(l)){
			String r = "";
			for(Object obj : l){
				r += obj.toString() + mark;
			}
			r = r.substring(0, r.length() - mark.length());
			return r;
		}else{
			return null;
		}
	}
	
	/**
	 * 字符串转List
	 * @param str 字符串
	 * @param mark 分隔符
	 * @return
	 */
	public static String listMapToString(List l , String propertyName,  String mark){
		if(MyListUtils.isNotEmpty(l)){
			String r = "";
			for(Object obj : l){
				Map m = (Map)obj;
				r += m.get(propertyName) + mark;
			}
			r = r.substring(0, r.length() - mark.length());
			return r;
		}else{
			return null;
		}
	}
}
