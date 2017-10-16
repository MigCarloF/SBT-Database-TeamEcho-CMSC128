
package com.database;

public class Bus {
    private String plateNo;
    private String company;
    private String busType;
    private boolean isMinibus = false;
    private String busNumber;
    
    public Bus(){
        plateNo = null;
        company = null;
        busNumber = "0";
    }
    public Bus(String plateNo, String company, String busNumber) {
        this.plateNo = plateNo;
        this.company = company;
        this.isMinibus = false;
        setBusType("bus");
        this.busNumber = busNumber;
    }
    public Bus(String plateNo, String company){
        this.plateNo = plateNo;
        this.company = company;
        this.isMinibus = true;
        setBusType("minibus");
        this.busNumber = "0";
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
    
    public String getBusNumber(){
        return busNumber;
    }
    
    public void setBusNumber(String busNumber){
        this.busNumber = busNumber;
    }
    
    
    
    
}
