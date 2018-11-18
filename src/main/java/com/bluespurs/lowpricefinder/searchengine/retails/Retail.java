package com.bluespurs.lowpricefinder.searchengine.retails;

import com.bluespurs.lowpricefinder.PriceItem;

import java.util.Collection;

public interface Retail {
    Collection<? extends PriceItem> search(String name);
}
