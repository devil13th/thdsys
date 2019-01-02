package com.thd.utils.myutils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class MyFileUtils {

	/*
	 * Description : 创建文件夹
	 * 
	 * @param folderPath
	 * 要创建的文件夹的完整路径 例如 d:/x/y
	 * 
	 */
	public static void newFolder(String folderPath) {
		try {
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			System.out.println(myFilePath);
			if (!myFilePath.exists()) {
				myFilePath.mkdirs();
				System.out.println("目录创建成功！");
			}
		} catch (Exception e) {
			System.out.println("新建目录操作出错");
			e.printStackTrace();
		}
	}
	/*
	 *  新建文件  
	 *  
	 *  @param  filePathAndName
	 *  文件路径及名称  如c:/fqf.txt  
	 *  
	 *  @param  fileContent
	 *  文件内容  
	 *  
	 */
	public static void newFile(String filePathAndName, String fileContent) {

		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			FileWriter resultFile = new FileWriter(myFilePath);
			PrintWriter myFile = new PrintWriter(resultFile);
			String strContent = fileContent;
			myFile.println(strContent);
			resultFile.close();

		} catch (Exception e) {
			System.out.println("新建目录操作出错");
			e.printStackTrace();

		}
	}

	/*  
	 *  删除文件  
	 *  @param  filePathAndName  String  
	 *  文件路径及名称  如c:/fqf.txt 
	 */
	public static void delFile(String filePathAndName) {
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			java.io.File myDelFile = new java.io.File(filePath);
			myDelFile.delete();

		} catch (Exception e) {
			System.out.println("删除文件操作出错");
			e.printStackTrace();

		}

	}

	/*  
	 *  删除文件夹里面的所有文件  
	 *  @param  path  String  文件夹路径  如  c:/fqf  
	 */
	public static void delAllFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			return;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件  
				delFolder(path + "/" + tempList[i]);//再删除空文件夹  
			}
		}
	}

	/*  
	 *  删除文件夹  
	 *  @param  filePathAndName  String  文件夹路径及名称  如c:/fqf  
	 *  @param  fileContent  String  
	 *  @return  boolean  
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); //删除完里面所有内容  
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); //删除空文件夹  

		} catch (Exception e) {
			System.out.println("删除文件夹操作出错");
			e.printStackTrace();

		}
	}

	/*  
	 *  复制单个文件  
	 *  @param  oldPath  String  原文件路径  如：c:/fqf.txt  
	 *  @param  newPath  String  复制后路径  如：f:/fqf.txt  
	 *  @return  boolean  
	 */
	public static void copyFile(String oldPath, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) { //文件存在时  
				InputStream inStream = new FileInputStream(oldPath); //读入原文件  
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[8 * 1024];
				int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; //字节数  文件大小  
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();

		}

	}

	/*  
	 *  复制整个文件夹内容  
	 *  @param  oldPath  String  原文件路径  如：c:/fqf  
	 *  @param  newPath  String  复制后路径  如：f:/fqf/ff  
	 *  @return  boolean  
	 */
	public static void copyFolder(String oldPath, String newPath) {

		try {
			(new File(newPath)).mkdirs(); //如果文件夹不存在  则建立新文件夹  
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}

				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath
							+ "/" + (temp.getName()).toString());
					byte[] b = new byte[1024 * 8];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if (temp.isDirectory()) {//如果是子文件夹  
					copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
				}
			}
		} catch (Exception e) {
			System.out.println("复制整个文件夹内容操作出错");
			e.printStackTrace();

		}
	}

	/*  
	 *  移动文件到指定目录  
	 *  @param  oldPath  String  如：c:/fqf.txt  
	 *  @param  newPath  String  如：d:/fqf.txt  
	 */
	public static void moveFile(String oldPath, String newPath) {
		copyFile(oldPath, newPath);
		delFile(oldPath);

	}

	/*  
	 *  移动文件到指定目录  
	 *  @param  oldPath  String  如：c:/fqf.txt  
	 *  @param  newPath  String  如：d:/fqf.txt  
	 */
	public static void moveFolder(String oldPath, String newPath) {
		copyFolder(oldPath, newPath);
		delFolder(oldPath);

	}

	public static String getFix(String fileName) {
		int pos = fileName.lastIndexOf(".");
		if (pos == -1) {
			return null;
		} else {
			return fileName.substring(pos+1, fileName.length());
		}
	}

	public static void copy(File src, File dst) {
		int BUFFER_SIZE = 8 * 1024;
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
	
	
	
	private static HashMap<String,String> h = new HashMap<String,String>();
	
	static {
		 h.put("","application/octet-stream");
		  h.put("323","text/h323");
		  h.put("acx","application/internet-property-stream");
		  h.put("ai","application/postscript");
		  h.put("aif","audio/x-aiff");
		  h.put("aifc","audio/x-aiff");
		  h.put("aiff","audio/x-aiff");
		  h.put("asf","video/x-ms-asf");
		  h.put("asr","video/x-ms-asf");
		  h.put("asx","video/x-ms-asf");
		  h.put("au","audio/basic");
		  h.put("avi","video/x-msvideo");
		  h.put("axs","application/olescript");
		  h.put("bas","text/plain");
		  h.put("bcpio","application/x-bcpio");
		  h.put("bin","application/octet-stream");
		  h.put("bmp","image/bmp");
		  h.put("c","text/plain");
		  h.put("cat","application/vnd.ms-pkiseccat");
		  h.put("cdf","application/x-cdf");
		  h.put("cer","application/x-x509-ca-cert");
		  h.put("class","application/octet-stream");
		  h.put("clp","application/x-msclip");
		  h.put("cmx","image/x-cmx");
		  h.put("cod","image/cis-cod");
		  h.put("cpio","application/x-cpio");
		  h.put("crd","application/x-mscardfile");
		  h.put("crl","application/pkix-crl");
		  h.put("crt","application/x-x509-ca-cert");
		  h.put("csh","application/x-csh");
		  h.put("css","text/css");
		  h.put("dcr","application/x-director");
		  h.put("der","application/x-x509-ca-cert");
		  h.put("dir","application/x-director");
		  h.put("dll","application/x-msdownload");
		  h.put("dms","application/octet-stream");
		  h.put("doc","application/msword");
		  h.put("dot","application/msword");
		  h.put("dvi","application/x-dvi");
		  h.put("dxr","application/x-director");
		  h.put("eps","application/postscript");
		  h.put("etx","text/x-setext");
		  h.put("evy","application/envoy");
		  h.put("exe","application/octet-stream");
		  h.put("fif","application/fractals");
		  h.put("flr","x-world/x-vrml");
		  h.put("gif","image/gif");
		  h.put("gtar","application/x-gtar");
		  h.put("gz","application/x-gzip");
		  h.put("h","text/plain");
		  h.put("hdf","applicatin/x-hdf");
		  h.put("hlp","application/winhlp");
		  h.put("hqx","application/mac-binhex40");
		  h.put("hta","application/hta");
		  h.put("htc","text/x-component");
		  h.put("htm","text/html");
		  h.put("html","text/html");
		  h.put("htt","text/webviewhtml");
		  h.put("ico","image/x-icon");
		  h.put("ief","image/ief");
		  h.put("iii","application/x-iphone");
		  h.put("ins","application/x-internet-signup");
		  h.put("isp","application/x-internet-signup");
		  h.put("jfif","image/pipeg");
		  h.put("jpe","image/jpeg");
		  h.put("jpeg","image/jpeg");
		  h.put("jpg","image/jpeg");
		  h.put("js","application/x-javascript");
		  h.put("latex","application/x-latex");
		  h.put("lha","application/octet-stream");
		  h.put("lsf","video/x-la-asf");
		  h.put("lsx","video/x-la-asf");
		  h.put("lzh","application/octet-stream");
		  h.put("m13","application/x-msmediaview");
		  h.put("m14","application/x-msmediaview");
		  h.put("m3u","audio/x-mpegurl");
		  h.put("man","application/x-troff-man");
		  h.put("mdb","application/x-msaccess");
		  h.put("me","application/x-troff-me");
		  h.put("mht","message/rfc822");
		  h.put("mhtml","message/rfc822");
		  h.put("mid","audio/mid");
		  h.put("mny","application/x-msmoney");
		  h.put("mov","video/quicktime");
		  h.put("movie","video/x-sgi-movie");
		  h.put("mp2","video/mpeg");
		  h.put("mp3","audio/mpeg");
		  h.put("mpa","video/mpeg");
		  h.put("mpe","video/mpeg");
		  h.put("mpeg","video/mpeg");
		  h.put("mpg","video/mpeg");
		  h.put("mpp","application/vnd.ms-project");
		  h.put("mpv2","video/mpeg");
		  h.put("ms","application/x-troff-ms");
		  h.put("mvb","application/x-msmediaview");
		  h.put("nws","message/rfc822");
		  h.put("oda","application/oda");
		  h.put("p10","application/pkcs10");
		  h.put("p12","application/x-pkcs12");
		  h.put("p7b","application/x-pkcs7-certificates");
		  h.put("p7c","application/x-pkcs7-mime");
		  h.put("p7m","application/x-pkcs7-mime");
		  h.put("p7r","application/x-pkcs7-certreqresp");
		  h.put("p7s","application/x-pkcs7-signature");
		  h.put("pbm","image/x-portable-bitmap");
		  h.put("pdf","application/pdf");
		  h.put("pfx","application/x-pkcs12");
		  h.put("pgm","image/x-portable-graymap");
		  h.put("pko","application/ynd.ms-pkipko");
		  h.put("pma","application/x-perfmon");
		  h.put("pmc","application/x-perfmon");
		  h.put("pml","application/x-perfmon");
		  h.put("pmr","application/x-perfmon");
		  h.put("pmw","application/x-perfmon");
		  h.put("pnm","image/x-portable-anymap");
		  h.put("pot,","application/vnd.ms-powerpoint");
		  h.put("ppm","image/x-portable-pixmap");
		  h.put("pps","application/vnd.ms-powerpoint");
		  h.put("ppt","application/vnd.ms-powerpoint");
		  h.put("prf","application/pics-rules");
		  h.put("ps","application/postscript");
		  h.put("pub","application/x-mspublisher");
		  h.put("qt","video/quicktime");
		  h.put("ra","audio/x-pn-realaudio");
		  h.put("ram","audio/x-pn-realaudio");
		  h.put("ras","image/x-cmu-raster");
		  h.put("rgb","image/x-rgb");
		  h.put("rmi","audio/mid");
		  h.put("roff","application/x-troff");
		  h.put("rtf","application/rtf");
		  h.put("rtx","text/richtext");
		  h.put("scd","application/x-msschedule");
		  h.put("sct","text/scriptlet");
		  h.put("setpay","application/set-payment-initiation");
		  h.put("setreg","application/set-registration-initiation");
		  h.put("sh","application/x-sh");
		  h.put("shar","application/x-shar");
		  h.put("sit","application/x-stuffit");
		  h.put("snd","audio/basic");
		  h.put("spc","application/x-pkcs7-certificates");
		  h.put("spl","application/futuresplash");
		  h.put("src","application/x-wais-source");
		  h.put("sst","application/vnd.ms-pkicertstore");
		  h.put("stl","application/vnd.ms-pkistl");
		  h.put("stm","text/html");
		  h.put("svg","image/svg+xml");
		  h.put("sv4cpio","application/x-sv4cpio");
		  h.put("sv4crc","application/x-sv4crc");
		  h.put("swf","application/x-shockwave-flash");
		  h.put("t","application/x-troff");
		  h.put("tar","application/x-tar");
		  h.put("tcl","application/x-tcl");
		  h.put("tex","application/x-tex");
		  h.put("texi","application/x-texinfo");
		  h.put("texinfo","application/x-texinfo");
		  h.put("tgz","application/x-compressed");
		  h.put("tif","image/tiff");
		  h.put("tiff","image/tiff");
		  h.put("tr","application/x-troff");
		  h.put("trm","application/x-msterminal");
		  h.put("tsv","text/tab-separated-values");
		  h.put("txt","text/plain");
		  h.put("uls","text/iuls");
		  h.put("ustar","application/x-ustar");
		  h.put("vcf","text/x-vcard");
		  h.put("vrml","x-world/x-vrml");
		  h.put("wav","audio/x-wav");
		  h.put("wcm","application/vnd.ms-works");
		  h.put("wdb","application/vnd.ms-works");
		  h.put("wks","application/vnd.ms-works");
		  h.put("wmf","application/x-msmetafile");
		  h.put("wps","application/vnd.ms-works");
		  h.put("wri","application/x-mswrite");
		  h.put("wrl","x-world/x-vrml");
		  h.put("wrz","x-world/x-vrml");
		  h.put("xaf","x-world/x-vrml");
		  h.put("xbm","image/x-xbitmap");
		  h.put("xla","application/vnd.ms-excel");
		  h.put("xlc","application/vnd.ms-excel");
		  h.put("xlm","application/vnd.ms-excel");
		  h.put("xls","application/vnd.ms-excel");
		  h.put("xlt","application/vnd.ms-excel");
		  h.put("xlw","application/vnd.ms-excel");
		  h.put("xof","x-world/x-vrml");
		  h.put("xpm","image/x-xpixmap");
		  h.put("xwd","image/x-xwindowdump");
		  h.put("z","application/x-compress");
		  h.put("zip","application/zip");
	}
	
	public static String getMimeType(String docType){
		  String mime = "";
		 
		  mime = h.get(docType.toLowerCase());
		  if(mime==null){
		   mime = "application/octet-stream";
		  }
		  return mime;
		 }

	
	/**
	 * 获取远端文件字符串
	 * 文件长度过大时会占用太多内存
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String getRemoteFileStringByURL(String urlStr) throws Exception {
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(urlStr);
			URLConnection con = url.openConnection();
			InputStream input = con.getInputStream();

			BufferedReader in = new BufferedReader(new InputStreamReader(input));
			String line = "";
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
			input.close();

		} catch (Exception e) {
			return null;
		}
		return buffer.toString();
	}
	


	public static void main(String args[]) throws Exception{
		//MyFile.newFolder("c:\\studyTest6\\devil13th\\WebRoot\\s");
		//System.out.println(MyFile.getFix("xxx.a"));
		//System.out.println(MyFile.getMimeType("JPG"));
		
		//System.out.println(1);
		String str = MyFileUtils.getRemoteFileStringByURL("http://10.0.10.34:9090/NewERS/public/dsmis/1993V0000729.xml");
		System.out.println(str);
	}

}
