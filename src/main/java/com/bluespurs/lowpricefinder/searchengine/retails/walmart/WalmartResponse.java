package com.bluespurs.lowpricefinder.searchengine.retails.walmart;

import java.util.List;

public class WalmartResponse {
    private List<WalmartPriceItem> items;
    private int totalResults;
    private int start;
    private int numItems;

    public WalmartResponse() {
    }

    List<WalmartPriceItem> getItems() {
        return items;
    }

    void setItems(List<WalmartPriceItem> items) {
        this.items = items;
    }

    void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    void setStart(int start) {
        this.start = start;
    }

    void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    int getTotalResults() {
        return totalResults;
    }

    int getStart() {
        return start;
    }

    int getNumItems() {
        return numItems;
    }
}
