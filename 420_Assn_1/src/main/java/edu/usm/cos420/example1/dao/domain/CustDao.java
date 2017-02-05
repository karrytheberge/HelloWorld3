package edu.usm.cos420.example1.dao.domain;

import java.util.Iterator;
import java.util.List;

import edu.usm.cos420.example1.dao.GenericDao;
import edu.usm.cos420.example1.dao.ObjectStreamDao;
import edu.usm.cos420.example1.domain.Customer;

/**
 * 
 *  A Data Access Object specifically for customer records 
 *     
 */
public class CustDao {

	private GenericDao<Long,Customer> custDao;

	/**
	 * Default constructor creates an ObjectStream file called cust.ser
	 */
	public CustDao()
	{
		custDao = new ObjectStreamDao<Long,Customer>("cust.ser");
	}

	/**
	 * Constructor where the filename is provided 
	 */
	public CustDao(String fileName)
	{
		custDao = new ObjectStreamDao<Long,Customer>(fileName);
	}

	/**
	 * Support for other DAOs is provided
	 * @param dao a Data Access Object class that implements GenericDao<Long,Customer> 
	 */
	public CustDao(GenericDao<Long,Customer> dao)
	{
		custDao = dao;
	}

	/**
	 * Returns the DAO used in the class
	 * @return a DAO that implements GenericDao<Long,Customer> 
	 */
	public GenericDao<Long,Customer> getCustDao() {
		return custDao;
	}

	/**
	 * Add a customer to the DAO repository
	 * @param entity any customer record
	 */
	public void add(Customer entity)
	{
		custDao.add(entity.getId(), entity);
	}

	/**
	 * Update a customer in the DAO repository
	 * @param entity any customer object
	 */
	public void update(Customer entity) 
	{
		custDao.update(entity.getId(), entity);
	}

	/**
	 * Remove a customer in the DAO repository
	 * @param id of the customer object to remove
	 */

	public void remove(Long id)
	{
		custDao.remove(id);
	}

	/**
	 * Find a customer in the DAO repository
	 * @param id of the customer record to locate
	 * @return the customer with id field equal to key
	 */
	public Customer find(Long key)
	{
		return custDao.find(key);
	}

	public Long findValue(String lastName, String firstName)
	{
		Iterator<Customer> custIter = custDao.list().iterator();
		Customer customerSearch;
		while (custIter.hasNext()) {
			customerSearch = custIter.next();
			String lName = customerSearch.getLastName();
			String fName = customerSearch.getFirstName();
			if (lName.equals(lastName) &&
					fName.equals(firstName))
				return customerSearch.getId();
		}
		return 0L;
	}

	/**
	 * Generate a list of customers in the DAO repository
	 * @return List of customers 
	 */

	public List<Customer> list() {
		return custDao.list();
	}

}

