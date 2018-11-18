package com.bluespurs.lowpricefinder;

import com.bluespurs.lowpricefinder.searchengine.SearchEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    @Autowired
    private SearchEngine searchEngine;

    @RequestMapping("/search")
    public PriceItem search(@RequestParam(value = "name") String name) {
        return searchEngine.getPriceItem(name);
    }
}
