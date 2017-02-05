package edu.usm.cos420.example1.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import edu.usm.cos420.example1.dao.domain.OrderDao;
import edu.usm.cos420.example1.domain.Items;
import edu.usm.cos420.example1.domain.Orders;
import edu.usm.cos420.example1.view.impl.CustomerView;
import edu.usm.cos420.example1.view.impl.ItemView;
import edu.usm.cos420.example1.view.impl.OrderView;

public class OrderService {

	OrderDao orderDao;
	private OrderView orderView;
	private CustomerService customerService;
	private CustomerView customerView;
	private ItemService itemService;
	private ItemView itemView;

	/**
	 * Default Constructor creates a default itemDao object
	 */

	public OrderService() 
	{
		this.orderDao = new OrderDao();
	}

	/**
	 * Constructor with the DAO provided 
	 * @param dao Data Access Object to use in the service
	 */

	public OrderService(OrderDao orderDao)
	{
		this.orderDao = orderDao;
	}

	/**
	 * Add an order to the DAO repository
	 */

	public void addNewOrder(OrderView orderView, CustomerService customerService,
			ItemService itemService, ItemView itemView) {
		this.customerService = customerService;
		this.orderView = orderView;
		this.itemService = itemService;
		this.itemView = itemView;
		Orders order = new Orders();
		Long orderNumber = order.getOrderNumber();
		while (orderDao.find(orderNumber) != null) 
		{
			order.getNewOrderNumber();
		}
		Calendar placed = order.getDatePlaced();
		Long custId = orderView.collectCustomerId(customerService);
		TreeMap items = collectItemsOnOrder(itemService, itemView);
		order = new Orders(orderNumber, placed, custId, items);
		orderDao.add(order);
		System.out.println(order.toString());

	}

	private TreeMap collectItemsOnOrder(ItemService itemService, ItemView itemView) {
		TreeMap<String, Integer> itemsList = new TreeMap<String, Integer>();
		this.itemService = itemService;
		this.itemView = itemView;
		boolean addOrder = true;
		while (addOrder) {
			Items item = itemService.orderItemLookUp(itemView);
			while (item == null) {
				System.out.println("Item not found.");
				item = itemService.orderItemLookUp(itemView);
			}
			int qty = orderView.collectOrderQty();
			int onHand = item.getOnHand();
			if (onHand < qty) {
				String answer = orderView.notEnoughInventory(onHand);
				if (answer.equalsIgnoreCase("a")) {
					qty = orderView.collectOrderQty();
				}
				if (answer.equalsIgnoreCase("c")) {
					addOrder = orderView.addMorePrompt();
				}
			}
			if (onHand >= qty) {
				itemService.rmvInventory(item.getId(), qty);
			}
			String plant = item.getId() + " " + item.getplantType();
			itemsList.put(plant, qty);
			addOrder = orderView.addMorePrompt();
		}
		return itemsList;

	}


	public void showCustomerOrder(OrderView orderView, CustomerService customerService, 
			CustomerView customerView) {
		this.customerService = customerService;
		this.customerView = customerView;
		Iterator iter = orderDao.list().iterator();
		String lName = customerView.collectLastName();
		String fName = customerView.collectFirstName();
		Long custId = customerService.dao.findValue(lName, fName);
		Calendar endDate = Calendar.getInstance();
		Calendar startDate = Calendar.getInstance();
		startDate.add(Calendar.MONTH, -1);
		
		while (iter.hasNext()){
			Orders thisOrder = (Orders) iter.next();
			if (thisOrder.getDatePlaced().compareTo(startDate) >= 0 &&
					thisOrder.getDatePlaced().compareTo(endDate) <= 0); {
						if (custId == thisOrder.getCustId());
						System.out.println(thisOrder.toString());
					}
		}
		
		

	}

	public String getPlantWIdToString(Long plantId) {
		String plant = itemService.getPlantName(plantId);
		return plant;
	}


}
