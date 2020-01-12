package com.example.yut;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.study.App;
import com.study.entity.MtSfaObject;
import com.study.entity.TestEntity;
import com.study.util.CosClientUtil;
import com.study.util.Sha1Util;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import sun.reflect.annotation.ExceptionProxy;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= App.class)
public class Test3 {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CosClientUtil cosutil;

    public static void main(String[] args) throws  Exception {

    }

    @Test
    public void testt(){
        String m = "报名接口调用异常或调用超时：\n" +
                "org.springframework.web.client.HttpServerErrorException: 500 null\n" +
                "\tat org.springframework.web.client.DefaultResponseErrorHandler.handleError(DefaultResponseErrorHandler.java:81)\n" +
                "\tat org.springframework.web.client.RestTemplate.handleResponse(RestTemplate.java:700)\n" +
                "\tat org.springframework.web.client.RestTemplate.doExecute(RestTemplate.java:653)\n";

        String ms =  m.substring(0,250);
        System.out.println(m.length()+":"+ms.length());
    }

    @Test
    public void testt1(){
        try {
            int a = 1 / 3;
            int b = 3 / 5;
            Integer dd = null;
            int c = dd.intValue();
            System.out.println(c);
            int d = 4 / 6;
        }catch (Exception e){
//            System.out.println("msg:"+e.getMessage());
//            System.out.println("-------------------------------------------------------------------------------------");
//            e.printStackTrace();
//            System.out.println("-------------------------------------------------------------------------------------");
            if (e.getMessage() == null) {
                StackTraceElement[] strr = ((Throwable)e).getStackTrace();
                System.out.println("InvocationTargetException:" + strr[0].toString()+"-"+strr[1].toString() );
//                for (StackTraceElement ele:strr) {
//                    System.out.println("InvocationTargetException:" + ele );
//                }
            }else {
                System.out.println("msg:"+e.getMessage());
            }
        }
    }

}
