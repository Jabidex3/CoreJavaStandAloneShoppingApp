package com.shoppingapp.utility;

public class ConsolePrinter {

	public static void initialOutput() {
		System.out.println("+==========================================+");
		System.out.println("| Welcome To The Standalone Ecommerce App! |");
		System.out.println("+==========================================+");
		System.out.println("| 1.REGISTER                               |");
		System.out.println("| 2.LOGIN                                  |");
		System.out.println("| 3.BUY AN ITEM                            |");
		System.out.println("| 4.RETURN AN ITEM                         |");
		System.out.println("| 5.EXIT                                   |");
		System.out.println("+==========================================+");
		System.out.println("Enter Choice (1, 2, 3, 4 or 5) :");
	}
	
	public static void loggedinoutput() {
		System.out.println("+============================+");
		System.out.println("| What would you like to do? |");
		System.out.println("+============================+");
		System.out.println("| 1.BUY AN ITEM              |");
		System.out.println("| 2.RETURN AN ITEM           |");
		System.out.println("| 3.VIEW INVOICES            |");
		System.out.println("| 4.LOG OUT                  |");
		System.out.println("+============================+");
		System.out.println("Enter Choice (1, 2, 3 or 4) :");
	}
	
	public static void buyOutput(int i) {
		if(i==1) {
			System.out.println("What would you like to buy? Please enter the item code:");
		}
		else if(i==2) {
			System.out.println("How many would you like to buy? Please enter the amount number:");
		}
	}
}
