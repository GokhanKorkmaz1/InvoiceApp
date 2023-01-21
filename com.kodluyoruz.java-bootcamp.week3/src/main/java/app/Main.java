package app;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Operations operations = new Operations();
		
		Collection<Customer> customers = new ArrayList<>();
		Collection<Order> orders = new HashSet<>();
		Map<Integer, Invoice> invoices = new HashMap<>();
		LocalDateTime now = LocalDateTime.now();
		
		customers.add(new Customer("Michael", "Schumacher", now));
		customers.add(new Customer("Roger", "Federer", LocalDateTime.of(2022, 6, 15, 8, 27)));
		customers.add(new Customer("Rafael", "Nadal", now));
		customers.add(new Customer("Ricky", "Gervais", now));
		customers.add(new Customer("Cameron", "Diaz", LocalDateTime.of(2021, 6, 22, 21, 05)));
		
		Iterator<Customer> customerIterator = customers.iterator();
		while(customerIterator.hasNext()) {
			Customer customer = customerIterator.next();
			orders.add(new Order(customer.getId(), "Laptop", 400.51, customer.getId()));
		}
		
		Iterator<Order> orderIterator = orders.iterator();
		while(orderIterator.hasNext()) {
			Order order = orderIterator.next();
			invoices.put(order.getId(), 
					new Invoice(order.getQuantity()*order.getUnitPrice(), now, "Amazon", "E-commerce")) ;
		}
		
		Order order1 = new Order(2, "Pen", 29.73, 2);
		Order order2 = new Order(3, "Printer", 300.00, 1);
		Order order3 = new Order(5, "Xbox", 605, 1);
		
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		
		invoices.put(order1.getId(), new Invoice(order1.getQuantity()*order1.getUnitPrice(), LocalDateTime.of(2021, 6, 22, 21, 05), "Avansas", "Stationary"));
		invoices.put(order2.getId(), new Invoice(order2.getQuantity()*order2.getUnitPrice(), LocalDateTime.of(2022, 6, 15, 8, 27), "Avansas", "Stationary"));
		invoices.put(order3.getId(), new Invoice(order3.getQuantity()*order3.getUnitPrice(), LocalDateTime.of(2022, 6, 15, 8, 27), "Trendyol", "High Tech Shopping"));
		
		System.out.println("Tüm müşterileri listeleyin");
		operations.getCustomers(customers);
		
		System.out.println("İçerisinde ‘C’ harfi olan müşterileri listeleyin");
		Collection<Customer> customerListWithC = operations.getCustomersBySearchText(customers, "C");
		operations.getCustomers(customerListWithC);

		System.out.println("Haziran ayında kayıt olan müşterilerin faturalarınının toplam tutarını listeleyin");
		Collection<Customer> customerListSignUpInJune = operations.getCustomersBySearchDate(customers, Month.JUNE);
		operations.getCustomers(customerListSignUpInJune);
		
		System.out.println("Sistemdeki tüm faturaları listeleyin");
		operations.getInvoices(invoices);
		
		List<Invoice> invoiceList = new ArrayList<>(invoices.values());
		System.out.println("Sistemdeki 1500TL üstündeki faturaları listeleyin");
		operations.getInvoices(operations.getInvoicesByUpperAmount(invoiceList, 1500.0));
		
		System.out.println("Sistemdeki 1500TL üstündeki faturaları ortalamasını hesaplayın");
		System.out.println("1500 TL üzeri faturaların ortalaması : " + operations.getInvoicesAmountAvarageByAmount(invoiceList, 1500.0) + "\n");
		
		System.out.println("Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimlerini listeleyin");
		operations.getCustomerNameByUnderInvoiceAmount(invoices, orders, customers, 500.0);
		System.out.println();
		
		System.out.println("Haziran ayını faturalarını ortalaması 750 altı olan firmalarının hangi sektörde olduğunu listeleyen kodu yazın");
		operations.getSectorByInvoiceAmountAndMonthAverage(invoices, 750, Month.JUNE);
	}

}
