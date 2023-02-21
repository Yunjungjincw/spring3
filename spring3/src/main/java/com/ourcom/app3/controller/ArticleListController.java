package com.ourcom.app3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//원칙적으로 요청함수는 <->Service<->DAO(Repository)<->(MyBatis)->db
//여기에서는 임시 요청함수                <->DAO(Repository)<->(MyBatis)->db
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ourcom.app3.domain.Article;
import com.ourcom.app3.repository.ArticleRepository;

@Controller
@RequestMapping("/article")
public class ArticleListController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	
	@GetMapping("/totalCnt")
	public String totalCnt(Model model) {
		
		int totalCnt=articleRepository.getTotalCnt();
		model.addAttribute("totalCnt",totalCnt);
		return "article/resultView";
	}
	
	@GetMapping("/list")
	public String articleList(Article article, Model model) {
		
		int totalCnt=articleRepository.getTotalCnt();
		model.addAttribute("totalCnt",totalCnt);
		
		List<Article> list=articleRepository.articleList(article);
		model.addAttribute("articleList",list);
		return "article/resultView";
	}
	
	@GetMapping("/content")
	public String articleContent(@RequestParam("articleNo") int articleNo, Article article,Model model) {
		Article article1 = articleRepository.articleContent(articleNo);
		model.addAttribute("articleContent",article1);
		return "article/resultView1";
	}
	
	
	
}
