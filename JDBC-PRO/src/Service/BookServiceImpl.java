package Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import Dao.BookDao;
import pojo.Book;

public class BookServiceImpl implements BookService {

	private BookDao dao;
	
	
	public BookServiceImpl(BookDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean save(Book b) {
		return dao.save(b);
	}

	@Override
	public Optional<Book> find(int isbn) {
		/*Book b =dao.find(isbn);
		if(b==null) {
			throw new BookNotFoundException("Book not found with ISBN: "+isbn);
		}*/
		return list().stream().filter(b -> b.getIsbn()==isbn).findFirst();
	}

	@Override
	public List<Book> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public boolean delete(int isbn) throws BookNotFoundException {
		// TODO Auto-generated method stub
		/*if(dao.delete(isbn)) {
			return true;
		}
		else {
			throw new BookNotFoundException("Book not found with ISBN: "+isbn);
		}*/
		
		return list().removeIf(b->b.getIsbn()==isbn);
	}

	@Override
	public List<Book> findByPrice(double min, double max) {
		// TODO Auto-generated method stub
		return dao.findByPrice(min, max);
	}

	@Override
	public List<Book> listOrderByTitle() {
		List<Book> books = this.list();
		books.sort(Comparator.comparing(Book::getTitle));
		return books;
	}
	
	
}
