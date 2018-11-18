package com.bluespurs.lowpricefinder.searchengine;

import com.bluespurs.lowpricefinder.PriceItem;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class LowPriceSearchEngine extends MultiRetailSearchEngine {

    @Override
    public PriceItem getPriceItem(String name) {
        List<PriceItem> priceItems = getPriceItems(name);
        if (priceItems != null && priceItems.size() > 0) {
            priceItems.sort(Comparator.comparingInt(o -> (int) (Double.parseDouble(o.getBestPrice()) * 100)));
            return priceItems.get(0);
        }

        return null;
    }
}
