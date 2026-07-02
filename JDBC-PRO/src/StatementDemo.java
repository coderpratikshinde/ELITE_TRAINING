import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDemo {

    public static void main(String[] args) {

        String sql = "insert into cust values (12,'Polo','Pune')";

        try {

            Connection conn = JdbcFactory.getConnection();

            Statement stmt = conn.createStatement();

            stmt.executeUpdate(sql);

            System.out.println("Record inserted");

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}