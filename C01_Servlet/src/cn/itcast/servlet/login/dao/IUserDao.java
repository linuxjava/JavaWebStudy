package cn.itcast.servlet.login.dao;

import cn.itcast.servlet.login.bean.User;

public interface IUserDao {
    User login(String name, String pwd);
}
