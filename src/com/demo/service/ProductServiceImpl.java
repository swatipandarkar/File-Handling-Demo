package com.demo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.demo.beans.Product;
public class ProductServiceImpl implements ProductService{

	static List<Product> plist;
	static{
		plist=new ArrayList<>();
		plist.add(new Product(1,"chair",12,3456));
		plist.add(new Product(2,"Table",34,2000));
	}
	@Override
	public void addNewProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enetr id");
		int id=sc.nextInt();
		System.out.println("enetr name");
		String nm=sc.next();
		System.out.println("enetr qty");
		int qty=sc.nextInt();
		System.out.println("enetr price");
		float pr=sc.nextFloat();
		Product p=new Product(id,nm,qty,pr);
		plist.add(p);
		
	}
	@Override
	public List<Product> displayAll() {
		if(plist.size()>0) {
		 return plist;
		}
		return null;
	}
	@Override
	public Product findById(int id) {
		int pos=plist.indexOf(new Product(id));
		if(pos!=-1) {
			return plist.get(pos);
		}
		return null;
	}
	@Override
	public Product findByName(String nm) {
		for(Product p:plist) {
			if(p.getName().equals(nm)) {
				return p;
			}
		}
		return null;
	}
	@Override
	public boolean RemoveById(int id) //Rmove internally called equal method
	{
		
		/*if(plist.contains(new Product(id)))//contain return true or false
		{
			plist.remove(new Product(id)); 
			return true;
		}return false;*/
		//remove return true if object remove else false
		
		return plist.remove(new Product(id));	
		}
	@Override
	public boolean RemoveByName(String name) {
		Product p= findByName(name);//call find by name
		if(p!=null)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println(p);
			System.out.println("do you want to delete it(y/n)?");
			String ans=sc.next();
			if(ans.equals("y")) 
			{
				plist.remove(p); //internaly call equals method in product class it checks on id 
				//bcz we can not create 2 equal method in product class
				//we can take either id or name not both at a time
				return true;
			}
			return false;
		
		}
		else
		{
			return false;
		
		}
	}
	@Override
	public List<Product> SortByPrice() {
		plist.sort(null);
		return plist;
	
		
	}
	@Override
	public List<Product> FindByQuantity(int qty) {
		return plist.stream().filter(x->x.getQty()>qty).collect(Collectors.toList());
		
		
		
	}
	@Override
	public boolean modifyPrice(int id, float pr) {
		int pos=plist.indexOf(new Product (id));
		if(pos!=-1)
		{
			Product p=plist.get(pos);//get (2nd) position of plist in product p
			p.setPrice(pr);
			return true;
			
		}
		
		
		return false;
	}
}



