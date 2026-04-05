package algorithms.JDBC;

import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String pass = "password";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = con.prepareStatement(
                     "SELECT * FROM users WHERE id = ?")) {

            ps.setInt(1, 1);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " +
                        rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


