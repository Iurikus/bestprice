package com.bluespurs.lowpricefinder.searchengine.retails.bestbuy;

import com.bluespurs.lowpricefinder.PriceItem;

public class BestbuyPriceItem extends PriceItem {

    public void setSalePrice(String salePrice) {
        setBestPrice(salePrice);
    }

    public void setName(String name) {
        super.setProductName(name);
    }

    public String getLocation() {
        return "bestbuy";
    }
}
