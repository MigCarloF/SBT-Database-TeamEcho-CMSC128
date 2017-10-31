package com.accountant.ui;

import com.database.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FXMLAccountantWindowController implements Initializable {
    @FXML
    private TableView<FeeTable> tableView;
    @FXML
    private TableColumn<FeeTable, String> columnFranchise;
    @FXML
    private TableColumn<FeeTable, String> columnBusType;
    @FXML
    private TableColumn<FeeTable, String> columnArrivalFee;
    @FXML
    private TableColumn<FeeTable, String> columnLoadingFee;
    @FXML
    private TableColumn<FeeTable, String> columnOrNum;
    @FXML
    private Label lblTotalEarnings;
    @FXML
    private TextField txtTotalArrivalFees;
    @FXML
    private TextField txtTotalLoadingFees;
    @FXML
    private TextField txtTotalAllFees;
    @FXML
    private DatePicker dateStartDate;
    @FXML
    private DatePicker dateEndDate;

    private ObservableList<FeeTable> fees;
    private Database database;

    /**
     * Code after End Date is update
     */
    public void dateEndDateUpdated() {
        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        if (item.isAfter(dateEndDate.getValue())) {
                            setDisable(true);
                            setStyle("-fx-background-color: #b3b5b0;");
                        }
                        if (item.isAfter(LocalDate.now())){
                            setDisable(true);
                            setStyle("-fx-background-color: #b3b5b0;");
                        }
                    }
                };
            }
        };
        dateStartDate.setDayCellFactory(dayCellFactory);
        updateTable(convertDate(dateStartDate.getValue()), convertDate(dateEndDate.getValue()));
    }

    public void dateStartDateUpdated() {
        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        if (item.isBefore(dateStartDate.getValue())) {
                            setDisable(true);
                        }
                        if (item.isAfter(LocalDate.now())){
                            setDisable(true);
                        }
                    }
                };
            }
        };
        dateEndDate.setDayCellFactory(dayCellFactory);
        updateTable(convertDate(dateStartDate.getValue()), convertDate(dateEndDate.getValue()));
    }

    public void logoutButtonPushed(ActionEvent event) throws IOException {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../loginform/LoginFormLayout.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //disable manual input of dates and disables selection of days after current day
        //code taken from https://stackoverflow.com/questions/26330348/javafx-datepicker-how-to-customize
        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        if (item.isAfter(LocalDate.now())) {
                            setDisable(true);
                            setStyle("-fx-background-color: #b3b5b0;");
                        }
                    }
                };
            }
        };
        dateEndDate.setDayCellFactory(dayCellFactory);
        dateStartDate.setDayCellFactory(dayCellFactory);
        dateStartDate.setEditable(false);
        dateEndDate.setEditable(false);

        //initialize columns on table
        columnFranchise.setCellValueFactory(new PropertyValueFactory<FeeTable, String>("busCompany"));
        columnBusType.setCellValueFactory(new PropertyValueFactory<FeeTable, String>("busType"));
        columnArrivalFee.setCellValueFactory(new PropertyValueFactory<FeeTable, String>("arrivalFee"));
        columnLoadingFee.setCellValueFactory(new PropertyValueFactory<FeeTable, String>("loadingFee"));
        columnOrNum.setCellValueFactory(new PropertyValueFactory<FeeTable, String>("orNum"));

        //Calls for the singleton class
        database = Database.database;
        fees = FXCollections.observableArrayList();
        updateTable(0, 0);

    }

    private void temporaryDatabaseSetup() {

        //todo TEMPORARY adds data to database
        LocalDate date1 = LocalDate.of(2017, Month.OCTOBER, 12);
        LocalDate date2 = LocalDate.of(2017, Month.OCTOBER, 13);
        LocalDate date3 = LocalDate.of(2017, Month.OCTOBER, 14);
        LocalDate date4 = LocalDate.of(2017, Month.OCTOBER, 15);
        database.addBus(new Bus("ABC123", "Ceres", "1"));
        database.addBus(new Bus("ABC321", "Flybus", "2"));
        database.addBus(new Bus("ACB321", "Landbus", "1"));
        database.addBus(new Bus("ABC213", "Smolbus"));

        database.addFee(new Fee(false, false, "4:30", "#104430F", "bigboiID", date1, "ABC123"));
        database.addFee(new Fee(false, true, "4:42", "#104431F", "smolboiID", date2, "ABC321"));
        database.addFee(new Fee(true, false, "4:52", "#104432F", "mediumboiID", date3, "ACB321"));
        database.addFee(new Fee(true, true, "4:42", "#104433F", "boiID", date4, "ABC213"));


    }

    private void updateFees() {
        fees.clear();
        //Convert Fee to FeeTable for display
        ArrayList<Fee> initFees = database.getAllFees();

        ArrayList<FeeTable> convertedFees = new ArrayList<FeeTable>();
        for (Fee f : initFees) {
            convertedFees.add(new FeeTable(f));
        }

        //Convert arraylist fees to observablelist fees
        fees = FXCollections.observableArrayList();
        fees.addAll(convertedFees);
    }

    /**
     * Updates Table with new data
     */
    private void updateTable(int startDate, int endDate){
        updateFees();
        ObservableList<FeeTable> sortedFees = FXCollections.observableArrayList();
        //sorts fees in 4 states. Both empty, start empty, end empty, both filled
        for (FeeTable f : fees) {
            int feeDate = convertDate(f.getDate());
            if(startDate == 0 && endDate == 0) {
                sortedFees.add(f);
            }
            else if (startDate == 0) {
                if(feeDate <= endDate){
                    sortedFees.add(f);
                }
            }
            else if (endDate == 0) {
                if(feeDate >= startDate) {
                    sortedFees.add(f);
                }
            }
            else if (startDate <= feeDate && feeDate <= endDate) {
                sortedFees.add(f);
            }
        }

        tableView.setItems(sortedFees);

        int totalArrival = 0, totalLoading = 0;
        int unsortedTotal = 0;
        ObservableList<FeeTable> feeList = tableView.getItems();
        for (FeeTable f : feeList) {
            totalArrival += Integer.parseInt(f.getArrivalFee());
            totalLoading += Integer.parseInt(f.getLoadingFee());
        }
        for (FeeTable f : fees) {
            unsortedTotal += Integer.parseInt(f.getArrivalFee());
            unsortedTotal += Integer.parseInt(f.getLoadingFee());
        }
        txtTotalArrivalFees.setText(String.valueOf(totalArrival));
        txtTotalLoadingFees.setText(String.valueOf(totalLoading));
        txtTotalAllFees.setText(String.valueOf(totalArrival + totalLoading));
        lblTotalEarnings.setText(String.valueOf(unsortedTotal));

    }
    /**
     * converts LocalDate to int for easier comparison
     */
    private int convertDate(LocalDate date) {
        if (date == null){
            //return 0 if date picker has nothing
            return 0;
        }
        int year = date.getYear() * 10000;
        int month = date.getMonthValue() * 100;
        int day = date.getDayOfMonth();
        System.out.println(year + month + day);
        return  year + month + day;
    }

}