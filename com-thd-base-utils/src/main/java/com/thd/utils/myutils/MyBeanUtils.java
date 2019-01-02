package com.thd.utils.myutils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.collections.CollectionUtils;

public class MyBeanUtils {
	
	
	public static List listMapToListBean(List l , String className) {
		List r = new ArrayList();
		if(MyListUtils.isNotEmpty(l)){
			for(Object obj : l){
				try {
					Map m = (Map)obj;
					Class c = Class.forName(className);
					Object bean = c.newInstance();
					BeanUtils.populate(bean, m);
					r.add(bean);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return r;
	}
	
	/**
	 * 拷贝源对象中不为空的属性到目标对象
	 * copy original object's properties that not null to destination object
	 * @param dest destination objet 目标对象
	 * @param orig original object 源对象
	 * @throws Exception 
	 */
	public static void copyNotNullProperties(Object dest,Object orig) throws Exception{
		if(orig.getClass() != dest.getClass()){
			throw new Exception("源对象和目的对象不是同一类型!");
		}
		Field[] fields = dest.getClass().getDeclaredFields();
		for(int i = 0 , j = fields.length ; i < j ; i++){
			String fieldName = fields[i].getName();
			String setter = "set" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1,fieldName.length());
			String getter = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1,fieldName.length());
			Method setterMethod = dest.getClass().getMethod(setter, fields[i].getType());
			Method getterMethod = orig.getClass().getMethod(getter, null);
			if(getterMethod.invoke(orig, null) != null){
				setterMethod.invoke(dest, getterMethod.invoke(orig, null));			
			}
		}
	}
	
	/**
	 * 制空对象属性
	 * @param obj 对象
	 * @param properties 需要制空的属性
	 * @throws Exception
	 */
	public static void setObjNullProperties(Object obj,Object[] properties) throws Exception{
		if(properties!= null && properties.length != 0){
			for(Object propertyObj : properties){
				String property = propertyObj.toString();
				property = property.trim();
				Field field = obj.getClass().getDeclaredField(property);
				String setter = "set" + property.substring(0,1).toUpperCase() + property.substring(1,property.length());
				Method setterMethod = obj.getClass().getMethod(setter, field.getType());
				setterMethod.invoke(obj,new Object[]{null});
			}
		}
	}
	
	
	
	
	
	/**
	 * 将original实例中的属性拷贝到dest实例中，不在nullableProps数组中的属性，如果为空不拷贝
	 * @param dest	目标实例(数据库)
	 * @param orig	源
	 * @param nullableProps	在拷贝中可以拷贝为空的字段
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static void copyPropertiesWithNull(Object dest, Object orig, Object[] nullableProps) throws IllegalAccessException, InvocationTargetException {
		// 将属性数组转为set方便比较
		Set<String> propSet = new HashSet<String>();
		if(null != nullableProps){
			CollectionUtils.addAll(propSet, nullableProps);
		}
		// Validate existence of the specified beans
		if (dest == null) {
			throw new IllegalArgumentException("No destination bean specified");
		}
		if (orig == null) {
			throw new IllegalArgumentException("No origin bean specified");
		}

		// Copy the properties, converting as necessary
		BeanUtilsBean bub = BeanUtilsBean.getInstance();
		if (orig instanceof DynaBean) {
			DynaProperty[] origDescriptors = ((DynaBean) orig).getDynaClass().getDynaProperties();
			for (int i = 0; i < origDescriptors.length; i++) {
				String name = origDescriptors[i].getName();
				// Need to check isReadable() for WrapDynaBean
				// (see Jira issue# BEANUTILS-61)
				if (bub.getPropertyUtils().isReadable(orig, name) && bub.getPropertyUtils().isWriteable(dest, name)) {
					Object value = ((DynaBean) orig).get(name);
					bub.copyProperty(dest, name, value);
				}
			}
		} else if (orig instanceof Map) {
			Iterator entries = ((Map) orig).entrySet().iterator();
			while (entries.hasNext()) {
				Map.Entry entry = (Map.Entry) entries.next();
				String name = (String) entry.getKey();
				if (bub.getPropertyUtils().isWriteable(dest, name)) {
					bub.copyProperty(dest, name, entry.getValue());
				}
			}
		} else /* if (orig is a standard JavaBean) */{
			PropertyDescriptor[] origDescriptors = bub.getPropertyUtils().getPropertyDescriptors(orig);
			for (int i = 0; i < origDescriptors.length; i++) {
				String name = origDescriptors[i].getName();
				if ("class".equals(name) || "propName".equals(name) || "propValue".equals(name)) {
					continue; // No point in trying to set an object's class
				}
				if (bub.getPropertyUtils().isReadable(orig, name) && bub.getPropertyUtils().isWriteable(dest, name)) {
					try {
						Object value = bub.getPropertyUtils().getSimpleProperty(orig, name);
						if(propSet.contains(name)){
							bub.copyProperty(dest, name, value);
						} else {
							if (value != null) {
								bub.copyProperty(dest, name, value);
							}
						}
					} catch (NoSuchMethodException e) {
						// Should not happen
					}
				}
			}
		}
	}
	
	//拷贝不为空的属性
	public static void copyPropertiesExceptNull(Object dest, Object orig) throws IllegalAccessException, InvocationTargetException {

		// Validate existence of the specified beans
		if (dest == null) {
			throw new IllegalArgumentException("No destination bean specified");
		}
		if (orig == null) {
			throw new IllegalArgumentException("No origin bean specified");
		}

		// Copy the properties, converting as necessary
		BeanUtilsBean bub = BeanUtilsBean.getInstance();
		if (orig instanceof DynaBean) {
			DynaProperty[] origDescriptors = ((DynaBean) orig).getDynaClass().getDynaProperties();
			for (int i = 0; i < origDescriptors.length; i++) {
				String name = origDescriptors[i].getName();
				// Need to check isReadable() for WrapDynaBean
				// (see Jira issue# BEANUTILS-61)
				if (bub.getPropertyUtils().isReadable(orig, name) && bub.getPropertyUtils().isWriteable(dest, name)) {
					Object value = ((DynaBean) orig).get(name);
					bub.copyProperty(dest, name, value);
				}
			}
		} else if (orig instanceof Map) {
			Iterator entries = ((Map) orig).entrySet().iterator();
			while (entries.hasNext()) {
				Map.Entry entry = (Map.Entry) entries.next();
				String name = (String) entry.getKey();
				if (bub.getPropertyUtils().isWriteable(dest, name)) {
					bub.copyProperty(dest, name, entry.getValue());
				}
			}
		} else /* if (orig is a standard JavaBean) */{
			PropertyDescriptor[] origDescriptors = bub.getPropertyUtils().getPropertyDescriptors(orig);
			for (int i = 0; i < origDescriptors.length; i++) {
				String name = origDescriptors[i].getName();
				if ("class".equals(name) || "propName".equals(name) || "propValue".equals(name)) {
					continue; // No point in trying to set an object's class
				}
				if (bub.getPropertyUtils().isReadable(orig, name) && bub.getPropertyUtils().isWriteable(dest, name)) {
					try {
						Object value = bub.getPropertyUtils().getSimpleProperty(orig, name);
						if (value != null) {
							bub.copyProperty(dest, name, value);
						}
					} catch (NoSuchMethodException e) {
						// Should not happen
					}
				}
			}
		}
	}
}
