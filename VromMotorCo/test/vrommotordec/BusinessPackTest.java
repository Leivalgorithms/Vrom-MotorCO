/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotordec;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import vrommotorco.Vehicle;
import vrommotordec.BusinessPack;

public class BusinessPackTest {

    private Vehicle decoratedVehicle;

    @Before
    public void setUp() {
        // Crear un vehículo decorado con BusinessPack para la prueba
        decoratedVehicle = new Vehicle() {
            @Override
            public String getDescription() {
                return "SUV - "; // Descripción base para el vehículo decorado
            }

            @Override
            public double getPrice(String marca, String modelo, String version) {
                return 30000.0; // Precio base para el vehículo decorado
            }
        };
    }

    @Test
    public void testGetDescription() {
        BusinessPack businessPack = new BusinessPack(decoratedVehicle);
        String description = businessPack.getDescription();

        assertEquals("SUV - Business Pack - ", description);
    }

    @Test
    public void testGetPrice() {
        BusinessPack businessPack = new BusinessPack(decoratedVehicle);
        double price = businessPack.getPrice("Toyota", "Rav4", "2023");

        assertEquals(35000.0, price, 0.01);
        // Aquí se espera que el precio sea el precio base (30000.0) más el incremento (5000.0) del Business Pack.
    }
}
