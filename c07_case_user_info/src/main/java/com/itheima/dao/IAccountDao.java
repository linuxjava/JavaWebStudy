package com.itheima.dao;

import com.itheima.bean.PageInfo;
import com.itheima.domain.Account;

import java.util.List;
import java.util.Map;

public interface IAccountDao {
    String TABLE_ACCOUNT = "account";

    List<Account> findAll();

    Account login(String username, String password);

    void add(Account account);

    void update(Account account);

    void delById(String id);

    void findByPage(int pageIndex, int pageSize, String username, String address, String email, PageInfo pageInfo);

    Account findById(String id);
}
