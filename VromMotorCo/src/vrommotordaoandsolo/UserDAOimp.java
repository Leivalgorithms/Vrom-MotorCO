/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



package vrommotordaoandsolo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leiva
 */
public class UserDAOimp implements UserDAO{
    
    private static UserDAOimp instancia;
    private Connection conexion;

    // Constructor privado para implementar el patrón Singleton
    private UserDAOimp() {
        // Obtener la conexión desde la clase de conexión
        conexion = MySQLDBConection.getConnection();
    }

    // Método para obtener la instancia única (patrón Singleton)
    public static synchronized UserDAOimp getInstancia() {
        if (instancia == null) {
            instancia = new UserDAOimp();
        }
        return instancia;
    }

    // Método para obtener la conexión
    public Connection getConnection() {
        return conexion;
    }

    @Override
    public List<user> obtenerTodos() {
        List<user> usuarios = new ArrayList<>();
        try {
            String query = "SELECT * FROM stockcarro";
            try (PreparedStatement statement = conexion.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    user usuario = new user();
                    // Asume que User tiene métodos setter para cada columna en la tabla
                    usuario.setId(resultSet.getInt("IDCARRO"));
                    usuario.setModelo(resultSet.getString("MODELO"));
                    usuario.setMarca(resultSet.getString("MARCA"));
                    usuario.setVersion(resultSet.getString("VERSION"));
                    usuario.setDisponible(resultSet.getInt("Disponible"));
                    usuario.setCantidad(resultSet.getInt("Cantidad"));
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public int insertarcarro(String cliente, int cedula, String email, String modelo, String marca, String version) {
    int idPedidocarroGenerado = -1;

    try {
        String queryInsertCarro = "INSERT INTO pedidocarro (CLIENTE, CEDULA, EMAIL, MODELO, MARCA, VERSION, CANTIDAD) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(queryInsertCarro, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, cliente);
            statement.setInt(2, cedula);
            statement.setString(3, email);
            statement.setString(4, modelo);
            statement.setString(5, marca);
            statement.setString(6, version);
            statement.setInt(7, 1);
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idPedidocarroGenerado = generatedKeys.getInt(1);
                } else {
                    System.out.println("No se pudo obtener el ID del pedido de carro generado.");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return idPedidocarroGenerado;
}

public void insertarextra(String nombre, int cantidad, int idPedidocarro) {
    try {
        String queryInsertExtra = "INSERT INTO pedidoextra (NOMBRE, COSTO, CANTIDAD) SELECT NOMBRE, COSTO$, ? FROM stockextra WHERE NOMBRE = ?";
        String queryInsertRelacion = "INSERT INTO pedidocarroextra (idpedidocarro, idpedidoextra) VALUES (?, LAST_INSERT_ID())";
        
        // Insertar el pedido de extra
        try (PreparedStatement statement = conexion.prepareStatement(queryInsertExtra)) {
            statement.setInt(1, cantidad);
            statement.setString(2, nombre);
            statement.executeUpdate();
        }

        // Insertar la relación en la tabla de asociación
        try (PreparedStatement statement = conexion.prepareStatement(queryInsertRelacion)) {
            statement.setInt(1, idPedidocarro);
            statement.executeUpdate();
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    

    public void actualizar(user usuario) {
        try {
        String query = "UPDATE usuarios SET modelo = ?, marca = ?, version = ?, disponible = ?, cantidad = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, usuario.getModelo());
            statement.setString(2, usuario.getMarca());
            statement.setString(3, usuario.getVersion());
            statement.setInt(4, usuario.getDisponible());
            statement.setInt(5, usuario.getCantidad());
            statement.setInt(6, usuario.getId());
            statement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    public void eliminar(int id) {
         try {
        String query = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
    // Método para restar 1 a la columna "Cantidad" de un registro específico
    public void restarUno(String marca, String modelo, String version) {
        try {
        // Consulta SQL para obtener el ID del registro que coincide con los valores ingresados
        String queryConsultaId = "SELECT IDCARRO FROM stockcarro WHERE MARCA = ? AND MODELO = ? AND VERSION = ?";
        int idRegistro = -1;

        try (PreparedStatement statementConsultaId = conexion.prepareStatement(queryConsultaId)) {
            statementConsultaId.setString(1, marca);
            statementConsultaId.setString(2, modelo);
            statementConsultaId.setString(3, version);

            try (ResultSet resultSet = statementConsultaId.executeQuery()) {
                if (resultSet.next()) {
                    idRegistro = resultSet.getInt("IDCARRO");
                } else {
                    System.out.println("No se encontró un registro con los valores ingresados.");
                    System.out.println("Consulta SQL: " + queryConsultaId);
                    return;
                }
            }
        }
        
        
        // Consulta SQL para restar 1 a la columna 'Cantidad' del registro encontrado
        String queryRestarUno = "UPDATE stockcarro SET CANTIDAD = CANTIDAD - 1 WHERE IDCARRO = ?";
        
        try (PreparedStatement preparedStatement = conexion.prepareStatement(queryRestarUno)) {
            preparedStatement.setInt(1, idRegistro);
            int filasActualizadas = preparedStatement.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Actualización exitosa. Se restó 1 a la cantidad del registro.");
            } else {
                System.out.println("No se encontró el registro con el ID " + idRegistro);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
    public void restarUnoExtra(String nombreExtra) {
    try {
        // Consulta SQL para obtener el ID del registro que coincide con el nombre del extra
        String queryConsultaId = "SELECT IDEXTRA FROM stockextra WHERE NOMBRE = ?";
        int idRegistro = -1;

        try (PreparedStatement statementConsultaId = conexion.prepareStatement(queryConsultaId)) {
            statementConsultaId.setString(1, nombreExtra);

            try (ResultSet resultSet = statementConsultaId.executeQuery()) {
                if (resultSet.next()) {
                    idRegistro = resultSet.getInt("IDEXTRA");
                } else {
                    System.out.println("No se encontró un registro con el nombre de extra ingresado.");
                    System.out.println("Consulta SQL: " + queryConsultaId);
                    return;
                }
            }
        }

        // Consulta SQL para restar 1 a la columna 'Cantidad' del registro encontrado
        String queryRestarUno = "UPDATE stockextra SET CANTIDAD = CANTIDAD - 1 WHERE IDEXTRA = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(queryRestarUno)) {
            preparedStatement.setInt(1, idRegistro);
            int filasActualizadas = preparedStatement.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Actualización exitosa. Se restó 1 a la cantidad del registro.");
            } else {
                System.out.println("No se encontró el registro con el ID " + idRegistro);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
   
    public List<extra> obtenerExtrasDisponibles() {
    List<extra> extras = new ArrayList<>();

    try {
        String query = "SELECT NOMBRE, costo$ FROM stockextra WHERE cantidad > 0";

        try (PreparedStatement statement = conexion.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String nombre = resultSet.getString("NOMBRE");
                int costo = resultSet.getInt("costo$");

                extra extra = new extra(nombre, costo);
                extras.add(extra);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return extras;
}

    
    
}
