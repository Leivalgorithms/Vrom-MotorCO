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

public class SUVFactoryTest {

    private Connection connection;
    private SUVFactory suvFactory;

    @Before
    public void setUp() {
        try {
            // Puedes usar una base de datos en memoria para las pruebas
            connection = DriverManager.getConnection("jdbc:h2:mem:test");
            suvFactory = new SUVFactory(connection);
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
    public void testCreateVehicle() {
        Vehicle vehicle = suvFactory.createVehicle();

        assertNotNull(vehicle);
        assertTrue(vehicle instanceof SUV);
    }
}
