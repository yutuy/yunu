package com.example.yut;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.study.entity.Message;
import org.apache.catalina.LifecycleState;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

    public static void main(String[] args) throws Exception{

//        String str = "{\"motherPhone\":\"13891432055\",\"finishTime\":\"2019-08-06 20:05:02\",\"orderSn\":\"FH2019080637477401\",\"opType\":\"1\",\"motherName\":\"荣杨\",\"sign\":\"c506b510e52477dfcd56b0955309b494b59e9b02\",\"buyTime\":\"2019-08-06 20:05:02\",\"customerFrom\":\"1\",\"pgCode\":\"137838\",\"number\":1,\"customerType\":\"0\",\"skuCode\":\"10081011\",\"storeCode\":\"311984\",\"memberId\":\"CRM000000000027015819\",\"ts\":1565093102705}\n";
//        System.out.println(str);
//        System.out.println("-------------------------------------------------------------");
//        //JSONObject json = JSONObject.parseObject(str);
//        System.out.println(JSON.parseObject(str).toJSONString());

//        String jsondata ="{url=https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQGe7zwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyRGc4Y0FiUEpmdTIxal9IOXh0Y2IAAgR-N0VdAwSA9AMA}";
////        String jsondata ="{KEY:1}";
////        JSONObject obj = JSON.parseObject(jsondata);
////        System.out.println(obj);
////        JSONObject json = JSON.parseObject(jsondata);
////        System.out.println(json)
////        String s = jsondata.split("=")[1];
//        String url = jsondata.substring(5,jsondata.length()-1);
//        System.out.println(url);

//        String date1 = "2018-12-29";
//        String date2 = "2019-01-01";
//        int i = getDays(date1,date2);
//        System.out.println(i);


//        List<Integer>  pkIds = new ArrayList<Integer>();
//        pkIds.add(1);
//        pkIds.add(2);
//        pkIds.add(4);
//        Iterator<Integer> it = pkIds.iterator();
//        while (it.hasNext()){
//            if(it.next() == 2){
//                it.remove();
//            }
//        }
//        System.out.println(pkIds);

//        String st = "201.12";
//        String[] sa = st.split(".");
//        for (String  s :sa) {
//            System.out.println(s);
//        }

//        Object o = new Integer(12);
//        Map a = new HashMap<String,Object>();
//        a.put("b",2112);
//        a.put("c",21121111);
////        System.out.println(a.getClass().getDeclaredField("c"));
////        System.out.println("--------------------------------------------");
//        Message m = new Message();
//        m.setName("wewew");
//        System.out.println(m.getClass().getDeclaredField("name").getGenericType().toString());
//        System.out.println("--------------------------------------------");
//        Field f = getDeclaredField(a,"b");
//        System.out.println(f.getGenericType().toString());

        String s = "15618335861第12222章76407221第3333节";
        Pattern p = Pattern.compile("\\d{1,}");
        Matcher m = p.matcher(s);
//        System.out.println("--------------------------------------------");
//        System.out.println(m.group());
//        System.out.println("--------------------------------------------");
        Long i = null;
        while(m.find()) {
            System.out.println(m.group());
            i = Long.parseLong(m.group());
            break;
        }
        System.out.println("--------------------------------------------");
        System.out.println(i);

    }

    /**
     * 循环向上转型, 获取对象的 DeclaredField
     *
     * @param object    : 子类对象
     * @param fieldName : 父类中的属性名
     *                  获取案例： String type = field.getGenericType().toString();
     * @return 父类中的属性对象
     */

    public static Field getDeclaredField(Object object, String fieldName) {
        Field field = null;
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                return field;
            } catch (Exception e) {
                // 这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                // 如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }
        return null;
    }


    /**
     * 方法说明：传入两个日期，得到两个日期相差多少天
     * @author      ethan
     */
    public static int getDays(String date1,String date2) throws Exception{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();

        cal.setTime(sdf.parse(date1));

        long time1 = cal.getTimeInMillis();

        cal.setTime(sdf.parse(date2));

        long time2 = cal.getTimeInMillis();

        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }

}
