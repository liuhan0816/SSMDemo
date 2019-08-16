package com.arthur.web.dao.entity;

import java.util.Date;
import lombok.Data;

/**
 * udp_user
 * @author Administrator
 * @date 2019-08-01 11:40:01
 */
@Data
public class UdpUser {
    /**
     * 主键
     */
    private String id;

    /**
     * 用户代码
     */
    private String userCode;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 权限00无权限20管理员
     */
    private String userType;

    /**
     * 创作时间
     */
    private Date createdTime;

    /**
     * 创建人id
     */
    private String creatorId;

    /**
     * 创建人名称
     */
    private String creatorName;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 修改人id
     */
    private String modifierId;

    /**
     * 修改人名称
     */
    private String modifierName;

    /**
     * 性别-1未知0女1男
     */
    private String gender;

    /**
     * 证件类型@1:身份证;2:护照;3:军官证（未使用）
     */
    private String cerType;

    /**
     * 证件号码
     */
    private String cerNo;

    /**
     * 电话号码
     */
    private String telNo;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 电子邮箱
     */
    private String mail;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 传真
     */
    private String fax;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 活动状态0:禁用;1:启用
     */
    private String isActive;

    /**
     * 状态@0:删除;1:正常
     */
    private String status;

    /**
     * 登录失败次数
     */
    private String loginFail;

    /**
     * 登录锁定时间
     */
    private Date lockLoginDate;

    /**
     * 密码找回token
     */
    private String token;
}