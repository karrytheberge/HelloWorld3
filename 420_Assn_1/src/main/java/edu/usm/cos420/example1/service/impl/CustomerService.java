package edu.usm.cos420.example1.service.impl;

import java.util.Iterator;
import java.util.List;

import edu.usm.cos420.example1.dao.domain.CustDao;
import edu.usm.cos420.example1.domain.Customer;
import edu.usm.cos420.example1.view.impl.CustomerView;

public class CustomerService {

	CustDao dao;
	private CustomerView customerView;

	/**
	 * Default Constructor creates a default custDao object 
	 */

	public CustomerService() 
	{
		this.dao = new CustDao();  
	}

	/**
	 * Constructor with the DAO provided 
	 * @param dao Data Access Object to use in the service
	 */
	public CustomerService(CustDao dao)
	{
		this.dao = dao; 
	}

	/**
	 * Add a customer to the DAO repository
	 */

	public void addACustomer(CustomerView customerView){
		Customer customer = new Customer();
		this.customerView = customerView;
		Long id = customer.getNewId();
		while (dao.find(id) != null) {
			customer.getNewId();
		}
		String firstName, lastName, strAddress, cityTown, state, zipCode;
		firstName = customerView.collectFirstName();
		lastName = customerView.collectLastName();
		if(dao.findValue(lastName, firstName) != null){
			System.out.println("Customer already exists.");
			System.out.println("Customer# " + dao.findValue(lastName, firstName) +
					" " + firstName + " " + lastName);
			return;
		}
		strAddress = customerView.collectStrAddress();
		cityTown = customerView.collectCityTown();
		state = customerView.collectState();
		zipCode = customerView.collectZip();        
		customer = new Customer(id, firstName, lastName, strAddress, cityTown, state, zipCode);
		dao.add(customer);
		System.out.println(customer.toString());
	}

	public void showAllCustomers(){
		Iterator nextCustomer = dao.list().iterator();
		while (nextCustomer.hasNext()){
			System.out.println(nextCustomer.next());
		}
	}

	public void customerLookUp(CustomerView customerView){
		this.customerView = customerView;
		String customerFirst = customerView.collectFirstName();
		String customerLast = customerView.collectLastName();
		Long thisID = dao.findValue(customerLast, customerFirst);
		if (thisID != 0L) {
		System.out.println();
		System.out.println(dao.find(thisID).customerWIdToString());
		}
		else System.out.println("Customer not found.");
	}

	public Long getNameToId(String lastName, String firstName)
	{
		Long thisId = dao.findValue(lastName, firstName);
		return thisId;
	}

}



