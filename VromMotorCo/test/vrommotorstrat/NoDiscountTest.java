/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotorstrat;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import vrommotorstrat.NoDiscount;

public class NoDiscountTest {

    @Test
    public void testApplyDiscount() {
        double originalPrice = 100.0; // Precio original
        
        NoDiscount noDiscount = new NoDiscount();
        double discountedPrice = noDiscount.applyDiscount(originalPrice);

        assertEquals(originalPrice, discountedPrice, 0.01);
        // Verificar si el precio se mantiene sin cambios al aplicar la estrategia de no descuento.
    }
}
