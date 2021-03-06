package com.nicolarosada.salestaxes.parser;

import com.nicolarosada.salestaxes.datamodel.NotCompliantItemException;
import com.nicolarosada.salestaxes.datamodel.ShoppingItem;

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
        int idx = partialLine.toLowerCase().indexOf("imported");
        if (idx != -1) {
            partialLine = partialLine.substring(0, idx).trim() + " " + partialLine.substring(idx + 8).trim();
            partialLine = "imported " + partialLine.trim();
        }

        shoppingItem.setName(partialLine);
    }

}
