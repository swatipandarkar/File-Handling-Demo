package com.demo.test;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;
public class Test {

public static void main(String[] args) {

		
		
		Scanner sc=new Scanner(System.in);
		ProductService pservice=new ProductServiceImpl(); 
		int choice=0;
		do {
		System.out.println("1. add new product\n2. remove by id\n 3. remove by name\n");
		System.out.println("4. display all\n5.find by id\n 6. sort by price\n");
		System.out.println("7. display all with qty > given qty\n8.modify price\n9.find by name 10.exit\n ");
		System.out.println("choice :");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			pservice.addNewProduct();
			break;
		case 2:System.out.println("enter id to remove");
		       int id=sc.nextInt();
		       boolean status=pservice.RemoveById(id);
		       if(status)
		       {
		    	   System.out.println(("remove successfuly"));
		       }
		       else
		       {
		    	   System.out.println(("not found"));
		       }
		       break;
		
			
		case 3:System.out.println("enter name to remove");
	       String name =sc.next();
	       boolean st=pservice.RemoveByName(name);
	       if(st)
	       {
	    	   System.out.println(("remove successfuly"));
	       }
	       else
	       {
	    	   System.out.println(("remove successfuly")); 
	       }
			
		case 4:
			List<Product> plist=pservice.displayAll();
			Iterator<Product> it=plist.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			
			break;
		case 5:
			System.out.println("enter id to search");
			 id=sc.nextInt();
			Product p=pservice.findById(id);
			if(p!=null) {
				System.out.println(p);
			}
			else {
				System.out.println("not found");
			}
			break;
		case 6:List<Product> plist1=pservice.SortByPrice();
		       if(plist1!=null)
		       {
		    	   for(Product p1:plist1)
		    	   {
		    		   System.out.println(p1);
		    	   }
		    	   
		       }
		       break;
			
		case 7:
		{
			System.out.println("enter qty ");
			int qty=sc.nextInt();
			List<Product>plist2=pservice.FindByQuantity(qty);
			plist2.forEach(x->{System.out.println(x);});
			break;
			
			
		}	
		case 8:System.out.println("enetr id");
		 id=sc.nextInt();
		 System.out.println("enetr new price");
		float pr=sc.nextFloat();
		status=pservice.modifyPrice(id,pr);
		if(status) {
			System.out.println("modified successfully");
		}
		else {
			System.out.println("not found");
		}
		break;
			
		case 9:
			System.out.println("enetr name");
			String nm=sc.next();
			p=pservice.findByName(nm);
			if(p!=null) {
				System.out.println(p);
			}
			else {
				System.out.println("not found");
			}
			break;
		case 10:
			System.out.println("thank you for visiting....");
			sc.close();
			break;
		}
		}while(choice!=10);
	}

}
