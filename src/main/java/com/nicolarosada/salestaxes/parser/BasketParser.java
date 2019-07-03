package com.nicolarosada.salestaxes.parser;

import com.nicolarosada.salestaxes.datamodel.ShoppingItem;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class BasketParser {

    private final String inputShoppingBasket;
    private List<ShoppingItem> shoppingBasket = new ArrayList<>();

    public BasketParser(String inputShoppingBasket) {
        this.inputShoppingBasket = inputShoppingBasket;
    }

    public List<ShoppingItem> parse() {
        new BufferedReader(new StringReader(inputShoppingBasket))
            .lines()
            .forEach(this::parseLine);

        return shoppingBasket;
    }

    private void parseLine(String line) {

        ShoppingItem item = new LineParser(line)
            .parse()
            .getShoppingItem();

        shoppingBasket.add(item);
    }
}
