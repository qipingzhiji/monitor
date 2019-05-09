package com.holk.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("select * from comm where id=#{id} and store=#{store}")
    public List<Map> queryUser(@Param("id")String id, @Param("store") String store);

    @Select("select * from comm where id = #{id}")
    public List<Map> queryUserById(@Param("id") String id);

}
