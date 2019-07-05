package com.nicolarosada.salestaxes.dictionaries;

import com.nicolarosada.salestaxes.datamodel.ProductCategory;
import com.nicolarosada.salestaxes.datamodel.ShoppingItem;
import com.nicolarosada.salestaxes.datamodel.TaxCategory;

import java.util.HashMap;

public class SimpleDictionary {
    private static final HashMap<String, ProductCategory> dictionary = simpleDictionaryConstructor();

    private static HashMap<String, ProductCategory> simpleDictionaryConstructor() {
        return new HashMap<String, ProductCategory>() {
            {
                put("book", ProductCategory.EXEMPT);
                put("books", ProductCategory.EXEMPT);

                put("chocolate", ProductCategory.EXEMPT);
                put("chocolates", ProductCategory.EXEMPT);

                put("headache", ProductCategory.EXEMPT);
            }
        };
    }

    public static TaxCategory findTaxCategory(ShoppingItem shoppingItem) {
        TaxCategory taxCategory = new TaxCategory();

        if (shoppingItem
            .getName()
            .toLowerCase()
            .contains("imported")) {
            taxCategory.setImported(true);
        }

        String[] words = shoppingItem.getName().toLowerCase().split(" ");
        for (String word : words) {
            ProductCategory wordCategory = SimpleDictionary.findCategory(word);//mapper
            if (wordCategory != ProductCategory.DEFAULT) {
                taxCategory.setProductCategory(wordCategory);
                break;
            }
        }

        return taxCategory;
    }

    private static ProductCategory findCategory(String word) {
        return dictionary.getOrDefault(word, ProductCategory.DEFAULT);
    }
}
