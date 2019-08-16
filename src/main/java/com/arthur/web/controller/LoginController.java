package com.arthur.web.controller;

import com.arthur.web.core.controller.BaseController;
import com.arthur.web.core.user.bean.LoginMsg;
import com.arthur.web.core.user.service.UserService;
import com.arthur.web.core.user.service.UserTokenService;
import com.arthur.web.core.util.RandomValidateCodeUtil;
import com.baomidou.kisso.SSOHelper;
import com.baomidou.kisso.security.token.SSOToken;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @ClassName LoginController
 * @Description 登陆模块
 * @Author liuhan
 * @Date 2019/8/1 11:11
 * @Version 1.0
 **/
@Controller
public class LoginController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    protected String loginMsg = "";
    protected String systemname = "ssmdemo";

    @Resource
    private UserService userServiceImpl;

    @RequestMapping(value = "/login")
    public String index(Model model, String userCode, String userPassword, String certificationCode) {
        loginMsg = "";
        // 普通登录
        UserTokenService userTokenService = new UserTokenService(request, response);

        if (userTokenService.validateToken()) {
            return "redirect:/member/index";
        }

        if (StringUtils.isNotEmpty(userCode) && StringUtils.isNotEmpty(userPassword) && StringUtils.isNotEmpty(certificationCode)) {
            // 如果 账号 或 密码 为空
            if (StringUtils.isEmpty(userCode) || StringUtils.isEmpty(userPassword)) {
                loginMsg = LoginMsg.LOGIN_STATUS_BLANK_ZONE;
            }
            if (!RandomValidateCodeUtil.checkVerify(certificationCode, request.getSession())) {
                // 验证码是否正确判断
                loginMsg = LoginMsg.LOGIN_STATUS_CERTIFICATION_CODE_ERROR;
            } else {
                if(userServiceImpl.checkUser(userCode,userPassword)) {
                    loginMsg = LoginMsg.LOGIN_STATUS_AUTHENTICATED;
                }else {
                    loginMsg = LoginMsg.LOGIN_STATUS_WRONG_USER_OR_PASSWORD;
                }

                if (loginMsg.equals(LoginMsg.LOGIN_STATUS_AUTHENTICATED)) {
                    // 设置登录 COOKIE
                    SSOHelper.setCookie(request, response, SSOToken.create().setIp(request).setId(userCode).setIssuer(systemname), false);

                    return "redirect:/member/index";
                }
            }
        }

        model.addAttribute("loginMsg", loginMsg);
        return "login";
    }

    /**
     * 退出
     */
    @RequestMapping(value = "/logout")
    public String logout() {
        SSOHelper.clearLogin(request, response);
        return "redirect:/login";
    }

    // 查看登录信息
    @ResponseBody
    @RequestMapping("/token")
    public String token() {
        String msg = "暂未登录";
        SSOToken ssoToken = SSOHelper.attrToken(request);
        if (null != ssoToken) {
            msg = "登录信息 ip=" + ssoToken.getIp();
            msg += "， id=" + ssoToken.getId();
            msg += "， issuer=" + ssoToken.getIssuer();
        }
        return msg;
    }

    /**
     * 生成验证码
     */
    @RequestMapping(value = "/imageCheck")
    @ResponseBody
    public void getVerify() {
        try {
            response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);// 输出验证码图片方法
        } catch (Exception e) {
            logger.error("获取验证码失败>>>>   ", e);
        }
    }
}
