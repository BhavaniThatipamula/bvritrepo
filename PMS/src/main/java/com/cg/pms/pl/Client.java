package com.cg.pms.pl;

import java.util.List;
import java.util.Scanner;
import com.cg.pms.bean.Product;
import com.cg.pms.exception.ProductException;
import com.cg.pms.service.ProductService;
import com.cg.pms.service.ProductServiceImpl;

public class Client {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ProductService productService = new ProductServiceImpl();
		int choice=0;
		Product product=null;
		List<Product> list=null;
		while(choice!=5)
		{
			System.out.println("1.Add Product");
			System.out.println("2.Search Product");
			System.out.println("3.Delete Product");
			System.out.println("4.List of Product");
			System.out.println("5.Exit");
			
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			
			switch(choice)
			{
			case 1: System.out.println("Enter the name");
			        sc.nextLine();
			        String name=sc.nextLine();
			        
			        System.out.println("Enter the price");
			        double price=sc.nextDouble();
			        product =new Product();
			        product.setProductName(name);
			        product.setPrice(price);
			        try
			        {
			        int id=productService.addProduct(product);
			        System.out.println("Product Id= "+id);
			        }
			        catch(ProductException e)
			        {
			        	System.err.println(e.getMessage());
			        }
			        break;
			case 2: System.out.println("Enter the productId");
			        int id=sc.nextInt();
			        try
			        {
			        product= productService.findProductById(id);
			        System.out.println("Name ="+product.getProductName());
			        System.out.println("Price= "+product.getPrice());
			        }
			        catch(ProductException e)
			        {
			        	System.err.println(e.getMessage());
			        }
			        break;
			        
			case 3:System.out.println("Enter ProductId ");
			        id=sc.nextInt();
			        try
			        {
			        	product=productService.deleteProductById(id);
			        	System.out.println(id+" is deleted");
			        	
			        	
			        	
			        }
			        catch(ProductException e)
			        {
			        	System.out.println(e.getMessage());
			        }
			        break;
			       
			case 4: try
			       {
				    list= productService.findAllProduct();
			        for(Product pro: list)
			        {
			        	 id=pro.getProductId();
			        	 name=pro.getProductName();
			        	 price=pro.getPrice();
			        	 System.out.println(id+" "+name+" "+price);
			        	 
			        }}
			      catch(ProductException e)
			      {
				    System.out.println(e.getMessage());
			      }
			       break;
			
			case 5:
				   System.out.println("Thank you take break");
				   return;
			}
			
		}
		 

	}

}
