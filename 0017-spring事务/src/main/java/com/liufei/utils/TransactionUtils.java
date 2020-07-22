//package com.liufei.utils;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Scope;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.TransactionStatus;
//import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
//
////@Component
////@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//public class TransactionUtils {
//
//	@Autowired
//	private DataSourceTransactionManager dataSourceTransactionManager;
//
//	// 开启事务
//	public TransactionStatus begin() {
//		TransactionStatus transaction = dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
//		return transaction;
//	}
//
//	// 提交事务
//	public void commit(TransactionStatus transactionStatus) {
//		dataSourceTransactionManager.commit(transactionStatus);
//	}
//
//	// 回滚事务
//	public void rollback(TransactionStatus transactionStatus) {
//		dataSourceTransactionManager.rollback(transactionStatus);
//	}
//}
