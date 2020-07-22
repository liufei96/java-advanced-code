package com.liufei.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Auther: liufei
 * @Date: 2020/07/22/11:58 下午
 * @Description:
 */
@Repository
public class LogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addLog(String name) {
        String sql = "insert log(name) values(?)";
        int update = jdbcTemplate.update(sql, name);
        System.out.println("insert log result:" + update);
    }
}
