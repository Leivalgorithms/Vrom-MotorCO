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
public class PercentageDiscountTest {
    
    public PercentageDiscountTest() {
    }

    @Test
    public void PercentageDiscounttest() {
        // Crear un objeto PercentageDiscount con un descuento del 20%
        DiscountStrategy discount = new PercentageDiscount(20);

        // Aplicar el descuento a un precio original de 100
        double discountedPrice = discount.applyDiscount(100);

        // Verificar que el precio descontado sea el esperado (80 en este caso)
        assertEquals(80.0, discountedPrice, 0.01);
    }
    
}
