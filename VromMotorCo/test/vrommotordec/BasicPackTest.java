/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotordec;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import vrommotorco.Vehicle;
import vrommotordec.BasicPack;

public class BasicPackTest {

    private Vehicle decoratedVehicle;

    @Before
    public void setUp() {
        // Crear un vehículo decorado con BasicPack para la prueba
        decoratedVehicle = new Vehicle() {
            @Override
            public String getDescription() {
                return "SUV - "; // Descripción base para el vehículo decorado
            }

            @Override
            public double getPrice(String marca, String modelo, String version) {
                return 25000.0; // Precio base para el vehículo decorado
            }
        };
    }

    @Test
    public void testGetDescription() {
        BasicPack basicPack = new BasicPack(decoratedVehicle);
        String description = basicPack.getDescription();

        assertEquals("SUV - Basic Pack - ", description);
    }

    @Test
    public void testGetPrice() {
        BasicPack basicPack = new BasicPack(decoratedVehicle);
        double price = basicPack.getPrice("Toyota", "Rav4", "2023");

        assertEquals(25000.0, price, 0.01);
        // Aquí se espera que el precio no cambie al añadir el Basic Pack, 
        // ya que en este caso se suma 0.0 al precio base.
    }
}
