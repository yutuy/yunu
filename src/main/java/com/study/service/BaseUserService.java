package com.study.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.study.entity.BaseUserEntity;
import com.study.mapper.BaseUserMapper;
import com.study.vo.BaseUserVo;

@Service
public class BaseUserService extends ServiceImpl<BaseUserMapper, BaseUserEntity> {
	private static final Logger logger = LoggerFactory.getLogger(BaseUserService.class);
	@Autowired
	private BaseUserMapper baseUserMapper;

	@Value("${my.table}")
	private String myTable;

	/**
	 * 分页查询
	 * @param page
	 * @param wrapper
	 * @return
	 */
	public Map<String,Object> getPage(Page<BaseUserEntity> page,EntityWrapper<BaseUserEntity> wrapper) {
		Map<String,Object> result = new HashMap<String,Object>();
		int total = baseUserMapper.selectCount(wrapper);
		wrapper.orderBy("id", true);
		List<BaseUserEntity> brands = baseUserMapper.selectPage(page, wrapper);
		List<BaseUserVo> list = new ArrayList<BaseUserVo>();
		for (BaseUserEntity brand : brands) {
			BaseUserVo kaVo = new BaseUserVo();
			BeanUtils.copyProperties(brand, kaVo);
			list.add(kaVo);
		}
		result.put("total", total);
        result.put("rows", list);
        return result;
	}

	/**
	* 方法说明：根据传入的表名获取数据
	* @author      ethan
	*/
	public Map<String, Object> getCommmonDataByTable(){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("total", 10);
		//result.put("rows", baseUserMapper.getCommmonDataByTable());
		System.out.println("biao:"+myTable);
		result.put("rows", baseUserMapper.selectTest(myTable));
		return result;
	}
}
