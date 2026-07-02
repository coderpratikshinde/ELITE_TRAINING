package Service;

import java.util.List;
import java.util.Optional;

import pojo.Book;

public interface BookService {
	
	boolean save(Book b);
	
	Optional<Book> find(int isbn) throws BookNotFoundException;
	
	List<Book> list();
	
	boolean delete(int isbn) throws BookNotFoundException;
	
	List<Book> findByPrice(double min,double max);
	
	List<Book> listOrderByTitle();
}
