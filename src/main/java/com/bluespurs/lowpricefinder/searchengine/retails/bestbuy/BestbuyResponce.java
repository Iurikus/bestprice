package com.bluespurs.lowpricefinder.searchengine.retails.bestbuy;

import java.util.List;

public class BestbuyResponce  {

    private List<BestbuyPriceItem> products;
    private int from;
    private int to;
    private int total;

    void setProducts(List<BestbuyPriceItem> products) {
        this.products = products;
    }

    List<BestbuyPriceItem> getProducts() {
        return products;
    }

    int getFrom() {
        return from;
    }

    void setFrom(int from) {
        this.from = from;
    }

    int getTo() {
        return to;
    }

    void setTo(int to) {
        this.to = to;
    }

    int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
