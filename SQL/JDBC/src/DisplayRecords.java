import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayRecords {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/Student";
        String username = "root";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT * FROM Registration";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String program = resultSet.getString("program");

                System.out.println("ID: " + id + ", Name: " + name + ", Address: " + address + ", Program: " + program);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

