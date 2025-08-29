package com.mst.database.mysqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLJDBCExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/northwind";
        String user = "root";
        String password = "1234";

        try {
            // 1. Load the driver (optional for newer JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to the database
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL database!");

            // 3. Create a statement
            Statement stmt = conn.createStatement();

            // 4. Execute a query (list all employees)
            String sql = "SELECT EmployeeID, FirstName, LastName, Title FROM employees";
            ResultSet rs = stmt.executeQuery(sql);

            // 5. Process the result set
            System.out.println("Employees:");
            while (rs.next()) {
                int id = rs.getInt("EmployeeID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String title = rs.getString("Title");
                System.out.println(id + ": " + firstName + " " + lastName + " - " + title);
            }

            // 6. Close resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
