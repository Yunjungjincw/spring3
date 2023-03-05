package com.ourcom.app3;

import com.ourcom.app3.domain.Criteria;
import com.ourcom.app3.repository.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ourcom.app3.domain.*;


public class ProductTest {
	
	@Autowired
	ProductRepository productRepository;
	
	public void testPaging() {
		Criteria cri = new Criteria();
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<Product> list = productRepository.getListWithPaging(cri);
		
		System.out.println(list);
	}
	
	
}
