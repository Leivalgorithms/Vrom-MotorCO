/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotordec;

import org.junit.Test;
import static org.junit.Assert.*;
import vrommotorco.SedanFactory;
import vrommotorco.Vehicle;
import vrommotorco.VehicleFactory;

/**
 *
 * @author fervr
 */
public class LeatherSeatsTest {
    
    public LeatherSeatsTest() {
    }

    @Test
    public void testGetDescription() {
        
     
        
        VehicleFactory carFactory = new SedanFactory();
        Vehicle vehicle = carFactory.createVehicle();   
   
        Vehicle LeatherSeatsCar = new LeatherSeats(vehicle);

        
        assertTrue(LeatherSeatsCar.getDescription().contains("Sedan"));
        assertTrue(LeatherSeatsCar.getDescription().contains("Leather Seats"));

    }

    @Test
    public void testGetPrice() {
        VehicleFactory carFactory = new SedanFactory();
        Vehicle vehicle = carFactory.createVehicle();
        
        Vehicle LeatherSeatsCar = new LeatherSeats(vehicle);
        
         assertEquals(21500.0, LeatherSeatsCar.getPrice(), 0.01);
    }
    
}
