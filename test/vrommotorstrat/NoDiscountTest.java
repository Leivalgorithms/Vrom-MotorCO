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
public class NoDiscountTest {
    
    public NoDiscountTest() {
    }

    @Test
    public void testApplyDiscount() {
       // Crear un objeto NoDiscount
        DiscountStrategy discount = new NoDiscount();

        // Aplicar el descuento a un precio original de 100
        double discountedPrice = discount.applyDiscount(100);

        // Verificar que el precio descontado sea igual al precio original (sin descuento)
        assertEquals(100.0, discountedPrice, 0.01);
    }
    
}
