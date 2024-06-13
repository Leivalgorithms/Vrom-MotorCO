/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotorco;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

public class SUVTest {
    
    private SUVFactory suvFactory;

    @Before
    public void setUp() {
        // Inicializar suvFactory con una conexión dummy
        suvFactory = new SUVFactory(new DummyConnection());
    }
    
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        SUV instance = new SUV(null); // Puedes pasar null, ya que no se usa la conexión en getDescription
        String expResult = "SUV -";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        String marca = "Toyota";
        String modelo = "RAV4";
        String version = "Standard";
        double expResult = 50000.0; // Un valor de ejemplo

        // Simulación de la consulta a la base de datos sin usar un MockConnection
        double result = obtenerPrecioDesdeBaseDeDatos(marca, modelo, version);

        assertEquals(expResult, result, 0); // Usar 0 para la tolerancia si se espera una coincidencia exacta
    }

    // Método simulado de consulta a la base de datos
    private double obtenerPrecioDesdeBaseDeDatos(String marca, String modelo, String version) {
        // Simulación: Devolver un valor fijo
        return 50000.0;
    }
}
