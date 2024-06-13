/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotordec;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import vrommotorco.Vehicle;
import vrommotordec.PremiumPack;

public class PremiumPackTest {

    private Vehicle decoratedVehicle;

    @Before
    public void setUp() {
        // Crear un vehículo decorado con PremiumPack para la prueba
        decoratedVehicle = new Vehicle() {
            @Override
            public String getDescription() {
                return "SUV - "; // Descripción base para el vehículo decorado
            }

            @Override
            public double getPrice(String marca, String modelo, String version) {
                return 50000.0; // Precio base para el vehículo decorado
            }
        };
    }

    @Test
    public void testGetDescription() {
        PremiumPack premiumPack = new PremiumPack(decoratedVehicle);
        String description = premiumPack.getDescription();

        assertEquals("SUV - Premium Pack - ", description);
    }

    @Test
    public void testGetPrice() {
        PremiumPack premiumPack = new PremiumPack(decoratedVehicle);
        double price = premiumPack.getPrice("Toyota", "Rav4", "2023");

        assertEquals(58000.0, price, 0.01);
        // Se espera que el precio sea el precio base (50000.0) más el incremento (8000.0) del Premium Pack.
    }
}
