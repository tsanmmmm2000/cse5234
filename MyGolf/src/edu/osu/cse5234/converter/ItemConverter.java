package edu.osu.cse5234.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.LineItem;

@Stateless
@LocalBean
public class ItemConverter {
	public Item toItem(LineItem lineItem) {
		Item item = new Item();
		item.setId(lineItem.getId());		
		item.setName(lineItem.getItemName());
		item.setAvailableQuantity(lineItem.getQuantity());
		item.setItemNumber(lineItem.getItemNumber());
		item.setUnitPrice(lineItem.getPrice());
		return item;
	} 
    
	public List<Item> toItems(List<LineItem> lineItems) {
		List<Item> items = new ArrayList<>();
		for (LineItem lineItem : lineItems) {
			items.add(toItem(lineItem));
		}
		return items;
	}
	
	public LineItem toLineItem(Item item) {
		LineItem lineItem = new LineItem();
		lineItem.setId(item.getId());
		lineItem.setItemName(item.getName());
		lineItem.setItemNumber(item.getItemNumber());
		lineItem.setPrice(item.getUnitPrice());
		lineItem.setQuantity(item.getAvailableQuantity());
		return lineItem;
	} 
    
	public List<LineItem> toLineItems(List<Item> items) {
		List<LineItem> lineItems = new ArrayList<>();
		for (Item item : items) {
			lineItems.add(toLineItem(item));
		}
		return lineItems;
	} 
}