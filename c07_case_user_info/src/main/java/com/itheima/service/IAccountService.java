package com.itheima.service;

import com.itheima.bean.PageInfo;
import com.itheima.domain.Account;

import java.util.List;
import java.util.Map;

public interface IAccountService {
    void delByIds(String[] ids);

    void findByPage(int pageIndex, int pageSize, String username, String address, String email, PageInfo pageInfo);

    Account findById(String id);

    void update(Account account);
}
