package com.ssfassessment2.cryptonews.models;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.sql.Array;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;

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
            JsonValue data = o.get("Data");
            Gson gson = new Gson();

            Type collectionType = new TypeToken<Collection<NewsArticles>>(){}.getType();
            Collection<NewsArticles> art = gson.fromJson(data.toString(), collectionType);
            Object placeholder = art.toArray()[0];
            
            logger.info("data === " + placeholder );

            
            
        } 

        return payload;
    }

    public static NewsArticles createJson(JsonObject jObj) {
        NewsArticles newsArticle = new NewsArticles();
        newsArticle.setId(jObj.getInt("id"));
        newsArticle.setNewsTitle(jObj.getString("title"));
        newsArticle.setNewsBody(jObj.getString("body"));
        newsArticle.setPublishedOn(jObj.getInt("published_on"));
        newsArticle.setNewsUrl(jObj.getString("url"));
        newsArticle.setNewsImageUrl(jObj.getString("imageurl"));
        newsArticle.setNewsTag(jObj.getString("tags"));
        newsArticle.setNewsCategories(jObj.getString("categories"));

        return newsArticle;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
            .add("id", id)
            .add("title", newsTitle)
            .add("body", newsBody)
            .add("published_on", publishedOn)
            .add("url", newsUrl)
            .add("imageurl", newsImageUrl)
            .add("tags", newsTag)
            .add("categories", newsCategories)
            .build();
    }

}
