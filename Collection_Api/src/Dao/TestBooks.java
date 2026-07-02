package Dao;

import pojo.Book;

public class TestBooks {

	public static void main(String[] args) {
		
		BookDaoCollectionImpl bc = new BookDaoCollectionImpl();
		
		Book b1 = new Book(1,"Gunaho Ka Devta","Dharmveer Bharti",350);
		Book b2 = new Book(2,"Godan","Premchand",550);
		Book b3 = new Book(5,"Kosala","Bhalchandra Nemade",350);
		Book b4 = new Book(10,"Gunaho Ka Devta","Dharmveer Bharti",350);
		
	}

}
