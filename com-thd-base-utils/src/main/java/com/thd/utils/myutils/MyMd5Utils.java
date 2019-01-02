package com.thd.utils.myutils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MyMd5Utils {
	
	
	
	
	public static String encoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		
		
		
		byte[] hash;
	    try {
	        hash = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
	    } catch (NoSuchAlgorithmException e) {
	        throw new RuntimeException("Huh, MD5 should be supported?", e);
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException("Huh, UTF-8 should be supported?", e);
	    }
 
	    StringBuilder hex = new StringBuilder(hash.length * 2);
	    for (byte b : hash) {
	        if ((b & 0xFF) < 0x10) hex.append("0");
	        hex.append(Integer.toHexString(b & 0xFF));
	    }
	    return hex.toString();

		
		
//		
//	        //确定计算方法
//	    MessageDigest md5=MessageDigest.getInstance("MD5");
//	    BASE64Encoder base64en = new BASE64Encoder();
//	    //加密后的字符串
//	    String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
//	    return newstr;
	} 
	
	public static void main(String[] args) throws Exception{
		String a = "我是大好人";
		System.out.println(MyMd5Utils.encoderByMd5(a));
	}
}
