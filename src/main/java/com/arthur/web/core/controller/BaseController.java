package com.arthur.web.core.controller;


import com.arthur.web.core.user.model.UserSession;
import com.arthur.web.core.user.service.UserTokenService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * controller 层公共资源
 */
public class BaseController {
	private final static Logger logger = LoggerFactory.getLogger(BaseController.class);
	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected HttpServletResponse response;

	/**
	 * 获取登录用户userSession
	 *
	 * @return
	 */
	protected UserSession getUserSession() {
		UserSession userSession = null;
		try {
			UserTokenService userTokenService = new UserTokenService(request, response);
			userSession = userTokenService.getUserSession();
			// 查看用户是否存在
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
		return userSession;
	}

 
	/**
	 * 带参重定向
	 *
	 * @param path
	 * @return
	 */
	protected String redirect(String path) {
		return "redirect:" + path;
	}

	/**
	 * 不带参重定向
	 *
	 * @param response
	 * @param path
	 * @return
	 */
	protected String redirect(HttpServletResponse response, String path) {
		try {
			response.sendRedirect(path);
		} catch (IOException e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
		return null;
	}

    protected void setResultData(Object obj) throws IOException {
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        pw.print(JSON.toJSONString(obj));
        pw.flush();
        pw.close();
    }
}
