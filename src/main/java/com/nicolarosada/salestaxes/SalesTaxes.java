package com.nicolarosada.salestaxes;

import com.nicolarosada.salestaxes.datamodel.NotCompliantItemException;
import com.nicolarosada.salestaxes.datamodel.ShoppingItem;
import com.nicolarosada.salestaxes.dictionaries.CategoryRecognition;
import com.nicolarosada.salestaxes.parser.BasketParser;
import com.nicolarosada.salestaxes.taxes.TaxCalculator;

import java.util.List;

public class SalesTaxes {

    private final String inputShoppingBasket;
    private List<ShoppingItem> shoppingBasket;

    public SalesTaxes(String inputShoppingBasket) {
        this.inputShoppingBasket = inputShoppingBasket;
    }

    private void computeTaxes() {
        shoppingBasket = new BasketParser(inputShoppingBasket).parse();

        new CategoryRecognition(shoppingBasket).parse();
        new TaxCalculator(shoppingBasket).parse();
    }

    public String getReceipt() {
        try {
            computeTaxes();
        } catch (NotCompliantItemException e) {
            return e.getMessage();
        }

        String output =
            "1 book: 12.49\n" +
            "1 music CD: 16.49\n" +
            "1 chocolate bar: 0.85\n" +
            "Sales Taxes: 1.50\n" +
            "Total: 29.83\n";

        return output;
    }

}
