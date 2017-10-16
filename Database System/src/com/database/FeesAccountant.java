package com.database;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class FeesAccountant {
	private String bus_plate, employeeID; // we need to connect the fee transaction to the bus payer and the employee doing the transaction
	private SimpleStringProperty feeType, feeAmount, timePaid,  orNum, voidORNum;
	private SimpleStringProperty busCompany, busType;
	private LocalDate datePaid;
	private Boolean isVoid;
	private Bus bus;

    /**
     * Constructor
     * @param feeType
     * @param timePaid
     * @param datePaid
     * @param orNum
     * @param employeeID
     * @param bus
     */
	public FeesAccountant(String feeType, String timePaid, String orNum, String employeeID, LocalDate datePaid, Bus bus){
		this.feeType = new SimpleStringProperty(feeType);
		this.feeAmount = new SimpleStringProperty(feeAmounter());
		this.timePaid = new SimpleStringProperty(timePaid);
		this.datePaid = datePaid;
		this.orNum = new SimpleStringProperty(orNum);
		this.employeeID = employeeID;
		this.bus = bus;
		initBus();
		voidORNum = null;
		isVoid = false;

	}

    private String feeAmounter() {
	    return feeType.equals("arrival") ? "50" : "150";
    }

    /**
     * Initializes bus data
     */
    private void initBus() {
        bus_plate = bus.getPlateNo();
        busCompany = new SimpleStringProperty(bus.getCompany());
        busType = new SimpleStringProperty(bus.getBusType());
    }

	public void voidTransaction(String orNum){
		isVoid = true;
		voidORNum = new SimpleStringProperty(orNum);
	}


    public boolean isVoid() {
        return isVoid;
    }

    /**
     * getters and setters
     */

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

	public String getORNum() {
		return orNum.get();
	}

	public boolean isArrival() {
		return feeType.equals("arrival") ? true : false;
	}

	public String getComment() {
		return "";
	}

    public String getBusCompany() {
        return busCompany.get();
    }

    public SimpleStringProperty busCompanyProperty() {
        return busCompany;
    }

    public String getBusType() {
        return busType.get();
    }

    public SimpleStringProperty busTypeProperty() {
        return busType;
    }

    public Bus getBus() {
        return bus;
    }

    public void setFeeType(String feeType) {
        this.feeType.set(feeType);
    }

    public void setFeeAmount(String feeAmount) {
        this.feeAmount.set(feeAmount);
    }

    public void setTimePaid(String timePaid) {
        this.timePaid.set(timePaid);
    }

    public void setOrNum(String orNum) {
        this.orNum.set(orNum);
    }

    public void setVoidORNum(String voidORNum) {
        this.voidORNum.set(voidORNum);
    }

    public void setBusCompany(String busCompany) {
        this.busCompany = new SimpleStringProperty(busCompany);
    }

    public void setBusType(String busType) {
        this.busType.set(busType);
    }
}
