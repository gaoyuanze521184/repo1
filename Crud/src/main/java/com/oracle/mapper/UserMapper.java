package com.oracle.mapper;

import com.oracle.pojo.User;
import com.oracle.pojo.UserQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserMapper {
    int countByExample(UserQuery example);

    int deleteByExample(UserQuery example);

    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExampleWithRowbounds(UserQuery example, RowBounds rowBounds);

    List<User> selectByExample(UserQuery example);

    User selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserQuery example);

    int updateByExample(@Param("record") User record, @Param("example") UserQuery example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}