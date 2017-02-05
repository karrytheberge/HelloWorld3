package edu.usm.cos420.example1.dao.domain;


import java.util.Iterator;
import java.util.List;

import edu.usm.cos420.example1.dao.GenericDao;
import edu.usm.cos420.example1.dao.ObjectStreamDao;
import edu.usm.cos420.example1.domain.Items;

/**
 * 
 *  A Data Access Object specifically for item records 
 *     
 */

public class ItemDao {

    private GenericDao<Long,Items> itemDao;

    /**
     * Default constructor creates an ObjectStream file called items.ser
     */

    public ItemDao() {
        itemDao = new ObjectStreamDao<Long, Items>("items.ser");
    }

    /**
     * Constructor where the filename is provided 
     */
    public ItemDao(String fileName)
    {
        itemDao = new ObjectStreamDao<Long, Items>(fileName);;
    }

    /**
     * Support for other DAOs is provided
     * @param dao a Data Access Object class that implements GenericDao<Long,Items> 
     */
    public ItemDao(GenericDao<Long, Items> dao)
    {
        itemDao = dao;
    }

    /**
     * Returns the DAO used in the class
     * @return a DAO that implements GenericDao<Long,Items> 
     */
    public GenericDao<Long,Items> getItemDao() {
        return itemDao;
    }

    /**
     * Add an item to the DAO repository
     * @param entity any item record
     */
    public void add(Items entity)
    {
        itemDao.add(entity.getId(), entity);
    }

    /**
     * Update an item in the DAO repository
     * @param entity any item object
     */
    public void update(Items entity) 
    {
        itemDao.update(entity.getId(), entity);
    }

    /**
     * Remove an item in the DAO repository
     * @param id of the item object to remove
     */

    public void remove(Long id)
    {
        itemDao.remove(id);
    }

    /**
     * Find an item in the DAO repository
     * @param id of the item record to locate
     * @return the item with id field equal to key
     */
    public Items find(Long key)
    {
        return itemDao.find(key);
    }

    public Long findValue(String plantType)
    {
        Iterator<Items> itemIter = itemDao.list().iterator();
        Items plantSearch;
        while (itemIter.hasNext()) {
            plantSearch = itemIter.next();
            if (plantSearch.getplantType().equals(plantType))
                    return plantSearch.getId();
        }
        return 0L;
    }

    /**
     * Generate a list of items in the DAO repository
     * @return List of items 
     */

    public List<Items> list() {
        return itemDao.list();
    }

}

