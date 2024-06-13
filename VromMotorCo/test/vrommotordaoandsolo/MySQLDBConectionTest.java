/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotordaoandsolo;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MySQLDBConectionTest {

    @Before
    public void setUp() {
        // Puedes realizar configuraciones de prueba aquí si es necesario
    }

    @After
    public void tearDown() {
        // Puedes realizar limpieza de recursos aquí si es necesario
    }

    @Test
    public void testGetConnection() throws SQLException {
        // Configuración de la conexión de prueba usando H2 en memoria
        Connection connection = MySQLDBConection.getConnection();

        // Asegúrate de que la conexión no sea nula
        assertNotNull("La conexión no debería ser nula", connection);

        // Puedes realizar más aserciones o pruebas según tus necesidades
    }
}
