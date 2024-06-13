/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotorco;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InvoiceTest {

    private Invoice invoice;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        invoice = new Invoice();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testInitialTotalPriceIsZero() {
        assertEquals(0.0, invoice.getTotalPrice(), 0.01);
    }

    @Test
    public void testAddItem() {
        invoice.addItem("Item 1", 50.0);
        assertEquals(50.0, invoice.getTotalPrice(), 0.01);
    }

    @Test
    public void testPrintInvoice() {
        invoice.addItem("Item 1", 50.0);
        invoice.addItem("Item 2", 75.0);

        invoice.printInvoice();
        String expectedOutput = "---------- Recibo ----------\nItem 1\nItem 2\n\nPrecio total: $125.0\n";

        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
