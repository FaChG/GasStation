import java.util.HashMap;


public class FuelTypes {
	private HashMap<String, Fuel> fuelTypes;
	
	public FuelTypes() {
		fuelTypes = new HashMap<String, Fuel>();
	}
	
	public void addFuelType(Fuel fuel) {
		fuelTypes.put(fuel.getName(), fuel);
	}
	
	public Fuel fuelByName(String name) {
		return fuelTypes.get(name);
	}
	
	public String fuelNames() {
		String output = new String("");
		
		for(String f : fuelTypes.keySet()) {
			output += f + ", ";
		}
		
		return output.substring(0, output.length() - 2);
	}
	
	public String summary() {
		String output = new String("");
		
		for(String name : fuelTypes.keySet()) {
			output += name + " = $" + fuelTypes.get(name).getRevenue() + "\n";
		}
		return output;
	}
}
