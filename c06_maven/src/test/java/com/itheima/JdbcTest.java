package com.itheima;

import com.itheima.domain.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTest {
    @Test
    public void testEmp(){
        JdbcTemplate jdbcTemplate = JdbcUtil.createJdbcTemplate();
        String sql = "select * from emp";
        List<Emp> empList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(empList);
    }
}
