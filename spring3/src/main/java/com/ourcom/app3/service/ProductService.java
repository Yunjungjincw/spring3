package com.ourcom.app3.service;

import java.util.List;
import java.util.Map;
import com.ourcom.app3.domain.*;

public interface ProductService {
	
	//상품 등록
	public int productAdd(Map productAdd) throws Exception;
	
	//상품 리스트 조회
	public List<Product> productList() throws Exception;
	
	
	 //업로드 사진 조회 
	public List<ImageFileVO> productImageList(int sellNo) throws Exception;
	
	//상품 상세 조회
	public Product productDetail(int sellNo) throws Exception;
	
	//상품 등급 변경
	public int goodsGradeChange(Map gradeMap) throws Exception;
	
	//판매하기 게시글 갯수 조회
	public int productListCount() throws Exception;
	
	//페이징 처리
	public List<Product> getListWithPaging(Criteria cri) throws Exception;
	 
	
	//Criteria 셋팅
	public Criteria criSetting(int pageNum,int amount) throws Exception;
 }
