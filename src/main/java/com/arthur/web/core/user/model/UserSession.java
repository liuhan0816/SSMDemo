package com.arthur.web.core.user.model;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;


/**
    * Description ：用户会话信息
    * Author ：   liuhan
    * CreateTime：2019/7/25 16:45
 */

public class UserSession implements Serializable {

	private String id;
	//用户代码
	private String userCode;
	//用户名称
	private String userName;
	//用户密码
	private String userPwd;
	//组名称
	private String groupName;
	//创建时间
	private Date createTime;
	//创建人
	private String createId;
	//更新时间
	private Date updateTime;
	//更新人
	private String updateId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode == null ? null : userCode.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd == null ? null : userPwd.trim();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName == null ? null : groupName.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId == null ? null : createId.trim();
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId == null ? null : updateId.trim();
	}

	/**
	 * 直接转化成jsonString
	 * @return
	 */
	public String build() {
		return JSONObject.toJSONString(this);
	}
}
