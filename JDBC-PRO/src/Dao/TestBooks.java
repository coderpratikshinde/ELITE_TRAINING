package Dao;

import pojo.Book;

public class TestBooks {

	public static void main(String[] args) {
		
		BookDaoJdbcImpl bc = new BookDaoJdbcImpl();
		
		
		for(Book b:bc.list()) {
		System.out.println(b);
		}
	}

}
