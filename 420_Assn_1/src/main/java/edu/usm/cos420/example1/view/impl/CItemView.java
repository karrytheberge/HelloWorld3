package edu.usm.cos420.example1.view.impl;

import java.util.Scanner;

import edu.usm.cos420.example1.service.ExampleService;
import edu.usm.cos420.example1.service.impl.Example1Service;

/* 
 * CItemView class 
 *    A Command line User Interface which displays menu of CItem options to user and collects 
 *    the user choice.  
 * 
 */

public class CItemView{
 
	/** {@value}  : no choice selected by user */
	public static final int NO_CHOICE = 0;
	/** {@value #ADDONE}  : Add one CItem to the collection of items */
    public static final int ADDONE = 1;
    /** {@value #ADD_CUSTOMER}  : Add new customer to list */
    public static final int ADD_CUSTOMER = 2;
	/** {@value #EXIT}  : Exit the program */
    public static final int EXIT = 6;
  
    // Object to read menu choices
    private Scanner in = new Scanner(System.in); 
    private ExampleService example1Service;
 
    /**
     * This small version of the UI does not need the model or service objects but, in general, 
     *     references to these objects are needed in the UI. Default constructor
     *     creates a reference to Example1Service class to illustrate this.
     */
  public CItemView()
  {
      this.example1Service = new Example1Service();
  }
  /**
   * This small version of the UI does not need the model or service objects but, in general, 
   *     references to these objects are needed in the UI.
   * @param example1Service reference to class which provides CItem Services
   */
   public CItemView(ExampleService example1Service)
   {
	  this.example1Service = example1Service;
   }
   
  /**
   * Display top level menu.
   */
  public void displayMenu () {
    System.out.println();
    System.out.println("Enter the number denoting the action " +
                       "to perform:");
    System.out.println("ADD one....................." + ADDONE);
    System.out.println("ADD new customer............" + ADD_CUSTOMER);
    System.out.println("Exit........................" + EXIT);
  }

  /**
   * Read the menu choice from user.
   * @param prompt Text asking user to enter choice
   * @return 
   *  <ul>
   *    <li>{@value #ADDONE}  : Add one item to the collection of items
   *    <li>{@value #ADD_CUSTOMER}  : Add new customer to the list of customers
   *    <li>{@value #EXIT}  : Exit the program 
   * </ul>
   */
  public int readIntWithPrompt (String prompt) {
    System.out.print(prompt); 
    System.out.flush();
    int choice = in.nextInt();
    return choice;
  }
  
}
