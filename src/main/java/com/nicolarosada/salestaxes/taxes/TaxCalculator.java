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

    private float totalTaxes = 0.00f;
    private float totalPriceAfterTax = 0.00f;

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
        float taxes = shoppingItem.getTotalPricePreTaxes() * computeTaxes(shoppingItem.getTaxCategory());
        taxes = Math.round(taxes * 20.0f) / 20.0f;
        shoppingItem.setTotalTaxes(taxes);

        totalTaxes += shoppingItem.getTotalTaxes();
        totalPriceAfterTax += shoppingItem.getTotalPriceAfterTaxes();
    }

    private float computeTaxes(TaxCategory taxCategory) {
        float taxRate = CATEGORY_TAX_RATE.get(taxCategory.getProductCategory());

        if (taxCategory.isImported())
            taxRate += IMPORTED_TAX_RATE;

        return taxRate;
    }

    public float getTotalTaxes() {
        return totalTaxes;
    }

    public float getTotalPriceAfterTax() {
        return totalPriceAfterTax;
    }
}
