package com.thd.utils.myutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MyDateUtils {
	public static String toString(Date date){
		String str ="";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			str = sf.format(date);
		}catch(Exception ex)
		{
			str="";
		}
		return str;
	}
	
	/*
	Letter	Date or Time Component	Presentation	Examples
	G	Era designator	Text	AD
	y	Year	Year	1996; 96
	M	Month in year	Month	July; Jul; 07
	w	Week in year	Number	27
	W	Week in month	Number	2
	D	Day in year	Number	189
	d	Day in month	Number	10
	F	Day of week in month	Number	2
	E	Day in week	Text	Tuesday; Tue
	a	Am/pm marker	Text	PM
	H	Hour in day (0-23)	Number	0
	k	Hour in day (1-24)	Number	24
	K	Hour in am/pm (0-11)	Number	0
	h	Hour in am/pm (1-12)	Number	12
	m	Minute in hour	Number	30
	s	Second in minute	Number	55
	S	Millisecond	Number	978
	z	Time zone	General time zone	Pacific Standard Time; PST; GMT-08:00
	Z	Time zone	RFC 822 time zone	-0800
	
	
	
	
	
	
Date and Time Pattern	          Result
"yyyy.MM.dd G 'at' HH:mm:ss z"	  2001.07.04 AD at 12:08:56 PDT
"EEE, MMM d, ''yy"	              Wed, Jul 4, '01
"h:mm a"	                      12:08 PM
"hh 'o''clock' a, zzzz"	12 o'clock PM, Pacific Daylight Time
"K:mm a, z"	0:08 PM, PDT
"yyyyy.MMMMM.dd GGG hh:mm aaa"	  02001.July.04 AD 12:08 PM
"EEE, d MMM yyyy HH:mm:ss Z"	  Wed, 4 Jul 2001 12:08:56 -0700
"yyMMddHHmmssZ"	010704120856-0700
"yyyy-MM-dd'T'HH:mm:ss.SSSZ"	  2001-07-04T12:08:56.235-0700


	*/
	public static String toString(Date date,String pattern){
		String str ="";
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		try
		{
			str = sf.format(date);
		}catch(Exception ex)
		{
			str="";
		}
		return str;
	}
	
	public static Date toDate(String date){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = null;
		try {
			dt = sf.parse(date);
		} catch (ParseException e) {
			dt = null;
		}
		return dt;
	}
	
	
	public static String toStringEn(Date date){
		String str ="";
		SimpleDateFormat sf = new SimpleDateFormat("EEE MMM d HH:mm:ss 'CST' yyyy", Locale.ENGLISH);
		try{
			str = sf.format(date);
		}catch(Exception ex){
			str="";
		}
		return str;
	}
	/**
	 * 获取某日期在当年的所属周次
	 * @param date 日期 格式：yyyy-MM-dd
	 * @return 某日期在当年的所属周次
	 */
	public static int getWeekOfYear(String date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		Date cdate = null;  
		try {  
		    cdate = format.parse(date);  
		} catch (ParseException e) {  
		    e.printStackTrace();  
		    throw new RuntimeException(e);
		}  
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);  
		calendar.setTime(cdate);  
		return calendar.get(Calendar.WEEK_OF_YEAR); 
	}
	
	 /** 
     * 获取某年第几周的开始日期
     * @param year 
     * @param weekNo 
     * @return 
     */  
    public static String getFirstDayOfWeekNo(int year,int weekNo){  
		Calendar cal = Calendar.getInstance();  
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);        
		cal.set(Calendar.YEAR, year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);  
        int m = cal.get(Calendar.MONTH) + 1;
        int d = cal.get(Calendar.DAY_OF_MONTH);
        return cal.get(Calendar.YEAR) + "-" + (m < 10 ? "0" + m : "" + m)+ "-" + (d < 10 ? "0" + d : "" + d);
          
    }  
    
    /** 
     *  获取某年第几周的结束日期
     * @param year 
     * @param weekNo 
     * @return 
     */  
    public static String getLastDayOfWeekNo(int year,int weekNo){  
         Calendar cal = Calendar.getInstance();  
         cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);        
         cal.set(Calendar.YEAR, year);  
         cal.set(Calendar.WEEK_OF_YEAR, weekNo);  
         cal.add(Calendar.DAY_OF_WEEK, 6);  
         
         int m = cal.get(Calendar.MONTH) + 1;
         int d = cal.get(Calendar.DAY_OF_MONTH);
         return cal.get(Calendar.YEAR) + "-" + (m < 10 ? "0" + m : "" + m)+ "-" + (d < 10 ? "0" + d : "" + d);
          
    }
    
    
    
    /** 
     * 获取某年某月第一天
     * @param year 
     * @param month 
     * @return 
     */  
    public static String getFirstDayOfMonth(int year,int month){  
        String monthStr = month < 10 ? "0" + month : String.valueOf(month);  
        return year + "-"+monthStr+"-" +"01";  
    }  
      
    /** 
     * 获取某年某月最后一天
     * @param year 
     * @param month 
     * @return 
     */  
    public static String getLastDayOfMonth(int year,int month){  
        Calendar calendar = Calendar.getInstance();  
        calendar.set(Calendar.YEAR , year);
        calendar.set(Calendar.MONTH , month - 1);  
        calendar.set(Calendar.DATE , 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_YEAR , -1);
        
        int m = calendar.get(Calendar.MONTH) + 1;
        String strM = m > 9 ? (m+"") : ("0"+m) ;
        return calendar.get(Calendar.YEAR) + "-" + strM + "-" +  
               calendar.get(Calendar.DAY_OF_MONTH);  
    }  
	
    public static int getDayOfWeek(String date){
    	Calendar calendar = Calendar.getInstance();  
    	calendar.setTime(MyDateUtils.toDate(date));
    	int r = calendar.get(Calendar.DAY_OF_WEEK) - 1;
    	return r == 0 ? 7 : r;
    }
    
	public static void main(String[] args){
		System.out.println(MyDateUtils.getWeekOfYear("2017-01-01"));
		System.out.println(MyDateUtils.getFirstDayOfWeekNo(2017,1));
		System.out.println(MyDateUtils.getLastDayOfWeekNo(2017,1));
		
		System.out.println(MyDateUtils.getFirstDayOfMonth(2017,1));
		System.out.println(MyDateUtils.getLastDayOfMonth(2017,1));
		
		
		System.out.println(MyDateUtils.toStringEn(new Date()));
	}
}
