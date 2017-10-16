package echo;

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

    public Bus getBus(String plateNo) {
        for(Bus bus : listofBuses) {
            if (plateNo.equals(bus.getPlateNo())) {
                return bus;
            }
        }
        return null;
    }

    public Bus getBus(String company, String busNo) {
        //this busList is temporary to find all buses with the same franchise as parameter
        ArrayList<Bus> busList = new ArrayList<Bus>();
        for(Bus bus : listofBuses) {
            if(company.equals(bus.getCompany())) {
                busList.add(bus);
            }
        }
        //this loop is to single out busNo from franchise in list
        for(Bus bus : busList) {
            if(busNo.equals(bus.getBusNumber())) {
                return bus;
            }
        }
        return null;
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

    public ArrayList<Bus> getAllBuses(){
        return listofBuses;
    }
}
