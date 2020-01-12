package com.study.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author Sun
 *
 */
public class DateUtils {
	
	public static SimpleDateFormat formatymd = new SimpleDateFormat("yyyy-MM-dd");

	public static SimpleDateFormat formatym = new SimpleDateFormat("yyyy-MM");

	/**
	 * 获取本月第一天
	 * @return yyyy-MM-dd
	 */
	public static String getFirstDate(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		Calendar cale = Calendar.getInstance();       
		cale.add(Calendar.MONTH, 0);         
		cale.set(Calendar.DAY_OF_MONTH, 1);     
		return  format.format(cale.getTime()); 
	}

	/**
	 * 获取本月最后一天
	 * @return yyyy-MM-dd
	 */
	public static String getLastDate(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		Calendar cale = Calendar.getInstance();       
		cale.add(Calendar.MONTH, 1);         
		cale.set(Calendar.DAY_OF_MONTH, 0);     
		return  format.format(cale.getTime()); 
	}
	
	/**
	 * 获取两个时间相差天数
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException 
	 */
    public static int differentDaysByMillisecond(String date1,String date2) throws ParseException
    {
//        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
//        return days;
    	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
         Date fDate=sdf.parse(date1);
         Date oDate=sdf.parse(date2);
         Calendar aCalendar = Calendar.getInstance();
         aCalendar.setTime(fDate);
         int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
		System.out.println(day1);
         aCalendar.setTime(oDate);
         int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
		System.out.println(day2);
         int days=day2-day1;
		System.out.println("*********************************");
         return days;
    }
}
