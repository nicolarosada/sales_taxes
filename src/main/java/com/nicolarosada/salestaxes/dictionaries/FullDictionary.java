package com.nicolarosada.salestaxes.dictionaries;

import com.nicolarosada.salestaxes.datamodel.ProductCategory;
import com.nicolarosada.salestaxes.datamodel.ShoppingItem;
import com.nicolarosada.salestaxes.datamodel.TaxCategory;
import com.nicolarosada.salestaxes.dictionaries.json.CategoryDataset;
import com.nicolarosada.salestaxes.dictionaries.json.JsonReader;
import com.nicolarosada.salestaxes.dictionaries.utils.StringGroup;

import java.util.HashMap;


public class FullDictionary {

  private static final HashMap<String, ProductCategory> dictionary = dictionaryConstructor();

  private static HashMap<String, ProductCategory> dictionaryConstructor() {
    HashMap<String, ProductCategory> dict = new HashMap<>();

    CategoryDataset dataset = JsonReader.read();
    dataset.getBooks().forEach(entry -> dict.put(entry, ProductCategory.EXEMPT));
    dataset.getDrugs().forEach(entry -> dict.put(entry, ProductCategory.EXEMPT));
    dataset.getFood().forEach(entry -> dict.put(entry, ProductCategory.EXEMPT));

    return dict;
  }

  public static TaxCategory findTaxCategory(ShoppingItem shoppingItem) {
    TaxCategory taxCategory = new TaxCategory();
    String name = shoppingItem.getName().toLowerCase();

    // Find imported key
    if (name.startsWith("imported ")) {
      taxCategory.setImported(true);
      name = name.substring(9);
    }

    // Find keywords into data set
    String[] splitName = name.split(" ");
    for (int groupSize = 1; groupSize <= splitName.length; groupSize++) {
      StringGroup stringGroup = new StringGroup(splitName, groupSize);
      String shortName = stringGroup.next();

      while (shortName != null) {
        ProductCategory wordCategory = dictionary.get(shortName);
        if (wordCategory != null) {
          taxCategory.setProductCategory(wordCategory);
          break;
        }

        shortName = stringGroup.next();
      }
    }

    return taxCategory;
  }
}
