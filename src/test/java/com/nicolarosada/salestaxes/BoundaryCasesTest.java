package com.nicolarosada.salestaxes;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoundaryCasesTest {

    @Ignore
    @Test
    public void noNewLine() {
        String input = "1 BOOK AT 12.49";
        String output =
            "1 BOOK: 12.49\n" +
            "Sales Taxes: 0.00\n" +
            "Total: 12.49\n";

        assertEquals(output, new SalesTaxes(input).getReceipt());
    }

    @Ignore
    @Test
    public void moreSpaces() {
        String input = " 1 book   at 12.49 ";
        String output =
            "1 BOOK: 12.49\n" +
            "Sales Taxes: 0.00\n" +
            "Total: 12.49\n";

        assertEquals(output, new SalesTaxes(input).getReceipt());
    }

    @Test
    public void wrongSyntax() {
        String input = "1bookat12.49";
        String output = "Item is not compliant with the shopping basket syntax";

        assertEquals(output, new SalesTaxes(input).getReceipt());
    }

    @Test
    public void noquantity() {
        String input = "book at 12.49";
        String output = "Quantity not compliant";

        assertEquals(output, new SalesTaxes(input).getReceipt());
    }

    @Test
    public void notCompliantUnitPrice() {
        String input = "1 book at12.49";
        String output = "Item is not compliant with the shopping basket syntax";

        assertEquals(output, new SalesTaxes(input).getReceipt());
    }

    @Ignore
    @Test
    public void commaUnitPrice() {
        String input = "1 book at 12,49";
        String output =
            "1 BOOK: 12.49\n" +
            "Sales Taxes: 0.00\n" +
            "Total: 12.49\n";

        assertEquals(output, new SalesTaxes(input).getReceipt());
    }

    @Ignore
    @Test
    public void doubleAt() {
        String input = "1 book at at 12.49";
        String output =
                "1 book at: 12.49\n" +
                "Sales Taxes: 0.00\n" +
                "Total: 12.49\n";

        assertEquals(output, new SalesTaxes(input).getReceipt());
    }
}
