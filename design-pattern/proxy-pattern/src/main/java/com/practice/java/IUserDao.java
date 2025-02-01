package com.practice.java;

import com.practice.java.agent.Select;

public interface IUserDao {
    @Select("select userName from user where id = #{userId}")
    String queryUserInfo(String userId);
}
