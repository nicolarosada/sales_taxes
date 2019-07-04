package com.nicolarosada.salestaxes.datamodel;

public class ShoppingItem {

    private int quantity;
    private String name;
    private float unitPrice;
    private TaxCategory taxCategory;
    private float totalTaxes;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public TaxCategory getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(TaxCategory taxCategory) {
        this.taxCategory = taxCategory;
    }

    public float getTotalTaxes() {
        return totalTaxes;
    }

    public void setTotalTaxes(float totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public float getTotalPricePreTaxes() {
        return quantity * unitPrice;
    }

    public float getTotalPriceAfterTaxes() {
        return getTotalPricePreTaxes() + totalTaxes;
    }
}
