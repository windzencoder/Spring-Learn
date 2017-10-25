package com.wz.spring.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {

	private ApplicationContext ctx = null;
	private BookShopDao bookShopDao;
	private BookShopService bookShopService;

	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShopDao = ctx.getBean(BookShopDao.class);
		bookShopService = ctx.getBean(BookShopService.class);
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
