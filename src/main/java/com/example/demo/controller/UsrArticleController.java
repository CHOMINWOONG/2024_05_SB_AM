package com.example.demo.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.ArticleService;
import com.example.demo.util.Util;
import com.example.demo.vo.Article;
import com.example.demo.vo.ResultData;
import com.example.demo.vo.Rq;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UsrArticleController {
	
	private ArticleService articleService;
	
	public UsrArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@GetMapping("/usr/article/write")
	public String write() {
		
		return "usr/article/write";
	}
	
	@GetMapping("/usr/article/doWrite")
	@ResponseBody
	public String doWrite(HttpServletRequest req, String title, String body) {
		
		Rq rq = (Rq) req.getAttribute("rq");
		
		articleService.writeArticle(rq.getLoginedMemberId(), title, body);
		
		int id = articleService.getLastInsertId();
		
		return Util.jsReplace(String.format("%s번 게시물을 작성했습니다.", id), String.format("detail?id=%d", id));
		
		
	}
	
	@GetMapping("/usr/article/list")
	public String list(Model model, int boardId) {
		
		String boardName = articleService.getBoardNameById(boardId);
		
		List<Article> articles = articleService.getArticles(boardId);
		
		model.addAttribute("articles", articles);
		
		return "usr/article/list";
	}
	
	@GetMapping("/usr/article/detail")
	public String detail(HttpServletRequest req, Model model, int id) {
		
		Rq rq = (Rq) req.getAttribute("rq");
		
		Article article = articleService.getArticleById(id);
		
		model.addAttribute("article", article);
		model.addAttribute("loginedMemberId", rq.getLoginedMemberId());
		return "usr/article/detail";
	}
	
	@GetMapping("/usr/article/modify")
	public String modify(HttpServletRequest req, Model model, int id) {
		
		Rq rq = (Rq) req.getAttribute("rq");
		
		Article article = articleService.getArticleById(id);
		
		model.addAttribute("loginedMemberId", rq.getLoginedMemberId());
		
		return "usr/article/modify";
	}
	
	@GetMapping("/usr/article/doModify")
	public String doModify(int id, String title, String body) {
		
		articleService.modifyArticle(id, title, body);
		
		return Util.jsReplace(String.format("%s번 게시물을 수정했습니다.", id), String.format("detail?id=%d", id));
	}
	
	@GetMapping("/usr/article/delete")
	@ResponseBody
	public String delete(int id) {
		
		Article article = articleService.getArticleById(id);
		
		
		articleService.deleteArticle(id);
		
		return Util.jsReplace(String.format("%s번 게시물을 삭제했습니다.", id), "list");
	}
}