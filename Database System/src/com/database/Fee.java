package com.database;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Fee {
	private String bus_plate, employeeID; // we need to connect the fee transaction to the bus payer and the employee doing the transaction
	private String arrivalFee, loadingFee, timePaid,  orNum, voidORNum;
	private String datePaid;
	private Boolean isVoid, paidArrival, paidLoading;

	/**
	 * Constructor
	 * @param timePaid
	 * @param datePaid
	 * @param orNum
	 * @param employeeID
	 */
	public Fee(boolean paidArrival, boolean paidLoading, String timePaid, String orNum, String employeeID, LocalDate datePaid, String plateNumber){
		this.paidArrival = paidArrival;
		this.paidLoading = paidLoading;
		initFees();
		this.bus_plate = plateNumber;
		this.timePaid = timePaid;
		this.datePaid = datePaid.toString();
		this.orNum = orNum;
		this.employeeID = employeeID;
		voidORNum = null;
		isVoid = false;

	}

    /**
     * Initializes bus data
     */


	public void initFees() {
		arrivalFee = paidArrival ? "150" : "0";
		loadingFee = paidLoading ? "50" : "0";
	}

	public void voidTransaction(String orNum){
		isVoid = true;
		voidORNum = orNum;
	}




	/**
     * getters and setters
     */

	public boolean isVoid() {
		return isVoid;
	}

	public String getArrivalFee() {
		return arrivalFee;
	}

	public String arrivalFeeProperty() {
		return arrivalFee;
	}

	public void setArrivalFee(String arrivalFee) {
		this.arrivalFee = arrivalFee;
	}

	public String getLoadingFee() {
		return loadingFee;
	}

	public void setLoadingFee(String loadingFee) {
		this.loadingFee = loadingFee;
	}

	public String getBus_plate() {
		return bus_plate;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public String getTimePaid() {
		return timePaid;
	}

	public String getOrNum() {
		return orNum;
	}

	public String getVoidORNum() {
		return voidORNum;
	}

	public String getDatePaid() {
		return datePaid;
	}

	public Boolean getVoid() {
		return isVoid;
	}

	public String getComment() {
		return "";
	}

    public void setTimePaid(String timePaid) {
        this.timePaid =timePaid;
    }

    public void setOrNum(String orNum) {
        this.orNum = orNum;
    }

    public void setVoidORNum(String voidORNum) {
        this.voidORNum = voidORNum;
    }
}
