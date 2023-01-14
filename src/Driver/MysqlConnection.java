/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection {

    Connection connection = null;

    public static Connection getConnection() {

        System.out.println("Mysql Testing");

        try {
            Class.forName("com.mysql.jdbc.Driver");
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bdterrainbook", "root", "");

        } catch (Exception ex) {
            System.out.println("Connection Error");
            ex.printStackTrace();
        } finally {

           

        }

        return null;
    }

}
