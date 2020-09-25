package com.shoppingapp.controller;

import java.util.ArrayList;

import com.shoppingapp.model.Customer;

public class ShoppingAppController {

	private ArrayList<Customer> customers;
	private int currentUserIndex = 0;
	
	public ShoppingAppController() {
		customers = new ArrayList<Customer>();
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
}
