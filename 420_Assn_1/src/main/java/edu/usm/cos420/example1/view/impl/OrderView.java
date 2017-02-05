package edu.usm.cos420.example1.view.impl;


import java.util.Scanner;

import edu.usm.cos420.example1.service.impl.CustomerService;
import edu.usm.cos420.example1.service.impl.ItemService;

/* 
 * itemView class 
 *    A Command line User Interface which displays menu of inventory item options to user and collects 
 *    the user choice.  
 * 
 */
public class OrderView {
    
    /** {@value}  : no choice selected by user */
    public static final int NO_CHOICE = 0;
    
    /** {@value #NEW_ORD}  : Create a new customer order */
    public static final int NEW_ORD = 1;
    
    /** {@value #DSP_ORD}  : Display orders by customer */
    public static final int DSP_ORD = 2;
    
    /** {@value #MAIN_MENU}  : Return to previous menu */
    public static final int RETURN = 8;
  
    // Object to read menu choices
    private Scanner in = new Scanner(System.in);

  
    public void displayMenu () {
        for (int i = 0; i < 5; i++) System.out.println();
        System.out.println("Enter the number denoting the action " +
                           "to perform:");
        System.out.println("New order.................." + NEW_ORD);
        System.out.println("Customer order history....." + DSP_ORD);
        System.out.println("Main menu.................." + RETURN);
      }
    
    /**
     * Read the menu choice from user.
     * @param prompt Text asking user to enter choice
     * @return 
     *  <ul>
     *    <li>{@value #NEW_ORD}  : Create a new customer order
     *    <li>{@value #DSP_ORD}  : Display customer order history
     *    <li>{@value #RETURN}  : Return to the main menu 
     * </ul>
     */
    public int readIntWithPrompt (String prompt) {
      System.out.print(prompt); 
      System.out.flush();
      int choice = in.nextInt();
      return choice;
    }

	public Long collectCustomerId(CustomerService customerService) {
        System.out.println();
        System.out.println("Enter Last Name:");
        String lastName = in.nextLine();
        while (lastName.equals("")) {
            System.out.println("Please re-enter last name:");
            lastName = in.nextLine();
        }
        
        System.out.println();
        System.out.println("Enter First Name:");
        String firstName = in.nextLine();
        while (firstName.equals("")) {
            System.out.println("Please re-enter first name:");
            firstName = in.nextLine();
        }
        Long id = customerService.getNameToId(lastName, firstName);
        return id;
	}

	public int collectOrderQty() {
		System.out.println("Enter quantity:");
		int qty = in.nextInt();
		return qty;
	}

	public String notEnoughInventory(int qty) {
		System.out.println("Not enough inventory. \n Currently " + qty + " available");
		System.out.println("Adjust qty (a) or cancel item (c)? a or c");
		String answer = in.next();
		return answer;
	}

	public boolean addMorePrompt() {
		System.out.println("Add more items? y or n?");
		String answer = in.next();
		if (answer.equalsIgnoreCase("y")) return true;
		else return false;
	}
}

