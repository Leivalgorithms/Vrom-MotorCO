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
public class PremiumPackTest {
    
    public PremiumPackTest() {
    }

    @Test
    public void testGetDescription() {
        
        VehicleFactory carFactory = new SedanFactory();
        Vehicle vehicle = carFactory.createVehicle();   
   
        Vehicle PremiumPackCar = new PremiumPack(vehicle);

        
        assertTrue(PremiumPackCar.getDescription().contains("Sedan"));
        assertTrue(PremiumPackCar.getDescription().contains("Premium Pack"));
    }

    @Test
    public void testGetPrice() {
      VehicleFactory carFactory = new SedanFactory();
        Vehicle vehicle = carFactory.createVehicle();
        
        Vehicle PremiumPackCar = new PremiumPack(vehicle);
        
         assertEquals(28000.0, PremiumPackCar.getPrice(), 0.01);
    }
    
}
