package spring_mybatis.dao;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("Select t_user")
    String selectById(int id);
}
