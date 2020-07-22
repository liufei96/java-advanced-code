package com.liufei.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(String name) {
        String sql = "insert into test(name) values(?)";
        int update = jdbcTemplate.update(sql, name);
        System.out.println("insert result:" + update);
    }
}
