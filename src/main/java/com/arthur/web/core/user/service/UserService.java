package com.arthur.web.core.user.service;

import com.arthur.web.dao.entity.UdpUser;

/**
 * @ClassName UserService
 * @Description 用户查询类
 * @Author liuhan
 * @Date 2019/8/1 11:13
 * @Version 1.0
**/
public interface UserService {

    /**
     * @Author liuhan
     * @Description 通过账号密码验证用户
     * @Date 2019/8/1 11:13
     * @Param
     * @Return
     */
    boolean checkUser(String userCode, String pwd);

    /**
     * @Author liuhan
     * @Description 通过userCode获取用户
     * @Date 2019/8/1 11:13
     * @Param
     * @Return
     */
    UdpUser getUserByUserCode(String userCode);
}
