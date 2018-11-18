package com.bluespurs.lowpricefinder.searchengine;

import com.bluespurs.lowpricefinder.PriceItem;
import com.bluespurs.lowpricefinder.searchengine.retails.Retail;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class MultiRetailSearchEngine implements SearchEngine {

    private List<Retail> retails;

    @Autowired(required = false)
    public void setRetails(List<Retail> retails) {
        this.retails = retails;
    }

    @Override
    public PriceItem getPriceItem(String name) {
        List<PriceItem> priceItems = getPriceItems(name);
        if (priceItems != null && priceItems.size() > 0) {
            return priceItems.get(0);
        }
        return null;
    }

    public List<PriceItem> getPriceItems(String name) {
        List<PriceItem> priceItems = new ArrayList<>();
        for (Retail retail : retails) {
            priceItems.addAll(retail.search(name));
        }
        return priceItems;
    }
}
