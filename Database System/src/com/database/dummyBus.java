
package com.database;

public class dummyBus {
    private String plateNo;
    private String company;
    private boolean isMinibus = false;
    private int busNumber;
    
    public dummyBus(){
        plateNo = null;
        company = null;
        busNumber = 0;
    }
    
    public dummyBus(String plateNo, String company, boolean isMinibus, int busNumber){
        this.plateNo = plateNo;
        this.company = company;
        this.isMinibus = isMinibus;
        this.busNumber = busNumber;
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
