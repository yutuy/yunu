package com.study.vo;

import java.util.Date;

public class BaseUserVo {

//	private BaseRoleMapper baseRoleMapper = SpringUtils.getBean(BaseRoleMapper.class);
//	private BaseUserMapper baseUserMapper= SpringUtils.getBean(BaseUserMapper.class);
	private Integer id;
	
	/** 登录名 */
	private String loginUserName;
	
	/** 登录密码 */
	private String loginUserPassword;
	
	/** 手机号 */
	private String mobile;
	
	/** 用户状态0：未激活；1：激活；2：离职；*/
	private Integer active;
	 private String activeStr;
	/** 真是姓名 */
	private String realName;
	
	/** 邮箱 */
	private String mail;
	
	
	/** 所属公司(字典关联项common.user.compny) */
	private Integer company;
	
	private String companyStr;

	/** 用户激活时间 */
	private Date activeTime;	
	
	/** 用户新增时间 */
	private Date createTime;
	
	/** 最后修改时间 */
	private Date updateTime;
	private Integer createUserId;
	private String createUserName;
    private Integer updateUserId;
	/** 开始工作时间 */
	private Date beginWorkDate;

	/** 结束工作时间 */
	private Date endWorkDate;
	
	/** 证件号码 */
	private String idCard;
	
	/**mac地址 */
	private String mac;
	
	private Integer level;

	/** SSR-人员类型（1：驻店服务代表；2：流动服务代表） */
	private Integer ssrType;
	
	/** SSR-人员类型中文 */
	private String ssrTypeStr;
	
	private String roleName;
	/**
	 * 是否绑定终端（绑定手机）
	 */
	private Integer isBind;

	private String isBindStr;

	private String ksfid;
	/**
     * 在职状态(关联字典项user.workstate)
     */
	private Integer workState;
	
	private String workStateStr;
	
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

    public String getKsfid() {
		return ksfid;
	}

	public void setKsfid(String ksfid) {
		this.ksfid = ksfid;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}
	
    public Integer getIsBind() {
        return isBind;
    }

    public void setIsBind(Integer isBind) {
        this.isBind = isBind;
    }

	public String getIsBindStr() {
		return isBindStr;
	}

	public void setIsBindStr(String isBindStr) {
		this.isBindStr = isBindStr;
	}
	
	public Integer getCompany() {
		return company;
	}

	public void setCompany(Integer company) {
		this.company = company;
	}
	public String getCompanyStr() {
		return companyStr;
	}

	public void setCompanyStr(String companyStr) {
		this.companyStr = companyStr;
	}
	public String getWorkStateStr() {
		return workStateStr;
	}

	public void setWorkStateStr(String workStateStr) {
		this.workStateStr = workStateStr;
	}

	public Integer getWorkState() {
		return workState;
	}

	public void setWorkState(Integer workState) {
		this.workState = workState;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	public String getLoginUserPassword() {
		return loginUserPassword;
	}

	public void setLoginUserPassword(String loginUserPassword) {
		this.loginUserPassword = loginUserPassword;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(Date activeTime) {
		this.activeTime = activeTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getBeginWorkDate() {
		return beginWorkDate;
	}

	public void setBeginWorkDate(Date beginWorkDate) {
		this.beginWorkDate = beginWorkDate;
	}

	public Date getEndWorkDate() {
		return endWorkDate;
	}

	public void setEndWorkDate(Date endWorkDate) {
		this.endWorkDate = endWorkDate;
	}

	public Integer getSsrType() {
		return ssrType;
	}

	public void setSsrType(Integer ssrType) {
		this.ssrType = ssrType;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getSsrTypeStr() {
		return ssrTypeStr;
	}

	public void setSsrTypeStr(String ssrTypeStr) {
		this.ssrTypeStr = ssrTypeStr;
	}
	

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
    public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}
	  public String getActiveStr() {
			return activeStr;
		}

		public void setActiveStr(String activeStr) {
			this.activeStr = activeStr;
		}
}
