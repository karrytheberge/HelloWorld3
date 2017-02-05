package edu.usm.cos420.example1.service.impl;

import java.util.Iterator;
import java.util.List;

import edu.usm.cos420.example1.dao.domain.ItemDao;
import edu.usm.cos420.example1.domain.Items;
import edu.usm.cos420.example1.view.impl.ItemView;

public class ItemService {

	ItemDao itemDao;
	private ItemView itemView;

	/**
	 * Default Constructor creates a default itemDao object
	 */

	public ItemService() 
	{
		this.itemDao = new ItemDao();
	}

	/**
	 * Constructor with the DAO provided 
	 * @param dao Data Access Object to use in the service
	 */

	public ItemService(ItemDao itemDao)
	{
		this.itemDao = itemDao;
	}

	/**
	 * Add a customer to the DAO repository
	 */
	public void addNewItem(ItemView itemView) {
		Items items = new Items();
		this.itemView = itemView;
		Long id = items.getNewId();
		while (itemDao.find(id) != null) 
		{
			items.getNewId();
		}
		String plantType, description;
		int onHand;
		plantType = itemView.collectPlantType();
		description = itemView.collectDescription();
		onHand = itemView.collectAmountOnHand();
		items = new Items(id, plantType, description, onHand);
		itemDao.add(items);
	}

	public void removeItem(ItemView itemView) {
		Long id = itemView.collectPlantId();
		itemDao.remove(id);
	}

	public void  showOnHand(ItemView itemView){
		this.itemView = itemView;
		Long plantId = itemView.collectPlantId();
		Items plant = itemDao.find(plantId);
		if (plant == null) { 
			itemView.itemNotFound();
		}
		else {
			int qtyAvailable = plant.getOnHand();
			System.out.println(plant.toString() + qtyAvailable);
		}
	}

	public void addItemInventory(ItemView itemView) {
		this.itemView = itemView;
		Long item = itemView.collectPlantId();
		addInventory(item);

	}
	public void removeItemInventory(ItemView itemView) {
		this.itemView = itemView;
		Long item = itemView.collectPlantId();
		int subAmount = itemView.collectUserSubtraction();
		rmvInventory(item, subAmount);
		System.out.println(item.toString());

	}

	public void addInventory(Long id) {
		Items item = itemDao.find(id);
		int available = item.getOnHand();
		int addAmount = itemView.collectUserAddition();
		available += addAmount;
		item.setInv(available);
		itemDao.update(item);
		System.out.println(item.toString());
	}

	public void rmvInventory(Long id, int subAmount) {
		Items item = itemDao.find(id);
		int available = item.getOnHand();
		available -= subAmount;
		if (!(available < 0)) {
			item.setInv(available);
			itemDao.update(item); 
		}
		else System.out.println("Inventory too low. "
				+ "Unable to complete adjustment.");
	}

	public void itemsLookUp(ItemView itemView){
		this.itemView = itemView;
		String plantType = itemView.collectPlantType();
		Long thisID = itemDao.findValue(plantType);
		if (thisID == null) {
			System.out.println("Item not found."); 
		}
		else {
			System.out.println();
			System.out.println(itemDao.find(thisID).plantWIdToString());
		}
	}

	public void showAll(ItemView itemView)	{
		Iterator nextItem = itemDao.list().iterator();
		while (nextItem.hasNext()){
			System.out.println(nextItem.next());
		}
	}

	public Items orderItemLookUp(ItemView itemView) {
		this.itemView = itemView;
		Items itemWanted;
		String plantType = itemView.collectPlantType();
		Long thisId = itemDao.findValue(plantType);
		if (thisId == null) {
			System.out.println("Item not found.");
			return null;
		}
		else {
			itemWanted = itemDao.find(thisId);
			return itemWanted;
		}

	}

	public String getPlantName(Long plantId) {
		Items plant = itemDao.find(plantId);
		String plantName = plant.getplantType();
		return plantName;
	}

}