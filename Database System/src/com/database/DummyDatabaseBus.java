package com.database;

import java.util.ArrayList;

public class DummyDatabaseBus {
    public static final DummyDatabaseBus dummyDatabaseBus = new DummyDatabaseBus();


    private ArrayList<Bus> listofBuses;

    private DummyDatabaseBus(){
        listofBuses = new ArrayList<>();
    }

    public void addBus(Bus bus){
        listofBuses.add(bus);
    }

    public void remove(String plateNo){
        int ctr = 0;
        for(Bus bus : listofBuses){
            if(plateNo.equals(bus.getPlateNo())) {
                listofBuses.remove(ctr);
                break;
            }
            ctr++;
        }
    }

    public ArrayList<Bus> getAllFees(){
        return listofBuses;
    }
}
