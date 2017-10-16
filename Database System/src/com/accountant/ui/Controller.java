package com.accountant.ui;

import com.database.Bus;
import com.database.DummyDatabase;
import com.database.DummyDatabaseBus;
import com.database.FeesAccountant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private TableView<FeesAccountant> tableView;
    @FXML
    private TableColumn<FeesAccountant, String> columnFranchise;
    @FXML
    private TableColumn<FeesAccountant, String> columnBusType;
    @FXML
    private TableColumn<FeesAccountant, String> columnArrivalFee;
    @FXML
    private TableColumn<FeesAccountant, String> columnParkingFee;
    @FXML
    private TableColumn<FeesAccountant, String> columnOrNum;
    @FXML
    private Label lblTotalEarnings;
    @FXML
    private TextField txtTotalArrivalFees;
    @FXML
    private TextField txtTotalParkingFees;
    @FXML
    private TextField txtTotalAllFees;

    private ObservableList<FeesAccountant> fees;
    private DummyDatabase database;
    private DummyDatabaseBus databaseBus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //initialize columns on table
        columnFranchise.setCellValueFactory(new PropertyValueFactory<FeesAccountant, String>("busCompany"));
        columnBusType.setCellValueFactory(new PropertyValueFactory<FeesAccountant,String>("busType"));
        columnArrivalFee.setCellValueFactory(new PropertyValueFactory<FeesAccountant, String>("feeType"));
        columnParkingFee.setCellValueFactory(new PropertyValueFactory<FeesAccountant, String>("feeType"));
        columnOrNum.setCellValueFactory(new PropertyValueFactory<FeesAccountant, String>("orNum"));
        //Calls for the singleton class
        database = DummyDatabase.dummyClass;
        databaseBus = DummyDatabaseBus.dummyDatabaseBus;
        tableView.setItems(getFees());


    }

    private ObservableList<FeesAccountant> getFees() {
        //todo TEMPORARY adds data to database
        LocalDate date = LocalDate.of(2016, Month.DECEMBER, 12);
        databaseBus.addBus(new Bus("ABC 123", "Ceres",  1));
        databaseBus.addBus(new Bus("ABC 321", "Flybus",  2));
        databaseBus.addBus(new Bus("ACB 321", "Landbus", 1));
        databaseBus.addBus(new Bus("ABC 213", "Smolbus"));

        database.add(new FeesAccountant("arrival", "4:30", "#104430F", "bigboiID", date, new Bus("ABC 123", "Ceres", 1)));
        database.add(new FeesAccountant("parking", "4:42", "#104431F", "smolboiID", date, new Bus("ABC 321", "Flybus", 2)));
        database.add(new FeesAccountant("parking", "4:52", "#104432F", "mediumboiID", date, new Bus("ACB 321", "Landbus", 1)));
        database.add(new FeesAccountant("arrival", "4:42", "#104433F", "boiID", date, new Bus("ABC 213", "Smolbus")));

        //Convert arraylist fees to observablelist fees
        fees = FXCollections.observableArrayList();
        ArrayList<FeesAccountant> initFees = database.getAllFees();
        fees.addAll(initFees);

        System.out.print(fees.get(0).getBusCompany());
        return fees;
    }
}
