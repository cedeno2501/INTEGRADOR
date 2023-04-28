package conexion;

import java.sql.*;

public class ConexionDB {

        public static final String url = "jdbc:mysql://localhost:3306/futbol?serverTimezone=UTC";
        public static final String username= "root";
        public static final String password = "root";
        public static Connection connection;
        public static Statement statement;

        public static void getConnection() {
            try {
                connection = DriverManager.getConnection(url, username, password);
                statement = connection.createStatement();

            }catch(SQLException e){
                e.printStackTrace();
            }
        }



}
