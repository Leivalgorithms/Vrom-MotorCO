/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotorstrat;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fervr
 */
public class FixedDiscountTest {
    
    public FixedDiscountTest() {
    }

    @Test
    public void testApplyDiscount() {
      // Crear un objeto FixedDiscount con un descuento fijo de 10
        DiscountStrategy discount = new FixedDiscount(10);

        // Aplicar el descuento a un precio original de 50
        double discountedPrice = discount.applyDiscount(50);

        // Verificar que el precio descontado sea el esperado (40 en este caso)
        assertEquals(40.0, discountedPrice, 0.01);
    }
    
}
