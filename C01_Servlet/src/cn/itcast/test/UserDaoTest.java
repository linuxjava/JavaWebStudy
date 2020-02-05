package cn.itcast.test;

import cn.itcast.servlet.login.bean.User;
import cn.itcast.servlet.login.dao.impl.UserDao;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin(){
        UserDao userDao = new UserDao();
        User login = userDao.login("tencent", "123");
        System.out.println(login);
    }
}
