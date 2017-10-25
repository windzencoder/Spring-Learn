package com.wz.spring.tx.xml;

public interface BookShopDao {

	//根据书号获取单价
	public int findBookPriceByIsbn(String isbn);
	
	//更新书的库存，即使书号对应的库存减去1
	public void updateBookStock(String isbn);
	
	//更新用户的账户余额，是username的balance - price （这里一次只买一本书）
	public void updateUserAccount(String username, int price);
}
