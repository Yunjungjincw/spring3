package com.ourcom.app3;

import java.util.List;

import com.ourcom.app3.domain.Criteria;
import com.ourcom.app3.domain.Product;

public interface ProductMapper {
	
	public List<Product> getList();
	
	public List<Product> getListWithPaging(Criteria cri);
	
	public void insert(Product product);
	
	public Integer insertSelectKey(Product product);
	
	public Product read(Long sellNo);
	
	public int delete(Long sellNo);
	
	public int update(Product board);
}
