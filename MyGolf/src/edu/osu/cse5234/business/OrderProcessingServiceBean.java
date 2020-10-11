package edu.osu.cse5234.business;

import java.util.List;
import java.util.UUID;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {

	private InventoryService inventoryService = ServiceLocator.getInventoryService();
	
    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
    	List<Item> items = order.getItems();
    	if (inventoryService.validateQuantity(items)) {
        	inventoryService.updateInventory(items);
    	}
    	return UUID.randomUUID().toString();
    } 
    
    public boolean validateItemAvailability(Order order) {
    	return inventoryService.validateQuantity(order.getItems());
    }

}
