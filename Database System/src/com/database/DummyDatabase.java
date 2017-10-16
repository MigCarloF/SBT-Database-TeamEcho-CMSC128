package com.database;

import java.util.ArrayList;
import java.util.List;

public class DummyDatabase { // you can't make top level class as static

    //allows to have only one instance of this class *SINGLETON*
    public static final DummyDatabase dummyClass = new DummyDatabase();


    private ArrayList<Fee> listofFees;

    private DummyDatabase(){
        listofFees = new ArrayList<>();
    }

    public void addListoffees(ArrayList<Fee> fees){
        listofFees = fees;
    }

    public void add(Fee fee){
        listofFees.add(fee);
    }

    public void remove(Fee f){
        int ctr = 0;
        for(Fee fee : listofFees){
            if(f.getOrNum().equals(fee.getOrNum())) {
                listofFees.remove(ctr);
                break;
            }
            ctr++;
        }
    }

    public ArrayList<Fee> getAllFees(){
        return listofFees;
    }

    public Fee getFeeByOrnum(String OR){
        int ctr = 0;

        for(Fee fee : listofFees){
            if(fee.getOrNum().equals(OR)) {
                return fee;
            }
            ctr++;
        }
        if(ctr == listofFees.size()) throw new Error("No such fee exists");
        return null;
    }

    public ArrayList<Fee> sortByOrnum(){
        //TODO ---> add implements Comparable<dummyFee> to dummyFee class for easier sorting

        List<Fee> dummyFeelist = new ArrayList<>();
        //Collections.sort(dummyFeelist, dummyFee.Comparators.OR);  <-- needed
        return null;
    }

    public ArrayList<Fee> sortByDate(){
        //TODO ---> add implements Comparable<dummyFee> to dummyFee class for easier sorting

        List<Fee> dummyFeelist = new ArrayList<>();
        //Collections.sort(dummyFeelist, dummyFee.Comparators.Date);  <-- needed
        return null;
    }

    public void displayAllFees(){
        displayFees(listofFees);
    }

    public void displayFees(ArrayList<Fee> feelist){
        for(Fee fee : feelist){
            String out = "OR#: " + fee.getOrNum() +
                    "Date: " + fee.getDatePaid() +
                    "Void: " + fee.isVoid() +
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



    public ArrayList<Fee> getListofFees() {
        return listofFees;
    }


}
