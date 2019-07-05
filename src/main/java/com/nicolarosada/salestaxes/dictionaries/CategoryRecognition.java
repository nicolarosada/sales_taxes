package com.nicolarosada.salestaxes.dictionaries;

import com.nicolarosada.salestaxes.datamodel.ShoppingItem;
import com.nicolarosada.salestaxes.datamodel.TaxCategory;
import com.nicolarosada.salestaxes.parser.ShoppingBasketParser;

import java.util.List;

public class CategoryRecognition extends ShoppingBasketParser {

    public CategoryRecognition(List<ShoppingItem> shoppingBasket) {
        super(shoppingBasket);
    }

    protected void apply(ShoppingItem shoppingItem) {
        //TaxCategory taxCategory = SimpleDictionary.findTaxCategory(shoppingItem);
        TaxCategory taxCategory = FullDictionary.findTaxCategory(shoppingItem);
        shoppingItem.setTaxCategory(taxCategory);
    }
}
