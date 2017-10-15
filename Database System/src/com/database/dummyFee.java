package com.database;
import java.util.Date;

public class dummyFee {
    private String comment;
    private boolean isVoid = false;
    private boolean isArrival = false;
    private Date time;
    //private cashier inputter;
    private dummyBus bus;
    private String orNum;
    
    dummyFee(){
        this.comment = null;
        time = null;
        bus = null;
        orNum = null;
    }
    
    dummyFee(String comment, boolean isParking, dummyBus bus, String orNum){
        this.comment = comment;
        this.time = new Date();
        this.bus = bus;
        this.orNum = orNum;
        this.isArrival = isParking;
    }
    
    public String getComment(){
        return comment;
    }

    public void set(String comment){
        this. comment = comment;
    }

    public boolean parking(){
        return isArrival;
    }

    public String getTime(){
        return time.toString();
    }


    public String getORNum(){
        return orNum;
    }

    public void makeVoid(){
        isVoid = true;
    }

    public boolean isVoid() {
        return isVoid;
    }

    public boolean isArrival() {
        return isArrival;
    }
    
    
    
    
    
    
    
    
    
    
    
}


