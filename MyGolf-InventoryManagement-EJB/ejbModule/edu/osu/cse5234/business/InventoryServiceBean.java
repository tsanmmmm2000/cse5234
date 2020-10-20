package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.Item;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
public class InventoryServiceBean implements InventoryService {

	@PersistenceContext
	EntityManager entityManager;
	
	private final static String MY_QUERY = "Select i from Item i";
	
    /**
     * Default constructor. 
     */
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Inventory getAvailableInventory() {
		// TODO Auto-generated method stub	
		List<Item> items = entityManager.createQuery(MY_QUERY, Item.class).getResultList();
		Inventory inventory = new Inventory();		
		inventory.setItems(items);
		return inventory;
	}

	@Override
	public boolean validateQuantity(List<Item> items) {
		// TODO Auto-generated method stub
		Inventory inventory = getAvailableInventory();
		HashMap<String, Integer> map = getInventoryItemsMap(inventory.getItems());

		for (Item item : items) {
			String name = item.getName();
			if (!map.containsKey(name)) return false;
			if (map.get(name) < item.getAvailableQuantity()) return false;
		}
		return true;
	}

	@Override
	public boolean updateInventory(List<Item> items) {
		// TODO Auto-generated method stub
		Inventory inventory = getAvailableInventory();
		List<Item> inventoryItems = inventory.getItems();
		HashMap<String, Integer> map = getInventoryItemsMap(inventoryItems);
		
		// calculate new quantity of items
		for (Item item : items) {
			String name = item.getName();
			int num = item.getAvailableQuantity();
			map.put(name, map.getOrDefault(name, 0) - num);
		}
		
		// update quantity of items to inventory
		for (Item inventoryItem : inventoryItems) {
			inventoryItem.setAvailableQuantity(map.get(inventoryItem.getName()));
		}	
		return true;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	private HashMap<String, Integer> getInventoryItemsMap(List<Item> items) {
		HashMap<String, Integer> map = new HashMap<>();
		for (Item item : items) {
			map.put(item.getName(), item.getAvailableQuantity());
		}
		return map;
	}

}
