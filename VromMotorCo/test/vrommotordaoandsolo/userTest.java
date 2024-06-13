/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotordaoandsolo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class userTest {

    private user userInstance;

    @Before
    public void setUp() {
        // Configurar una instancia de User para las pruebas
        userInstance = new user();
        userInstance.setId(1);
        userInstance.setModelo("ModeloPrueba");
        userInstance.setMarca("MarcaPrueba");
        userInstance.setVersion("VersionPrueba");
        userInstance.setCliente("ClientePrueba");
        userInstance.setCedula("1234567890");
        userInstance.setEmail("correo@prueba.com");
        userInstance.setDisponible(1);
        userInstance.setCantidad(5);
    }

    @Test
    public void testGetters() {
        // Verificar que los valores establecidos se obtengan correctamente
        assertEquals("El ID debería ser 1", 1, userInstance.getId());
        assertEquals("El modelo debería ser 'ModeloPrueba'", "ModeloPrueba", userInstance.getModelo());
        assertEquals("La marca debería ser 'MarcaPrueba'", "MarcaPrueba", userInstance.getMarca());
        assertEquals("La versión debería ser 'VersionPrueba'", "VersionPrueba", userInstance.getVersion());
        assertEquals("El cliente debería ser 'ClientePrueba'", "ClientePrueba", userInstance.getCliente());
        assertEquals("La cédula debería ser '1234567890'", "1234567890", userInstance.getCedula());
        assertEquals("El email debería ser 'correo@prueba.com'", "correo@prueba.com", userInstance.getEmail());
        assertEquals("La disponibilidad debería ser 1", 1, userInstance.getDisponible());
        assertEquals("La cantidad debería ser 5", 5, userInstance.getCantidad());
    }

    @Test
    public void testSetters() {
        // Establecer nuevos valores utilizando setters
        userInstance.setId(2);
        userInstance.setModelo("NuevoModelo");
        userInstance.setMarca("NuevaMarca");
        userInstance.setVersion("NuevaVersion");
        userInstance.setCliente("NuevoCliente");
        userInstance.setCedula("0987654321");
        userInstance.setEmail("nuevo@correo.com");
        userInstance.setDisponible(0);
        userInstance.setCantidad(10);

        // Verificar que los valores se actualicen correctamente
        assertEquals("El ID debería ser 2", 2, userInstance.getId());
        assertEquals("El modelo debería ser 'NuevoModelo'", "NuevoModelo", userInstance.getModelo());
        assertEquals("La marca debería ser 'NuevaMarca'", "NuevaMarca", userInstance.getMarca());
        assertEquals("La versión debería ser 'NuevaVersion'", "NuevaVersion", userInstance.getVersion());
        assertEquals("El cliente debería ser 'NuevoCliente'", "NuevoCliente", userInstance.getCliente());
        assertEquals("La cédula debería ser '0987654321'", "0987654321", userInstance.getCedula());
        assertEquals("El email debería ser 'nuevo@correo.com'", "nuevo@correo.com", userInstance.getEmail());
        assertEquals("La disponibilidad debería ser 0", 0, userInstance.getDisponible());
        assertEquals("La cantidad debería ser 10", 10, userInstance.getCantidad());
    }

    // Puedes agregar más pruebas según las operaciones que desees validar en tu clase User
}
