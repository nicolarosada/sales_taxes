package com.nicolarosada.salestaxes.parser;

import com.nicolarosada.salestaxes.SalesTaxes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserErrorsTest {

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
}
