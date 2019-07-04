package com.nicolarosada.salestaxes.taxes;

import com.nicolarosada.salestaxes.SalesTaxes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxCalculatorTest {

    @Test
    public void taxRoundCeil1() {
        String output =
                "1 phone: 11.15\n" +
                        "Sales Taxes: 1.05\n" +
                        "Total: 11.15\n";

        assertEquals(output, new SalesTaxes("1 phone at 10.1").getReceipt());
    }

    @Test
    public void taxRoundCeil4() {
        String output =
                "1 phone: 11.45\n" +
                        "Sales Taxes: 1.05\n" +
                        "Total: 11.45\n";

        assertEquals(output, new SalesTaxes("1 phone at 10.4").getReceipt());
    }

    @Test
    public void taxRoundCeil49() {
        String output =
                "1 phone: 11.54\n" +
                        "Sales Taxes: 1.05\n" +
                        "Total: 11.54\n";

        assertEquals(output, new SalesTaxes("1 phone at 10.49").getReceipt());
    }

    @Test
    public void taxPrecision0() {
        String output =
                "1 phone: 11.00\n" +
                        "Sales Taxes: 1.00\n" +
                        "Total: 11.00\n";

        assertEquals(output, new SalesTaxes("1 phone at 10.00").getReceipt());
        assertEquals(output, new SalesTaxes("1 phone at 10.0").getReceipt());
        assertEquals(output, new SalesTaxes("1 phone at 10.").getReceipt());
        assertEquals(output, new SalesTaxes("1 phone at 10").getReceipt());
    }

    @Test
    public void taxQuantity() {
        String output =
                "2 phones: 21.80\n" +
                        "Sales Taxes: 2.00\n" +
                        "Total: 21.80\n";

        assertEquals(output, new SalesTaxes("2 phones at 9.9").getReceipt());
    }
}
