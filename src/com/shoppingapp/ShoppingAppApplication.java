package com.shoppingapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shoppingapp.controller.ShoppingAppController;
import com.shoppingapp.model.Invoice;
import com.shoppingapp.model.Item;
import com.shoppingapp.utility.ConsolePrinter;

public class ShoppingAppApplication {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean runApp = true;
		ShoppingAppController sac = new ShoppingAppController();
		boolean loggedIn=false;
		boolean registered = false;
		
		List<Item> itemsOrdered = new ArrayList<Item>();
		List<Integer> quantitiesOfItems = new ArrayList<Integer>();
		boolean buying=true;
		boolean modifyingQty = true;
		boolean oldItem = false;
		String yes= "y";
		String no= "n";
		
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
						registered = true;
					}
					else {
						System.out.println("The email you have entered already has an account linked to it! Please Try Again!");
					}
				}
				
				if(choice==2 || registered) {//LOGIN
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
						System.out.println("| 3.VIEW INVOICES            |");
						System.out.println("| 4.LOG OUT                  |");
						System.out.println("+============================+");
						System.out.println("Enter Choice (1, 2, 3 or 4) :");
						
						try {
						int userChoice = Integer.parseInt(scan.nextLine());
						if(userChoice==1) {//BUY ITEM
							buying=true;
				
							itemsOrdered = new ArrayList<Item>();
							quantitiesOfItems = new ArrayList<Integer>();
							while(buying) {
								modifyingQty = true;
								oldItem = false;
								sac.printItems();
								ConsolePrinter.buyOutput(1);
								String itemCode = scan.nextLine();
								if(sac.checkItemCode(itemCode)) {
									
									for(int i=0;i<itemsOrdered.size();i++) {
										if(itemsOrdered.get(i).getItemCode().equals(itemCode)) {//check if already picked before
											oldItem=true;
											while(modifyingQty) {
												System.out.println("That item is already in your shopping cart! Would you like to modify its quantity?(y/n)");
												String modifyQty = scan.nextLine();
												if(modifyQty.equalsIgnoreCase(yes)) {
													while(true) {
														ConsolePrinter.buyOutput(2);
														try {
															int qtyNew =Integer.parseInt(scan.nextLine());
															if(qtyNew>=0) {
																if(qtyNew==0) {
																	itemsOrdered.remove(i);
																	quantitiesOfItems.remove(i);
																	modifyingQty = false;
																	break;
																}
																else {
																	quantitiesOfItems.set(i, qtyNew);
																	modifyingQty = false;
																	break;
																}
															}
															else {
																System.out.println("Invalid Quantity! Number has to be greater than or equal to 0!");
															}
														}
														catch(Exception e) {
															System.out.println("Invalid Quantity! Try Again!");
														}
													}
													
												}
												else if(modifyQty.equalsIgnoreCase(no)) {
													modifyingQty = false;
													
													
												}
												else {
													System.out.println("Invalid Choice! Try Again!");
												}
											}
											
										}
									
									}
									
									if(modifyingQty==false ) {
										System.out.println("Would You Like To Buy Anything Else?(y/n)");
										String moreItems1 = scan.nextLine();
										while(true) {
											if(moreItems1.equalsIgnoreCase(yes)) {
												break;
											}
											else if(moreItems1.equalsIgnoreCase(no)) {
												buying = false;
												System.out.println("Thank you for your order!");
												double orderPrice = 0;
												for(int i=0;i<itemsOrdered.size();i++) {
													orderPrice += itemsOrdered.get(i).getPrice()*quantitiesOfItems.get(i);
												}
												sac.addInvoice(new Invoice(sac.getCustId(login_email), sac.getNextOrderPlaceNum(sac.getCustId(login_email)),itemsOrdered, quantitiesOfItems, orderPrice),sac.getCustId(login_email));
												break;
											}
											else {
												System.out.println("Invalid Choice! Try Again!");
											}
										}
									}
									
									if(oldItem==false) {
										boolean check = true;
										while(check) {
											ConsolePrinter.buyOutput(2);
											String qty =scan.nextLine();
											if(sac.checkQty(qty)) {//check if number is >=0
												itemsOrdered.add(sac.getItemByCode(itemCode));
												quantitiesOfItems.add(Integer.parseInt(qty));
												while(true) {
													System.out.println("Would You Like To Buy Anything Else?(y/n)");
													String moreItems = scan.nextLine();
													
													if(moreItems.equalsIgnoreCase(yes)) {
														//do nothing
														check=false;
														break;
													}
													else if(moreItems.equalsIgnoreCase(no)) {
														buying = false;
														System.out.println("Thank you for your order!");
														double orderPrice = 0;
														for(int i=0;i<itemsOrdered.size();i++) {
															orderPrice += itemsOrdered.get(i).getPrice()*quantitiesOfItems.get(i);
														}
														sac.addInvoice(new Invoice(sac.getCustId(login_email), sac.getNextOrderPlaceNum(sac.getCustId(login_email)),itemsOrdered, quantitiesOfItems, orderPrice),sac.getCustId(login_email));
														check=false;
														break;
													}
													else {
														System.out.println("Invalid Choice! Try Again!");
													}
												}
												
											}
											else {
												System.out.println("Invalid Amount! Try Again!");
											}
										}
										
									}
									
								}
								else {
									System.out.println("Invalid Item Code entered! Please Try Again!");
								}
							}
							
							
//							if(itemsOrdered.size()>0) {
//								System.out.println("Thank you for your order!");
//								double orderPrice = 0;
//								for(int i=0;i<itemsOrdered.size();i++) {
//									orderPrice += itemsOrdered.get(i).getPrice()*quantitiesOfItems.get(i);
//								}
//								
//								sac.addInvoice(new Invoice(sac.getCustId(login_email), sac.getNextOrderPlaceNum(sac.getCustId(login_email)),itemsOrdered, quantitiesOfItems, orderPrice),sac.getCustId(login_email)); //adds invoice to customer invoice list
//							}
							
						}
						else if(userChoice==2) {//Return
							
						}
						else if(userChoice==3) {//view invoice list
							sac.printInvoices(sac.getCustId(login_email));
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
					sac.printItems();
					System.out.println("Please Login to purchase items!");
				}
				else if(choice==4) {//RETURN AN ITEM
					System.out.println("This feature is only available to logged in users! Please Login To Return an Item!");
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
