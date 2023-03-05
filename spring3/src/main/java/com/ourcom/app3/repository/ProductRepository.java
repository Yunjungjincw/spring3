package com.ourcom.app3.repository;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.ourcom.app3.domain.Criteria;
import com.ourcom.app3.domain.ImageFileVO;
import com.ourcom.app3.domain.Product;

public interface ProductRepository {
	public int insertProductAdd(Map productAdd) throws DataAccessException;

	public void insertProductImageFile(List<ImageFileVO> fileList) throws DataAccessException;
	
	
	public List<Product> productListSelect() throws DataAccessException;
	
	
	public List<ImageFileVO> productImageSelect(int sellNo) throws DataAccessException;
	
	
	public Product productSelectOne(int sellNo) throws DataAccessException;
	
	public int goodsGradeUpdate(Map gradeChangeMap) throws DataAccessException;
	
	public int productListConut() throws DataAccessException;

	public List<Product> getListWithPaging(Criteria cri);
}
