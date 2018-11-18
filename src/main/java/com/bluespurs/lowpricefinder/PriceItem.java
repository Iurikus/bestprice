package com.bluespurs.lowpricefinder;

public abstract class PriceItem {
    private String productName;
    private String bestPrice;

    protected void setProductName(String productName) {
        this.productName = productName;
    }

    protected void setBestPrice(String bestPrice) {
        this.bestPrice = bestPrice;
    }

    public String getProductName() {
        return productName;
    }

    public String getBestPrice() {
        return bestPrice;
    }

    public String getCurrency() {
        return "cad";
    }

    abstract public String getLocation();
}
