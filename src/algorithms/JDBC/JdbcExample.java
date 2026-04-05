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

/*
<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
    <version>5.1.0</version>
</dependency>

<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.3.0</version>
</dependency>
 */
//-------------------------------------------------------------------
/* PRODUCTION Ready code:::
//--------------------------------------------------------------------
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

public class JdbcAdvancedExample {

    public static void main(String[] args) {

        // 🔹 1. Configure HikariCP (Connection Pool)
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/testdb");
        config.setUsername("root");
        config.setPassword("password");

        // Pool settings
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setIdleTimeout(30000);
        config.setConnectionTimeout(20000);

        HikariDataSource dataSource = new HikariDataSource(config);

        // 🔹 2. Get Connection from Pool
        try (Connection con = dataSource.getConnection()) {

            // 🔹 3. Disable auto-commit (for transaction)
            con.setAutoCommit(false);

            try {

                // 🔹 4. Batch Insert
                String insertSQL = "INSERT INTO users (id, name) VALUES (?, ?)";
                try (PreparedStatement ps = con.prepareStatement(insertSQL)) {

                    for (int i = 1; i <= 5; i++) {
                        ps.setInt(1, i);
                        ps.setString(2, "User_" + i);
                        ps.addBatch();
                    }

                    int[] results = ps.executeBatch();
                    System.out.println("Batch Insert Count: " + results.length);
                }

                // 🔹 5. Query Data
                String selectSQL = "SELECT * FROM users";
                try (PreparedStatement ps = con.prepareStatement(selectSQL);
                     ResultSet rs = ps.executeQuery()) {

                    while (rs.next()) {
                        System.out.println(
                                rs.getInt("id") + " " + rs.getString("name")
                        );
                    }
                }

                // 🔹 6. Commit Transaction
                con.commit();
                System.out.println("Transaction committed successfully");

            } catch (Exception e) {

                // 🔹 7. Rollback if any error
                con.rollback();
                System.out.println("Transaction rolled back due to error");

                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 🔹 8. Shutdown pool
        dataSource.close();
    }
}
 */
