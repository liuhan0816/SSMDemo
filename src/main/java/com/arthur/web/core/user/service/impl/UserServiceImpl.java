package com.arthur.web.core.user.service.impl;

import com.arthur.web.core.user.service.UserService;
import com.arthur.web.dao.entity.UdpUser;
import com.arthur.web.dao.entity.UdpUserExample;
import com.arthur.web.dao.mapper.UdpUserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description UserService实现类
 * @Author liuhan
 * @Date 2019/8/1 11:42
 * @Version 1.0
**/
@Service
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    public UdpUserMapper UdpUserMapper;

    @Override
    public boolean checkUser(String userCode,String pwd) {
        if(StringUtils.isEmpty(userCode) || StringUtils.isEmpty(pwd) ){
            return false;
        }
        UdpUserExample example = new UdpUserExample();
        UdpUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserCodeEqualTo(userCode);
       // pwd = DigestUtils.md5Hex(pwd);
        criteria.andUserPwdEqualTo(pwd);
        long num = UdpUserMapper.countByExample(example);
        if(num > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public UdpUser getUserByUserCode(String userCode){
        UdpUser UdpUser = new UdpUser();
        if(StringUtils.isEmpty(userCode)){
            return UdpUser;
        }

        UdpUserExample example = new UdpUserExample();
        UdpUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserCodeEqualTo(userCode);
        List<UdpUser> list = UdpUserMapper.selectByExample(example);
        if(list.size() > 0){
            UdpUser = list.get(0);
        }
        return UdpUser;
    }
}
