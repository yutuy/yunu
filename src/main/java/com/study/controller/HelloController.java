package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by kemp on 2018/8/15.
 */
@Controller
@RequestMapping("/base")
public class HelloController {
 
    @RequestMapping(value = "/test")
    public String test(){ 
        return "index1";
    }

    /**
     * 上传图片
     * @param name
     * @param age
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/testMt", method = RequestMethod.POST)
    @ResponseBody
    public String testMt(@RequestParam("name") String name,@RequestParam("age") Integer age){

        return name+"是"+age+"岁！";
    }
}