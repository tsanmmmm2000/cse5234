package edu.osu.cse5234.converter;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.LineItem;
import lombok.NonNull;

@Stateless
@LocalBean
public class ItemConverter {
	public Item toDomainObject(@NonNull LineItem dto) {
		Item domain = new Item();
		domain.setName(dto.getItemName());
		domain.setAvailableQuantity(dto.getQuantity());
		domain.setItemNumber(dto.getItemNumber());
		domain.setUnitPrice(dto.getPrice());
		return domain;
	} 
    
	public List<Item> toDomainObjects(@NonNull List<LineItem> dtos) {
		return dtos.stream()
				.map(this::toDomainObject)
				.collect(Collectors.toList());
	}
	
	public LineItem toDataTransferObject(@NonNull Item domain) {
		LineItem dto = new LineItem();
		dto.setId(domain.getId());
		dto.setItemName(domain.getName());
		dto.setItemNumber(domain.getItemNumber());
		dto.setPrice(domain.getUnitPrice());
		dto.setQuantity(domain.getAvailableQuantity());
		return dto;
	} 
    
	public List<LineItem> toDataTransferObjects(@NonNull List<Item> domains) {		
		return domains.stream()
				.map(this::toDataTransferObject)
				.collect(Collectors.toList());
	} 
}
