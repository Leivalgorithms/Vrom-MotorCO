/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vrommotorstrat;

/**
 *
 * @author leiva
 */
public class NoDiscount implements DiscountStrategy {
    
    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice; 
    }
}
