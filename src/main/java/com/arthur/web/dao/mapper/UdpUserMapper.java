package com.arthur.web.dao.mapper;

import com.arthur.web.dao.entity.UdpUser;
import com.arthur.web.dao.entity.UdpUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface UdpUserMapper {
    long countByExample(UdpUserExample example);

    int deleteByExample(UdpUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(UdpUser record);

    int insertSelective(UdpUser record);

    List<UdpUser> selectByExample(UdpUserExample example);

    UdpUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UdpUser record, @Param("example") UdpUserExample example);

    int updateByExample(@Param("record") UdpUser record, @Param("example") UdpUserExample example);

    int updateByPrimaryKeySelective(UdpUser record);

    int updateByPrimaryKey(UdpUser record);
}