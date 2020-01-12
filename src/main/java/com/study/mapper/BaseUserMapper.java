package com.study.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.study.entity.BaseUserEntity;
import com.study.vo.BaseUserVo;

/**
 * 
 */
public interface BaseUserMapper extends BaseMapper<BaseUserEntity>{
	
	public int selectByConditionForCount(Map<String, Object> param);
	
	public List<BaseUserVo> selectByConditionForListByIdsAndLimt(Map<String, Object> param);
	
	/**
	 * 用户登录
	 * @param loginUserName
	 * @return
	 */
	BaseUserEntity getUserByUserName(String loginUserName);
	
	
	/**
	 * 根据真名查出用户
	 * @param loginUserName
	 * @return
	 */
	BaseUserEntity getUserByRealName(String realName);
	
	/** 
	 * 根据角色id查询所有的用户信息
	 * @param roleId
	 * @return
	 */
	public List<BaseUserEntity> getUsersByRoleId(Integer roleId);
	
	/**
	 * 用户是否存在的校验
	 * @param loginUserName
	 * @return
	 */
	public int checkUserExists(String loginUserName);
	
	/**
	 * 用户是否存在的校验
	 * @param loginUserName
	 * @return
	 */
	public int getUserSsrType(Integer userId);
	
	/**
	 * 该角色管理的用户
	 * @param loginUserLevel
	 * @return
	 */
	public List<BaseUserVo> getUserWithRole(@Param("loguserId") Integer loguserId, @Param("logroleId") Integer logroleId, @Param("logdomainlevel") Integer loglevel, @Param("roleId") Integer roleId, @Param("domainlevel") Integer domainlevel);
	
	/**
	 * 没有被管辖的人员
	 * @return
	 */
	public List<BaseUserVo> selectUserForListNoDomain(Integer logLevel);
	
	/**
	 * @see 督导角色管理的用户
	 * @return
	 */
	public List<BaseUserVo> getUserWithRoleFive(@Param("loguserId") Integer loguserId, @Param("logroleId") Integer logroleId, @Param("logdomainlevel") Integer loglevel, @Param("roleId") Integer roleId, @Param("domainlevel") Integer domainlevel);


	//根据传入的表名获取数据
	List<Map<String, Object>> getCommmonDataByTable();

	List<Map<String, Object>> selectTest(String myTable);
}
