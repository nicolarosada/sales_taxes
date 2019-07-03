package com.nicolarosada.salestaxes;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class SalesTaxesTest {

    @Test
    public void input1() {
        String input =
            "1 book at 12.49\n" +
            "1 music CD at 14.99\n" +
            "1 chocolate bar at 0.85\n";

        String output =
            "1 book : 12.49\n" +
            "1 music CD: 16.49\n" +
            "1 chocolate bar: 0.85\n" +
            "Sales Taxes: 1.50\n" +
            "Total: 29.83\n";

        assertEquals(output, SalesTaxes.receipt(input));
    }
}
