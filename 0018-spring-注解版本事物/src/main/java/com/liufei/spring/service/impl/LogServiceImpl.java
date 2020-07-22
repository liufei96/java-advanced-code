package com.liufei.spring.service.impl;

import com.liufei.spring.dao.LogDao;
import com.liufei.spring.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Auther: liufei
 * @Date: 2020/07/23/12:00 上午
 * @Description:
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addLog() {
        logDao.addLog("addLog" + System.currentTimeMillis());
    }
}
