package com.guxingyuan.login.mapper;

import com.guxingyuan.login.entity.Clientinfo;
import com.guxingyuan.login.entity.ClientinfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClientinfoMapper {
    long countByExample(ClientinfoExample example);

    int deleteByExample(ClientinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Clientinfo record);

    int insertSelective(Clientinfo record);

    List<Clientinfo> selectByExample(ClientinfoExample example);

    Clientinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Clientinfo record, @Param(
            "example") ClientinfoExample example);

    int updateByExample(@Param("record") Clientinfo record,
                        @Param("example") ClientinfoExample example);

    int updateByPrimaryKeySelective(Clientinfo record);

    int updateByPrimaryKey(Clientinfo record);
}