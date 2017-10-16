package com.database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// import dummy fee, bus and employee classes here
// or you can just store this in the same folder with the others

public class Database{

	//allows to have only one instance of this class *SINGLETON*
	public static final Database database = new Database();

	private ArrayList<Fee> fees = new ArrayList<>();
	private ArrayList<Bus> bus_accounts = new ArrayList<>();
	private ArrayList<Employee> employee_accounts = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);

	private void clearScreen() throws IOException, InterruptedException{
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}

	private void pause(){
		System.out.print("\n\n\n\n\n\t\t\t\tPress Enter...");
		sc.nextLine();
	}

	public void addFee(Fee f){
		fees.add(f);
	}

	public void addEmployee(Employee e){
		employee_accounts.add(e);
	}

	public void addBus(Bus b){
		bus_accounts.add(b);
	}

	public ArrayList<Fee> getAllFees(){
		return fees;
	}

	public ArrayList<Bus> getAllBuses(){
		return bus_accounts;
	}

	public ArrayList<Employee> getAllEmployees(){
		return employee_accounts;
	}

	// public void addFee(String fee_type, String time_paid, String date_paid, String or_number, String bus_plate, String employee_id){
	// 	// someone suggested that it doesn't have to be the employee_id, we can also use the name, but i'm just gonna use the id here :) 
	// 	fees.add(new Fee(fee_type, fee_amount, time_paid, date_paid, or_number, findBus(, employee_id));
	// }

	// public void addBus(String plate_number, String company, String bus_number){
	// 	bus_accounts.add(new Bus(plate_number, company, bus_number));
	// }

	// public void addEmployee(String name, String id, String position){
	// 	employee_accounts.add(new Employee(name, id, position));
	// }

	/************************para sa mga naniniwala na "CMD is life!"***************************/
	private void displayFeeTable(){
		System.out.println("\n\n\t\t\t\t     [Table of Fees]\n");
		System.out.println("   |   OR #   |  Date    |   Time   |   Bus Number   |   Cashier");
		int counter = 1;
		for(Fee f : fees){
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println(" " + counter + " | " + f.getORNum() + "   |   " + f.getDatePaid() + "  | " + f.getTimePaid() + " |    " + f.getBus().getBusNumber() + "     | " + f.getEmployeeID());
			counter++;
		}
	}

	private void displayBusTable(){
		System.out.println("\n\n\t\t\t\t     [Bus Accounts]\n");
		System.out.println("   |   Company   |   Plate #   |  Bus Type  |  Bus Number");
		int counter = 1;
		for(Bus b : bus_accounts){
			String bus_type = "";
			if(b.isMinibus()){
				bus_type = "minibus";
			}else{
				bus_type = "regular";
			}

			System.out.println("------------------------------------------------------------");
			System.out.println(" " + counter + " |    " + b.getCompany() + "    |   " + b.getPlateNo() + "    |   " + bus_type + "  | " + b.getBusNumber());

			counter++;
		}
	}

	private void displayEmployeeTable(){
		System.out.println("\n\n\t\t\t\t     [Employee Accounts]\n");
		System.out.println("   |         Name          |     ID     |    Position  ");
		int counter = 1;
		for(Employee e : employee_accounts){
			System.out.println("------------------------------------------------------------");
			System.out.println(" " + counter + " |  " + e.getName() + "    |   " + e.getID() + "    |   " + e.getPosition());

			counter++;
		}
	}

	public void displayFees() throws IOException, InterruptedException{
		clearScreen();
		displayFeeTable();
		pause();
	}

	public void displayBusAccounts() throws IOException, InterruptedException{
		clearScreen();
		displayBusTable();
		pause();
	}

	public void displayEmployeeAccounts() throws IOException, InterruptedException{
		clearScreen();
		displayEmployeeTable();
		pause();
	}
	public void displayAll() throws IOException, InterruptedException{
		clearScreen();
		displayFeeTable();
		displayBusTable();
		// displayEmployeeTable();
		// pause();
	}
	/******************************************************************************************/

	/***********************make sure to check in testing if arraylist is null*********************************/
	public ArrayList<Bus> getBus(ArrayList<String> description, ArrayList<String> values){
		// System.out.println("\n\n---------------------------------------------------------\n\tinside getBus function");
		ArrayList<ArrayList<Bus>> found = new ArrayList<>();
		for(int i = 0; i < description.size(); i++){
			ArrayList<Bus> buses = getBus(description.get(i), values.get(i));
			// found.add(getBus(description.get(i), values.get(i)));
			found.add(buses);
		}

		ArrayList<Bus> copy = found.get(0);
		for(int i = 0; i < copy.size(); i++){
			ArrayList<Bus> current = found.get(i);
			for(int j = 0; j < current.size(); j++){
				if(!(copy.get(i).getPlateNo().equals(current.get(j).getPlateNo()))){
					current.remove(j);
				}
			}
		}
		return copy;
	}

	private ArrayList<Fee> getFee(String description, String value){ // descriptions: feeType, feeAmount, etc.
		ArrayList<Fee> found = new ArrayList<>();
		switch(description){
			case "feeAmount":
				for(Fee f : fees){
					if(f.getFeeAmount().equals(value)){
						found.add(f);
					}
				}
				break;
			case "timePaid":
				for(Fee f : fees){
					if(f.getTimePaid().equals(value)){
						found.add(f);
					}
				}
				break;
			case "datePaid":
				for(Fee f : fees){
					if(f.getDatePaid().equals(value)){
						found.add(f);
					}
				}
				break;
			case "orNum":
				for(Fee f : fees){
					if(f.getOrNum().equals(value)){
						found.add(f);
					}
				}
				break;
			case "voidORNum":
				for(Fee f : fees){
					if(f.getVoidORNum().equals(value)){
						found.add(f);
					}
				}
				break;
			case "bus_plate":
				for(Fee f : fees){
					if(f.getBus_plate().equals(value)){
						found.add(f);
					}
				}
				break;
			case "employeeID":
				for(Fee f : fees){
					if(f.getEmployeeID().equals(value)){
						found.add(f);
					}
				}
				break;
			case "isVoid":
				for(Fee f : fees){
					if(f.getVoid() && value.equals("true")){
						found.add(f);
					}else if((!f.getVoid()) && value.equals("false")){
						found.add(f);
					}
				}
				break;
		}
		return found;
	}

	public ArrayList<Bus> getBus(String description, String value){ // descriptions: plateNo, company, isMinibus and busNumber
		ArrayList<Bus> found = new ArrayList<>();
		// System.out.println("\n********************inside getBus*************************");
		
		if(description.equals("plateNo")){
			for(Bus b : bus_accounts){
				if(b.getPlateNo().equals(value)){
					found.add(b);
				}
			}
		}else if(description.equals("company")){
			for(Bus b : bus_accounts){
				if(b.getCompany().equals(value)){
					// System.out.println("added");
					found.add(b);
				}
			}
		}else if(description.equals("isMinibus")){
			for(Bus b : bus_accounts){
				if(b.isMinibus() && value.equals("true")){
					found.add(b);
				}else if ((!b.isMinibus() && value.equals("false"))){
					found.add(b);
				}
			}
		}else if(description.equals("busNumber")){
			for(Bus b : bus_accounts){
					if(b.getBusNumber().equals(value)){
						found.add(b);
						// System.out.println("added!");
					}
				}
			}
		return found;
	} 

	public ArrayList<Employee> getEmployee(String description, String value){ // descriptions: name, id, position
		ArrayList<Employee> found = new ArrayList<>();
		switch(description){
			case "name":
				for(Employee e : employee_accounts){
					if(e.getName().equals(value)){
						found.add(e);
					}
				}
				break;
			case "id":
				for(Employee e : employee_accounts){
					if(e.getID().equals(value)){
						found.add(e);
					}
				}
				break;
			case "position":
				for(Employee e : employee_accounts){
					if(e.getPosition().equals(value)){
						found.add(e);
					}
				}
				break;
		}
		return found;
	}
	/**********************************************************************************************************/

	/*************deleting/removing stuffs********************/
	public void removeFee(String or_num) throws IOException, InterruptedException{
		int i = 0;
		for(Fee f : fees){
			if(f.getORNum().equals(or_num)){
				fees.remove(i);
				break;
			}
			i++;
		}
	}

	public void removeEmployee(String emp_id){
		int i = 0;
		for(Employee e : employee_accounts){
			if(e.getID().equals(emp_id)){
				employee_accounts.remove(i);
				break;
			}
			i++;
		}
	}

	public void removeBus(String bus_plate){
		int i = 0;
		for(Bus b : bus_accounts){
			if(b.getPlateNo().equals(bus_plate)){
				bus_accounts.remove(i);
				break;
			}
			i++;
		}
	}

	/***********************************************/

	/************sorting fees****************
	private ArrayList<Fee> sortFees(ArrayList<String> items, String description){
		ArrayList<Boolean> done = new ArrayList<>();
		for(int i = 0; i < fees.size(); i++){
			done.add(false);
		}

		int counter = 0;
		ArrayList<Fee> sorted = new ArrayList<>();
		while(counter < fees.size()){
			String item = items.get(counter);
			for(int i = 0; i < fees.size(); i++){
				if(description.equals("timePaid")){
					if(fees.get(i).getTimePaid().equals(item) && !done.get(i)){
						sorted.add(fees.get(i));
						counter++;
						done.set(i, true);
					}
				}else if(description.equals("datePaid")){
					if(fees.get(i).getDatePaid().equals(item) && !done.get(i)){
						sorted.add(fees.get(i));
						counter++;
						done.set(i, true);
					}
				}else if(description.equals("orNum")){
					if(fees.get(i).getORNum().equals(item) && !done.get(i)){
						sorted.add(fees.get(i));
						counter++;
						done.set(i, true);
					}
				}
			}
		}
		return sorted;
	}

	public ArrayList<Fee> sortFee(String description){ // description: timePaid, datePaid, orNum
		ArrayList<String> items = new ArrayList<>();
		switch(description){
			case "timePaid":
				for(Fee f : fees){
					items.add(f.getTimePaid());
				}
				break;
			case "datePaid":
				for(Fee f : fees){
					items.add(f.getDatePaid());
				}
				break;
			case "orNum":
				for(Fee f : fees){
					items.add(f.getORNum());
				}
				break;
		}
		Collections.sort(items);
		ArrayList<Fee> sorted = sortFees(items, description);
		for(Fee f : sorted){
			System.out.println(f.getFeeType());
		}
		return sorted;
	}*/

}