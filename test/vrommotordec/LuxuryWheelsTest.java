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
public class LuxuryWheelsTest {
    
    public LuxuryWheelsTest() {
    }

    @Test
    public void testGetDescription() {
         
        VehicleFactory carFactory = new SedanFactory();
        Vehicle vehicle = carFactory.createVehicle();   
   
        Vehicle LuxuryWheelsCar = new LuxuryWheels(vehicle);

        
        assertTrue(LuxuryWheelsCar.getDescription().contains("Sedan"));
        assertTrue(LuxuryWheelsCar.getDescription().contains("Luxury Wheels"));

    }

    @Test
    public void testGetPrice() {
        VehicleFactory carFactory = new SedanFactory();
        Vehicle vehicle = carFactory.createVehicle();
        
        Vehicle LuxuryWheelsCar = new LuxuryWheels(vehicle);
        
         assertEquals(21000.0, LuxuryWheelsCar.getPrice(), 0.01);
    }
    
}
