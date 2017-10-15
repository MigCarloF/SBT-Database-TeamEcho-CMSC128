package com.accountant.ui;

import com.database.DummyBus;
import com.database.DummyDatabase;
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
        tableView.setItems(getFees());


    }

    private ObservableList<FeesAccountant> getFees() {
        //todo TEMPORARY adds data to database
        LocalDate date = LocalDate.of(2016, Month.DECEMBER, 12);
        database.add(new FeesAccountant("arrival", "4:30", "#104430F", "bigboiID", date, new DummyBus("ABC 123", "Ceres", false, 1)));
        database.add(new FeesAccountant("parking", "4:42", "#104431F", "smolboiID", date, new DummyBus("ABC 321", "Flybus", false, 2)));
        database.add(new FeesAccountant("parking", "4:52", "#104432F", "mediumboiID", date, new DummyBus("ACB 321", "Landbus", false, 1)));
        database.add(new FeesAccountant("arrival", "4:42", "#104433F", "boiID", date, new DummyBus("ABC 213", "Smolbus", true, 5)));

        //Convert arraylist fees to observablelist fees
        fees = FXCollections.observableArrayList();
        ArrayList<FeesAccountant> initFees = database.getAllFees();
        fees.addAll(initFees);

        System.out.print(fees.get(0).getBusCompany());
        return fees;
    }
}
