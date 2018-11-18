package com.bluespurs.lowpricefinder.searchengine;

import com.bluespurs.lowpricefinder.PriceItem;

public interface SearchEngine {

    PriceItem getPriceItem(String name);
}
