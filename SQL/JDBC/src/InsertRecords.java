import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertRecords {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/Student";
        String username = "root";
        String password = "1234";

        String sql = "INSERT INTO Registration (id, name, address, program) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, 1000);
            statement.setString(2, "A");
            statement.setString(3, "Manager");
            statement.setString(4, "100000");
            statement.executeUpdate();
            statement.setInt(1, 2000);
            statement.setString(2, "B");
            statement.setString(3, "Manager");
            statement.setString(4, "100000");
            statement.executeUpdate();
            statement.setInt(1, 1010);
            statement.setString(2, "C");
            statement.setString(3, "Assitant Manager");
            statement.setString(4, "20000");
            statement.executeUpdate();

            statement.setInt(1, 1020);
            statement.setString(2, "D");
            statement.setString(3, "Senior Manger");
            statement.setString(4, "40000");
            statement.executeUpdate();

            statement.setInt(1, 1030);
            statement.setString(2, "E");
            statement.setString(3, "Intern");
            statement.setString(4, "500000");
            statement.executeUpdate();

            System.out.println("Records inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

