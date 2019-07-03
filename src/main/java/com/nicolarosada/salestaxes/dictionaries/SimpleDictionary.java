package com.nicolarosada.salestaxes.dictionaries;

import com.nicolarosada.salestaxes.datamodel.ProductCategory;

import java.util.HashMap;

public class SimpleDictionary {
    private static final HashMap<String, ProductCategory> dictionary = SimpleDictionaryConstructor();

    private static HashMap<String, ProductCategory> SimpleDictionaryConstructor() {
        return new HashMap<String, ProductCategory>() {
            {
                put("book", ProductCategory.BOOKS);
                put("books", ProductCategory.BOOKS);

                put("chocolate", ProductCategory.FOOD);
                put("chocolates", ProductCategory.FOOD);

                put("headache", ProductCategory.MEDICAL);
            }
        };
    }

    public static ProductCategory findCategory(String word) {
        return dictionary.getOrDefault(word, ProductCategory.DEFAULT);
    }
}
