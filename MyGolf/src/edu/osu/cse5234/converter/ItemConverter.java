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
	public Item toDomainObject(LineItem dto) {
		Item domain = new Item();
		domain.setName(dto.getItemName());
		domain.setAvailableQuantity(dto.getQuantity());
		domain.setItemNumber(dto.getItemNumber());
		domain.setUnitPrice(dto.getPrice());
		return domain;
	} 
    
	public List<Item> toDomainObjects(List<LineItem> dtos) {
		List<Item> domains = new ArrayList<>();
		for (LineItem dto : dtos) {
			domains.add(toDomainObject(dto));
		}
		return domains;
	}
	
	public LineItem toDataTransferObject(Item domain) {
		LineItem dto = new LineItem();
		dto.setId(domain.getId());
		dto.setItemName(domain.getName());
		dto.setItemNumber(domain.getItemNumber());
		dto.setPrice(domain.getUnitPrice());
		dto.setQuantity(domain.getAvailableQuantity());
		return dto;
	} 
    
	public List<LineItem> toDataTransferObjects(List<Item> domains) {
		List<LineItem> dtos = new ArrayList<>();
		for (Item domain : domains) {
			dtos.add(toDataTransferObject(domain));
		}
		return dtos;
	} 
}