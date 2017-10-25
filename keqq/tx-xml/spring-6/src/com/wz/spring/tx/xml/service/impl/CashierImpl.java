package com.wz.spring.tx.xml.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wz.spring.tx.xml.service.BookShopService;
import com.wz.spring.tx.xml.service.Cashier;

public class CashierImpl implements Cashier {

	
	private BookShopService bookShopService;
	
	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}
	
	
	//一个事务方法调用另一个事务方法
	@Transactional
	@Override
	public void checkout(String username, List<String> isbns) {

		for (String isbn : isbns) {
			bookShopService.purchase(username, isbn);//这是个事务方法
		}
		
	}

}
