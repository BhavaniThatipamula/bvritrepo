package com.cg.pms.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.cg.pms.bean.Product;
import com.cg.pms.exception.ProductException;

public class ProductDaoMapImpl implements ProductDao{
	
	private Map<Integer,Product>map;
	
	public ProductDaoMapImpl()
	{
		map=new HashMap<Integer,Product>();
	}

	public int addProduct(Product product) throws ProductException {
		
		boolean flag=map.containsKey(product.getProductId());
		 if(flag)
		 {
			 throw new ProductException("Id already exits");
		 }
		 else
			 map.put(product.getProductId(), product);
		   
		 return product.getProductId();
		 
		
		 
	}

	public Product findProductById(int productId) throws ProductException {
		 
		boolean flag=map.containsKey(productId);
		Product product=null;
		if(flag)
		{
			product=map.get(productId);
		}
		else
		{
			throw new ProductException(productId+" Id not found");
		}
		 
		return product;
		 
	}

	public Product deleteProductById(int productId) throws ProductException {
		 
		boolean flag=map.containsKey(productId);
		Product product=null;
		if(flag)
		{
			product=map.remove(productId);
		}
		else
		{
			throw new ProductException(productId+" Id not found");
		}
		 
		return product;
		 
	}

	public List<Product> findAllProduct() throws ProductException {
		 
Collection<Product> col=map.values();
		
		List<Product> list=new ArrayList<Product>(col);
		 
		return list;
		 
	}

}
