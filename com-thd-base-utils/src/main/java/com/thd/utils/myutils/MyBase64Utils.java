package com.thd.utils.myutils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;

public class MyBase64Utils {
	
	/**
	 * 将文件用base64编码
	 * @param filePath 文件路径
	 * @return
	 */
	public static String encodeBase64File(String filePath) {
		if (filePath == null) {
			return null;
		}
		try {
			byte[] b = Files.readAllBytes(Paths.get(filePath));
			return Base64.getEncoder().encodeToString(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
 
		return null;
	}
	/**
	 * 将base字符串转换为文件
	 * @param base64
	 * @param filePath
	 * @return
	 */
	public static void decoderBase64File(String base64, String filePath) {
		if (base64 == null && filePath == null) {
            throw new RuntimeException( "生成文件失败，请给出相应的数据。");
		}
		try {
			Files.write(Paths.get(filePath), Base64.getDecoder().decode(base64),StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}




	
	/**
	 * <p>
	 * 将base64字符保存文本文件
	 * </p>
	 * 
	 * @param base64Code
	 * @param targetPath
	 * @throws Exception
	 */
	public static void toFile(String base64Code, String targetPath)
			throws Exception {
		FileOutputStream out = null;
		try {
			byte[] buffer = base64Code.getBytes();
			out = new FileOutputStream(targetPath);
			out.write(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	/**
	 * 将字符串编码成base64字符串
	 * @param str
	 * @return
	 */
	public static String encodeStr(String str) throws Exception{
		return Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
		//return new Base64.getEncoder().encodeToString(str.getBytes());
	}
	
	/**
	 * 将base64字符串解码为字符串
	 * @param str
	 * @return
	 */
	public static String decodeStr(String str){
		String ret="";
		try {
			
			ret = new String(Base64.getDecoder().decode(str));
			//ret=  new String(new BASE64Decoder().decodeBuffer(str));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static void main(String[] args) {
		try {

			// String base64Code = encodeBase64File("D:\\FileUpload.pdf");
			//
			// System.out.println(base64Code);
			//
			// decoderBase64File(base64Code, "D:\\FileUpload2.pdf");

			// toFile(base64Code, "D:\\three.txt");
			// String s = "1";
			// double d_time = 0;
			// d_time = Double.parseDouble(s);
			// System.out.println(d_time);
			// d_time = d_time * 60 * 60 * 1000;
			// System.out.println(d_time);
			// int time = (int)d_time;
			// System.out.println(time);
			// Date date = new Date();
			// System.out.println(date.getTime());
			// System.out.println(System.currentTimeMillis());
			// System.out.println(File2Code.encryptBASE64("11111111".getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
