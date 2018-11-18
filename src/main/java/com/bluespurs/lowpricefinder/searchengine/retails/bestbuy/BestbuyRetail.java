package com.bluespurs.lowpricefinder.searchengine.retails.bestbuy;

import com.bluespurs.lowpricefinder.PriceItem;
import com.bluespurs.lowpricefinder.searchengine.retails.Retail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

@Service
public class BestbuyRetail implements Retail {
    @Value("${bestbuyApiKey}")
    private String bestbuyApiKey;

    private final RestTemplate restTemplate;

    public BestbuyRetail(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Collection<? extends PriceItem> search(String name) {
        List<PriceItem> items = new ArrayList<>();

        ResponseEntity<BestbuyResponce> exchange = getBestbuyResponceResponseEntity(name, 1);
        if (exchange != null) {
            BestbuyResponce bestbuyResponce = exchange.getBody();
            if (bestbuyResponce != null) {
                items.addAll(bestbuyResponce.getProducts());
            }
        }
        return items;

    }

    private ResponseEntity<BestbuyResponce> getBestbuyResponceResponseEntity(String name, int start) {
        String encodedName;
        try {
            encodedName = URLEncoder.encode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        return restTemplate.exchange("https://api.bestbuy.com/v1/products((search=" + encodedName + "))?apiKey=" + bestbuyApiKey + "&format=json&sort=salePrice.asc", HttpMethod.GET, entity, BestbuyResponce.class);
    }


}
