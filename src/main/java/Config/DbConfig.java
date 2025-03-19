package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {


        static String url = "jdbc:mysql://localhost:3306/construction";
        static String username = "root";
        static String pass = "";

        public static Connection getConnection() throws SQLException {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection(url, username, pass);
            }catch (ClassNotFoundException e){
                throw new SQLException("Database driver not found", e);
            }
        }
    }
