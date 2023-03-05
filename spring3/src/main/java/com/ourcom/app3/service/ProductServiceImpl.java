package com.ourcom.app3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourcom.app3.repository.ProductRepository;
import com.ourcom.app3.domain.*;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	
	
	@Override
	public int productAdd(Map productAdd) throws Exception {
		
		System.out.println("productAdd service 진입");
		int sellNo=productRepository.insertProductAdd(productAdd);
		//파일 정보 저장
		List<ImageFileVO> imageFileList =(ArrayList)productAdd.get("imageFileList");
		for(ImageFileVO imageFileVO : imageFileList) {
			imageFileVO.setSellNo(sellNo);
			System.out.println("서비스 for문안 imageFileVO="+imageFileVO);
		}
		productRepository.insertProductImageFile(imageFileList);
		return sellNo;
	}



	@Override
	public List<Product> productList() throws Exception {
		
		
		return productRepository.productListSelect();
	}



	@Override
	public List<ImageFileVO> productImageList(int num) throws Exception {
		return productRepository.productImageSelect(num);
	}



	@Override
	public Product productDetail(int num) throws Exception {
		return productRepository.productSelectOne(num);
	}



	@Override
	public int goodsGradeChange(Map gradeChangeMap) throws Exception {
		
		
		return productRepository.goodsGradeUpdate(gradeChangeMap);
	}

	@Override
	public int productListCount() throws Exception {
		
		
		return productRepository.productListConut();
	}



	@Override
	public List<Product> getListWithPaging(Criteria cri) throws Exception {
		return productRepository.getListWithPaging(cri);
	}



	@Override
	public Criteria criSetting(int pageNum,int amount) throws Exception {
		return new Criteria();
	}
}
