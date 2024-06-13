/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vrommotordaoandsolo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author leiva
 */
public class MySQLDBConection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/vrommotorco";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    private static Connection connection;

    private MySQLDBConection() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    
}
