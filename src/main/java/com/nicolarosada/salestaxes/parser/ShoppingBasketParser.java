package com.nicolarosada.salestaxes.parser;

import com.nicolarosada.salestaxes.datamodel.ShoppingItem;

import java.util.List;


public abstract class ShoppingBasketParser {

    private final List<ShoppingItem> shoppingBasket;

    public ShoppingBasketParser(List<ShoppingItem> shoppingBasket) {
        this.shoppingBasket = shoppingBasket;
    }

    public void parse() {
        shoppingBasket.forEach(this::apply);
    }

    protected abstract void apply(ShoppingItem shoppingItem);
}
