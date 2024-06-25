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
	
	@GetMapping("/usr/article/doWrite")
	@ResponseBody
	public ResultData<Article> doWrite(HttpSession session, String title, String body) {
		
		if (session.getAttribute("loginedMemberId") == null) {
			return ResultData.from("F-LO", "로그인 후 이용해주세요");
		}
		
		if (Util.isEmpty(title)) {
			return ResultData.from("F-1", "제목을 입력해주세요");
		}
		if (Util.isEmpty(body)) {
			return ResultData.from("F-2", "내용을 입력해주세요");
		}
		
		articleService.writeArticle((int) session.getAttribute("loginedMemberId"),title, body);
		
		int id = articleService.getLastInsertId();
		
		return ResultData.from("S-1", String.format("%d번 게시물을 작성했습니다", id), articleService.getArticleById(id));
		
		
	}
	
	@GetMapping("/usr/article/list")
	public String showList(Model model) {

		List<Article> articles = articleService.getArticles();
		
		model.addAttribute("articles", articles);
		
		return "usr/article/list";
	}
	
	@GetMapping("/usr/article/detail")
	public String showDetail(HttpServletRequest req, Model model, int id) {
		
		Rq rq = (Rq) req.getAttribute("rq");
		
		Article article = articleService.getArticleById(id);
		
		model.addAttribute("article", article);
		model.addAttribute("loginedMemberId", rq.getLoginedMemberId());
		return "usr/article/detail";
	}
	
	@GetMapping("/usr/article/modify")
	public String doModify(Model model, HttpSession session, int id, String title, String body) {
		
		List<Article> articles = articleService.getArticles();
		
		model.addAttribute("articles", articles);
		
		Article foundArticle = articleService.getArticleById(id);
		
		if (foundArticle == null) {
			return "usr/article/list";
		}
		
		if (foundArticle.getMemberId() != (int) session.getAttribute("loginedMemberId")) {
			return "usr/article/list";
		}
		
		articleService.modifyArticle(id, title, body);
		
		return "usr/article/modify";
	}
	
	@GetMapping("/usr/article/delete")
	@ResponseBody
	public String doDelete(int id) {
		
		Article article = articleService.getArticleById(id);
		
		
		articleService.deleteArticle(id);
		
		return Util.jsReplace(String.format("%s번 게시물을 삭제했습니다.", id), "list");
	}
}