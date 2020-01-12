package com.study.controller;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.study.entity.BaseUserEntity;
import com.study.service.BaseUserService;
/**
 * 基础模块用户管理
 * @author ronnie
 *
 */
@Controller
@RequestMapping("/base/user")
public class BaseUserController{
	private static final Logger logger = LoggerFactory.getLogger(BaseUserController.class);
	@Autowired
	private BaseUserService baseUserService;
	
	/**
	 * 获取品牌数据Grid
	 * @param pageSize
	 * @param pageNumber
	 * @param BaseUserEntity
	 * @return
	 */
	@GetMapping("/gridBrands")
	@ResponseBody
	public Object gridBrands(Integer pageSize,Integer pageNumber,BaseUserEntity BaseUserEntity) {
//		EntityWrapper<BaseUserEntity> wrapper = new EntityWrapper<BaseUserEntity>();
//		wrapper.eq("active", BaseUserEntity.getActive() == null ? 1: BaseUserEntity.getActive());
//		Map<String,Object> result = baseUserService.getPage(new Page<BaseUserEntity>(pageNumber, pageSize), wrapper);
//        return result;

		return baseUserService.getCommmonDataByTable();
	}
	
}
