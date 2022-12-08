package com.demo.beans;

public class Product implements Comparable <Product> {//you have to implement compareble inteface hear to override
	//compareble method,it s default method called by sort function,this applicable for one entity like name or id not for 2 at atime
	private int id;
	private String name;
	private int qty;
	private float price;
	public Product() {
		super();
	}
	public Product(int id) {
		super();
		this.id = id;
		this.name = null;
		this.qty = 0;
		this.price = 0;
	}
	
	public Product(int id, String name, int qty, float price) {
		super();
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int compareTo(Product o) {
	System.out.println("in compareTo method");
	System.out.println(this.price +"-------"+o.price);
	/*
	 * if(this.price<o.price)
	 *  { 
	 * return -1;
	 *  } else if(this.price==o.price)
	 *  {
	 *    return 0;
	 *    }
	 *   else 
	 *  return 1;
	 */
	return  (int)(this.price-o.price);
}
	
	
	
	
	
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("in equlas method");
		System.out.println(this.id+"======="+((Product)obj).id);
		return this.id== ((Product)obj).id;//|| this.name.equals(((Product)obj).name);
	}//equal method has internal for loop which return index
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", qty=" + qty + ", price=" + price + "]";
	}
	
	

}



