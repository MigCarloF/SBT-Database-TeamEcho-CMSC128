package com.database;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class FeesAccountant {
	private String bus_plate, employeeID; // we need to connect the fee transaction to the bus payer and the employee doing the transaction
	private SimpleStringProperty feeType, feeAmount, timePaid,  orNum, voidORNum;
	private LocalDate datePaid;
	private Boolean isVoid;

	public FeesAccountant(String feeType, String feeAmount, String timePaid, LocalDate datePaid, String orNum, String bus_plate, String employeeID, dummyBus bus){
		this.feeType = new SimpleStringProperty(feeType);
		this.feeAmount = new SimpleStringProperty(feeAmount);
		this.timePaid = new SimpleStringProperty(timePaid);
		this.datePaid = datePaid;
		this.orNum = new SimpleStringProperty(orNum);
		this.bus_plate = bus_plate;
		this.employeeID = employeeID;
		voidORNum = null;
		isVoid = false;
	}

	public void voidTransaction(String orNum){
		isVoid = true;
		voidORNum = new SimpleStringProperty(orNum);
	}

	public String getBus_plate() {
		return bus_plate;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public String getFeeType() {
		return feeType.get();
	}

	public SimpleStringProperty feeTypeProperty() {
		return feeType;
	}

	public String getFeeAmount() {
		return feeAmount.get();
	}

	public SimpleStringProperty feeAmountProperty() {
		return feeAmount;
	}

	public String getTimePaid() {
		return timePaid.get();
	}

	public SimpleStringProperty timePaidProperty() {
		return timePaid;
	}

	public String getOrNum() {
		return orNum.get();
	}

	public SimpleStringProperty orNumProperty() {
		return orNum;
	}

	public String getVoidORNum() {
		return voidORNum.get();
	}

	public SimpleStringProperty voidORNumProperty() {
		return voidORNum;
	}

	public LocalDate getDatePaid() {
		return datePaid;
	}

	public Boolean getVoid() {
		return isVoid;
	}
}
