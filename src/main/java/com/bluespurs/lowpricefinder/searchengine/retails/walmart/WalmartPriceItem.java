package com.bluespurs.lowpricefinder.searchengine.retails.walmart;


import com.bluespurs.lowpricefinder.PriceItem;

public class WalmartPriceItem extends PriceItem {

    public WalmartPriceItem() {
    }

    public void setSalePrice(String salePrice) {
        setBestPrice(salePrice);
    }

    public void setName(String name) {
        setProductName(name);
    }

    @Override
    public String getLocation() {
        return "walmart";
    }
}
