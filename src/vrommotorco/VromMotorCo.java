/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vrommotorco;

import java.util.List;
import vrommotordaoandsolo.user;
import vrommotordec.LeatherSeats;
import vrommotordec.LuxuryWheels;
import vrommotordec.PremiumPack;
import vrommotorobserver.EmailNotification;
import vrommotorobserver.Subject;
import vrommotorstrat.DiscountStrategy;
import vrommotorstrat.PercentageDiscount;
import vrommotordaoandsolo.UserDAOimp;
import vrommotordaoandsolo.UserDAO;
import java.util.Scanner;
import vrommotordaoandsolo.extra;
import vrommotordec.PanoramicSunRoof;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vrommotordec.BusinessPack;

/**
 *
 * @author leiva
 */


public class VromMotorCo {
    
    private static double obtenerPrecioCarro(String marca, String modelo, String version, Connection conexion) {
        double precio = 0.0;
        String query = "SELECT PRECIO FROM stockcarro WHERE MARCA = ? AND MODELO = ? AND VERSION = ?";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
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
      
    

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    UserDAOimp userDAO = UserDAOimp.getInstancia();
    int tipoVehiculo;
    String cliente, correo, marca, modelo, version;
    int cedula;
    String nombrePaquete = "";
    int idPedidocarroGenerado = -1;
    List<String> extrasSeleccionados = new ArrayList<>();


    
    System.out.println("Seleccione el tipo de vehículo:");
    System.out.println("1. Sedan");
    System.out.println("2. SUV");
    System.out.println("3. Deportivo");
    tipoVehiculo = scanner.nextInt();

    
    VehicleFactory carFactory = obtenerFactorySegunTipo(tipoVehiculo, userDAO.getConnection());
    Vehicle vehicle = carFactory.createVehicle();
    Vehicle bumblebee = carFactory.createVehicle();
    Vehicle bumblebee2 = carFactory.createVehicle();
    Vehicle luxurywheels = null;
    Vehicle leatherseats = null;
    Vehicle panoramicSunroof = null;
    Invoice invoice = new Invoice();
    
    System.out.println("Ingrese su nombre completo: ");
    scanner.nextLine(); 
    cliente = scanner.nextLine().trim();

    System.out.println("Ingrese su numero de cedula: ");
    cedula = scanner.nextInt();

    System.out.println("Ingrese su correo electronico: ");
    scanner.nextLine(); 
    correo = scanner.nextLine().trim();

    System.out.println("Ingrese la marca del vehiculo que desea: ");
    marca = scanner.nextLine().trim();

    System.out.println("Ingrese el modelo del vehiculo que desea: ");
    modelo = scanner.nextLine().trim();

    System.out.println("Ingrese la version del vehiculo que desea: ");
    version = scanner.nextLine().trim();

    userDAO.restarUno(marca, modelo, version);
    idPedidocarroGenerado = userDAO.insertarcarro(cliente, cedula, correo, modelo, marca, version);
    double precioCarro = obtenerPrecioCarro(marca, modelo, version, userDAO.getConnection());
    System.out.println("El precio del carro seleccionado es: $" + precioCarro);
    
    Vehicle premiumpack = new PremiumPack(vehicle);
    
    // Paso 3: Elegir el paquete del vehículo
    System.out.println("Seleccione el paquete del vehículo:");
    System.out.println("1. Basico");
    System.out.println("2. Premium");
    System.out.println("3. Business");
    int tipoPaquete = scanner.nextInt();
    switch (tipoPaquete) {
        case 1:
            break; 
        case 2:
            bumblebee = new PremiumPack(bumblebee);
            
            nombrePaquete = "Premium";
            break;
        case 3:
            bumblebee = new BusinessPack(bumblebee);
           
            nombrePaquete = "Business";
            break;
        default:
            System.out.println("Opción no válida. Saliendo del programa.");
            return;
    }

    // Paso 4: Agregar extras al vehículo
    System.out.println("¿Desea agregar extras? (1. Sí / 2. No)");
    int opcionAgregarExtras = scanner.nextInt();
    if (opcionAgregarExtras == 1) {
            int opcionExtra;
        
         
    do {
        System.out.println("Seleccione el extra:");
        System.out.println("1. Luxury Wheels");
        System.out.println("2. Leather Seats");
        System.out.println("3. Panoramic Sunroof");
        System.out.println("0. Terminar de agregar extras");

        opcionExtra = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        
        switch (opcionExtra) {
            case 1:
                bumblebee  = new LuxuryWheels(bumblebee);
                userDAO.insertarextra("AROS", 1, idPedidocarroGenerado);
                extrasSeleccionados.add(bumblebee.getDescription() + " - $" + bumblebee.getPrice(marca,modelo,version));
                userDAO.restarUnoExtra("AROS");
                break;
            case 2:
                bumblebee  = new LeatherSeats(bumblebee);
                userDAO.insertarextra("ASIENTOSCUERO", 1, idPedidocarroGenerado);
                extrasSeleccionados.add(bumblebee.getDescription() + " - $" + bumblebee.getPrice(marca,modelo,version));
                userDAO.restarUnoExtra("ASIENTOSCUERO");
                break;
            case 3:
                bumblebee  = new PanoramicSunRoof(bumblebee);
                userDAO.insertarextra("TECHOPANORAMICO", 1, idPedidocarroGenerado);
                extrasSeleccionados.add(bumblebee.getDescription() + " - $" + bumblebee.getPrice(marca,modelo,version));
                userDAO.restarUnoExtra("TECHOPANORAMICO");
                break;
            case 0:
                break;  
            default:
                System.out.println("Opción no válida.");
                break;
        }

    } while (opcionExtra != 0);
            // Imprimir recibo
            System.out.println("---------- Recibo ----------");
            System.out.println("Cliente: " + cliente);
            System.out.println("Número de cédula: " + cedula);
            System.out.println("Correo electrónico: " + correo);
            System.out.println("Vehículo: " + marca + " " + modelo + " " + version);
            System.out.println("Paquete seleccionado: " + nombrePaquete);
            System.out.println("Extras seleccionados:");
            for (String extra : extrasSeleccionados) {
                System.out.println("- " + extra);
            }
            System.out.println("Precio total: $" + bumblebee.getPrice(marca,modelo,version));
    
        
            } else 
                {
                    // Imprimir recibo
            System.out.println("---------- Recibo ----------");
            System.out.println("Cliente: " + cliente);
            System.out.println("Número de cédula: " + cedula);
            System.out.println("Correo electrónico: " + correo);
            System.out.println("Vehículo: " + marca + " " + modelo + " " + version);
            System.out.println("Paquete seleccionado: " + nombrePaquete);
            System.out.println("Precio total: $" + bumblebee.getPrice(marca,modelo,version));
                    
                }   
            

}

    private static VehicleFactory obtenerFactorySegunTipo(int tipoVehiculo, Connection connection) {
        switch (tipoVehiculo) {
            case 1:
                return new SedanFactory(connection);
            case 2:
                return new SUVFactory(connection);
            case 3:
                return new SportCarFactory(connection);
            default:
                throw new IllegalArgumentException("Tipo de vehículo no válido.");
        }
    }


    
}
