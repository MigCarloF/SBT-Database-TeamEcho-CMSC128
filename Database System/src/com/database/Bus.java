
package com.database;

public class Bus {
    private String plateNo;
    private String company;
    private String busType;
    private boolean isMinibus = false;
    private int busNumber;
    
    public Bus(){
        plateNo = null;
        company = null;
        busNumber = 0;
    }
    public Bus(String plateNo, String company, int busNumber) {
        this.plateNo = plateNo;
        this.company = company;
        this.isMinibus = false;
        setBusType("minibus");
        this.busNumber = 0;
    }
    public Bus(String plateNo, String company){
        this.plateNo = plateNo;
        this.company = company;
        this.isMinibus = true;
        setBusType(isMinibus() ? "minibus" : "bus");
        this.busNumber = busNumber;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getPlateNo(){
        return plateNo;
    }
    
    public void setPlateNo(String plateNo){
        this.plateNo = plateNo;
    }
    
    public String getCompany(){
        return company;
    }
    
    public void setCompany(String company){
        this.company = company;
    }
    
    public boolean isMinibus(){
        return isMinibus;
    }
    
    public void setMinibus(boolean flag){
        isMinibus = flag;
    }
    
    public int getBusNumber(){
        return busNumber;
    }
    
    public void setBusNumber(int busNumber){
        this.busNumber = busNumber;
    }
    
    
    
    
}
