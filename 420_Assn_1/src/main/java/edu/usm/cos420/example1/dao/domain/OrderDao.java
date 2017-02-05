package edu.usm.cos420.example1.dao.domain;

import java.util.Iterator;
import java.util.List;

import edu.usm.cos420.example1.dao.GenericDao;
import edu.usm.cos420.example1.dao.ObjectStreamDao;
import edu.usm.cos420.example1.domain.Orders;

/**
 * 
 *  A Data Access Object specifically for orders 
 *     
 */
public class OrderDao {
    
    private GenericDao<Long,Orders> orderDao;
    
    /**
     * Default constructor creates an ObjectStream file called orders.ser
     */

    public OrderDao() {
        orderDao = new ObjectStreamDao<Long, Orders>("orders.ser");
    }

    /**
     * Constructor where the filename is provided 
     */
    public OrderDao(String fileName)
    {
        orderDao = new ObjectStreamDao<Long, Orders>(fileName);;
    }

    /**
     * Support for other DAOs is provided
     * @param dao a Data Access Object class that implements GenericDao<Long,Orders> 
     */
    public OrderDao(GenericDao<Long, Orders> dao)
    {
        orderDao = dao;
    }

    /**
     * Returns the DAO used in the class
     * @return a DAO that implements GenericDao<Long,Orders> 
     */
    public GenericDao<Long,Orders> getOrderDao() {
        return orderDao;
    }

    /**
     * Add an item to the DAO repository
     * @param entity any item record
     */
    public void add(Orders entity)
    {
        orderDao.add(entity.getOrderNumber(), entity);
    }

    /**
     * Update an order in the DAO repository
     * @param entity any order object
     */
    public void update(Orders entity) 
    {
        orderDao.update(entity.getOrderNumber(), entity);
    }

    /**
     * Remove an order in the DAO repository
     * @param id of the order to remove
     */

    public void remove(Long id)
    {
        orderDao.remove(id);
    }

    /**
     * Find an order in the DAO repository
     * @param orderNumber of the order to locate
     * @return the order with orderNumber field equal to key
     */
    public Orders find(Long key)
    {
        return orderDao.find(key);
    }

    /**
    public Long findValue(String customerName)
    {
        Iterator<Orders> orderIter = orderDao.list().iterator();
        Orders orderSearch;
        while (orderIter.hasNext()) {
            orderSearch = orderIter.next();
            if (orderSearch.getCustomerName().equals(customerName))
                    return orderSearch.getOrderNumber();
        }
        return 0L;
    }
    **/

    /**
     * Generate a list of items in the DAO repository
     * @return List of items 
     */

    public List<Orders> list() {
        return orderDao.list();
    }
}

