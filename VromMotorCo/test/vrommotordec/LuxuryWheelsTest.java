/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotordec;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import vrommotorco.Vehicle;
import vrommotordec.LuxuryWheels;

public class LuxuryWheelsTest {

    private Vehicle decoratedVehicle;

    @Before
    public void setUp() {
        // Crear un vehículo decorado con LuxuryWheels para la prueba
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
        LuxuryWheels luxuryWheels = new LuxuryWheels(decoratedVehicle);
        String description = luxuryWheels.getDescription();

        assertEquals("SUV - Luxury Wheels - ", description);
    }

    @Test
    public void testGetPrice() {
        LuxuryWheels luxuryWheels = new LuxuryWheels(decoratedVehicle);
        double price = luxuryWheels.getPrice("Toyota", "Rav4", "2023");

        assertEquals(30500.0, price, 0.01);
        // Se espera que el precio sea el precio base (30000.0) más el incremento (500.0) de Luxury Wheels.
    }
}
