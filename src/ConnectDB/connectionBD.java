
package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class connectionBD {
    Connection conn = null;
    public static Connection conDB()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bdterrainbook", "root", "");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("connectionBD : "+ex.getMessage());
           return null;
        }
    }
    
}

 