package com.wz.spring.tx.xml;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wz.spring.tx.xml.service.BookShopService;
import com.wz.spring.tx.xml.service.Cashier;

public class SpringTransactionTest {

	private ApplicationContext ctx = null;
	private BookShopDao bookShopDao;
	private BookShopService bookShopService;
	private Cashier cashier;

	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShopDao = ctx.getBean(BookShopDao.class);
		bookShopService = ctx.getBean(BookShopService.class);
		cashier = ctx.getBean(Cashier.class);
	}
	
	@Test
	public void testTransactionlPropagation(){
		cashier.checkout("AA", Arrays.asList("1001", "1002"));
	}
	
	@Test
	public void testBookShopService(){
		bookShopService.purchase("AA", "1001");
	}
	
	
	@Test
	public void testUpdateUserAccount(){
		bookShopDao.updateUserAccount("AA", 200);
	}
	
	@Test
	public void testUpdateBookStock() {
		bookShopDao.updateBookStock("1001");
	}
	
	
	@Test
	public void testFindBookPriceByIsbn() {
		int price = bookShopDao.findBookPriceByIsbn("1001");
		System.out.println("price  = " + price);
	}
	
}
