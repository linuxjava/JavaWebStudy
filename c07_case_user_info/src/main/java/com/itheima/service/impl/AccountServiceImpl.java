package com.itheima.service.impl;

import com.itheima.bean.PageInfo;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;

import java.util.List;
import java.util.Map;

public class AccountServiceImpl implements IAccountService{
    private AccountDaoImpl daoImpl;

    public AccountServiceImpl() {
        this.daoImpl = new AccountDaoImpl();
    }

    @Override
    public void delByIds(String[] ids) {
        for (String id : ids){
            daoImpl.delById(id);
        }
    }

    @Override
    public void findByPage(int pageIndex, int pageSize, String username, String address, String email, PageInfo pageInfo) {
        daoImpl.findByPage(pageIndex, pageSize, username, address, email, pageInfo);
    }

    @Override
    public Account findById(String id) {
        return daoImpl.findById(id);
    }

    @Override
    public void update(Account account) {
        daoImpl.update(account);
    }
}
