package edu.usm.cos420.example1.controller;

import edu.usm.cos420.example1.view.impl.*;
import edu.usm.cos420.example1.controller.*;
import edu.usm.cos420.example1.service.impl.*;

/**
 *   A Controller class to execute user's initial menu choice.
 *     List of possible choices can be found at {@link edu.usm.cos420.example1.view.TextUI}
 *   
 */ 

public class InitialController {

	private InitialView initialView;
	private OrderView orderView;
	private OrderService orderService;
	private ItemView itemView;
	private ItemService itemService;
	private CustomerView customerView;
	private CustomerService customerService;
	private OrderController orderController = new OrderController(orderView, orderService);
	private ItemController itemController = new ItemController(itemView, itemService);
	private CustomerController customerController = new CustomerController(customerView, customerService);


	/**
	 * Constructor : pass in a service class which can provide access to initial operations. 
	 * @param initialView
	 * @param itemView 
	 * @param itemService
	 * @param orderView 
	 * @param orderService 
	 * @param customerView 
	 * @param customerService 
	 */
	public InitialController(InitialView initialView, OrderView orderview, OrderService orderService, 
			ItemView itemView, ItemService itemService, CustomerView customerView, 
			CustomerService customerService)
	{
		this.initialView = initialView;
		this.itemView = itemView;
		this.itemService = itemService;
		this.orderView = orderview;
		this.orderService = orderService;
		this.customerView = customerView;
		this.customerService = customerService;
	}

	/**
	 * Allow the user to access the other menus
	 * 
	 */
	public void provideMenuAccess()
	{
		int choice = initialView.NO_CHOICE;
		while (choice != initialView.EXIT) {
			initialView.displayMenu();
			choice = initialView.readIntWithPrompt("Enter choice: ");
			executeChoice(choice);
		}   
	}

	/**
	 *   Performs the branching logic to call appropriate functions to satisfy user choice
	 *   @param choice represents the user selection of action they want accomplished. 
	 */
	public void executeChoice (int choice) {
		System.out.println();
		if (choice == initialView.ORDERS)
		{
			orderController.provideOrderAccess(orderView, orderService, 
					customerService, itemService, itemView, customerView);
		}

		if (choice == initialView.INVENTORY)
		{
			itemController.provideItemAccess(itemView, itemService);
		}

		if (choice == initialView.CUSTOMERS)
		{
			customerController.provideCustomerAccess(customerView, customerService);
		}

		else if (choice == initialView.EXIT)
		{
			System.out.println("Goodbye.");
			System.exit(0);
		}
	}

}


