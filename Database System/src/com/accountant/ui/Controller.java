package com.accountant.ui;

import com.database.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

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
    private TableColumn<Fee, String> columnLoadingFee;
    @FXML
    private TableColumn<Fee, String> columnOrNum;
    @FXML
    private Label lblTotalEarnings;
    @FXML
    private TextField txtTotalArrivalFees;
    @FXML
    private TextField txtTotalLoadingFees;
    @FXML
    private TextField txtTotalAllFees;

    private ObservableList<Fee> fees;
    private Database database;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //initialize columns on table
        columnFranchise.setCellValueFactory(new PropertyValueFactory<Fee, String>("busCompany"));
        columnBusType.setCellValueFactory(new PropertyValueFactory<Fee, String>("busType"));
        columnArrivalFee.setCellValueFactory(new PropertyValueFactory<Fee, String>("arrivalFee"));
        columnLoadingFee.setCellValueFactory(new PropertyValueFactory<Fee, String>("loadingFee"));
        columnOrNum.setCellValueFactory(new PropertyValueFactory<Fee, String>("orNum"));
        //Calls for the singleton class
        database = Database.database;
        tableView.setItems(getFees());

        int totalArrival = 0, totalLoading = 0;
        ObservableList<Fee> feeList = tableView.getItems();
        for(Fee f : feeList) {
            totalArrival += Integer.parseInt(f.getArrivalFee());
            totalLoading += Integer.parseInt(f.getLoadingFee());
        }
        txtTotalArrivalFees.setText(String.valueOf(totalArrival));
        txtTotalLoadingFees.setText(String.valueOf(totalLoading));
        txtTotalAllFees.setText(String.valueOf(totalArrival+totalLoading));
        lblTotalEarnings.setText(String.valueOf(totalArrival+totalLoading));

    }

    private void temporaryDatabaseAccess() {
        //todo TEMPORARY adds data to database
        LocalDate date = LocalDate.of(2016, Month.DECEMBER, 12);
        database.addBus(new Bus("ABC 123", "Ceres", "1"));
        database.addBus(new Bus("ABC 321", "Flybus", "2"));
        database.addBus(new Bus("ACB 321", "Landbus", "1"));
        database.addBus(new Bus("ABC 213", "Smolbus"));

        database.addFee(new Fee(false, false, "4:30", "#104430F", "bigboiID", date, "ABC 123"));
        database.addFee(new Fee(false, true, "4:42", "#104431F", "smolboiID", date, "ABC 321"));
        database.addFee(new Fee(true, false, "4:52", "#104432F", "mediumboiID", date, "ACB 321"));
        database.addFee(new Fee(true, true, "4:42", "#104433F", "boiID", date, "ABC 213"));


    }

    private ObservableList<Fee> getFees() {
        temporaryDatabaseAccess();

        //Convert arraylist fees to observablelist fees
        fees = FXCollections.observableArrayList();
        ArrayList<Fee> initFees = database.getAllFees();
        fees.addAll(initFees);

        int totalArrivalFees;
        return fees;
    }
}
