package com.arthur.web.core.user.service;

import com.arthur.web.core.user.model.UserSession;
import com.arthur.web.core.user.service.impl.UserServiceImpl;
import com.arthur.web.core.util.SpringBeanUtil;
import com.arthur.web.dao.entity.UdpUser;
import com.baomidou.kisso.SSOHelper;
import com.baomidou.kisso.security.token.SSOToken;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName UserTokenService
 * @Description 获取Usersession
 * @Author liuhan
 * @Date 2019/8/1 11:12
 * @Version 1.0
**/
public class UserTokenService {
	String sessionname="lhsession";
	private HttpServletRequest request;
	private HttpServletResponse response;

	private UserService userService = SpringBeanUtil.getApplicationContext().getBean(UserServiceImpl.class);

	public UserTokenService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public UserSession getUserSession() {
		UserSession rtn = new UserSession();
		SSOToken ssoToken = SSOHelper.attrToken(request);
		String userid = ssoToken.getId();
		
		Object sessionobj = request.getSession().getAttribute(sessionname);
		
		//usersession为空获取usersession并插入到session中
		if(sessionobj==null) {
			rtn = setSession(userid);
		}else {
			rtn = (UserSession) sessionobj;
			String suserid= rtn.getUserCode();
			//userid为空获取usersession并插入到session中
			if(StringUtils.isEmpty(suserid)) {
				rtn = setSession(userid);
			}else {
				//userid不相同，则根据token中的userid重新获取usersession后设置到session中
				if(!userid.equals(suserid)) {
					rtn = setSession(userid);
				}
			}
		}
		return rtn;
	}

	  
	private UserSession setSession(String userid) {
		UserSession rtn = new UserSession();
		rtn = getUserSessionByUserCode(userid);
		request.getSession().removeAttribute(sessionname);
		request.getSession().setAttribute(sessionname,rtn);
		System.out.println("登录session："+rtn.build());
		return rtn;
	}

	/**
	* 方法描述： 将用户表数据填入session(这里根据每个项目不同进行补充)
	* 创建人：  
	* 创建时间：2019年6月27日 下午1:32:35   
	* 服务项目：   
	* 服务类:
	*/
	private UserSession getUserSessionByUserCode(String userCode) {
		UserSession rtn = new UserSession();
		//测试，根据需要进行改造，从数据库或者从接口获取
		UdpUser UdpUser = userService.getUserByUserCode(userCode);
		rtn.setUserCode(UdpUser.getUserCode());
		rtn.setUserName(UdpUser.getUserName());
		rtn.setId(UdpUser.getId());
		return rtn;
	}

	  
	/**
	* 方法描述： 判断是否登录过
	* 创建人：  
	* 创建时间：2019年6月27日 下午1:49:24   
	* 服务项目：   
	* 服务类:
	*/
	public boolean validateToken() {
		boolean result =false;
		SSOToken ssoToken = SSOHelper.attrToken(request);
		if(ssoToken!=null&& StringUtils.isNotEmpty(ssoToken.getId())) {
			result = true;
		}
		return result;
	}

}
