package edu.usm.cos420.example1.view.impl;

import java.util.Scanner;

public class InitialView {

        /** {@value}  : no choice selected by user */
        public static final int NO_CHOICE = 0;
        
        /** {@value #ORDERS}  : View order work with */
        public static final int ORDERS = 1;
        
        /** {@value #INVENTORY}  : View inventory work with */
        public static final int INVENTORY = 2;
        
        /** {@value #CUSTOMERS}  : View customer work with */
        public static final int CUSTOMERS = 3;
        
        /** {@value #EXIT}  : Exit the program */
        public static final int EXIT = 8;
      
        // Object to read menu choices
        private Scanner in = new Scanner(System.in); 
        
     
        public void displayMenu () {
            System.out.println();
            System.out.println("Enter the number denoting the action " +
                               "to perform:");
            System.out.println("View Order Menu.............." + ORDERS);
            System.out.println("View Inventory Menu.........." + INVENTORY);
            System.out.println("View Customer Menu..........." + CUSTOMERS);

            System.out.println("Exit........................." + EXIT);
          }
        
        /**
         * Read the menu choice from user.
         * @param prompt Text asking user to enter choice
         * @return 
         *  <ul>
         *    <li>{@value #ORDERS}  : View the "Orders" menu
         *    <li>{@value #INVENTORY}  : View the "Inventory" menu
         *    <li>{@value #CUSTOMER}  : View the "Customer" menu
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
