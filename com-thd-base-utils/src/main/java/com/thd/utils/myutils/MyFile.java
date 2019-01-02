package com.thd.utils.myutils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class MyFile {
	
	public static boolean createPath(String path){		
		String folders[] = path.split("\\\\");
		String p = "";	
		//File f = new File(path);
		
			for(int i = 0 , j = folders.length ; i < j ; i++){
				p += ("\\" + folders[i]);
				File file = new File(p);
				if(!file.exists()){
					file.mkdir();
					System.out.println(p + " 正在创建");
				}else{
					System.out.println(p + " 已经创建");
				}
			}
		
		return false;
	}	
	
	
	public static String getFix(String fileName){
		int pos = fileName.lastIndexOf(".");
		if(pos == -1){
			return null;
		}else{
			return fileName.substring(pos,fileName.length());
		}
	}

	public static void copy(File src, File dst) {
		int BUFFER_SIZE = 16 * 1024;
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst),
                    BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	
	public static void main(String args[]){
		//MyFile.createPath("c:\\studyTest6\\devil13th\\WebRoot\\s");
		//System.out.println(MyFile.getFix("xxx.a"));
		File a = new File("D://111111111111//xx//sc_websbook_com_2404570.jpg.jpg");
		File b = new File("D:\\111111111111\\xx\\333\\sc_websbook_com_2404570.jpg.jpg");
		System.out.println(a.getName());
		System.out.println(b.getName());
		MyFile.copy(a, b);
		System.out.println("success");
	}

}
