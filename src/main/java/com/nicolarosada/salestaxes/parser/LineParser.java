package com.nicolarosada.salestaxes.parser;

import com.nicolarosada.salestaxes.datamodel.NotCompliantItemException;
import com.nicolarosada.salestaxes.datamodel.ProductCategory;
import com.nicolarosada.salestaxes.datamodel.ShoppingItem;
import com.nicolarosada.salestaxes.datamodel.TaxCategory;
import com.nicolarosada.salestaxes.dictionaries.SimpleDictionary;

public class LineParser {

    private String partialLine;
    private ShoppingItem shoppingItem = new ShoppingItem();

    public LineParser(String line) {
        partialLine = line;
    }

    public LineParser parse() throws NotCompliantItemException {
        parseQuantity();
        parseUnitPrice();
        parseName();
        parseTaxCategory();

        return this;
    }

    public ShoppingItem getShoppingItem() {
        return shoppingItem;
    }

    private void parseQuantity() {
        String[] split = partialLine.trim().split(" ", 2);
        if (split.length != 2)
            throw new NotCompliantItemException("Item is not compliant with the shopping basket syntax");

        try {
            shoppingItem.setQuantity(Integer.parseInt(split[0]));
        } catch (NumberFormatException e) {
            throw new NotCompliantItemException("Quantity not compliant");
        }

        partialLine = split[1];
    }

    private void parseUnitPrice() {
        int idx = partialLine.toLowerCase().lastIndexOf(" at ");
        if (idx < 0)
            throw new NotCompliantItemException("Item is not compliant with the shopping basket syntax");

        String price = partialLine.substring(idx + 4);
        try {
            shoppingItem.setUnitPrice(Float.parseFloat(price.replaceAll(",", ".")));
        } catch (NumberFormatException e) {
            throw new NotCompliantItemException("Unit price not compliant");
        }

        partialLine = partialLine.substring(0, idx);
    }

    private void parseName() {
        shoppingItem.setName(partialLine);
    }

    private void parseTaxCategory() {
        TaxCategory taxCategory = new TaxCategory();

        if (shoppingItem
            .getName()
            .toLowerCase()
            .contains("imported")) {
            taxCategory.setImported(true);
        }

        String[] words = shoppingItem.getName().toLowerCase().split(" ");
        for (String word: words) {
            ProductCategory wordCategory = SimpleDictionary.findCategory(word);//mapper
            if (wordCategory != ProductCategory.DEFAULT) {
                taxCategory.setProductCategory(wordCategory);
                break;
            }
        }

        shoppingItem.setTaxCategory(taxCategory);
    }
}
