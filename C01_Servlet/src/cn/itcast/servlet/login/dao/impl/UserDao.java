package cn.itcast.servlet.login.dao.impl;

import cn.itcast.servlet.login.bean.User;
import cn.itcast.servlet.login.dao.IUserDao;
import cn.itcast.servlet.login.util.JdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDao implements IUserDao{

    @Override
    public User login(String name, String pwd) {
        JdbcTemplate jdbcTemplate = JdbcUtil.createJdbcTemplate();
        String sql = "select * from user where name = ? AND password = ?";
        List<User> userList = jdbcTemplate.query(sql, new Object[]{name, pwd}, new BeanPropertyRowMapper<>(User.class));
        if(userList.size() == 1){
            return userList.get(0);
        }

        return null;
    }
}
