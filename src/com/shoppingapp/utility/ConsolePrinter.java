package com.shoppingapp.utility;

public class ConsolePrinter {

	public static void buyOutput(int i) {
		if(i==1) {
			System.out.println("What would you like to buy? Please enter the item code:");
		}
		else if(i==2) {
			System.out.println("How many would you like to buy? Please enter the amount number:");
		}
	}
}
