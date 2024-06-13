/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotorco;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SUVFactoryTest {

    @Test
    public void testCreateVehicle() {
        System.out.println("createVehicle");
        SUVFactory instance = new SUVFactory(); // Suponiendo que no se requiere una conexión a la base de datos
        Vehicle expResult = new SUV(null); // Puedes pasar null si la conexión no se utiliza en el constructor
        Vehicle result = instance.createVehicle();
        assertEquals(expResult.getDescription(), result.getDescription());
        assertEquals(expResult.getPrice("Toyota", "RAV4", "Standard"), result.getPrice("Toyota", "RAV4", "Standard"), 0);
    }
}


