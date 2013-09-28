
public class Dispenser {
	private double revenue;
	
	public Dispenser() {
		revenue = 0.0;
	}
	
	public void paid(double amount) {
		revenue += amount;
	}
	
	public double getRevenue() {
		return revenue;
	}
}
