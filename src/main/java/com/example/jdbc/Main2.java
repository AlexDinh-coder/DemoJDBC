package com.example.jdbc;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main2 {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/myschool";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args){
        updateNameById();
        updateCustomersByEmail();
        selectAllCustomers();
        System.out.println("Stop");

    }
    public static void updateNameById() {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool", "root", "password")){
//             PreparedStatement preparedStatement = con.prepareStatement("UPDATE Information2 SET Name = ? WHERE ID = ?")) {
            int idToUpdate = 1;
          String updateSql = "UPDATE Information2 SET Name = ? WHERE ID = ?";
            var p = con.prepareStatement(updateSql);
            p.setString(1, "Dung2");
            p.setString(2, "3");
            p.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public static void updateCustomersByEmail()   {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool", "root", "password")){
            String updateSql1 = "UPDATE Information2 SET Customers = ? WHERE email =? ";
            var c = con.prepareStatement(updateSql1);
            c.setString(1, "bbb");
            c.setString(2, "dtt@gmail.com");

            c.executeUpdate();

            System.out.println("Update created");


       }catch (SQLException e) {
            e.printStackTrace();
        }




    }
    public static void selectAllCustomers() {
        Statement st = null;
        ResultSet rs = null;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool", "root", "password")){
            String selectAllCustomers = "SELECT * FROM Information2";
            st = con.createStatement();
            rs = st.executeQuery(selectAllCustomers);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String email = rs.getString("email");
                String customer = rs.getString("Customers");
                String product = rs.getString("products");

                System.out.println("ID: " + id+ ", Name: " + name+ ",email: " +email+ ",Customer: " +customer+ ",products: " + product);

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


}




