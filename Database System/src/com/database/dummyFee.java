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
    
    private String getComment(){
        return comment;
    }
    
    private void set(String comment){
        this. comment = comment;
    }
    
    private boolean parking(){
        return isArrival;
    }
    
    private String getTime(){
        return time.toString();
    }

    
    private String getORNum(){
        return orNum;
    }
    
    private void makeVoid(){
        isVoid = true;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
}


