import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;


public class JDBCTestConnection {
    @Test
    public void  TestJDBCConnection(){
        Connection connection;

        String url = "jdbc:mysql://localhost/world?" + "autoReconnect=true&useSSL=false";
        String username = "root";
        String password = "Supermandhaderkryp29t!";


        try{
            connection = DriverManager.getConnection(url, username, password);
            assertEquals(true, connection.isValid(1));
            connection.close();
            assertEquals(false, connection.isValid(1));
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("jeg virker nu langt om længe");

    }
}