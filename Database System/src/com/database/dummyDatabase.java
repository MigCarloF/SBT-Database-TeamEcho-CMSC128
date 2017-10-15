package com.database;

import java.util.ArrayList;
import java.util.List;

public class dummyDatabase { // you can't make top level class as static

    private static dummyDatabase dummyClass = new dummyDatabase();
    private ArrayList<dummyFee> listofFees;

    private dummyDatabase(){
        listofFees = new ArrayList<>();
    }

    public static dummyDatabase getInstance(){
        if(dummyClass == null){
            dummyClass = new dummyDatabase();
        }
        return dummyClass;
    }

    public void addListoffees(ArrayList<dummyFee> fees){
        listofFees = fees;
    }

    public void add(dummyFee fee){
        listofFees.add(fee);
    }

    public void remove(dummyFee f){
        int ctr = 0;
        for(dummyFee fee : listofFees){
            if(f.getORNum().equals(fee.getORNum())) {
                listofFees.remove(ctr);
                break;
            }
            ctr++;
        }
    }

    public ArrayList<dummyFee> getAllFees(){
        return listofFees;
    }

    public dummyFee getFeeByOrnum(String OR){
        int ctr = 0;

        for(dummyFee fee : listofFees){
            if(fee.getORNum().equals(OR)) {
                return fee;
            }
            ctr++;
        }
        if(ctr == listofFees.size()) throw new Error("No such fee exists");
        return null;
    }

    public ArrayList<dummyFee> sortByOrnum(){
        //TODO ---> add implements Comparable<dummyFee> to dummyFee class for easier sorting

        List<dummyFee> dummyFeelist = new ArrayList<>();
        //Collections.sort(dummyFeelist, dummyFee.Comparators.OR);  <-- needed
        return null;
    }

    public ArrayList<dummyFee> sortByDate(){
        //TODO ---> add implements Comparable<dummyFee> to dummyFee class for easier sorting

        List<dummyFee> dummyFeelist = new ArrayList<>();
        //Collections.sort(dummyFeelist, dummyFee.Comparators.Date);  <-- needed
        return null;
    }

    public void displayAllFees(){
        displayFees(listofFees);
    }

    public void displayFees(ArrayList<dummyFee> feelist){
        for(dummyFee fee : feelist){
            String out = "OR#: " + fee.getORNum() +
                    "Date: " + fee.getTime() +
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




    public static void main(String[] args) {
    }


}
