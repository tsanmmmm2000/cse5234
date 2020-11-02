package edu.osu.cse5234.business;

import java.util.List;
import java.util.UUID;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.converter.ItemConverter;
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
	private ItemConverter itemConverter = ServiceLocator.getItemConverter();

	@PersistenceContext 
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
    	List<Item> items = itemConverter.toItems(order.getItems());
    	if (!inventoryService.validateQuantity(items)) {
            return "fail";
    	}
    	inventoryService.updateInventory(items);
		entityManager.persist(order);
		entityManager.flush();
    	return UUID.randomUUID().toString();
    }
    
    public boolean validateItemAvailability(Order order) {
    	List<Item> items = itemConverter.toItems(order.getItems());
    	return inventoryService.validateQuantity(items);
    } 
}
