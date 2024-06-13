/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vrommotordec;

import vrommotorco.Vehicle;

/**
 *
 * @author leiva
 */
public class BusinessPack implements VehicleDecorator{
    
    private final Vehicle decoratedVehicle;

    public BusinessPack(Vehicle decoratedVehicle) {
        this.decoratedVehicle = decoratedVehicle;
    }

    @Override
    public String getDescription() {
        return decoratedVehicle.getDescription() + " Business Pack - ";
    }
    
    @Override
    public double getPrice(String marca, String modelo,String version) {
        return decoratedVehicle.getPrice(marca,modelo,version) + 5000.0; 
    }
}
