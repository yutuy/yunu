package com.study.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 城市信息表
 * @author Administrator
 *
 */
@TableName("t_sfa_city")
public class CityEntity extends Model<CityEntity>{

	private static final long serialVersionUID = 4770495902163816831L;

	/**
     * 主键ID
     */
	@TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 所属城市群ID（t_sfa_city_group）
     */
	@TableField("cg_id")
    private Integer cityGroupId;

    /**
     * 城市等级
     */
	@TableField("city_level")
    private Integer cityLevel;
    
	 /**
     * 数据修改时间
     */
	@TableField("update_time")
    private Date updateTime;

    /**
     * 数据修改人ID
     */
	@TableField("update_user_id")
    private Integer updateUserId;

    /**
     * 数据创建时间
     */
	@TableField("create_time")
    private Date createTime;

    /**
     * 数据创建人ID
     */
	@TableField("create_user_id")
    private Integer createUserId;

    /**
     * 数据状态(字典关联项：common.active)
     */
    private Integer active;

    /**
     * 主键ID
     * @return id 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 编码
     * @return code 编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 编码
     * @param code 编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 名称
     * @return name 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    /**
     * 数据修改时间
     * @return update_time 数据修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据修改时间
     * @param updateTime 数据修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 数据修改人ID
     * @return update_user_id 数据修改人ID
     */
    public Integer getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 数据修改人ID
     * @param updateUserId 数据修改人ID
     */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * 数据创建时间
     * @return create_time 数据创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 数据创建时间
     * @param createTime 数据创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 数据创建人ID
     * @return create_user_id 数据创建人ID
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 数据创建人ID
     * @param createUserId 数据创建人ID
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 数据状态(字典关联项：common.active)
     * @return active 数据状态(字典关联项：common.active)
     */
    public Integer getActive() {
        return active;
    }

    /**
     * 数据状态(字典关联项：common.active)
     * @param active 数据状态(字典关联项：common.active)
     */
    public void setActive(Integer active) {
        this.active = active;
    }

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getCityLevel() {
		return cityLevel;
	}

	public void setCityLevel(Integer cityLevel) {
		this.cityLevel = cityLevel;
	}

	public Integer getCityGroupId() {
		return cityGroupId;
	}

	public void setCityGroupId(Integer cityGroupId) {
		this.cityGroupId = cityGroupId;
	}
}