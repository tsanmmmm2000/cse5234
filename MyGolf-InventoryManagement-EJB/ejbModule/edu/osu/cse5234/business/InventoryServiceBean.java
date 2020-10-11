package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.Item;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
public class InventoryServiceBean implements InventoryService {

    /**
     * Default constructor. 
     */
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Inventory getAvailableInventory() {
		// TODO Auto-generated method stub
		List<Item> items = new ArrayList<>();
		items.add(buildItem("club", "300", "2"));
		items.add(buildItem("ball", "10", "12"));
		items.add(buildItem("bag", "150", "1"));
		items.add(buildItem("shoes", "40", "1"));
		items.add(buildItem("polo", "30", "2"));
		
		Inventory inventory = new Inventory();		
		inventory.setItems(items);
		
		return inventory;
	}

	@Override
	public boolean validateQuantity(List<Item> items) {
		// TODO Auto-generated method stub		
		return true;
	}

	@Override
	public boolean updateInventory(List<Item> items) {
		// TODO Auto-generated method stub
		return true;
	}
	
	private Item buildItem(String name, String price, String quantity) {
		Item item = new Item();
		item.setName(name);
		item.setPrice(price);
		item.setQuantity(quantity);
		return item;
	}	

}
