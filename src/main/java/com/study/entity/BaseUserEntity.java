package com.study.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 用户信息表
 * @author Administrator
 *
 */
@TableName("t_sfa_user")
public class BaseUserEntity extends Model<BaseUserEntity> {

	private static final long serialVersionUID = 5064705231645822993L;
	
	/**
	 * shiro管理的sessionId
	 */
	@TableField(exist = false)
	private String sessionId;

	/**
     * 主键ID
     */
	@TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 账号
     */
	@TableField("login_user_name")
    private String loginUserName;

    /**
     * 密码
     */
	@TableField("login_user_password")
    private String loginUserPassword;

    /**
     * 真实姓名
     */
	@TableField("real_name")
    private String realName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 所属公司（字典关联项：common.user.compny）
     */
    private Integer company;

    /**
     * 是否绑定终端（绑定手机）
     */
	@TableField("is_bind")
    private Integer isBind;

    /**
     * 激活时间（绑定手机）
     */
	@TableField("active_time")
    private Date activeTime;

    /**
     * 入职日期
     */
	@TableField("begin_workdate")
    private Date beginWorkDate;

    /**
     * 离职日期
     */
	@TableField("end_workdate")
    private Date endWorkDate;

    /**
     * 身份证号（证件号码）
     */
	@TableField("idCard")
    private String idCard;

    /**
     * mac地址（绑定手机）
     */
    private String mac;

    /**
     * SSR-人员类型（1：驻店服务代表；2：流动服务代表;）
     */
	@TableField("ssr_type")
    private Integer ssrType;
	
	/**
     * 角色id
     */
	@TableField(exist = false)
	private Integer roleId;
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
     * 在职状态(关联字典项user.work_state)
     */
	@TableField("work_state")
	private Integer workState;

    /**
     * 忠实会员招募所用的二维码ID，如可对接巢妈团会员数据可将此项信息匹配过来
     */
    private String ksfid;

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

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
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
     * 账号
     * @return login_user_name 账号
     */
    public String getLoginUserName() {
        return loginUserName;
    }

    /**
     * 账号
     * @param loginUserName 账号
     */
    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName == null ? null : loginUserName.trim();
    }

    /**
     * 密码
     * @return login_user_password 密码
     */
    public String getLoginUserPassword() {
        return loginUserPassword;
    }

    /**
     * 密码
     * @param loginUserPassword 密码
     */
    public void setLoginUserPassword(String loginUserPassword) {
        this.loginUserPassword = loginUserPassword == null ? null : loginUserPassword.trim();
    }

    /**
     * 真实姓名
     * @return real_name 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 真实姓名
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 手机号
     * @return mobile 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 邮箱
     * @return mail 邮箱
     */
    public String getMail() {
        return mail;
    }

    /**
     * 邮箱
     * @param mail 邮箱
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    /**
     * 所属公司（字典关联项：common.user.compny）
     * @return company 所属公司（字典关联项：common.user.compny）
     */
    public Integer getCompany() {
        return company;
    }

    /**
     * 所属公司（字典关联项：common.user.compny）
     * @param company 所属公司（字典关联项：common.user.compny）
     */
    public void setCompany(Integer company) {
        this.company = company;
    }

    /**
     * 是否绑定终端（绑定手机）
     * @return isBind 是否绑定终端（绑定手机）
     */
    public Integer getIsBind() {
        return isBind;
    }

    /**
     * 是否绑定终端（绑定手机）
     * @param IsBind 是否绑定终端（绑定手机）
     */
    public void setIsBind(Integer isBind) {
        this.isBind = isBind;
    }

    /**
     * 激活时间（绑定手机）
     * @return active_time 激活时间（绑定手机）
     */
    public Date getActiveTime() {
        return activeTime;
    }

    /**
     * 激活时间（绑定手机）
     * @param activeTime 激活时间（绑定手机）
     */
    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    /**
     * 入职日期
     * @return beginWorkDate 入职日期
     */
    public Date getBeginWorkDate() {
        return beginWorkDate;
    }

    /**
     * 入职日期
     * @param beginWorkDate 入职日期
     */
    public void setBeginWorkDate(Date beginWorkDate) {
        this.beginWorkDate = beginWorkDate;
    }

    /**
     * 离职日期
     * @return endWorkDate 离职日期
     */
    public Date getEndWorkDate() {
        return endWorkDate;
    }

    /**
     * 离职日期
     * @param endworkdate 离职日期
     */
    public void setEndWorkDate(Date endWorkDate) {
        this.endWorkDate = endWorkDate;
    }

    /**
     * 身份证号（证件号码）
     * @return idCard 身份证号（证件号码）
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 身份证号（证件号码）
     * @param idcard 身份证号（证件号码）
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * mac地址（绑定手机）
     * @return mac mac地址（绑定手机）
     */
    public String getMac() {
        return mac;
    }

    /**
     * mac地址（绑定手机）
     * @param mac mac地址（绑定手机）
     */
    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    /**
     * SSR-人员类型（1：驻店服务代表；2：流动服务代表;3.BBS）
     * @return ssr_type SSR-人员类型（1：驻店服务代表；2：流动服务代表;3.BBS）
     */
    public Integer getSsrType() {
        return ssrType;
    }

    /**
     * SSR-人员类型（1：驻店服务代表；2：流动服务代表;3.BBS）
     * @param ssrType SSR-人员类型（1：驻店服务代表；2：流动服务代表;3.BBS）
     */
    public void setSsrType(Integer ssrType) {
        this.ssrType = ssrType;
    }

    /**
     * 忠实会员招募所用的二维码ID，如可对接巢妈团会员数据可将此项信息匹配过来
     * @return ksfid 忠实会员招募所用的二维码ID，如可对接巢妈团会员数据可将此项信息匹配过来
     */
    public String getKsfid() {
        return ksfid;
    }

    /**
     * 忠实会员招募所用的二维码ID，如可对接巢妈团会员数据可将此项信息匹配过来
     * @param ksfid 忠实会员招募所用的二维码ID，如可对接巢妈团会员数据可将此项信息匹配过来
     */
    public void setKsfid(String ksfid) {
        this.ksfid = ksfid == null ? null : ksfid.trim();
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

	public Integer getWorkState() {
		return workState;
	}

	public void setWorkState(Integer workState) {
		this.workState = workState;
	}
}