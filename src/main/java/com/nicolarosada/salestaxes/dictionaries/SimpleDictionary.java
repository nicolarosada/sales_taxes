package com.nicolarosada.salestaxes.dictionaries;

import com.nicolarosada.salestaxes.datamodel.ProductCategory;

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

    public static ProductCategory findCategory(String word) {
        return dictionary.getOrDefault(word, ProductCategory.DEFAULT);
    }
}
