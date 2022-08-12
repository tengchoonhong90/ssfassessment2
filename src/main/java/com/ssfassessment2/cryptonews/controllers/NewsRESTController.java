package com.ssfassessment2.cryptonews.controllers;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssfassessment2.cryptonews.models.NewsArticles;
import com.ssfassessment2.cryptonews.services.NewsService;

import jakarta.json.Json;
import jakarta.json.JsonObject;

@RestController
@RequestMapping(path = "/news", produces = "application/json")
public class NewsRESTController {

    @Autowired
    private NewsService newsService;

    private static final Logger logger = LoggerFactory.getLogger(NewsArticles.class);

    @GetMapping(value = "{id}")
    public ResponseEntity<String> getNewsArticle(@PathVariable (name="id") String id) throws IOException {
        Optional<NewsArticles> article = newsService.getNewsArticleById(id);

        if (article.isEmpty()) {
            JsonObject err = Json.createObjectBuilder()
                                .add("error", "Id %s not found".formatted(id))
                                .build();
            
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err.toString());
        }

        NewsArticles newsArticles = article.get();
        return ResponseEntity.ok(newsArticles.toJson().toString());
    }
    
}
