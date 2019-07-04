package com.nicolarosada.salestaxes.taxes;

import com.nicolarosada.salestaxes.datamodel.ProductCategory;
import com.nicolarosada.salestaxes.datamodel.ShoppingItem;
import com.nicolarosada.salestaxes.datamodel.TaxCategory;
import com.nicolarosada.salestaxes.parser.ShoppingBasketParser;

import java.util.HashMap;
import java.util.List;

public class TaxCalculator extends ShoppingBasketParser {

    private static final float IMPORTED_TAX_RATE = 0.05f;
    private static final HashMap<ProductCategory, Float> CATEGORY_TAX_RATE = categoryTaxRateConstructor();

    public TaxCalculator(List<ShoppingItem> shoppingBasket) {
        super(shoppingBasket);
    }

    private static HashMap<ProductCategory, Float> categoryTaxRateConstructor() {
        return new HashMap<ProductCategory, Float>() {
            {
                put(ProductCategory.DEFAULT, 0.10f);
                put(ProductCategory.EXEMPT, 0.00f);
            }
        };
    }

    protected void apply(ShoppingItem shoppingItem) {
        float totalTaxes = shoppingItem.getTotalPricePreTaxes() * computeTaxes(shoppingItem.getTaxCategory());
        totalTaxes = Math.round(totalTaxes * 20.0f) / 20.0f;

        shoppingItem.setTotalTaxes(totalTaxes);
    }

    private float computeTaxes(TaxCategory taxCategory) {
        float taxRate = CATEGORY_TAX_RATE.get(taxCategory.getProductCategory());

        if (taxCategory.isImported())
            taxRate += IMPORTED_TAX_RATE;

        return taxRate;
    }
}
