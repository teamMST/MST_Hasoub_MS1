package com.mst.database.mysqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLJDBCExample2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/northwind?serverTimezone=UTC";
        String user = "root";
        String password = "1234";

        String firstName = "Test";
        String lastName = "User";

        // 1️⃣ Load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            return; // stop program if driver not found
        }

        // 2️⃣ Connect to the database
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to MySQL database!\n");

            // 3️⃣ Insert employee
            String insertSql = "INSERT INTO employees (FirstName, LastName, Title) VALUES (?, ?, ?)";
            try (PreparedStatement psInsert = conn.prepareStatement(insertSql)) {
                psInsert.setString(1, firstName);
                psInsert.setString(2, lastName);
                psInsert.setString(3, "Developer");
                int inserted = psInsert.executeUpdate();
                System.out.println("Rows inserted: " + inserted);
            }

            // 4️⃣ Count employees
            try (PreparedStatement psCount = conn.prepareStatement("SELECT COUNT(*) AS cnt FROM employees");
                 ResultSet rs = psCount.executeQuery()) {
                if (rs.next()) System.out.println("Count after insertion: " + rs.getInt("cnt"));
            }

            // 5️⃣ Select the inserted employee
            String selectSql = "SELECT EmployeeID, FirstName, LastName, Title FROM employees WHERE FirstName=? AND LastName=?";
            try (PreparedStatement psSelect = conn.prepareStatement(selectSql)) {
                psSelect.setString(1, firstName);
                psSelect.setString(2, lastName);
                try (ResultSet rs = psSelect.executeQuery()) {
                    System.out.println("\nInserted employee info:");
                    while (rs.next()) {
                        System.out.println(rs.getInt("EmployeeID") + ": " +
                                rs.getString("FirstName") + " " +
                                rs.getString("LastName") + " - " +
                                rs.getString("Title"));
                    }
                }
            }

            // 6️⃣ Delete the employee
            String deleteSql = "DELETE FROM employees WHERE FirstName=? AND LastName=?";
            try (PreparedStatement psDelete = conn.prepareStatement(deleteSql)) {
                psDelete.setString(1, firstName);
                psDelete.setString(2, lastName);
                int deleted = psDelete.executeUpdate();
                System.out.println("\nRows deleted: " + deleted);
            }

            // 7️⃣ Count again
            try (PreparedStatement psCount = conn.prepareStatement("SELECT COUNT(*) AS cnt FROM employees");
                 ResultSet rs = psCount.executeQuery()) {
                if (rs.next()) System.out.println("Count after deletion: " + rs.getInt("cnt"));
            }

            // 8️⃣ Confirm deletion
            try (PreparedStatement psSelect = conn.prepareStatement(selectSql)) {
                psSelect.setString(1, firstName);
                psSelect.setString(2, lastName);
                try (ResultSet rs = psSelect.executeQuery()) {
                    System.out.println("\nCheck if deleted employee exists:");
                    if (!rs.next()) System.out.println("No such employee found.");
                }
            }

            // 9️⃣ Re-add employee
            try (PreparedStatement psInsert = conn.prepareStatement(insertSql)) {
                psInsert.setString(1, firstName);
                psInsert.setString(2, lastName);
                psInsert.setString(3, "Developer");
                psInsert.executeUpdate();
            }
            try (PreparedStatement psSelect = conn.prepareStatement(selectSql)) {
                psSelect.setString(1, firstName);
                psSelect.setString(2, lastName);
                try (ResultSet rs = psSelect.executeQuery()) {
                    System.out.println("\nRe-added employee info:");
                    while (rs.next()) {
                        System.out.println(rs.getInt("EmployeeID") + ": " +
                                rs.getString("FirstName") + " " +
                                rs.getString("LastName") + " - " +
                                rs.getString("Title"));
                    }
                }
            }

            // 🔟 Update employee
            String updateSql = "UPDATE employees SET Title=? WHERE FirstName=? AND LastName=?";
            try (PreparedStatement psUpdate = conn.prepareStatement(updateSql)) {
                psUpdate.setString(1, "Senior Developer");
                psUpdate.setString(2, firstName);
                psUpdate.setString(3, lastName);
                psUpdate.executeUpdate();
            }
            try (PreparedStatement psSelect = conn.prepareStatement(selectSql)) {
                psSelect.setString(1, firstName);
                psSelect.setString(2, lastName);
                try (ResultSet rs = psSelect.executeQuery()) {
                    System.out.println("\nUpdated employee info:");
                    while (rs.next()) {
                        System.out.println(rs.getInt("EmployeeID") + ": " +
                                rs.getString("FirstName") + " " +
                                rs.getString("LastName") + " - " +
                                rs.getString("Title"));
                    }
                }
            }

            // 11️⃣ Interesting query: employees grouped by title
            String groupSql = "SELECT Title, COUNT(*) AS cnt FROM employees GROUP BY Title";
            try (PreparedStatement psGroup = conn.prepareStatement(groupSql);
                 ResultSet rs = psGroup.executeQuery()) {
                System.out.println("\nEmployees grouped by title:");
                while (rs.next()) {
                    System.out.println(rs.getString("Title") + ": " + rs.getInt("cnt"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
