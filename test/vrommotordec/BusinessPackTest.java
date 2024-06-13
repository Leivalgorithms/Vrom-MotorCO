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
public class BusinessPackTest {
    
    public BusinessPackTest() {
    }

    @Test
    public void testGetDescription() {
      
        
        VehicleFactory carFactory = new SedanFactory();
        Vehicle vehicle = carFactory.createVehicle();   
        
        Vehicle BusinessPackCar = new BusinessPack(vehicle);

       
        assertTrue(BusinessPackCar.getDescription().contains("Sedan"));
        assertTrue(BusinessPackCar.getDescription().contains("Business Pack"));

        
    }

    @Test
    public void testGetPrice() {
        VehicleFactory carFactory = new SedanFactory();
        Vehicle vehicle = carFactory.createVehicle();
        
        Vehicle BusinessPackCar = new BusinessPack(vehicle);
        
         assertEquals(25000.0, BusinessPackCar.getPrice(), 0.01);
    }
    
}
