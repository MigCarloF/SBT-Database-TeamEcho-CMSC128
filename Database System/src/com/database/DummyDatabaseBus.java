package com.database;

import java.util.ArrayList;

public class DummyDatabaseBus {
    public static final DummyDatabaseBus dummyDatabaseBus = new DummyDatabaseBus();


    private ArrayList<DummyBus> listofBuses;

    private DummyDatabaseBus(){
        listofBuses = new ArrayList<>();
    }

    public void addBus(DummyBus bus){
        listofBuses.add(bus);
    }

    public void remove(FeesAccountant f){
        int ctr = 0;
        for(FeesAccountant fee : listofFees){
            if(f.getORNum().equals(fee.getORNum())) {
                listofFees.remove(ctr);
                break;
            }
            ctr++;
        }
    }

    public ArrayList<FeesAccountant> getAllFees(){
        return listofFees;
    }
}
