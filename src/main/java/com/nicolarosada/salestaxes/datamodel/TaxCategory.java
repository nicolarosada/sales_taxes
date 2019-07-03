package com.nicolarosada.salestaxes.datamodel;

public class TaxCategory {
    private boolean imported = false;
    private ProductCategory productCategory = ProductCategory.DEFAULT;

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
