package com.ssfassessment2.cryptonews.models;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class NewsArticles {
    
    private int id;
    private int publishedOn;
    private String newsTitle;
    private String newsUrl;
    private String newsImageUrl;
    private String newsBody;
    private String newsTag;
    private String newsCategories;

    private static final Logger logger = LoggerFactory.getLogger(NewsArticles.class);

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPublishedOn() {
        return publishedOn;
    }
    public void setPublishedOn(int publishedOn) {
        this.publishedOn = publishedOn;
    }
    public String getNewsTitle() {
        return newsTitle;
    }
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }
    public String getNewsUrl() {
        return newsUrl;
    }
    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }
    public String getNewsImageUrl() {
        return newsImageUrl;
    }
    public void setNewsImageUrl(String newsImageUrl) {
        this.newsImageUrl = newsImageUrl;
    }
    public String getNewsBody() {
        return newsBody;
    }
    public void setNewsBody(String newsBody) {
        this.newsBody = newsBody;
    }
    public String getNewsTag() {
        return newsTag;
    }
    public void setNewsTag(String newsTag) {
        this.newsTag = newsTag;
    }
    public String getNewsCategories() {
        return newsCategories;
    }
    public void setNewsCategories(String newsCategories) {
        this.newsCategories = newsCategories;
    }


    public static NewsArticles createJson(String json) throws IOException {
        NewsArticles payload = new NewsArticles();

        try(InputStream is = new ByteArrayInputStream(json.getBytes())) {
            JsonReader r = Json.createReader(is);
            JsonObject o = r.readObject();
            JsonArray array = o.asJsonArray();

            logger.info(">>>>>>>" + o.toString());
            // logger.info("array >>>>>> " + array);
            
        }
        return payload; 
    }

}
