package com.thd.utils.myutils.bean;

import java.util.List;

/*
 * jwt claims bean for json
 */
public class JwtClaims {
	//该JWT的签发者，是否使用是可选的
	private String iss = "iss-devil13th";
	//接收该JWT的一方，是否使用是可选的；
	private String aud  = "aud-devil13th";
	//expires 什么时候过期，设置方法例如：System.currentTimeMillis()  + 3600 * 1000 (1小时后过期注意：单位是毫秒!!)
	private long  expire;
	//issued at在什么时候签发的(UNIX时间),是否使用是可选的,设置方法例如：System.currentTimeMillis()  (单位是毫秒!!);
	private long iat;
	// 该JWT所面向的用户，是否使用是可选的；
	private String sub;
	//秘钥
	private String sercurityStr;
	//Not Before 如果当前时间在nbf里的时间之前，则Token不被接受；一般都会留一些余地，比如几分钟；，是否使用是可选的；
	private String nbf;
	
	
	
	public String getSercurityStr() {
		return sercurityStr;
	}
	public void setSercurityStr(String sercurityStr) {
		this.sercurityStr = sercurityStr;
	}
	public String getIss() {
		return iss;
	}
	public void setIss(String iss) {
		this.iss = iss;
	}
	
	
	public long getExpire() {
		return expire;
	}
	public void setExpire(long expire) {
		this.expire = expire;
	}
	public String getNbf() {
		return nbf;
	}
	public void setNbf(String nbf) {
		this.nbf = nbf;
	}
	
	public long getIat() {
		return iat;
	}
	public void setIat(long iat) {
		this.iat = iat;
	}
	public String getAud() {
		return aud;
	}
	public void setAud(String aud) {
		this.aud = aud;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	
}
