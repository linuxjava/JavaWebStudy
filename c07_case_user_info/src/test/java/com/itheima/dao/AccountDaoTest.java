package com.itheima.dao;

import com.itheima.dao.impl.AccountDaoImpl;
import org.junit.Test;

public class AccountDaoTest {
    @Test
    public void findAll(){
        AccountDaoImpl accountDao = new AccountDaoImpl();
        System.out.println(accountDao.findAll());
    }

    @Test
    public void login(){
        AccountDaoImpl accountDao = new AccountDaoImpl();
        System.out.println(accountDao.login("zhangsan", "123"));
    }

    @Test
    public void findByPage(){
        AccountDaoImpl accountDao = new AccountDaoImpl();
        System.out.println(accountDao.findByPage(1, 3));
        System.out.println(accountDao.findByPage(2, 3));
    }

    @Test
    public void getTotalPage(){
        AccountDaoImpl accountDao = new AccountDaoImpl();
        System.out.println(accountDao.getTotalPage());
    }
}
