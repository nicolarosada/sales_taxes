package com.nicolarosada.salestaxes.print;

import com.nicolarosada.salestaxes.datamodel.ShoppingItem;
import com.nicolarosada.salestaxes.taxes.TaxCalculator;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ReceiptPrinter {

    private static DecimalFormat df = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.ENGLISH));
    private final TaxCalculator taxCalculator;
    private String receipt = "";

    public ReceiptPrinter(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public String buildReceipt() {
        taxCalculator.getShoppingBasket().forEach(this::printReceiptLine);

        receipt += "Sales Taxes: " + df.format(taxCalculator.getTotalTaxes())
                + "\nTotal: " + df.format(taxCalculator.getTotalPriceAfterTax()) + "\n";

        return receipt;
    }

    private void printReceiptLine(ShoppingItem shoppingItem) {
        receipt += shoppingItem.getQuantity()
                + " " + shoppingItem.getName()
                + ": " + df.format(shoppingItem.getTotalPriceAfterTaxes())
                + "\n";
    }
}
