package com.liufei.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(String name) {
        String sql = "insert into test(name) values(?)";
        int update = jdbcTemplate.update(sql, name);
        System.out.println("insert result:" + update);
    }

    public void update(Integer id, String name) {
        String sql = "update test set name = ? where id = ?";
        int update = jdbcTemplate.update(sql, name, id);
        System.out.println("update result:" + update);
    }
}
