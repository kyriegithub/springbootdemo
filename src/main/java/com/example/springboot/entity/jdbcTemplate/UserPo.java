package com.example.springboot.entity.jdbcTemplate;

import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * jdbcTemplate实体类
 *
 * @author caojianyi@dxy.cn
 * @date 7/9/21 12:52 AM
 * @Description
 */
@Data
public class UserPo implements RowMapper<UserPo> {
    private int id;
    private String username;
    private String password;

    @Override
    public UserPo mapRow(ResultSet resultSet, int i) throws SQLException {
        UserPo userPo = new UserPo();
        userPo.setId(resultSet.getInt("id"));
        userPo.setUsername(resultSet.getString("username"));
        userPo.setPassword(resultSet.getString("password"));
        return userPo;
    }
}
