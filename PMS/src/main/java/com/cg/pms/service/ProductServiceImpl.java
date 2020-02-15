package com.cg.pms.service;

import java.util.List;
import java.util.Random;

import com.cg.pms.bean.Product;
import com.cg.pms.dao.ProductDao;
import com.cg.pms.dao.ProductDaoMapImpl;
import com.cg.pms.exception.ProductException;

public class ProductServiceImpl implements ProductService{
	
	private ProductDao productdao;
	
	public ProductServiceImpl()
	{
		productdao= new ProductDaoMapImpl();
	}

	public boolean validateName(String Productname) {
		
		boolean flag=false;
		flag=Productname.matches("[a-zA-Z]+");
		 
		return flag;
	}

	public int addProduct(Product product) throws ProductException {
		 
		String name=product.getProductName();
		boolean flag=validateName(name);
		if(!flag)
		{
			throw new ProductException("Name should contain only characters");
		}
		 
			Random random=new Random();
			int id=random.nextInt(100)+1000;
			product.setProductId(id);
			id=productdao.addProduct(product);
				
		return id;
	}

	public Product findProductById(int productId) throws ProductException {
		
		String proId=String.valueOf(productId);
		boolean flag=proId.matches("[0-9]{4}");
		if(!flag)
		{
			throw new ProductException("Id should contain 4 digits");
		}
		return productdao.findProductById(productId);
		 
		
		
	}

	public Product deleteProductById(int productId) throws ProductException {
		 
		String proId=String.valueOf(productId);
		boolean flag=proId.matches("[0-9]{4}");
		if(!flag)
		{
			throw new ProductException("Id should contain 4 digits");
		}
		return productdao.deleteProductById(productId);
		
	}

	public List<Product> findAllProduct() throws ProductException {
		 
		
		return productdao.findAllProduct();
	}

}
