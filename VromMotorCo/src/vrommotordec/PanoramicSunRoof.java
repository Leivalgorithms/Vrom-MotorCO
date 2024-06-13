/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vrommotordec;

import vrommotorco.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author leiva
 */
public class PanoramicSunRoof implements VehicleDecorator {
    
    private final Vehicle decoratedVehicle;

    public PanoramicSunRoof(Vehicle decoratedVehicle) {
        this.decoratedVehicle = decoratedVehicle;
    }

    @Override
    public String getDescription() {
        return decoratedVehicle.getDescription() + " Panoramic SunRoof - ";
    }
    
    @Override
    public double getPrice(String marca, String modelo,String version) {
        return decoratedVehicle.getPrice(marca,modelo,version) + 5000.0; 
    }
}
