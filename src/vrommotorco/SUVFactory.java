/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vrommotorco;

import java.sql.Connection;

/**
 *
 * @author leiva
 */
public class SUVFactory implements VehicleFactory {

    private final Connection connection;

    public SUVFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Vehicle createVehicle() {
        return new SUV(connection);
    }
}

