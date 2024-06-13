/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotordec;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import vrommotorco.Vehicle;
import vrommotordec.PanoramicSunRoof;

public class PanoramicSunRoofTest {

    private Vehicle decoratedVehicle;

    @Before
    public void setUp() {
        // Crear un vehículo decorado con PanoramicSunRoof para la prueba
        decoratedVehicle = new Vehicle() {
            @Override
            public String getDescription() {
                return "SUV - "; // Descripción base para el vehículo decorado
            }

            @Override
            public double getPrice(String marca, String modelo, String version) {
                return 40000.0; // Precio base para el vehículo decorado
            }
        };
    }

    @Test
    public void testGetDescription() {
        PanoramicSunRoof panoramicSunRoof = new PanoramicSunRoof(decoratedVehicle);
        String description = panoramicSunRoof.getDescription();

        assertEquals("SUV - Panoramic SunRoof - ", description);
    }

    @Test
    public void testGetPrice() {
        PanoramicSunRoof panoramicSunRoof = new PanoramicSunRoof(decoratedVehicle);
        double price = panoramicSunRoof.getPrice("Toyota", "Rav4", "2023");

        assertEquals(45000.0, price, 0.01);
        // Se espera que el precio sea el precio base (40000.0) más el incremento (5000.0) de Panoramic SunRoof.
    }
}
