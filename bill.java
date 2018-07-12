import java.util.Scanner;
//calculates the electric bill of the building. Personal use only.
//copyrighted.
//Developer: Lokeshwar
//github: im-loki

interface values{
	
	double tax_rate=5;
	double loss_rate=7.5;
	double demand_unit_charges=230;
	double elec_unit_rate=8.70;
	double gen_unit_rate=14;
	
	
}

class entity implements values{
	
	double elec_consumed,lt_loss,elec_gross_consumed_units;
	double billing_demand;
	double elec_gross_consumption_ruppees;
	double tax_cost;
	double gen_netunits,gen_cost;
	double total_cost;
	
	
	entity(double elec_present,double elec_previous,double alloted_power,
			double gen_present,double gen_previous){
		
		System.out.println("Inside constructor block.");
		
		if((elec_present>=elec_previous)&&(gen_present>gen_previous)){
			
		elec_consumed=elec_present-elec_previous;
		lt_loss=(elec_consumed*loss_rate)/100;
		elec_gross_consumed_units=lt_loss+elec_consumed;
		billing_demand=alloted_power*demand_unit_charges;
		elec_gross_consumption_ruppees=elec_gross_consumed_units*elec_unit_rate;
		tax_cost=((elec_gross_consumption_ruppees+billing_demand)*tax_rate)/100;
		gen_netunits=gen_present-gen_previous;
		gen_cost=gen_netunits*gen_unit_rate;
		total_cost=gen_cost+elec_gross_consumption_ruppees+tax_cost+billing_demand;
		
		System.out.println("Calculations completed.");
		
		}else {
			
			System.out.println("Check Input.");
		
		}
		
	}
	
	void display_result() {
		System.out.println("\nThe values are::");
		System.out.println("Consume Unit: "+elec_consumed);
		System.out.println("LT loss unit: "+lt_loss);
		System.out.println("Gross Consumption unit: "+
		elec_gross_consumed_units);
		System.out.println("Bill Demand Cost: "+billing_demand);
		System.out.println("Electric gross consumption: "
				+elec_gross_consumption_ruppees);
		System.out.println("Tax: "+tax_cost);
		System.out.println("Generator Units: "+gen_netunits);
		System.out.println("Generator Cost: "+gen_cost);
		System.out.println("Total cost: "+total_cost);
	}
	
	
}
public class bill {
	

	public static void main(String[] args) {
		
		
		double elec_present, elec_previous, alloted_power, gen_present, gen_previous;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\t\t\t---Developed by Lokeshwar---\t\t\t");
		System.out.print("\nEnter the electric_present meter reading:: ");
		elec_present=scan.nextDouble();
		System.out.print("\nEnter the electric_previous meter reading:: ");
		elec_previous=scan.nextDouble();
		System.out.print("\nEnter the alloted power units:: ");
		alloted_power=scan.nextDouble();
		System.out.print("\nEnter the generator present readings:: ");
		gen_present=scan.nextDouble();
		System.out.print("\nEnter the generator previous readings:: ");
		gen_previous=scan.nextDouble();
		System.out.println("Input completed.");
		
		if(elec_present<elec_previous) {
			double temp = elec_present;
			elec_present = elec_previous;
			elec_previous = temp;
		}
		
		if(gen_present<gen_previous) {
			double temp = gen_present;
			gen_present = gen_previous;
			gen_previous = temp;
		}
		
		entity obj = new entity(elec_present,elec_previous,alloted_power,
				gen_present,gen_previous);
		
		obj.display_result();
		
		
		scan.close();
		

	}
	
	

}

/*
OUTPUT::
			---Developed by Lokeshwar---			

Enter the electric_present meter reading:: 32080

Enter the electric_previous meter reading:: 31596

Enter the alloted power units:: 10

Enter the generator present readings:: 743

Enter the generator previous readings:: 739
Input completed.
Inside constructor block.
Calculations completed.

The values are::
Consume Unit: 484.0
LT loss unit: 36.3
Gross Consumption unit: 520.3
Bill Demand Cost: 2300.0
Electric gross consumption: 4396.534999999999
Tax: 334.82674999999995
Generator Units: 4.0
Generator Cost: 48.0
Total cost: 7079.361749999999
*/
