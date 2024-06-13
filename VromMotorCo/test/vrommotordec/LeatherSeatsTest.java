/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotordec;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import vrommotorco.Vehicle;
import vrommotordec.LeatherSeats;

public class LeatherSeatsTest {

    private Vehicle decoratedVehicle;

    @Before
    public void setUp() {
        // Crear un vehículo decorado con LeatherSeats para la prueba
        decoratedVehicle = new Vehicle() {
            @Override
            public String getDescription() {
                return "SUV - "; // Descripción base para el vehículo decorado
            }

            @Override
            public double getPrice(String marca, String modelo, String version) {
                return 20000.0; // Precio base para el vehículo decorado
            }
        };
    }

    @Test
    public void testGetDescription() {
        LeatherSeats leatherSeats = new LeatherSeats(decoratedVehicle);
        String description = leatherSeats.getDescription();

        assertEquals("SUV - Leather Seats - ", description);
    }

    @Test
    public void testGetPrice() {
        LeatherSeats leatherSeats = new LeatherSeats(decoratedVehicle);
        double price = leatherSeats.getPrice("Toyota", "Rav4", "2023");

        assertEquals(21000.0, price, 0.01);
        // Aquí se espera que el precio sea el precio base (20000.0) más el incremento (1000.0) de Leather Seats.
    }
}
