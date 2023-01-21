package app;

public class Order {
	// oluşan her Customer için unique id sağlar
    private static int autoIncrementId = 0;
	
	private int id;
	private int customerId;
	private String name;
	private double unitPrice;
	private int quantity;
	
	public Order(int customerId, String name, double unitPrice, int quantity) {
		setId(++autoIncrementId);
		setCustomerId(customerId);
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	
}
