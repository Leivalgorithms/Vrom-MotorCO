/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vrommotorco;

/**
 *
 * @author leiva
 */
import java.sql.Connection;

public class SportCarFactory implements VehicleFactory {

    private final Connection connection;

    public SportCarFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Vehicle createVehicle() {
        return new SportCar(connection);
    }
}
