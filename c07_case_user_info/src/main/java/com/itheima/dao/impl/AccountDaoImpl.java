package com.itheima.dao.impl;

import com.alibaba.druid.util.StringUtils;
import com.itheima.bean.PageInfo;
import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.util.JdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements IAccountDao {
    private JdbcTemplate template;

    public AccountDaoImpl() {
        template = JdbcUtil.createJdbcTemplate();
    }

    @Override
    public List<Account> findAll() {
        String sql = "select * from " + TABLE_ACCOUNT;

        List<Account> accounts = template.query(sql, new BeanPropertyRowMapper<>(Account.class));

        return accounts;
    }

    @Override
    public Account login(String username, String password) {
        String sql = "select * from " + TABLE_ACCOUNT + " where username = ? and password = ?";
        List<Account> accounts = template.query(sql, new BeanPropertyRowMapper<>(Account.class), username, password);
        if (accounts.size() == 1) {
            return accounts.get(0);
        }

        return null;
    }

    @Override
    public void add(Account account) {
        String sql = "insert into " + TABLE_ACCOUNT + " values(NULL, ?, ?, ?, ?, ?, ?, ?)";
        int id = template.update(sql, account.getUsername(), "123", account.getAge(), account.getGender(), account.getAddress(), account.getQq(), account.getEmail());
    }

    @Override
    public void update(Account account) {
        String sql = "update " + TABLE_ACCOUNT + " set age = ?, gender = ?, address = ?, qq = ?, email = ? where id = ?";
        int id = template.update(sql, account.getAge(), account.getGender(), account.getAddress(), account.getQq(), account.getEmail(), account.getId());
    }

    @Override
    public void delById(String id) {
        String sql = "delete from " + TABLE_ACCOUNT + " where id = ?";
        template.update(sql, id);
    }

    @Override
    public void findByPage(int pageIndex, int pageSize, String username, String address, String email, PageInfo pageInfo) {
        StringBuilder builder1 = new StringBuilder();
        builder1.append("select * from ")
                .append(TABLE_ACCOUNT)
                .append(" where 1=1");

        StringBuilder builder2 = new StringBuilder();
        builder2.append("select count(id) from ")
                .append(TABLE_ACCOUNT)
                .append(" where 1=1");

        List<Object> params = new ArrayList<>();

        if (!StringUtils.isEmpty(username)) {
            builder1.append(" and username like ?");
            builder2.append(" and username like ?");
            params.add("%" + username + "%");
        }
        if (!StringUtils.isEmpty(address)) {
            builder1.append(" and address like ?");
            builder2.append(" and address like ?");
            params.add("%" + address + "%");
        }
        if (!StringUtils.isEmpty(email)) {
            builder1.append(" and email like ?");
            builder2.append(" and email like ?");
            params.add("%" + email + "%");
        }

        //查询有多少条数据
        long size = 0;
        if(params.size() > 0) {
            size = template.queryForObject(builder2.toString(), Long.class, params.toArray());
        }else {
            size = template.queryForObject(builder2.toString(), Long.class);
        }
        //计算有多少页
        long remainder = size % pageSize;
        long pages = remainder == 0 ?  size / pageSize : (size / pageSize + 1);

        //获取分页数据
        builder1.append(" order by id desc limit ?, ?");
        params.add((pageIndex - 1) * pageSize);
        params.add(pageSize);
        List<Account> accounts = template.query(builder1.toString(), new BeanPropertyRowMapper<>(Account.class), params.toArray());

        pageInfo.setSize(size);
        pageInfo.setTotalPage(pages);
        pageInfo.setAccounts(accounts);
    }

    @Override
    public Account findById(String id) {
        if(!StringUtils.isEmpty(id)) {
            String sql = "select * from " + TABLE_ACCOUNT + " where id = ?";
            List<Account> accounts = template.query(sql, new BeanPropertyRowMapper<>(Account.class), id);
            if (accounts.size() > 0) {
                return accounts.get(0);
            }
        }
        return null;
    }
}



























