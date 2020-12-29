/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP ProBook
 */
public class koneksi {

    private static Connection mysqlkon;

    public static Connection koneksiDB(){
        if (mysqlkon == null) {
            try {
                String DB = "jdbc:mysql://localhost:3306/oop_rental";
                String User = "root";
                String pass = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlkon = (Connection) DriverManager.getConnection(DB, User, pass);

            } catch (Exception e) {
            }
        }
        return mysqlkon;
    }
}
