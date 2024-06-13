/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotorco;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class SedanFactoryTest {

    private Connection connection;
    private SedanFactory sedanFactory;

    @Before
    public void setUp() {
        try {
            // Establecer una conexión a una base de datos (o simularla)
            connection = DriverManager.getConnection("jdbc:h2:mem:test");
            sedanFactory = new SedanFactory(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateVehicle() {
        Vehicle vehicle = sedanFactory.createVehicle();

        assertNotNull(vehicle);
        assertTrue(vehicle instanceof Sedan);
    }
}
