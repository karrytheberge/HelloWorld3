package edu.usm.cos420.example1.view.impl;

import java.util.Scanner;

/* 
 * itemView class 
 *    A Command line User Interface which displays menu of customer options to user and collects 
 *    the user choice.  
 * 
 */
public class CustomerView {

    /** {@value}  : no choice selected by user */
    public static final int NO_CHOICE = 0;

    /** {@value #NEW_CUST}  : Create a new customer record */
    public static final int NEW_CUST = 1;

    /** {@value #ALL_CUST}  : Display all customer records */
    public static final int ALL_CUST = 2;

    /** {@value #CUST_ID}  : Display customer records with ID */
    public static final int CUST_ID = 3;

    /** {@value #MAIN_MENU}  : Return to previous menu */
    public static final int RETURN = 8;

    // Object to read menu choices
    private Scanner in = new Scanner(System.in); 

    public void displayMenu () {
        for (int i = 0; i < 5; i++) System.out.println();
        System.out.println("Enter the number denoting the action " +
                "to perform:");
        System.out.println("Enter new customer........." + NEW_CUST);
        System.out.println("Show all customers........." + ALL_CUST);
        System.out.println("Look up customers.........." + CUST_ID);
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

    /**
     * Read the new customer information from user.
     * @param firstName Text asking user to enter firstName
     * @return First Name
     * @param lastName Text asking user to enter lastName
     * @return Last Name
     * @param strAddress Text asking user to enter Street Address
     * @return Street Address
     */
    public String collectFirstName (){
        System.out.println();
        System.out.println("First Name:");
        String firstName = in.nextLine();
        while (firstName.equals("")) {
            System.out.println("Please re-enter first name:");
            firstName = in.nextLine();
        }
        return firstName;
    }

    public String collectLastName (){
        System.out.println();
        System.out.println("Last Name:");
        String lastName = in.nextLine();
        while (lastName.equals("")) {
            System.out.println("Please re-enter last name:");
            lastName = in.nextLine();
        }
        return lastName;
    }

    public String collectStrAddress (){
        System.out.println();
        System.out.println("Street Address:");
        String strAddress = in.nextLine();
        while (strAddress.equals("")) {
            System.out.println("Please enter street address");
            strAddress = in.nextLine();
        }
        char c = strAddress.charAt(0);
        while (!(Character.isDigit(c))) {
            System.out.println("That address appears to be incorrect. \n "
                    + "Please re-enter street address:");
            strAddress = in.nextLine();
            c = strAddress.charAt(0);
        }

        return strAddress;

    }


    public String collectCityTown (){
        System.out.println();
        System.out.println("City / Town:");
        String cityTown = in.nextLine();
        while (cityTown == "") {
            System.out.println("Please re-enter city / town:");
            cityTown = in.nextLine();
        }
        return cityTown;
    }

    public String collectState (){
        System.out.println();
        System.out.println("State abreviation:");
        String state = in.next();
        while (state == "" || 
                state.length() != 2) {
            System.out.println("Please re-enter state abbreviation:");
            state = in.next();
        }
        return state;
    }

    public String collectZip (){
        System.out.println();
        System.out.println("Zip code:");
        String zip = in.next();
        while (zip.length() != 5 || 
                !(Character.isDigit(zip.charAt(0))) ||
                !(Character.isDigit(zip.charAt(1))) ||
                !(Character.isDigit(zip.charAt(2))) ||
                !(Character.isDigit(zip.charAt(3))) ||
                !(Character.isDigit(zip.charAt(4)))) 
        {
            System.out.println("Please re-enter five digit zip code:");
            zip = in.next();
        }
        return zip;
    }
}
