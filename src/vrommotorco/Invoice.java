/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vrommotorco;

/**
 *
 * @author leiva
 */
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private List<String> items;
    private double totalPrice;

    public Invoice() {
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public void addItem(String item, double price) {
        items.add(item);
        totalPrice += price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void printInvoice() {
        System.out.println("---------- Recibo ----------");
        for (String item : items) {
            System.out.println(item);
        }
        System.out.println("\nPrecio total: $" + totalPrice);
    }
}