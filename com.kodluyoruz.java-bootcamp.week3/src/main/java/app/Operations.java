package app;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class Operations {
	
	void getCustomers(Collection<Customer> customerList){
		customerList.stream().forEach(c -> System.out.println(c.toString()));
	}
	
	Collection<Customer> getCustomersBySearchText(Collection<Customer> customerList, String key){
		return customerList.stream().filter
				(c -> c.getName().toLowerCase().contains(key.toLowerCase()) || 
					c.getSurname().toLowerCase().contains(key.toLowerCase()))
				.collect(Collectors.toSet());
	}
	
	Collection<Customer> getCustomersBySearchDate(Collection<Customer> customerList, Month month){
		return customerList.stream().filter
				(c -> c.getCreateDate().getMonth().getValue() == month.getValue())
				.collect(Collectors.toSet());
	}
	
	void getInvoices(Map<Integer, Invoice> invoices){
		invoices.forEach((o,i) -> System.out.println("Order ID : " + o + "\n" + i.toString()));
	}
	
	void getInvoices(Collection<Invoice> invoices){
		invoices.forEach(i -> System.out.println(i.toString()));
	}
	
	Collection<Invoice> getInvoicesByUpperAmount(Collection<Invoice> invoices, double amount){
		return invoices.stream().filter(i -> i.getAmount() >= amount).collect(Collectors.toList());
	}
	
	Map<Integer, Invoice> getInvoicesByUnderAmount(Map<Integer, Invoice> invoices, double amount){
		Map<Integer, Invoice> resultMap = new HashMap<>();
		invoices.forEach((o,i) -> {
			if(i.getAmount() < amount) {
				resultMap.put(o, i);
			}
		});
		return resultMap; 
	}
	
	double getInvoicesAmountAvarageByAmount(Collection<Invoice> invoices, double amount){
		return invoices.stream().filter(i -> i.getAmount() >= amount).collect(Collectors.averagingDouble(a -> a.getAmount()));
	}
	
	void getCustomerNameByUnderInvoiceAmount(Map<Integer, Invoice> invoices, Collection<Order> orders, Collection<Customer> customers, double amount) {
		Map<Integer, Invoice> filteredMap = getInvoicesByUnderAmount(invoices, amount);
		Collection<Order> filteredOrders = orders.stream().filter(o -> filteredMap.keySet().contains(o.getId())).collect(Collectors.toList());
		filteredOrders.forEach(o -> customers.stream()
				.filter(c -> c.getId() == o.getCustomerId()).collect(Collectors.toList()).
				forEach(s -> System.out.println(s.getName() + " " + s.getSurname())));
	}
	
	void asdasd(Map<Integer, Invoice> invoices, double amount, Month month) {
		 invoices.values().stream()
				.filter(i -> i.getDateOfInvoice().getMonth().getValue() == month.getValue())
				.collect(Collectors.groupingBy(Invoice::getSector, Collectors.averagingDouble(Invoice::getAmount)))
				.forEach((i,d) -> {
					if(amount > d) System.out.println(i);
				});
		
	}
	
}
