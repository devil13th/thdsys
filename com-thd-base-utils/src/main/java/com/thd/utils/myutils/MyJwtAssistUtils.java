/** 
 * Class Description:########
 * Date : 2017年6月4日 上午10:40:45
 * Auth : wanglei 
*/  

package com.thd.utils.myutils;

import io.jsonwebtoken.Claims;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thd.utils.myutils.bean.JwtClaims;

public class MyJwtAssistUtils {
	/**
	 * 获取cookie中某个名称的值
	 * @param req HttpServletRequest
	 * @param cookieName cookie的名称
	 * @return 返回cookie某个名称的值
	 * @throws Exception
	 */
	public static String getCookie(HttpServletRequest req,String cookieName){
		String cookieStr = "";
		Cookie[] cookies = req.getCookies();
		for(Cookie ck:cookies){
			if(ck.getName().equals(cookieName)){
				cookieStr = ck.getValue();
			}
		}
		return cookieStr;
	}
		
	/**
	 * 从cookie中获取载荷信息
	 * @param req HttpServletRequest
	 * @param cookieName cookie的名称
	 * @param claim claim信息类
	 * @return 载荷信息
	 * @throws Exception
	 */
	public static Claims getClaims(HttpServletRequest req,String cookieName,JwtClaims claim) throws Exception{
		String jwt = MyJwtAssistUtils.getCookie(req,cookieName);
		Claims claims = MyJwtUtils.parse(claim, jwt);
		System.out.println(claims);
		return claims;
	}
	
	/**
	 * 从cookie中获取载荷信息
	 * @param req HttpServletRequest
	 * @param cookieName cookie的名称
	 * @param claim claim信息类
	 * @param propertyName 载荷信息中需要获取值的属性名
	 * @return 载荷信息中某属性值
	 * @throws Exception
	 */
	public static Object getClaimsProperty(HttpServletRequest req,String cookieName,JwtClaims claim,String propertyName) throws Exception{
		Claims claims = MyJwtAssistUtils.getClaims(req, cookieName,claim);
		Object obj = claims.get(propertyName);
		return obj;
	}
	
	
	/**
	 * 从cookie中获取载荷中某个属性(转换成指定类(载荷属性的值必须为json格式数据))
	 * @param req HttpServletRequest
	 * @param cookieName cookie的名称
	 * @param claim claim信息类
	 * @param propertyName 载荷信息中需要获取值的属性名
	 * @param c 转换的类
	 * @return 载荷信息中某属性值
	 * @throws Exception
	 */
	public static Object getJsonObj(HttpServletRequest req,String cookieName,JwtClaims claim,String propertyName,Class c) throws Exception{
		Claims claims = MyJwtAssistUtils.getClaims(req, cookieName,claim);
		String jsonStr = claims.get(propertyName).toString();
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		Object obj = gson.fromJson(jsonStr, c);
		return obj;
	}
	
	
}
