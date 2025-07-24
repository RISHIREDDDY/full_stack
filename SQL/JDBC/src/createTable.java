import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class createTable {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/Student";
        String username = "root";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "CREATE TABLE Registration (" +
                            "id INT PRIMARY KEY, " +
                            "name VARCHAR(100), " +
                            "address VARCHAR(255), " +
                            "program VARCHAR(100))";

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Registration table created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

