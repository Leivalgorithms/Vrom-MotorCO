/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vrommotorco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author leiva
 */
public class SUV implements Vehicle {

    private final Connection connection;

    public SUV(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String getDescription() {
        return "SUV -";
    }

    public double getPrice(String marca, String modelo,String version) {
        

        double precio = obtenerPrecioDesdeBaseDeDatos(marca, modelo,version);
        return precio;
    }

    private double obtenerPrecioDesdeBaseDeDatos(String marca, String modelo,String version) {
        double precio = 0.0;
        String query = "SELECT PRECIO FROM stockcarro WHERE MARCA = ? AND MODELO = ? AND VERSION = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, marca);
            statement.setString(2, modelo);
            statement.setString(3, version);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    precio = resultSet.getDouble("PRECIO");
                } else {
                    System.out.println("No se encontró el carro en la base de datos.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return precio;
    }
}