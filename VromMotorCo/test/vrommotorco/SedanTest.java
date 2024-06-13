/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotorco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SedanTest {

    private Connection connection;
    private Sedan sedan;

    @Before
    public void setUp() {
        try {
            // Configurar una base de datos H2 en memoria
            connection = DriverManager.getConnection("jdbc:h2:mem:test");
            createTestTable();
            populateTestData();
            sedan = new Sedan(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPrice() {
        double price = sedan.getPrice("Toyota", "Camry", "2023");
        assertEquals(20000.0, price, 0.01);
    }

    private void createTestTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS stockcarro (MARCA VARCHAR(50), MODELO VARCHAR(50), VERSION VARCHAR(50), PRECIO DOUBLE)");
        }
    }

    private void populateTestData() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO stockcarro VALUES (?, ?, ?, ?)")) {
            statement.setString(1, "Toyota");
            statement.setString(2, "Camry");
            statement.setString(3, "2023");
            statement.setDouble(4, 20000.0);
            statement.executeUpdate();
        }
    }
}
