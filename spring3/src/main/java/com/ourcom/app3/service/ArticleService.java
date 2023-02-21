package com.ourcom.app3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourcom.app3.repository.ArticleRepository;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	public int getTotalCnt(){
		int cnt =articleRepository.getTotalCnt();
		return cnt;
	}
}
