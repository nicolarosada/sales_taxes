package com.nicolarosada.salestaxes.parser;

import com.nicolarosada.salestaxes.SalesTaxes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void noNewLine() {
        String input = "1 BOOK AT 12.49";
        String output =
                "1 BOOK: 12.49\n" +
                        "Sales Taxes: 0.00\n" +
                        "Total: 12.49\n";

        assertEquals(output, new SalesTaxes(input).getReceipt());
    }

    @Test
    public void moreSpaces() {
        String input = " 1 book   at 12.49 ";
        String output =
                "1 book  : 12.49\n" +
                        "Sales Taxes: 0.00\n" +
                        "Total: 12.49\n";

        assertEquals(output, new SalesTaxes(input).getReceipt());
    }

    @Test
    public void commaUnitPrice() {
        String input = "1 book at 12,49";
        String output =
                "1 book: 12.49\n" +
                        "Sales Taxes: 0.00\n" +
                        "Total: 12.49\n";

        assertEquals(output, new SalesTaxes(input).getReceipt());
    }

    @Test
    public void doubleAt() {
        String input = "1 book at at 12.49";
        String output =
                "1 book at: 12.49\n" +
                        "Sales Taxes: 0.00\n" +
                        "Total: 12.49\n";

        assertEquals(output, new SalesTaxes(input).getReceipt());
    }

    @Test
    public void importedKey() {
        String input = "1 IMPORTED book at 12.49";
        String output =
                "1 imported book: 13.14\n" +
                        "Sales Taxes: 0.65\n" +
                        "Total: 13.14\n";

        assertEquals(output, new SalesTaxes(input).getReceipt());
    }

    @Test
    public void importedKeyMiddle() {
        String input = "1 box of IMPORTED chocolates at 12.49";
        String output =
                "1 imported box of chocolates: 13.14\n" +
                        "Sales Taxes: 0.65\n" +
                        "Total: 13.14\n";

        assertEquals(output, new SalesTaxes(input).getReceipt());
    }

    @Test
    public void importedKeyEnd() {
        String input = "1 box of chocolates IMpoRTeD at 12.49";
        String output =
                "1 imported box of chocolates: 13.14\n" +
                        "Sales Taxes: 0.65\n" +
                        "Total: 13.14\n";

        assertEquals(output, new SalesTaxes(input).getReceipt());
    }
}
