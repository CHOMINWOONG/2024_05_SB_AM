package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.vo.Article;

@Controller
public class UsrArticleController {
	
	private int lastArticleId;
	private List<Article> articles;
	
	public UsrArticleController() {
		this.lastArticleId = 0;
		this.articles = new ArrayList<>();
		
		makeTestDate();
	}
	private void makeTestDate() {
		for(int i = 1; i <= 10; i++) {
			String title = "제목" + i;
			String body = "내용" + i;
			
			writeArticle(title, body);
		}
		
	}
	private Article writeArticle(String title, String body) {
		// TODO Auto-generated method stub
		Article article = new Article(++lastArticleId, title, body);
		this.articles.add(article);
		return article;
	}
	@GetMapping("/usr/article/doWrite")
	@ResponseBody 
	public Article doWrite(String title, String body) {
		
		return writeArticle(title, body);
	}
	
	@GetMapping("/usr/article/showList")
	@ResponseBody 
	public List<Article> showList() {
		return this.articles;
	}
	
    @Autowired
    private Article articleRepository;

    // 상세보기 기능
    @GetMapping("/usr/article/showDetail")
    public ResponseEntity<Article> getArticle(@PathVariable Long id) {
        Optional<Article> article = articleRepository.findById(id);
        return article.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
