package edu.osu.cse5234.business;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.converter.ItemConverter;
import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.ShippingInfo;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
@Resource(name="jms/emailQCF", lookup="jms/emailQCF", type=ConnectionFactory.class) 
public class OrderProcessingServiceBean {

	private static String SHIPPING_URI = "http://localhost:9080/UPS/services/shipping";
	
	private InventoryService inventoryService = ServiceLocator.getInventoryService();
	private ItemConverter itemConverter = ServiceLocator.getItemConverter();

	@Inject
	@JMSConnectionFactory("java:comp/env/jms/emailQCF")
	private JMSContext jmsContext;

	@Resource(lookup="jms/emailQ")
	private Queue queue;
	
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
		ship(order);
		notifyUser(order.getEmailAddress());
    	return UUID.randomUUID().toString();
    }
    
    public boolean validateItemAvailability(Order order) {
    	List<Item> items = itemConverter.toItems(order.getItems());
    	return inventoryService.validateQuantity(items);
    }
    
    private void ship(Order order) {
    	Client client = ClientBuilder.newClient();
    	WebTarget baseTarget = client.target(SHIPPING_URI);
    			
    	ShippingInfo shipping = order.getShipping();
    	JsonObject requestJson = Json.createObjectBuilder()
    	.add("Organization", "MyGolf LLC.")
    	.add("OrderRefId", order.getId())
    	.add("ItemsCount", order.getItems().size())
    	.add("Zip", shipping.getZip())
    	.build();

    	JsonObject responseJson = baseTarget.path("/initiate")
    	.request(MediaType.APPLICATION_JSON)
    	.post(Entity.json(requestJson), JsonObject.class);

    	System.out.println("UPS accepted request? " +   
    	     responseJson.getBoolean("Accepted"));
    	System.out.println("Shipping Reference Number: " + 
    	     responseJson.getInt("ShippingReferenceNumber"));

    	client.close();    	
    }
    
    private void notifyUser(String customerEmail) {
    	String message = customerEmail + ":" +
    	       "Your order was successfully submitted. " + 
    	     	"You will hear from us when items are shipped. " + 
    	      	new Date();

    	System.out.println("Sending message: " + message);
    	jmsContext.createProducer().send(queue, message);
    	System.out.println("Message Sent!");
	}
    
}
