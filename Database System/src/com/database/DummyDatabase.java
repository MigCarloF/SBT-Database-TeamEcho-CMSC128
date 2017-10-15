package com.database;

import java.util.ArrayList;
import java.util.List;

public class DummyDatabase { // you can't make top level class as static

    //allows to have only one instance of this class *SINGLETON*
    public static final DummyDatabase dummyClass = new DummyDatabase();


    private ArrayList<FeesAccountant> listofFees;

    private DummyDatabase(){
        listofFees = new ArrayList<>();
    }

    public void addListoffees(ArrayList<FeesAccountant> fees){
        listofFees = fees;
    }

    public void add(FeesAccountant fee){
        listofFees.add(fee);
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

    public FeesAccountant getFeeByOrnum(String OR){
        int ctr = 0;

        for(FeesAccountant fee : listofFees){
            if(fee.getORNum().equals(OR)) {
                return fee;
            }
            ctr++;
        }
        if(ctr == listofFees.size()) throw new Error("No such fee exists");
        return null;
    }

    public ArrayList<FeesAccountant> sortByOrnum(){
        //TODO ---> add implements Comparable<dummyFee> to dummyFee class for easier sorting

        List<FeesAccountant> dummyFeelist = new ArrayList<>();
        //Collections.sort(dummyFeelist, dummyFee.Comparators.OR);  <-- needed
        return null;
    }

    public ArrayList<FeesAccountant> sortByDate(){
        //TODO ---> add implements Comparable<dummyFee> to dummyFee class for easier sorting

        List<FeesAccountant> dummyFeelist = new ArrayList<>();
        //Collections.sort(dummyFeelist, dummyFee.Comparators.Date);  <-- needed
        return null;
    }

    public void displayAllFees(){
        displayFees(listofFees);
    }

    public void displayFees(ArrayList<FeesAccountant> feelist){
        for(FeesAccountant fee : feelist){
            String out = "OR#: " + fee.getORNum() +
                    "Date: " + fee.getDatePaid() +
                    "Void: " + fee.isVoid() +
                    "Arrival: " + fee.isArrival() +
                    "Comment: " + fee.getComment();

            System.out.println(out);
        }
    }

    public void displayByDate(){
        displayFees(sortByDate());
    }

    public void displayByOR(){
        displayFees(sortByOrnum());
    }



    public ArrayList<FeesAccountant> getListofFees() {
        return listofFees;
    }


}
