/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotorco;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SportCarFactoryTest {

    private Connection connection;
    private SportCarFactory sportCarFactory;

    @Before
    public void setUp() {
        try {
            // Establecer una conexión a una base de datos (o simularla)
            connection = DriverManager.getConnection("jdbc:h2:mem:test");
            sportCarFactory = new SportCarFactory(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateVehicle() {
        Vehicle vehicle = sportCarFactory.createVehicle();

        assertNotNull(vehicle);
        assertTrue(vehicle instanceof SportCar);
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
}
