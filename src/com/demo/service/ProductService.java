package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	void addNewProduct();

	List<Product> displayAll();

	Product findById(int id);

	Product findByName(String nm);

	boolean RemoveById(int id);

	boolean RemoveByName(String name);

	List<Product> SortByPrice();

	List<Product> FindByQuantity(int qty);

	boolean modifyPrice(int id, float pr);

	

}
