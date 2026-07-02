import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedDemo {

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Usage: java PreparedDemo <id> <name> <city>");
            return;
        }

        String sql = "INSERT INTO cust VALUES (?, ?, ?)";

        try {
            Connection conn = JdbcFactory.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, Integer.parseInt(args[0]));
            stmt.setString(2, args[1]);
            stmt.setString(3, args[2]);

            stmt.executeUpdate();
            System.out.println("Record Inserted");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}