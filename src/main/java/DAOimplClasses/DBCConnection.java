package DAOimplClasses;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCConnection {
    public static Connection getCon() {


        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Sureshpr@1998");
            System.out.println("Connected to Database");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}