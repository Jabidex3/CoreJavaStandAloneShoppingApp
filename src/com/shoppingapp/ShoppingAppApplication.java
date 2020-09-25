package com.shoppingapp;

import java.util.Scanner;

import com.shoppingapp.controller.ShoppingAppController;

public class ShoppingAppApplication {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean runApp = true;
		ShoppingAppController sac = new ShoppingAppController();
		boolean loggedIn=false;
		
		while(runApp) {
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
			try {
				int choice = Integer.parseInt(scan.nextLine());
				if(choice==1) {//REGISTER
					System.out.println("+-------------------------------+");
					System.out.println("| Enter Details For New Account |");
					System.out.println("+-------------------------------+");
					System.out.println("Customer Name: ");
					String cust_name = scan.nextLine();
					System.out.println("Customer Email: ");
					String cust_email = scan.nextLine();
					System.out.println("Password: ");
					String pw = scan.nextLine();
					
					if(sac.addCustomers(cust_name, cust_email, pw)) {
						System.out.println("Congratulations! You Have Successfully Registered An Account!");
					}
					else {
						System.out.println("The email you have entered already has an account linked to it! Please Try Again!");
					}
				}
				else if(choice==2) {//LOGIN
					System.out.println("+---------------------+");
					System.out.println("| Enter Login Details |");
					System.out.println("+---------------------+");
					System.out.println("Email: ");
					String login_email = scan.nextLine();
					System.out.println("Password: ");
					String login_pw = scan.nextLine();
					
					if(sac.loginCustomer(login_email, login_pw)) {
						loggedIn=true;
						
					}
					else {
						System.out.println("Invalid Credentials! Try Again");
					}
					
					//successfully logged in
					while(loggedIn) {
						System.out.println("+============================+");
						System.out.println("| What would you like to do? |");
						System.out.println("+============================+");
						System.out.println("| 1.BUY AN ITEM              |");
						System.out.println("| 2.RETURN AN ITEM           |");
						System.out.println("| 3.VIEW ORDERS              |");
						System.out.println("| 4.LOG OUT                  |");
						System.out.println("+============================+");
						System.out.println("Enter Choice (1, 2, 3 or 4) :");
						
						try {
						int userChoice = Integer.parseInt(scan.nextLine());
						if(userChoice==1) {//BUY ITEM
							
						}
						else if(userChoice==2) {//Return
							
						}
						else if(userChoice==3) {
							
						}
						else if(userChoice==4) {
							loggedIn = false;
						}
						else {
							System.out.println("Invalid Input! Try Again");
						}
						}
						catch(Exception e) {
							System.out.println("Invalid Input! Try Again");
						}
					}
				}
				else if(choice==3) {//BUY AN ITEM
					
				}
				else if(choice==4) {//RETURN AN ITEM
					System.out.println("Please Login To Return an Item");
				}
				else if(choice==5) {//EXIT
					System.out.println("Thank You and Goodbye!");
					runApp=false;
				}
				else if(choice==6) {//testing
					sac.printCustomers();
					
				}
				else {
					System.out.println("Invalid Input! Try Again");
				}
			}
			catch(Exception e) {
				System.out.println("Invalid Input! Try Again");
			}
		}
	}

}
