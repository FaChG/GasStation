import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class GasStation {

	public static void main(String[] args) {
		BufferedReader reader = null;
		String line = null;
		FuelTypes fuelTypes = new FuelTypes();
		Dispenser[] dispensers = new Dispenser[5];
		for(int i = 0; i<5; ++i) {
			dispensers[i] = new Dispenser();
		}
		
		try {
			reader = new BufferedReader(new FileReader("fuels.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("Can't find fuel definitions!");
			e.printStackTrace();
		}
		
		try {
			reader.readLine(); // Discard header
			while((line = reader.readLine()) != null) {
				String[] fields = line.split("\t");
				
				String fuelName = fields[0];
				String unitName = fields[1];
				double unitPrice = Double.parseDouble(fields[2]);
				
				fuelTypes.addFuelType(new Fuel(fuelName, unitName, unitPrice));
			}
		} catch (IOException e) {
			System.out.println("Error reading from fuel definition file!");
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Super Gas Station 42\n===================\n\n\n");
		while(true) {
			try {
				System.out.println("*********************************************");
				System.out.println("Select dispenser (1-5)");
				int dispenser = Integer.parseInt(scanner.nextLine());
				if (dispenser < 1 || dispenser > 5) {
					System.out.println("Sorry we only have 5 dispensers…\n");
					continue;
				}
				
				System.out.println("Select a fule type from the following: " + fuelTypes.fuelNames());
				Fuel selectedFuel = fuelTypes.fuelByName(scanner.nextLine());
				
				System.out.println("You have selected " + selectedFuel.getName() + ", the price is $" + selectedFuel.getUnitPrice() + "/" + selectedFuel.getUnitName() + ".\n");
				System.out.println("How many " + selectedFuel.getUnitName() + " you want to buy?");
				
				double quantity = Double.parseDouble(scanner.nextLine());
				double paid = selectedFuel.paidUnits(quantity);
				dispensers[dispenser-1].paid(paid);
				
				System.out.println("You paid $" + paid + "\n\n");
				
				System.out.println("--- Summary ---");
				for(int i = 0; i<5; ++i) {
					System.out.println("Dispenser " + (i+1) + "; revenue = $" + dispensers[i].getRevenue());
				}
				
				System.out.println("\n" + fuelTypes.summary());
				
			} catch (Exception exc) {
				exc.printStackTrace();
				System.out.println("I am sorry but I can't understand you, let's try again…");
			}
		}
	}

}
