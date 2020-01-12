package com.example.yut;

import com.study.util.Sha1Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFile {

    public static void main(String[] agrs )throws Exception{
        //String date = "2016-08-15T16:00:00.000Z";
//        String date = "2019-07-11T16:50:15.000+08:00";
//        date = date.replace("Z", " UTC");
//        System.out.println(date);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000+08:00");
//        Date d = format.parse(date);
//        SimpleDateFormat format1 =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(format1.format(d));

        System.out.println(new Date().getTime());
        String sign = Sha1Util.SHA1_NEW("U2FsdGVkX18TaQQcPTI8P11n9TEYHXY2yJ3SrXVOmY1512610594905");
        System.out.println(sign);
    }
}
