package com.bluespurs.lowpricefinder.searchengine.retails.walmart;

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
public class WalmartRetail implements Retail {
    @Value("${walmartApiKey}")
    private String walmartApiKey;

    private final RestTemplate restTemplate;

    public WalmartRetail(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Collection<? extends PriceItem> search(String name) {
        List<PriceItem> items = new ArrayList<>();

        ResponseEntity<WalmartResponse> exchange = getWalmartResponceResponseEntity(name, 1);
        if (exchange != null) {
            WalmartResponse walmartResponse = exchange.getBody();
            if (walmartResponse != null) {
                items.addAll(walmartResponse.getItems());
            }
        }
        return items;
    }

    private ResponseEntity<WalmartResponse> getWalmartResponceResponseEntity(String name, int start) {
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

        return restTemplate.exchange("http://api.walmartlabs.com/v1/search?apiKey=" + walmartApiKey + "&query=" + encodedName + "&sort=price&order=asc&start=" + start, HttpMethod.GET, entity, WalmartResponse.class);
    }


}
