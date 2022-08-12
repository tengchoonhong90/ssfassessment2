package com.ssfassessment2.cryptonews.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NewsArticleRepository {


    @Autowired
    @Qualifier("redisArticles")
    private RedisTemplate<String, String> redisTemplate;


    public String getIdFromRepo(String id){
        return id;
    }
    
}
