/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotordec;

import org.junit.Test;
import static org.junit.Assert.*;
import vrommotorco.SUV;
import vrommotorco.SedanFactory;
import vrommotorco.Vehicle;
import vrommotorco.VehicleFactory;

/**
 *
 * @author fervr
 */
public class BasicPackTest {
    
    public BasicPackTest() {
    }

    @Test
    public void testGetDescription() {
    
        // Crear un objeto Vehicle original
        
        VehicleFactory carFactory = new SedanFactory();
        Vehicle vehicle = carFactory.createVehicle();   
        // Crear un BasicPack que decora el objeto Vehicle
        Vehicle basicPackCar = new BasicPack(vehicle);

        // Verificar que getDescription incluya la descripción original y el texto "Basic Pack"
        assertTrue(basicPackCar.getDescription().contains("Sedan"));
        assertTrue(basicPackCar.getDescription().contains("Basic Pack"));

        
       
    }

     public void testGetPrice() {
        VehicleFactory carFactory = new SedanFactory();
        Vehicle vehicle = carFactory.createVehicle();
        
        Vehicle basicPackCar = new BasicPack(vehicle);
        
         assertEquals(20000.0, basicPackCar.getPrice(), 0.01);
    }
    
}
