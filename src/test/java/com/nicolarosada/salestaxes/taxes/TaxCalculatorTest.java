package com.nicolarosada.salestaxes.taxes;

import com.nicolarosada.salestaxes.SalesTaxes;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxCalculatorTest {

    @Ignore
    @Test
    public void taxPrecision() {
        String output =
            "1 phone at: 9.9\n" +
            "Sales Taxes: 1.00\n" +
            "Total: 12.49\n";

        assertEquals(output, new SalesTaxes("1 phone at 9.9").getReceipt());
        assertEquals(output, new SalesTaxes("1 phone at 10.0").getReceipt());
        assertEquals(output, new SalesTaxes("1 phone at 10.1").getReceipt());
        assertEquals(output, new SalesTaxes("1 phone at 10.2").getReceipt());
        assertEquals(output, new SalesTaxes("1 phone at 10.3").getReceipt());
        assertEquals(output, new SalesTaxes("1 phone at 10.4").getReceipt());
    }

    @Ignore
    @Test
    public void taxQuantity() {
        String output =
            "1 phone at: 9.9\n" +
            "Sales Taxes: 1.00\n" +
            "Total: 12.49\n";

        assertEquals(output, new SalesTaxes("2 phone at 9.9").getReceipt());
    }
}
