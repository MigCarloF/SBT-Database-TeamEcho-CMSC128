package com.accountant.ui;

import com.database.Bus;
import com.database.DummyDatabase;
import com.database.DummyDatabaseBus;
import com.database.Fee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private TableView<Fee> tableView;
    @FXML
    private TableColumn<Fee, String> columnFranchise;
    @FXML
    private TableColumn<Fee, String> columnBusType;
    @FXML
    private TableColumn<Fee, String> columnArrivalFee;
    @FXML
    private TableColumn<Fee, String> columnOrNum;
    @FXML
    private Label lblTotalEarnings;
    @FXML
    private TextField txtTotalArrivalFees;
    @FXML
    private TextField txtTotalParkingFees;
    @FXML
    private TextField txtTotalAllFees;

    private ObservableList<Fee> fees;
    private DummyDatabase database;
    private DummyDatabaseBus databaseBus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //initialize columns on table
        columnFranchise.setCellValueFactory(new PropertyValueFactory<Fee, String>("busCompany"));
        columnBusType.setCellValueFactory(new PropertyValueFactory<Fee,String>("busType"));
        columnArrivalFee.setCellValueFactory(new PropertyValueFactory<Fee, String>("feeType"));
        columnOrNum.setCellValueFactory(new PropertyValueFactory<Fee, String>("orNum"));
        //Calls for the singleton class
        database = DummyDatabase.dummyClass;
        databaseBus = DummyDatabaseBus.dummyDatabaseBus;
        tableView.setItems(getFees());


    }

    private ObservableList<Fee> getFees() {
        //todo TEMPORARY adds data to database
        LocalDate date = LocalDate.of(2016, Month.DECEMBER, 12);
        databaseBus.addBus(new Bus("ABC 123", "Ceres",  "1"));
        databaseBus.addBus(new Bus("ABC 321", "Flybus",  "2"));
        databaseBus.addBus(new Bus("ACB 321", "Landbus", "1"));
        databaseBus.addBus(new Bus("ABC 213", "Smolbus"));

        database.add(new Fee("arrival", "4:30", "#104430F", "bigboiID", date, new Bus("ABC 123", "Ceres", "1")));
        database.add(new Fee("parking", "4:42", "#104431F", "smolboiID", date, new Bus("ABC 321", "Flybus", "2")));
        database.add(new Fee("parking", "4:52", "#104432F", "mediumboiID", date, new Bus("ACB 321", "Landbus", "1")));
        database.add(new Fee("arrival", "4:42", "#104433F", "boiID", date, new Bus("ABC 213", "Smolbus")));

        //Convert arraylist fees to observablelist fees
        fees = FXCollections.observableArrayList();
        ArrayList<Fee> initFees = database.getAllFees();
        fees.addAll(initFees);

        System.out.print(fees.get(0).getBusCompany());
        return fees;
    }
}
