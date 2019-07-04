package com.nicolarosada.salestaxes.dictionaries;

import com.nicolarosada.salestaxes.datamodel.ProductCategory;
import com.nicolarosada.salestaxes.datamodel.ShoppingItem;
import com.nicolarosada.salestaxes.datamodel.TaxCategory;

import java.util.List;

public class CategoryRecognition {

    private final List<ShoppingItem> shoppingBasket;

    public CategoryRecognition(List<ShoppingItem> shoppingBasket) {
        this.shoppingBasket = shoppingBasket;
    }

    public void parse() {
        shoppingBasket.forEach(this::applyCategory);
    }

    private void applyCategory(ShoppingItem shoppingItem) {
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
