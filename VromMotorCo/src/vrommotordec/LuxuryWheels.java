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
public class LuxuryWheels implements VehicleDecorator {
    
    private final Vehicle decoratedVehicle;

    public LuxuryWheels(Vehicle decoratedVehicle) {
        this.decoratedVehicle = decoratedVehicle;
    }

    @Override
    public String getDescription() {
        return decoratedVehicle.getDescription() + " Luxury Wheels - ";
    }
    
    @Override
    public double getPrice(String marca, String modelo,String version) {
        return decoratedVehicle.getPrice(marca,modelo,version) + 500.0; 
    }
} 
