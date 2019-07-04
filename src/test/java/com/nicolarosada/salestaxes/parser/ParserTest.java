package com.nicolarosada.salestaxes.parser;

import com.nicolarosada.salestaxes.SalesTaxes;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

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
