package edu.osu.cse5234.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.business.OrderProcessingServiceBean;
import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.converter.ItemConverter;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;
import edu.osu.cse5234.util.ServiceLocator;


@Controller
@RequestMapping("/purchase")
public class Purchase {
	
	private OrderProcessingServiceBean orderProcessingServiceBean = ServiceLocator.getOrderProcessingService();
	private InventoryService inventoryService = ServiceLocator.getInventoryService();
	private ItemConverter itemConverter = ServiceLocator.getItemConverter();

	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Display items for purchase	
		Inventory inventory = inventoryService.getAvailableInventory();
		Order order = new Order();
		order.setItems(itemConverter.toDataTransferObjects(inventory.getItems()));
		request.setAttribute("order", order);
		return "OrderEntryForm";
	}

	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {
		// Submit selected Items for purchase
		String message = "";
		String redirectUrl = "redirect:/purchase/paymentEntry";
		if (orderProcessingServiceBean.validateItemAvailability(order)) {
			request.getSession().setAttribute("order", order);
		} else {
			message = "Please resubmit item quantities";
			redirectUrl = "redirect:/purchase";			
		}
		request.getSession().setAttribute("message", message);
		return redirectUrl;
	}
	
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryForm(HttpServletRequest request, HttpServletResponse response) {
		// Display payment entry form
		request.setAttribute("payment", new PaymentInfo());	
		return "PaymentEntryForm";
	}
	
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("payment") PaymentInfo payment, HttpServletRequest request) {
		// Submit Payment info
		request.getSession().setAttribute("payment", payment);
		return "redirect:/purchase/shippingEntry";
	}
	
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String shippingEntry(HttpServletRequest request, HttpServletResponse response) {
		// Display shipping entry form
		request.setAttribute("shipping", new ShippingInfo());	
		return "ShippingEntryForm";
	}
	
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shipping") ShippingInfo shipping, HttpServletRequest request) {
		// Submit shipping info
		request.getSession().setAttribute("shipping", shipping);
		return "redirect:/purchase/viewOrder";
	}	
	
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrderForm(HttpServletRequest request, HttpServletResponse response) {
		// Display complete order
		return "ViewOrder";
	}
	
	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrderForm(HttpServletRequest request) {
		// Confirm order
		Order order = (Order) request.getSession().getAttribute("order");
		PaymentInfo payment = (PaymentInfo) request.getSession().getAttribute("payment");
		ShippingInfo shipping = (ShippingInfo) request.getSession().getAttribute("shipping");
		order.setCustomerName(shipping.getName());
		order.setEmailAddress(shipping.getEmail());
		order.setPayment(payment);
		order.setShipping(shipping);
		String confirmationCode = orderProcessingServiceBean.processOrder(order);
		request.getSession().setAttribute("confirmationCode", confirmationCode);
		return "redirect:/purchase/viewConfirmation";
	}	
	
	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmationForm(HttpServletRequest request, HttpServletResponse response) {
		// Display confirmation 
		return "Confirmation";
	}
}
