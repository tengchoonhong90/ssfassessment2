package com.ssfassessment2.cryptonews.models;

public class NewsArticles {
    
    private int id;
    private int publishedOn;
    private String newsTitle;
    private String newsUrl;
    private String newsImageUrl;
    private String newsBody;
    private String newsTag;
    private String newsCategories;

    
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

}
