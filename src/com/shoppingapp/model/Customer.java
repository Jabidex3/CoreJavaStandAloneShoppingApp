package com.shoppingapp.model;

import java.util.List;

public class Customer {
	private int customerId;
	private String name;
	private String email;
	private String password;
	private List<Invoice> orders;
	
	public Customer() {
		super();
	}

	public Customer(int customerId, String name, String email, String password, List<Invoice> orders) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.orders = orders;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Invoice> getOrders() {
		return orders;
	}

	public void setOrders(List<Invoice> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", orders=" + orders + "]";
	}
	
}
