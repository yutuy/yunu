package com.example.yut;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import  java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.study.util.DateUtils;
import org.apache.commons.codec.digest.DigestUtils;

public class DateTest {
    public static void main(String[] agrs ) throws Exception{
        String date1 = "2019-07-29";
        String date2 = "2019-08-04";

        int days = getDays(date1,date2);
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
//        Date d1=sdf.parse(date1);
//        Date d2=sdf.parse(date2);
//        int days =  differentDays(d1,d2);
        System.out.println(days);

//        Map<String, String> dateMap =getWeekDate(date2);
//        String scheduleWeek = dateMap.get("mondayDate").toString();

//        System.out.println("::::::::"+scheduleWeek);
//        String timestamp =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//        String appkey = "10004";
//        String appSecret = "4e92f9fbe1f3bb19061dfbe91cc2e5c9";
//        String sbstr = appSecret + "timestamp"+ timestamp + appSecret;
//        String sign = DigestUtils.md5Hex(sbstr).toUpperCase();
//        System.out.println(timestamp);
//        System.out.println(sign);


//        //设置转换的日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        //开始时间
        Date startDate = sdf.parse("2019-07-29");
        //结束时间
        Date endDate = sdf.parse("2019-08-04");

        //得到相差的天数 betweenDate
        long betweenDate = (endDate.getTime() - startDate.getTime())/(60*60*24*1000);

        //打印控制台相差的天数
        System.out.println(betweenDate);
    }

    /**
     * 方法说明：传入两个日期，得到两个日期相差多少天
     * @author      ethan
     */
    public static int getDays(String date1,String date2) throws Exception{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date d1=sdf.parse(date1);
        Date d2=sdf.parse(date2);
        long  daysBetween=(d2.getTime()-d1.getTime())/(60*60*24*1000);
        int a = (int)daysBetween;
        return a;
    }

    /**
     * 当前时间所在一周的周一和周日时间
     * @param time 当前时间
     * @return
     */
    public static Map<String, String> getWeekDate(String date) {
        Map<String, String> map = new HashMap<String,String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(date));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (dayWeek == 1) {
            dayWeek = 8;
        }

        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayWeek);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        Date mondayDate = cal.getTime();
        String weekBegin = sdf.format(mondayDate);

        cal.add(Calendar.DATE, 4 + cal.getFirstDayOfWeek());
        Date sundayDate = cal.getTime();
        String weekEnd = sdf.format(sundayDate);

        map.put("mondayDate", weekBegin);
        map.put("sundayDate", weekEnd);
        return map;
    }

    public static int differentDays(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);


        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);


        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2) // 同一年
        {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) // 闰年
                {
                    timeDistance += 366;
                } else // 不是闰年
                {
                    timeDistance += 365;
                }
            }


            return timeDistance + (day2 - day1);
        } else // 不同年
        {
            System.out.println("判断day2 - day1 : " + (day2 - day1));
            return day2 - day1;
        }
    }

}
