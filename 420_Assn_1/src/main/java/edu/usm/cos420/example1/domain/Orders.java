package edu.usm.cos420.example1.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import edu.usm.cos420.example1.service.impl.OrderService;

/**
 *
 *  Order records holds four pieces
 *  of information. The class implements the interface 
 *  Serializable so that we can store and retrieve the 
 *  information in this class 
 * 
 */

public class Orders implements Serializable {

	private static final long serialVersionUID = 7526472295622776147L;
	private Long orderNumber, custId;
	private static Long COUNTER = 0L;
	private Calendar placed;
	private TreeMap<String, Integer> itemsOnOrder;
	private OrderService orderService;

	/**
	 * get the order#  
	 * @return orderNumber 
	 */
	public Long getOrderNumber() {
		return orderNumber;
	}

	/**
	 * Set the orderNumber
	 * @param orderNumber new orderNumber 
	 */
	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Long getCustId() {
		return custId;
	}

	public TreeMap getItemsOnOrder(){
		return itemsOnOrder;
	}

	/** 
	 * Default Constructor : 
	 * Creates new order with an autogenenerated sequence ID 
	 */
	public Orders() {
		orderNumber = getNewOrderNumber();
		placed = Calendar.getInstance();
		custId = 0L;
		itemsOnOrder = new TreeMap<String, Integer>();

	}

	/** 
	 * Order constructor 
	 */
	public Orders(Long orderNumber, Calendar placed, Long custId, TreeMap itemsOnOrder) {
		this.orderNumber = orderNumber;
		this.placed = placed;
		this.custId = custId;
		this.itemsOnOrder = itemsOnOrder;
	}

	/**
	 * Returns the String representation of this order. .
	 * @see java.lang.Object#toString()
	 */

	public String toString() {
		String items = itemsToString();
		return "Order# " + orderNumber + " Customer# " + custId +
				"\n" + items;
	}

	public String itemsToString() {
		String itemsToString = "";
		Set keys = itemsOnOrder.keySet();
		for (Iterator i = keys.iterator(); i.hasNext();) {
			String plant = (String) i.next();																																																																																																																																	
			Integer qty = (Integer) itemsOnOrder.get(plant);
			String newLine = plant + " Qty: " + qty + "\n";
			itemsToString = itemsToString + newLine;
		}
		return itemsToString;
	}

	// for returning autogeneration of ids
	public Long getNewOrderNumber()
	{
		Long orderNumber = generateNumber();
		return orderNumber;
	}

	// for autogeneration of ids
	private Long generateNumber()
	{
        return COUNTER+=(int)(Math.random()*1000000);
	}

	public Calendar getDatePlaced() {
		return placed;

	}


}
