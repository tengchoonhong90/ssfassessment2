package com.ssfassessment2.cryptonews.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ssfassessment2.cryptonews.models.NewsArticles;

@Service
public class NewsService {

    private static final Logger logger = LoggerFactory.getLogger(NewsService.class);
    
    @Value("${apiKey}")
    private String apiKey;

    private static String URL = "https://min-api.cryptocompare.com/data/v2/news/";

    public Optional<NewsArticles> getArticles(NewsArticles request) {
        String newsArticlesUrl = UriComponentsBuilder.fromUriString(URL)
                                                    .queryParam("lang", "EN")
                                                    .queryParam("api_key", apiKey)
                                                    .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = null;

        try{
            response = restTemplate.exchange(newsArticlesUrl, HttpMethod.GET, null, String.class);
            NewsArticles responseToJson = NewsArticles.createJson(response.getBody());
            return Optional.of(responseToJson);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            exception.printStackTrace();
        }

        return Optional.empty();
    }

}
