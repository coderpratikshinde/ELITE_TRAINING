import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.BookDao;
import pojo.Book;

public class BookDaoJdbcImpl implements BookDao{

	@Override
	public boolean save(Book b) {
		String sql = "insert into books values (?, ?, ?, ?)";
		
		try {
			Connection conn = JdbcFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, b.getIsbn());
			stmt.setString(2, b.getTitle());
			stmt.setString(3, b.getAuthor());
			stmt.setDouble(4, b.getPrice());
			
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Book find(int isbn) {
		String sql = "select * from books where isbn="+isbn;
		Book b;
		try {
			Connection conn = JdbcFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			b = null;
			if(rs.next()) {
				b = new Book();
				b.setIsbn(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getDouble(4));
			}
		} catch (SQLException e) {
			b=null;
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public List<Book> list() {
		String sql = "select * from books";
		List<Book> books = new ArrayList<Book>();
		try {
			Connection conn = JdbcFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			Book b;
			while(rs.next()) {
				b=new Book();
				b.setIsbn(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getDouble(4));
				books.add(b);
			}
		} catch (SQLException e) {
			books=null;
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public boolean delete(int isbn) {
		String sql = "delete from books where isbn="+isbn;
		try {
			Connection conn = JdbcFactory.getConnection();
			int rowsAffected = conn.createStatement().executeUpdate(sql);
			return rowsAffected>0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Book> findByPrice(double min, double max) {
		String sql = "select * from books where price between ? and ?";
		List<Book> books = new ArrayList<Book>();
		try {
			Connection conn = JdbcFactory.getConnection();
			PreparedStatement  ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, min);
			ps.setDouble(2, max);
			
			ResultSet rs = ps.executeQuery();
			Book b;
			while(rs.next()) {
				b=new Book();
				b.setIsbn(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getDouble(4));
				books.add(b);
			}
		} catch (SQLException e) {
			books=null;
			e.printStackTrace();
		}
		return books;
	}

}
