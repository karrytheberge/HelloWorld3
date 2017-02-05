package edu.usm.cos420.example1;

import edu.usm.cos420.example1.controller.InitialController;
import edu.usm.cos420.example1.service.*;
import edu.usm.cos420.example1.service.impl.*;
import edu.usm.cos420.example1.view.impl.*;

/**
 * Top level application class that coordinates the calls to view and Controller
 *
 */
public class App
{
    /**
     * Entry point for application : calls {@link #provideCItemAccess()}
     * @param args  main program arguments, currently not used
     */
	public static void main( String[] args )
    {
		InitialView initialView = new InitialView();
        OrderView orderView = new OrderView();
        OrderService orderService = new OrderService();
	    ItemView itemView = new ItemView();
	    ItemService itemService = new ItemService();
	    CustomerView customerView = new CustomerView();
        CustomerService customerService = new CustomerService();

		InitialController controller = new InitialController(initialView, orderView, orderService,
		        itemView, itemService, customerView, customerService);		
		controller.provideMenuAccess();
    }
}
