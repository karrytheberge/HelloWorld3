package edu.usm.cos420.example1.controller;

import edu.usm.cos420.example1.service.impl.CustomerService;
import edu.usm.cos420.example1.service.impl.ItemService;
import edu.usm.cos420.example1.service.impl.OrderService;
import edu.usm.cos420.example1.view.impl.CustomerView;
import edu.usm.cos420.example1.view.impl.InitialView;
import edu.usm.cos420.example1.view.impl.ItemView;
import edu.usm.cos420.example1.view.impl.OrderView;

public class ItemController {

    private ItemView itemView;
    private ItemService itemService;

    /**
     * Constructor : pass in a service class which can provide access to initial operations. 
     * @param itemService 
     * @param itemView 
     */
    public ItemController(ItemView itemView, ItemService itemService)
    {
        this.itemView = itemView;
        this.itemService = itemService;
    }

    /**
     * Allow the user to access the other menus
     * @param itemService 
     * 
     */
    public void provideItemAccess(ItemView itemView, ItemService itemService)
    {
        this.itemView = itemView;
        this.itemService = itemService;
        int choice = itemView.NO_CHOICE;
        while (choice != itemView.RETURN) {
            itemView.displayMenu();
            choice = itemView.readIntWithPrompt("Enter choice: ");
            executeChoice(choice);
        }   
    }

    /**
     *   Performs the branching logic to call appropriate functions to satisfy user choice
     *   @param choice represents the user selection of action they want accomplished. 
     */
    public void executeChoice (int choice) {
        System.out.println();
        if (choice == itemView.ADDNEW)
        {
            itemService.addNewItem(itemView);
        }
        
        if (choice == itemView.DISCO)
        {
            itemService.removeItem(itemView);
        }

        if (choice == itemView.INV_CHECK)
        {
            itemService.showOnHand(itemView);
        }

        if (choice == itemView.DSP_ALL)
        {
            itemService.showAll(itemView);
        }

        if (choice == itemView.ADD_INV)
        {
            itemService.addItemInventory(itemView);
        }
        
        if (choice == itemView.RMV_INV)
        {
            itemService.removeItemInventory(itemView);
        }
        
        if (choice == itemView.INV_SEARCH)
        {
            itemService.itemsLookUp(itemView);
        }

        else if (choice == ItemView.RETURN) {
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
