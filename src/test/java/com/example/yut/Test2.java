package com.example.yut;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.study.App;
import com.study.entity.MtSfaObject;
import com.study.entity.TestEntity;
import com.study.util.CosClientUtil;
import com.study.util.DateStyle;
import com.study.util.DateUtil;
import com.study.util.Sha1Util;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.LockSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= App.class)
public class Test2 {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CosClientUtil cosutil;
//    @Autowired
//    private AmqpTemplate amqpTemplate;
//
//    @Test
//    public void send1(){
//        amqpTemplate.convertAndSend("myQueue1", "1 now " + new Date());
//    }
//
//    @Test
//    public void send2(){
//        amqpTemplate.convertAndSend("myQueue2", "2 now " + new Date());
//    }
//
//    @Test
//    public void send3(){
//        amqpTemplate.convertAndSend("myQueue3", "3 now " + new Date());
//    }


    public static void main(String[] args) throws  Exception {
        final Thread  t1 =  new Thread();
        final Thread  t2 =  new Thread();
        final char[] ai = "123456".toCharArray();
        final char[] ac = "asdfgh".toCharArray();


        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < ai.length; i++) {

                    System.out.println("++++++++1" + ai[i]);
                    LockSupport.unpark(Thread.currentThread());
                    LockSupport.park();

                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <  ac.length; i++) {

                    System.out.println("++++++++2" + ac[i]);
                    LockSupport.unpark(t1);
                    LockSupport.park();
                }
            }
        }.start();

    }




    @Test
    public void testt2(){
        final char[] ai = "123456".toCharArray();
        final char[] ac = "asdfgh".toCharArray();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < ai.length; i++) {
                    LockSupport.park();
                    System.out.println("++++++++1" + ai[i]);
                    LockSupport.unpark(this);

                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <  ac.length; i++) {
                    LockSupport.park();
                    System.out.println("++++++++2" + ac[i]);
                    LockSupport.unpark(this);

                }
            }
        }.start();

    }

    @Test
    public void testt1(){
//        Test3 t3 = new Test3();
//        t3.testt1();
        System.out.println("机械结构："+Integer.getInteger("-92"));
    }

    @Test
    public void testt(){
        boolean f = true && true && false && true;
            System.out.println("wewew11:"+f);
         f = true && true && false && false;
            System.out.println("wewew12:"+f);

        List<TestEntity> list =  new ArrayList<TestEntity>();
        list = null;
        if(list != null && list.size() > 0 && ( list.get(0).getName() != null || !list.get(0).getName().equals(""))){
            System.out.println("并不为空");
        }else {
            System.out.println("为空");
        }

    }


    @Test
    public void tets(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        cal.setTime(new Date());
        //同步当天的追溯码
        cal.add(Calendar.DAY_OF_MONTH, 0);
        String date = sdf.format(cal.getTime());
        System.out.println(date);
    }

    @Test
    public void runFile() throws Exception{
        int num = (int) (Math.random() * 10000 + 1);
        String key = new Date().getTime() + num + ".png";
        File file = new File("D:\\code2.jpg");
        byte[] buffer =  File2byte(file);
        File file1 = cosutil.inputStreamToFile(buffer, key);
        String imgUrl = cosutil.uploadFile(file1, key);
        System.out.println(imgUrl);
    }

    /**
     * 将文件转换成byte数组
     * @param filePath
     * @return
     */
    public static byte[] File2byte(File tradeFile){
        byte[] buffer = null;
        try
        {
            FileInputStream fis = new FileInputStream(tradeFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1)
            {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * 方法说明： 参传调接口同步数据
     * @author      ethan
     */
    @Test
    public void postFor() {
        String url = "http://192.168.0.126:8082/mtSfaApi/allMtList";
        MtSfaObject s = new MtSfaObject();
        s.setPageNumber(1);
        s.setPageSize(10);
        String jsonParam = JSON.toJSONString(s);
        // 实际传递的参数
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> requestEntity = new HttpEntity<String>(jsonParam, requestHeaders);
        JSONObject response = restTemplate.postForObject(url, requestEntity, JSONObject.class);
        System.out.println("结果返回："+response.toString());

    }

    @Test
    public void requst(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //header
        //headers.set("Authorization", "1172452ae5f144cda26790d2ad18118e");
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
        //参数
        params.add("","");
        params.add("","");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        ResponseEntity<String> response = restTemplate.exchange("http://192.168.0.126:8082/mtSfaApi/allMtList", HttpMethod.POST, requestEntity, String.class);
        String sttr = response.getBody();
        System.out.println("结果返回："+sttr);
    }


    public static String getStr(){
        StringBuffer bf = new StringBuffer();
        bf.append(" 	SELECT  ");
        bf.append(" '" + "' date, ");
        bf.append(" 	a.Level1_SuperID `so_id`,a.Level1_SuperIDName `so`,a.Level2_SuperID `r_id`,a.Level2_SuperIDName `region`,a.Level3_SuperID `d_id`,a.Level3_SuperIDName `district`,a.Level4_SuperID `cg_id`,a.Level4_SuperIDName `city_group`,a.Level5_SuperID `c_id`,a.Level5_SuperIDName `city`,");
        bf.append(" 	s.id `s_id`,s.`code` `store_code`,s.`name` `store_name`,dealer.`code` `dealer_code`,dealer.`name` `dealer_name` ");
        bf.append(" 	,ss.`name` `sku_series`,sku.id `sku_id`,sku.`name` `sku_name`,  ");
        bf.append(" 	IF(datediff(NOW(),t.prodate) BETWEEN 1 AND 90,'绿灯区', ");
        bf.append(" 				IF(datediff(NOW(),t.prodate) BETWEEN 91 AND 180,'黄灯区', ");
        bf.append(" 						IF(datediff(NOW(),t.prodate) BETWEEN 181 AND 360,'红灯区', ");
        bf.append(" 							IF(datediff(DATE_ADD(t.prodate,INTERVAL sku.exp MONTH),NOW()) = 0 OR (datediff(NOW(),t.prodate) >= 361 AND datediff(DATE_ADD(t.prodate,INTERVAL sku.exp MONTH),NOW()) > 0),'近效期', ");
        bf.append(" 								IF(datediff(DATE_ADD(t.prodate,INTERVAL sku.exp MONTH),NOW()) < 0,'过期','未过期') ");
        bf.append(" 							) ");
        bf.append(" 						) ");
        bf.append(" 				) ");
        bf.append(" 		) `TermOfValidity`, SUM(1) `num`,IFNULL(SUM(sku.price),0) `price`,IFNULL(SUM(sku.weight),0) `weight`,NOW() create_time ");
        bf.append(" 	 FROM (SELECT a.`id`,a.`update_time`,a.`update_user_id`,a.`create_time`,a.`create_user_id`,a.`active`,a.`store_id`,a.`sku_id`,a.`qrcode`,a.`type`,b.prodate FROM  (  	SELECT   	`id`,`update_time`,`update_user_id`,`create_time`,`create_user_id`,`active`,`store_id`,`sku_id`,`qrcode`,`type`  	 FROM etms_feihe.`t_bo_store_sku_qrcode` WHERE type in (1,2,4) AND active=1) a INNER JOIN etms_feihe.t_bo_qrcode b ON b.`code` = a.qrcode WHERE (SELECT MAX(type) FROM t_bo_store_sku_qrcode aa WHERE aa.qrcode = a.qrcode AND aa.active = 1) IN (1, 2, 4) GROUP BY a.qrcode) t  ");
        bf.append(" 	LEFT JOIN t_bo_sku sku ON sku.id=t.sku_id ");
        bf.append(" 	LEFT JOIN t_bo_sku_series ss ON ss.id=sku.sku_series ");
        bf.append(" 	LEFT JOIN t_bo_store s ON t.store_id=s.id ");
        bf.append(" 	LEFT JOIN t_bo_dealer dealer ON dealer.id=s.dealer ");
        bf.append(" 	LEFT JOIN t_nr_area a ON a.ID = s.city_id ");
        bf.append(" GROUP BY s.id,sku.id,TermOfValidity ");

        return bf.toString();
    }

    /**
     * 获取签名信息
     * @param ts
     * @return
     */
    public static String checkSign(String signParam,long ts) {
        boolean pass = true;
        String tk = "U2FsdGVkX18TaQQ"+"cPTI8P11n9TEYHXY2yJ3SrXVOmY"+ts;
        String sign = "";
        try {
            sign = SHA1(tk);
            System.out.println("sign:" + sign + " ts:" + ts);
            if (!StringUtils.equals(signParam, sign)) {
                pass = false;
            }
        } catch (DigestException e) {
            pass = false;
        }
        return sign;
    }

    private static String SHA1(String str) throws DigestException {
        //获取信息摘要 - 参数字典排序后字符串
        String decrypt =  str;
        try {
            //指定sha1算法
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(decrypt.getBytes());
            //获取字节数组
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            //log.error("签名错误信息：{}",e.getMessage());
            throw new DigestException("签名错误！");
        }
    }


    /**
     * get请求
     * @param url
     * @param signParam
     * @return
     */
    public static  String get(String url, Map<String, Object> signParam) throws Exception{
        String json = "";
        // 签名信息
        String sign = "";
        // 没有参数
        if (signParam == null) {
            signParam = new HashMap<String, Object>();
        }
        long time = new Date().getTime();
        signParam.put("timestamp", time);
        // 对问号后面参数信息进行加密
        try {
            sign = Sha1Util.SHA1(signParam, "MZOOY#AM4IIMQ!@4");
        } catch (DigestException e1) {
            System.out.println("请求的URL：{}，异常信息：{}");
        } catch (UnsupportedEncodingException e1) {
            //logger.error("请求的URL：{}，异常信息：{}",url,e1.getMessage());
        }

        // url问号后面参数信息
        String param = "?sign=" + sign + "&publicKey=" + "MZZWAHAJ1855V12M";
        for (Map.Entry<String, Object> entry : signParam.entrySet()) {
            param = param + "" + "&" + entry.getKey() + "=" + entry.getValue();
        }
        url = url + param;
//        try {
//            json = restTemplate.getForObject(url, String.class);
//        } catch (Exception e) {
//            logger.error("请求的URL：{}，异常信息：{}",url,e.getMessage());
//        }

        return url;
    }

}
