public class Fee{
	private String feeType, feeAmount, timePaid, datePaid, orNum, voidORNum;
	private String bus_plate, employeeID; // we need to connect the fee transaction to the bus payer and the employee doing the transaction
	private Boolean isPaid;
	private Boolean isVoid;

	public Fee(String feeType, String feeAmount, String timePaid, String datePaid, String orNum, String bus_plate, String employeeID){
		this.feeType = feeType;
		this.feeAmount = feeAmount;
		this.timePaid = timePaid;
		this.datePaid = datePaid;
		this.orNum = orNum;
		this.bus_plate = bus_plate;
		this.employeeID = employeeID;
		voidORNum = null;
		isVoid = false;

		if(Double.parseDouble(feeAmount) > 0){
			isPaid = true;
		}else{
			isPaid = false;
		}
	}

	public void voidTransaction(String orNum){
		isVoid = true;
		voidORNum = orNum;
	}

	public String getBusPlate(){
		return bus_plate;
	}

	public String getEmployeeID(){
		return employeeID;
	}

	public String getFeeType(){
		return feeType;
	}

	public String getFeeAmount(){
		return feeAmount;
	}

	public String getTimePaid(){
		return timePaid;
	}

	public String getDatePaid(){
		return datePaid;
	}

	public String getORNum(){
		return orNum;
	}

	public String getVoidORNum(){
		return voidORNum;
	}

	public Boolean setPaidStatus(){
		return isPaid;
	}

	public Boolean setVoidStatus(){
		return isVoid;
	}
}