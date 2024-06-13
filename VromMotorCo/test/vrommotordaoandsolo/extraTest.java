/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotordaoandsolo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class extraTest {

    private extra extraInstance;

    @Before
    public void setUp() {
        // Configurar una instancia de Extra para las pruebas
        extraInstance = new extra("NombrePrueba", 100); // Valores de prueba
    }

    @Test
    public void testConstructorAndGetters() {
        // Verificar que los valores iniciales se establezcan correctamente por el constructor
        assertEquals("El nombre debería ser 'NombrePrueba'", "NombrePrueba", extraInstance.getNombre());
        assertEquals("El costo debería ser 100", 100, extraInstance.getCosto$());
        assertEquals("El ID debería ser 0", 0, extraInstance.getId());
    }

    @Test
    public void testSetters() {
        // Establecer nuevos valores utilizando setters
        extraInstance.setId(1);
        extraInstance.setNombre("NuevoNombre");
        extraInstance.setCosto(200);

        // Verificar que los valores se actualicen correctamente
        assertEquals("El ID debería ser 1", 1, extraInstance.getId());
        assertEquals("El nombre debería ser 'NuevoNombre'", "NuevoNombre", extraInstance.getNombre());
        assertEquals("El costo debería ser 200", 200, extraInstance.getCosto$());
    }

    // Puedes agregar más pruebas según las operaciones que desees validar en tu clase extra
}
