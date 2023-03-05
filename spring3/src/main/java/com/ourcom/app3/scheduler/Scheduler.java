package com.ourcom.app3.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ourcom.app3.repository.ProductRepositoryImpl;

@Component
public class Scheduler {
	
	@Autowired
	private ProductRepositoryImpl productRepositoryImpl; 
	
	
	@Scheduled(cron ="")
}
