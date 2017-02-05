package edu.usm.cos420.example1.view.impl;

import java.util.Scanner;

import edu.usm.cos420.example1.domain.Items;

/* 
 * itemView class 
 *    A Command line User Interface which displays menu of inventory item options to user and collects 
 *    the user choice.  
 * 
 */
public class ItemView {

    /** {@value}  : no choice selected by user */
    public static final int NO_CHOICE = 0;
    
    /** {@value #ADDNEW}  : Add a new inventory item */
    public static final int ADDNEW = 1;
    
    /** {@value #ADDNEW}  : Discontinue and inventory item */
    public static final int DISCO = 2;

    /** {@value #INV_CHECK}  : Display current inventory of searched item */
    public static final int INV_CHECK = 3;
    
    /** {@value #INV_CHECK}  : Display current inventory of all item */
    public static final int DSP_ALL = 4;
    
    /** {@value #ADJ_INV}  : Add stock to inventory */
    public static final int ADD_INV = 5;
    
    /** {@value #RMV_INV}  : Remove stock from inventory */
    public static final int RMV_INV = 6;

    /** {@value #ADJ_INV}  : Look up inventory to get item number*/
    public static final int INV_SEARCH = 7;
    
    /** {@value #MAIN_MENU}  : Return to previous menu */
    public static final int RETURN = 8;
  
    // Object to read menu choices
    private Scanner in = new Scanner(System.in); 
    
  
    public void displayMenu () {
        for (int i = 0; i < 5; i++) System.out.println();
        System.out.println("Enter the number denoting the action " +
                           "to perform:");
        System.out.println("Create new items.............." + ADDNEW);
        System.out.println("Discontinue item.............." + DISCO);
        System.out.println("Display item inventory........" + INV_CHECK);
        System.out.println("Show all inventory............" + DSP_ALL);
        System.out.println("Add inventory................." + ADD_INV);
        System.out.println("Remove inventory.............." + RMV_INV);
        System.out.println("Search for item..............." + INV_SEARCH);
        System.out.println("Main menu....................." + RETURN);
      }
    
    /**
     * Read the menu choice from user.
     * @param prompt Text asking user to enter choice
     * @return 
     *  <ul>
     *    <li>{@value #ADDNEW}  : Add new items to the inventory collection (items)
     *    <li>{@value #DISCO}  : Discontinue item
     *    <li>{@value #INV_CHECK}  : Display inventory listing
     *    <li>{@value #DSP_ALL}  : Show all inventory
     *    <li>{@value #ADD_INV}  : Add inventory
     *    <li>{@value #RMV_INV}  : Remove inventory
     *    <li>{@value #INV_SEARCH}  : Search inventory for item
     *    <li>{@value #RETURN}  : Return to the main menu 
     * </ul>
     */
    public int readIntWithPrompt (String prompt) {
      System.out.print(prompt); 
      System.out.flush();
      int choice = in.nextInt();
      return choice;
    }

    public String collectPlantType() {
        System.out.println();
        System.out.println("Enter plant type:");
        String plantType = in.nextLine();
        while (plantType.equals("")) {
            System.out.println("Please re-enter plant type:");
            plantType = in.nextLine();
        }
        return plantType;
    }

    public String collectDescription() {
        System.out.println();
        System.out.println("Enter brief description of plant:");
        String plantDescription = in.nextLine();
        while (plantDescription.equals("")) {
            System.out.println("Please re-enter plant description:");
            plantDescription = in.nextLine();
        }
        return plantDescription;
    }

    public int collectAmountOnHand() {
        System.out.println();
        System.out.println("Enter quantity on hand:");
        int onHand = in.nextInt();
        return onHand;
    }

	public Long collectPlantId() {
		System.out.println();
		System.out.println("Enter item#:");
		Long plantId = in.nextLong();
		
		return plantId;
	}

	public int collectUserAddition() {
		System.out.println("Enter amount to add:");
		int qty = in.nextInt();
		return qty;
	}

	public int collectUserSubtraction() {
		System.out.println("Enter amount to remove:");
		int qty = in.nextInt();
		return qty;
	}

	public void itemNotFound() {
		System.out.println("Item not found");
		
	}

}