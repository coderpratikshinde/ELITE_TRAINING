
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public final class JdbcFactory {
	
	private JdbcFactory() {
	}
	public static Connection getConnection() throws SQLException {
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("src/mysql.info"));
			
			String url = prop.getProperty("url");
			String username = prop.getProperty("user");;
			String password = prop.getProperty("pass");;
			DriverManager.registerDriver(new Driver());
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new SQLException(e.getMessage());
		} 
	}
}
