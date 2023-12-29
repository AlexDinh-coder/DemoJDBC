package com.example.jdbc;
import java.sql.*;
import java.sql.ResultSet;


public class Main {
    private final String Driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306//myschool";
    private final String user = "root";
    private final String pass = "password";
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null ;
         try {
             Class.forName("com.mysql.jdbc.Driver");
             System.out.println("Connecting to database");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool", "root", "password");
             System.out.println("Connected to database successfully");
             System.out.println("Creating table ");
             st = con.createStatement();

                //Create table
                //          String sql = """
                 //   CREATE TABLE Information2 (
                 //   ID int,
                 //   Name varchar(255),
                  //  email varchar(255),
                //    Customers varchar(255),
                  //  products varchar(255)
               // );



//""";

//                     "CREATE TABLE " +
//                     ("id INTEGER not null," +
//                     "first VARCHAR(255), " +
//                      "last VARCHAR(255), " +
//                      "age INTEGER," +
//                      "PRIMARY KEY(id)");
            // st.executeUpdate(sql);
           //  System.out.println("Table created");
             //Update by ID
             int idToUpdate = 1;
            String updateSql = "UPDATE Information2 SET Name = ? WHERE ID = ?";
            var p = con.prepareStatement(updateSql);
            p.setString(1, "Dung");
            p.setString(2, "3");
             p.executeUpdate();

            //Update customers by email

             String updateSql1 = "UPDATE Information2 SET Customers = ? WHERE email =? ";
             var c = con.prepareStatement(updateSql1);
             c.setString(1, "aaa");
             c.setString(2, "dtt@gmail.com");

             c.executeUpdate();

             System.out.println("Update created");

             //Get all customers from customer tables
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
             st.close();
             con.close();
         
         }catch (ClassNotFoundException | SQLException e) {
             e.printStackTrace();
         } catch(Exception e) {
             e.printStackTrace();
            }finally {
             try {
                 if(st != null)
                     con.close();
             }catch (SQLException e) {
                 e.printStackTrace();
             }
         }
         try {
             if(con != null)
                 con.close();
         }catch (SQLException e){
             e.printStackTrace();
         }
        System.out.println("Stop");

    }
}