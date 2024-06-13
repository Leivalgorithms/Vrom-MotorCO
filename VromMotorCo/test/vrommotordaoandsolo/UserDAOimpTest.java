/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotordaoandsolo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserDAOimpTest {

    private UserDAOimp userDAO;

    @Before
    public void setUp() {
        // Configurar la instancia de UserDAOimp para las pruebas
        userDAO = UserDAOimp.getInstancia();
    }

    @After
    public void tearDown() {
        // Realizar limpieza después de las pruebas si es necesario
    }

    @Test
    public void testObtenerTodos() {
        // Ejecutar el método y verificar que la lista no sea nula
        List<user> usuarios = userDAO.obtenerTodos();
        assertNotNull("La lista de usuarios no debería ser nula", usuarios);
    }

    @Test
    public void testInsertarcarro() {
        // Insertar un carro y verificar que se genere un ID válido
        int idPedidoCarroGenerado = userDAO.insertarcarro("ClientePrueba", 123456789, "cliente@prueba.com", "Modelo", "Marca", "Version");
        assertNotNull("El ID del pedido de carro generado no debería ser nulo", idPedidoCarroGenerado);
        // Puedes realizar más aserciones según tus necesidades
    }

    @Test
    public void testInsertarextra() {
        // Insertar un extra y verificar que se inserte correctamente
        userDAO.insertarextra("ExtraPrueba", 1, 1); // Suponiendo valores de prueba
        // Puedes realizar más aserciones según tus necesidades
    }

    @Test
    public void testRestarUno() {
        // Insertar un carro para probar la actualización de la cantidad
        int idPedidoCarroGenerado = userDAO.insertarcarro("ClientePrueba", 123456789, "cliente@prueba.com", "Modelo", "Marca", "Version");

        // Restar uno a la cantidad del carro y verificar que la actualización sea exitosa
        userDAO.restarUno("Marca", "Modelo", "Version");

        // Obtener el usuario después de la actualización
        List<user> usuariosDespues = userDAO.obtenerTodos();
        // Puedes realizar más aserciones según tus necesidades
    }

    @Test
    public void testRestarUnoExtra() {
        // Insertar un extra para probar la actualización de la cantidad
        userDAO.insertarextra("ExtraPrueba", 1, 1); // Suponiendo valores de prueba

        // Restar uno a la cantidad del extra y verificar que la actualización sea exitosa
        userDAO.restarUnoExtra("ExtraPrueba");

        // Obtener la lista de extras después de la actualización
        List<extra> extrasDespues = userDAO.obtenerExtrasDisponibles();
        // Puedes realizar más aserciones según tus necesidades
    }
    
    // Puedes agregar más pruebas según las operaciones que desees validar en tu DAO
}
