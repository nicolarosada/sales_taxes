package com.nicolarosada.salestaxes.dictionaries;

import com.nicolarosada.salestaxes.SalesTaxes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DatasetTest {

    @Test
    public void food() {
        String output =
                "1 baby back ribs: 10.00\n" +
                        "Sales Taxes: 0.00\n" +
                        "Total: 10.00\n";

        assertEquals(output, new SalesTaxes("1 baby back ribs at 10.00").getReceipt());
    }

    @Test
    public void books() {
        String output =
            "2 books: 20.00\n" +
                "Sales Taxes: 0.00\n" +
                "Total: 20.00\n";

        assertEquals(output, new SalesTaxes("2 books at 10.00").getReceipt());
    }

    @Test
    public void drugs() {
        String output =
            "1 écran total anti-intolérances solaires fps 30: 10.00\n" +
                "Sales Taxes: 0.00\n" +
                "Total: 10.00\n";

        assertEquals(output, new SalesTaxes("1 écran total anti-intolérances solaires fps 30 at 10.00").getReceipt());
    }
}
