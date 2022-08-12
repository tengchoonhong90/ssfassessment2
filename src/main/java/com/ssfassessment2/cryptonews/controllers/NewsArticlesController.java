package com.ssfassessment2.cryptonews.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ssfassessment2.cryptonews.models.NewsArticles;
import com.ssfassessment2.cryptonews.services.NewsService;

@Controller
public class NewsArticlesController {

    @Autowired
    private NewsService newsService;

    private static final Logger logger = LoggerFactory.getLogger(NewsArticlesController.class);
    
    @GetMapping(path = "/", produces= "text/html")

    public String showNewsArticlePage(Model model, @ModelAttribute NewsArticles requestArticles) {
        NewsArticles request = requestArticles;
        NewsArticles response = newsService.getArticles(request).get();

        model.addAttribute("response", response);
        
        return "newsArticle";
    }

}
