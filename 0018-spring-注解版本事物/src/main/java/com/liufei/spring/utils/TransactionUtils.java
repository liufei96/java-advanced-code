package com.liufei.spring.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TransactionUtils {

	@Autowired
	private DataSourceTransactionManager dataSourceTransactionManager;

	// 全局接收事务状态，可能会有线程安全问题。所以讲此类定义为多例
	private TransactionStatus transaction;

	// 开启事务
	public TransactionStatus begin() {
		System.out.println("开启事物");
		transaction = dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
		return transaction;
	}

	// 提交事务
	public void commit(TransactionStatus transactionStatus) {
		System.out.println("提交事物");
		dataSourceTransactionManager.commit(transactionStatus);
	}

	// 回滚事务
	public void rollback() {
		if (transaction != null) {
			dataSourceTransactionManager.rollback(transaction);
			System.out.println("回滚事务");
		}
	}
}
