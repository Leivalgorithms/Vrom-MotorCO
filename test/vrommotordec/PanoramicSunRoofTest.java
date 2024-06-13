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
public class PanoramicSunRoofTest {
    
    public PanoramicSunRoofTest() {
    }

    @Test
    public void testGetDescription() {
       VehicleFactory carFactory = new SedanFactory();
        Vehicle vehicle = carFactory.createVehicle();   
   
        Vehicle PanoramicSunRoofCar = new PanoramicSunRoof(vehicle);

        
        assertTrue(PanoramicSunRoofCar.getDescription().contains("Sedan"));
        assertTrue(PanoramicSunRoofCar.getDescription().contains("Panoramic Sunroof"));
    }

    @Test
    public void testGetPrice() {
       VehicleFactory carFactory = new SedanFactory();
        Vehicle vehicle = carFactory.createVehicle();
        
        Vehicle PanoramicSunRoofCar = new PanoramicSunRoof(vehicle);
        
         assertEquals(25000.0, PanoramicSunRoofCar.getPrice(), 0.01);
    }
    
}
