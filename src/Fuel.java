public class Fuel {
	private double unitPrice;
	private String unitName;
	private String name;
	
	private double revenue;

	public Fuel(String fuelName, String unitName) {
		this.name = fuelName;
		this.unitName = unitName;
		this.revenue = 0.0;
	}
	
	public Fuel(String fuelName, String unitName, double price) {
		this.name = fuelName;
		this.unitName = unitName;
		this.unitPrice = price;
		this.revenue = 0.0;
	}
	
	public double paidUnits(double amount) {
		double transactionRevenue = amount*this.unitPrice;
		this.revenue += transactionRevenue;
		return transactionRevenue;
	}

	public String getUnitName() {
		return unitName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getName() {
		return name;
	}
	
	public double getRevenue() {
		return revenue;
	}
}
