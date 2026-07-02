import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallableDemo {

    public static void main(String[] args) {

        try {
            Connection conn = JdbcFactory.getConnection();

            CallableStatement stmt =
                    conn.prepareCall("{? = call get_name(?)}");

            // OUT parameter (function return value)
            stmt.registerOutParameter(1, Types.VARCHAR);

            // IN parameter
            stmt.setInt(2, 12);

            stmt.execute();

            String name = stmt.getString(1);
            System.out.println("Name: " + name);

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}