package com.ssfassessment2.cryptonews.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssfassessment2.cryptonews.services.NewsService;

@Controller
public class NewsArticlesController {

    // @Autowired
    // private NewsService newsService;

    private static final Logger logger = LoggerFactory.getLogger(NewsArticlesController.class);
    
    @GetMapping("/")

    public String showNewsArticlePage(Model model) {
        return "newsArticle";
    }

}
