package com.wz.spring.tx.xml.service.impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wz.spring.tx.xml.BookShopDao;
import com.wz.spring.tx.xml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService {

	private BookShopDao bookShopDao;
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void purchase(String username, String isbn) {
		//1.获取书的单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		//2.更新书的数据库
		bookShopDao.updateBookStock(isbn);
		//3.更新用户余额
		bookShopDao.updateUserAccount(username, price);;
		
	}

}
