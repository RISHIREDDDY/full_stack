import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateRecords {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/Student";
        String username = "root";
        String password = "1234";

        String sql = "UPDATE Registration SET program = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            PreparedStatement statement = connection.prepareStatement(sql)) {

            // Update program for student with ID 100
            statement.setString(1, "Intern");
            statement.setInt(2, 100);
            statement.executeUpdate();

            // Update program for student with ID 101
            statement.setString(1, "Assitant");
            statement.setInt(2, 101);
            statement.executeUpdate();

            System.out.println("Records updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

