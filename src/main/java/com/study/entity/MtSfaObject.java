package com.study.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 活动行程管理所需参数
 * @author Sun
 *
 */
@ApiModel(value="活动行程管理入参",description="活动行程管理入参属性")
public class MtSfaObject {

	@ApiModelProperty(name="pageNumber",value="当前页数",example="1")
	private Integer pageNumber;

	@ApiModelProperty(name="pageSize",value="每页大小",example="10")
	private Integer pageSize;

	@ApiModelProperty(name="un",value="当前登录人账号",example="0433366")
	private String un;

	@ApiModelProperty(name="exceptMtIds",value="过滤当天已拜访的活动ids")
	private List<Integer> exceptMtIds;//过滤当天已拜访的活动

	@ApiModelProperty(name="provinceId",value="省区id",example="20534")
	private Integer provinceId;

	@ApiModelProperty(name="typeId",value="会议类型id",example="7")
	private Integer typeId;

	@ApiModelProperty(name="mtName",value="会议名称",example="秀")
	private String mtName;

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public List<Integer> getExceptMtIds() {
		return exceptMtIds;
	}

	public void setExceptMtIds(List<Integer> exceptMtIds) {
		this.exceptMtIds = exceptMtIds;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getMtName() {
		return mtName;
	}

	public void setMtName(String mtName) {
		this.mtName = mtName;
	}

	@Override
	public String toString() {
		return "MtSfaObject{" +
				"pageNumber=" + pageNumber +
				", pageSize=" + pageSize +
				", un='" + un + '\'' +
				", exceptMtIds=" + exceptMtIds +
				", provinceId=" + provinceId +
				", typeId=" + typeId +
				", mtName='" + mtName + '\'' +
				'}';
	}
}
