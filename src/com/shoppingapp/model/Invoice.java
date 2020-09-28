package com.shoppingapp.model;

import java.time.LocalDate;
import java.util.List;

public class Invoice {
	private int customerId;
	private int invoiceId;
	private List<Item> items;
	private List<Integer> quantities;
	private double amount;
	private LocalDate date;
	
	public Invoice() {
		super();
	}

	

	public Invoice(int customerId, int invoiceId, List<Item> items, List<Integer> quantities, double amount) {
		super();
		this.customerId = customerId;
		this.invoiceId = invoiceId;
		this.items = items;
		this.quantities = quantities;
		this.amount = amount;
		this.date = LocalDate.now();  
	}

//	public Invoice(int customerId, List<Item> items, List<Integer> quantities, double amount) {
//		super();
//		this.customerId = customerId;
//		this.items = items;
//		this.quantities = quantities;
//		this.amount = amount;
//		this.date = LocalDate.now();  
//	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	
	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Integer> getQuantities() {
		return quantities;
	}

	public void setQuantities(List<Integer> quantities) {
		this.quantities = quantities;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Invoice [customerId=" + customerId + ", invoiceId=" + invoiceId + ", items=" + items + ", quantities="
				+ quantities + ", amount=" + amount + ", date=" + date + "]";
	}

	
	
}
