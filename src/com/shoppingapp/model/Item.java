package com.shoppingapp.model;

public class Item {
	private String name;
	private String itemCode;
	private double price;
	
	
	public Item() {
		super();
	}

	public Item(String name, String itemCode, double price) {
		super();
		this.name = name;
		this.itemCode = itemCode;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", itemCode=" + itemCode + ", price=" + price + "]";
	}
	
}
