package edu.usm.cos420.example1.controller;

import edu.usm.cos420.example1.service.impl.OrderService;
import edu.usm.cos420.example1.view.impl.OrderView;
import edu.usm.cos420.example1.service.impl.CustomerService;
import edu.usm.cos420.example1.service.impl.ItemService;
import edu.usm.cos420.example1.view.impl.CustomerView;
import edu.usm.cos420.example1.view.impl.InitialView;
import edu.usm.cos420.example1.view.impl.ItemView;


/**
 *   A Controller class to execute user's order menu choice.
 *     List of possible choices can be found at {@link edu.usm.cos420.example1.view.TextUI}
 *   
 */ 
   

public class OrderController {

    private OrderView orderView;
    private OrderService orderService;
    private CustomerService customerService;
    private CustomerView customerView;
    private ItemService itemService;
    private ItemView itemView;

    /**
     * Constructor : pass in a service class which can provide access to initial operations. 
     * @param orderService 
     * @param orderView 
     */
    public OrderController(OrderView orderView, OrderService orderService)
    {
        this.orderView = orderView;
        this.orderService = orderService;
    }

    /**
     * Allow the user to access the other menus
     * @param orderService 
     * 
     */
    public void provideOrderAccess(OrderView orderView, OrderService orderService, 
    		CustomerService customerService, ItemService itemService, 
    		ItemView itemView, CustomerView customerView)
    {
    	this.customerService = customerService;
    	this.customerView = customerView;
        this.orderView = orderView;
        this.orderService = orderService;
        this.itemService = itemService;
        this.itemView = itemView;
        int choice = orderView.NO_CHOICE;
        while (choice != orderView.RETURN) {
            orderView.displayMenu();
            choice = orderView.readIntWithPrompt("Enter choice: ");
            executeChoice(choice);
        }   
    }

    /**
     *   Performs the branching logic to call appropriate functions to satisfy user choice
     *   @param choice represents the user selection of action they want accomplished. 
     */
    public void executeChoice (int choice) {
        System.out.println();
        if (choice == orderView.NEW_ORD)
        {
            orderService.addNewOrder(orderView, customerService, itemService, itemView);
        }
        
        if (choice == orderView.DSP_ORD)
        {
            orderService.showCustomerOrder(orderView, customerService, customerView);
        }

        else if (choice == orderView.RETURN) {
            InitialView initialView = new InitialView();
            OrderView orderView = new OrderView();
            ItemView itemView = new ItemView();
            CustomerView customerView = new CustomerView();
            OrderService orderService = new OrderService();
            ItemService itemService = new ItemService();
            CustomerService customerService = new CustomerService();

            InitialController controller = new InitialController(initialView, orderView, orderService, 
                    itemView, itemService, customerView, customerService);
            controller.provideMenuAccess();
        }

    }

}
