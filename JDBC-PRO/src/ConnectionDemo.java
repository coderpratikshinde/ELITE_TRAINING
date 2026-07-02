import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;

public class ConnectionDemo {

    public static void main(String[] args) throws SQLException {
    	
    	try {
    		/*String url = "jdbc:mysql://localhost:3306/elite";
            String username = "Pratik";
            String password = "PS9817";
            DriverManager.registerDriver(new Driver());
            Connection conn = DriverManager.getConnection(url, username, password);*/
    		
    		Connection conn = JdbcFactory.getConnection();
            System.out.println("Connection successful");
            
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println("DB Name: "+ meta.getDatabaseProductName());
            System.out.println("DB Version: "+ meta.getDatabaseProductVersion());
            System.out.println("Driver Name: "+ meta.getDriverName());
            System.out.println("Driver Version: "+ meta.getDriverVersion());
    		
    	} catch (SQLException e) {
    		System.out.println("Connection failed due to...");
    		e.printStackTrace();
    	}
    }
}