package com.nicolarosada.salestaxes;

import com.nicolarosada.salestaxes.datamodel.NotCompliantItemException;
import com.nicolarosada.salestaxes.datamodel.ShoppingItem;
import com.nicolarosada.salestaxes.dictionaries.CategoryRecognition;
import com.nicolarosada.salestaxes.parser.BasketParser;
import com.nicolarosada.salestaxes.print.ReceiptPrinter;
import com.nicolarosada.salestaxes.taxes.TaxCalculator;

import java.util.List;

public class SalesTaxes {

    private final String inputShoppingBasket;
    private TaxCalculator taxCalculator;

    public SalesTaxes(String inputShoppingBasket) {
        this.inputShoppingBasket = inputShoppingBasket;
    }

    public String getReceipt() {
        try {
            computeTaxes();
        } catch (NotCompliantItemException e) {
            return e.getMessage();
        }

        ReceiptPrinter printer = new ReceiptPrinter(taxCalculator);
        return printer.buildReceipt();
    }

    private void computeTaxes() {
        // Read input
        List<ShoppingItem> shoppingBasket = new BasketParser(inputShoppingBasket).parse();

        // Assign the category to the entries
        new CategoryRecognition(shoppingBasket).parse();

        // Compute taxes for every entry
        taxCalculator = new TaxCalculator(shoppingBasket);
        taxCalculator.parse();
    }
}
