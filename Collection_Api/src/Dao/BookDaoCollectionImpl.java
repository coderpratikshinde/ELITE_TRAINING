package Dao;

import java.util.List;
import java.util.Vector;

import pojo.Book;

public class BookDaoCollectionImpl implements BookDao{

	private List<Book> books;
	
	
	
	public BookDaoCollectionImpl() {
		super();
		books = new Vector<Book>();
	}

	@Override
	public boolean save(Book b) {
		books.add(b);
		return true;
	}

	@Override
	public Book find(int isbn) {
		for(Book b:books) {
			if(b.getIsbn()==isbn) {
				return b;
			}
		}
		return null;
	}

	@Override
	public List<Book> list() { 
		return books;
	}

	@Override
	public List<Book> findByPrice(double min, double max) {
		// TODO Auto-generated method stub
		List<Book> FoundBooks = new Vector<Book>();
		for(Book b:books) {
			if(b.getPrice()>=min && b.getPrice()<=max) {
				FoundBooks.add(b);
			}
		}
		return FoundBooks;
	}

	@Override
	public boolean delete(int isbn) {
		for(Book b:books) {
			if(b.getIsbn()==isbn) {
				books.remove(b);
				return true;
			}
		}
		return false;
	}
	
	
	
}
