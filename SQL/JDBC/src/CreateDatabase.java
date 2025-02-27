import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabase{
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "CREATE DATABASE Student";

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Database created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
