package edu.usm.cos420.example1.controller;

import edu.usm.cos420.example1.dao.domain.CustDao;
import edu.usm.cos420.example1.service.impl.CustomerService;
import edu.usm.cos420.example1.service.impl.ItemService;
import edu.usm.cos420.example1.service.impl.OrderService;
import edu.usm.cos420.example1.view.impl.CustomerView;
import edu.usm.cos420.example1.view.impl.InitialView;
import edu.usm.cos420.example1.view.impl.ItemView;
import edu.usm.cos420.example1.view.impl.OrderView;

/**
 *   A Controller class to execute user's customer choice.
 *     List of possible choices can be found at {@link edu.usm.cos420.example1.view.TextUI}
 *   
 */ 
public class CustomerController {

    private CustomerService customerService; 
    private CustomerView customerView;
    //private CustDao custDao;

     /**
     * Constructor : pass in a service class which can provide access to customer operations. 
     * @param customerView 
     * @param customerService
     */
    public CustomerController(CustomerView customerView, CustomerService customerService)
    {
        this.customerView = customerView;
        this.customerService = customerService;
    }    

    /**
     * Allow the user to access the customer records collection
     * @param customerService 
     * 
     */
    public void provideCustomerAccess(CustomerView customerView, CustomerService customerService) {
        int choice = CustomerView.NO_CHOICE;
        while (choice != CustomerView.RETURN) {
            this.customerView = customerView;
            this.customerService = customerService;
            customerView.displayMenu();
            choice = customerView.readIntWithPrompt("Enter choice: ");
            executeChoice(choice);
        }

    }
    /**
     *   Performs the branching logic to call appropriate functions to satisfy user choice
     *   @param choice represents the user selection of action they want accomplished. 
     */
    public void executeChoice (int choice) {
        System.out.println();
        if (choice == CustomerView.NEW_CUST)
        {
            customerService.addACustomer(customerView);
        }
        if (choice == CustomerView.ALL_CUST) {
            customerService.showAllCustomers();
        }
        
        if (choice == CustomerView.CUST_ID) {
        	customerService.customerLookUp(customerView);
            
            
        }

        else if (choice == CustomerView.RETURN) {
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
