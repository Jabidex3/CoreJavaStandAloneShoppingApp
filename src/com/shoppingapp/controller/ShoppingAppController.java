package com.shoppingapp.controller;

import java.util.ArrayList;
import java.util.List;

import com.shoppingapp.model.Customer;
import com.shoppingapp.model.Invoice;
import com.shoppingapp.model.Item;

public class ShoppingAppController {

	private ArrayList<Customer> customers;
	private ArrayList<Item> inventory;
	private int currentUserIndex = 0;
	
	public ShoppingAppController() {
		customers = new ArrayList<Customer>();
		inventory = new ArrayList<Item>();
		
		Item one = new Item("Jacket","Ja1",20.00);
		Item two = new Item("Jeans","Je1",10.00);
		Item three = new Item("Shirt","Sh1",5.00);
		inventory.add(one);
		inventory.add(two);
		inventory.add(three);
		
	}
	
	//Registration
	public boolean addCustomers(String name, String email, String pw) {//unique email is required to register an account
		if(customers.size()==0) {
			customers.add(new Customer(1,name,email,pw));
			return true;
		}
		else {
			for(int i=0;i<customers.size();i++) {
				if(customers.get(i).getEmail().equals(email)) {
					return false;
				}
			}
			customers.add(new Customer(customers.size()+1,name,email,pw));
			return true;
		}
	}
	
	public void printCustomers() {
		for(int i=0;i<customers.size();i++) {
			System.out.println(customers.get(i));
		}
	}
	
	//log in
	public boolean loginCustomer(String email, String pw) {
		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).getEmail().equals(email)) {
				if(customers.get(i).getPassword().equals(pw)) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;
	}
	
	//print item list
	public void printItems() {
//		for(Item i : inventory) {
//			System.out.println(i);
//		}
		//System.out.println("+===============================================+");
		System.out.println("Item              Item Code              Price ");
		System.out.println("===============================================");
		for(int i =0;i<inventory.size();i++) {
			System.out.println(inventory.get(i).getName()+"                "+inventory.get(i).getItemCode()+"                "+inventory.get(i).getPrice());
		}
	}
	
	public boolean checkItemCode(String code) {
		for(Item i : inventory) {
			if( i.getItemCode().equalsIgnoreCase(code)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkQty(String amt) {
		try {
			int x = Integer.parseInt(amt);
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception E) {
			return false;
		}
		
	}
	
	public Item getItemByCode(String code) {
		for(int i = 0;i<inventory.size();i++) {
			if(inventory.get(i).getItemCode().equalsIgnoreCase(code)) {
				return inventory.get(i);
			}
		}
		
		System.out.println("I shouldnt be here");
		return new Item(); //will never come here
	}
	
	public int getCustId(String email) {
		for(int i =0;i<customers.size();i++) {
			if(customers.get(i).getEmail().equals(email)) {
				return customers.get(i).getCustomerId();
			}
		}
		
		//will never come here
		System.out.println("-1");
		return -1;
	}
	
	public void addInvoice(Invoice order, int cust_id) {
		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).getCustomerId()==cust_id) {
				customers.get(i).addOrder(order);
			}
		}
	}
	
	public int getNextOrderPlaceNum(int cust_id) {
		for(int i =0;i<customers.size();i++) {
			if(customers.get(i).getCustomerId()==cust_id) {
				return customers.get(i).orderListLength();
			}
		}
		//will never come here
		System.out.println("-1");
		return -1;
		
	}
	
	public void printInvoices(int cust_id) {
		List<Invoice> orders = new ArrayList<Invoice>();
		Customer current = null;
		for(int i =0;i<customers.size();i++) {
			if(customers.get(i).getCustomerId()==cust_id) {
				current = customers.get(i);
				orders = customers.get(i).getOrders();
//				System.out.println(customers.get(i).getOrders());
				//System.out.println(customers.get(i));
			}
		}
		
		if(orders.size()==0) {
			System.out.println("You have no invoices at this time!");
		}
		else {
			for(int i=0;i<orders.size();i++) {
				System.out.println("+==============================================================================+");
				System.out.println("Customer Name : " + current.getName() + "\nDate: "+ orders.get(i).getDate());
				System.out.println("Invoice no : "+ orders.get(i).getInvoiceId());
				System.out.println("Order Details:");
				List<Item> items = orders.get(i).getItems();
				for(int j=0;j<items.size();j++) {
					System.out.println(items.get(j)+" ----- Quantity: "+ orders.get(i).getQuantities().get(j));
				}
				//System.out.println(orders.get(i).getItems());
				//System.out.println(orders.get(i).getQuantities());
				System.out.println();
				System.out.println("Total Price:" + orders.get(i).getAmount());
				System.out.println("+===============================================================================+");
			}
		}
	
		
		
	}
}
