package com.arthur.web.core.user.bean;

public class LoginMsg {
	
	/**
	 * 用户登录状态:登陆不成功，原因未知
	 */
	public static final String LOGIN_STATUS_UNAUTHENTICATED = "登陆不成功，原因未知";
	/**
	 * 用户登录状态:登陆成功，用户身份已认证
	 */
	public static final String LOGIN_STATUS_AUTHENTICATED = "登陆成功，用户身份已认证";

	/**
	 * 用户登录状态:用户不存在
	 */
	//public static final String LOGIN_STATUS_USER_NOT_EXIST = "用户不存在";
	/**
	 * 用户登录状态:密码错误
	 */
	public static final String LOGIN_STATUS_WRONG_USER_OR_PASSWORD = "账号或密码错误";

	/**
	 * 用户登录状态:账号或密码为空
	 */
	public static final String LOGIN_STATUS_BLANK_ZONE = "账号或密码为空";

	/**
	 * 用户登录状态:所在单位待审核
	 */
	public static final String LOGIN_STATUS_ORG_UNAPPROVED = "所在单位待审核";

	/**
	 * 用户登录状态:所在单位待激活
	 */
	public static final String LOGIN_STATUS_ORG_UNACTIVED = "所在单位待激活";

	/**
	 * 用户登录状态:用户帐号待审核
	 */
	public static final String LOGIN_STATUS_ACCOUNT_UNAPPROVED = "用户帐号待审核";

	/**
	 * 用户登录状态:用户帐号待激活
	 */
	public static final String LOGIN_STATUS_ACCOUNT_UNACTIVED = "用户帐号待激活";

	/**
	 * 用户登录状态:验证码错误
	 */
	public static final String LOGIN_STATUS_CERTIFICATION_CODE_ERROR = "验证码错误";

	/**
	 * 用户登录状态:需要提供证书
	 */
	public static final String LOGIN_STATUS_NEED_CERTIFICATE = "需要提供证书";

	/**
	 * 用户登录状态:超出最大允许的错误次数
	 */
	public static final String LOGIN_STATUS_EXCEEDED_ERROR_NUM = "超出最大允许的错误次数";

	/**
	 * 用户登录状态:需要提供短信认证
	 */
	public static final String LOGIN_STATUS_NEED_SMS_VALIDATION = "需要提供短信认证";

	/**
	 * 短信验证成功
	 */
	public static final String LOGIN_STATUS_SMS_VALIDATE_PASSED = "短信验证成功";
	
	/**
	 * 用户登录状态: 短信验证码错误
	 */
	public static final String LOGIN_STATUS_SMS_VALIDATE_NUM_ERROR = "短信验证码错误";

	/**
	 * 用户登录状态: 短信验证码超时
	 */
	public static final String LOGIN_STATUS_SMS_VALIDATE_TIMEOUT = "短信验证码超时";

	/**
	 * 用户登录状态: 未登记手机号码
	 */
	public static final String LOGIN_STATUS_SMS_MOBILE_NOT_EXIST = "未登记手机号码";

	/**
	 * 用户登录状态: 卡号尚未绑定
	 */
	public static final String LOGIN_STATUS_CA_NUMBER_NOT_EXIST = "卡号尚未绑定";

	/**
	 * 未提供重定向的url
	 */
	public static final String LOGIN_STATUS_REDIRECTURL_NOT_EXIST = "未提供重定向的url";
	
	/**
	 * 没有访问的权限
	 */
	public static final String NO_PERMIT_ROLE = "没有访问的权限";
	
	/**
	 * 用户登录状态: 卡号读取失败
	 */
	public static final String LOGIN_STATUS_CA_NUMBER_NOT_AVAILABLE = "卡号读取失败";
	
	/**
	 * 短信验证码的sessionID
	 */
	public static final String SMS_VALIDATE_NUM_SESSION_ID = "SMS_VALIDATE_NUM";
	
	/**
	 * 短信验证码发送时间的sessionID
	 */
	public static final String SMS_VALIDATE_DATE_SESSION_ID = "SMS_VALIDATE_DATE";
	

	 

}
