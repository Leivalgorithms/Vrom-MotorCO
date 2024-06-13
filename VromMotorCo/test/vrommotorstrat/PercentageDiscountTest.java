/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotorstrat;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import vrommotorstrat.PercentageDiscount;

public class PercentageDiscountTest {

    @Test
    public void testApplyDiscount() {
        double originalPrice = 100.0; // Precio original
        double discountPercentage = 20.0; // Porcentaje de descuento

        PercentageDiscount percentageDiscount = new PercentageDiscount(discountPercentage);
        double discountedPrice = percentageDiscount.applyDiscount(originalPrice);

        double expectedPrice = 80.0; // Precio esperado después del descuento

        assertEquals(expectedPrice, discountedPrice, 0.01);
        // Verificar si el descuento se aplicó correctamente al precio original.
    }
}
