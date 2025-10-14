import java.sql.*;
import java.util.Scanner;

public class VulnerableApp {

    public static void main(String[] args) {
        System.out.print("Enter email to search: ");
        String email = args[0];

        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
             Statement stmt = conn.createStatement()) {

            // Vulnerable SQL statement
            String query = "SELECT * FROM users WHERE email = '" + email + "'";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("User: " + rs.getString("name") + " - " + rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}