package com.cashier.ui;


import com.database.Database;
import com.database.DummyDatabaseBus;
import com.database.Fee;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

/**
 *
 * @author alboresallyssa
 */
public class FXMLArrivalWindowController implements Initializable {
    //These items are for the buttons in arrival window
    @FXML private Button busPrintButton;
    @FXML private Button minibusPrintButton;

    @FXML private Button transactButton;
    @FXML private Button voidButton;
    @FXML private Button cashierButton;
    @FXML private Button logoutButton;

    //These items are for the combo boxes in arrival window
    @FXML private ComboBox busFDD;
    @FXML private ComboBox minibusFDD;

    //These items are for the check boxes in arrival window
    @FXML private CheckBox arrivalFee;
    @FXML private CheckBox loadingFee;

    //These items are for the text fields in arrival window
    @FXML private TextField busNumber;
    @FXML private TextField plateNumber;

    @FXML private ObservableList<Fee> fees;
    @FXML private Database database;
    @FXML private DummyDatabaseBus databaseBus;

    private int currentOrNum;


    /**
     * When this method is called, a pop up window will appear.
     * The pop up window is the confirmation window for the BUS.
     * @param event
     * @throws IOException
     */
    public void busConfirmButtonPushed(ActionEvent event) throws IOException, InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String dateFormat = sdf.format(date.getTime());

        // to get the checked box in the window
        // TODO: database, if both are allowed to be checked
        String typeOfFee = "";
        boolean paidArrival = false;
        boolean paidLoading = false;
        if (arrivalFee.isSelected()) {
            paidArrival = true;
        } if (loadingFee.isSelected()) {
            paidLoading = true;
        }

        String busNum = busNumber.getText();

        // to get the selected franchise company in the window
        // TODO: database
        String franchiseSelected = busFDD.getValue().toString();
        String orNumber = "#" + String.valueOf(currentOrNum);
        System.out.println("Franchise: " + franchiseSelected + ", Type Of Fee: " + typeOfFee
                + ", and Bus number: " + busNum + ", Time: " + dateFormat + ", Date: " + localDate);

        Fee forDatabase =  new Fee(paidArrival, paidLoading, dateFormat, orNumber, "Cashier 01", localDate, busNum);
        currentOrNum++;
        Database database = Database.database;
        database.addFee(forDatabase);
        Database.database.displayFees();

    }

    /**
     * When this method is called, a pop up window will appear.
     * The pop up window is the confirmation window for the MINIBUS.
     * @param event
     * @throws IOException
     */
    public void minibusConfirmButtonPushed(ActionEvent event) throws IOException, InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String dateFormat = sdf.format(date.getTime());

        // to get the selected franchise company in the window
        // TODO: database
        String franchiseSelected = minibusFDD.getValue().toString();
        String plateNum = plateNumber.getText();
        System.out.println(franchiseSelected);

        //Bus temp = new Bus(plateNum, franchiseSelected);
        String orNumber = "#" + String.valueOf(currentOrNum);
        Fee forDatabase =  new Fee(true, false, dateFormat, orNumber, "Cashier 01", localDate, plateNum);
        currentOrNum++;
        Database database = Database.database;
        database.addFee(forDatabase);
        Database.database.displayFees();
    }

    public void initialize (URL url, ResourceBundle rb) {
        /**
         * These items are for configuring the Combo Box.
         * BUS Combo Box
         */
        currentOrNum = 0;
        ArrayList<Fee> listOfFees;
        try{
          listOfFees = database.getAllFees();
        } catch (NullPointerException e) {
            listOfFees = new ArrayList<Fee>();
        }
            for (Fee f : listOfFees) {
                if (Integer.parseInt(f.getOrNum()) > currentOrNum) {
                    currentOrNum = Integer.parseInt(f.getOrNum());
                }
            }
        currentOrNum++;

        busFDD.getItems().add("CERES LINER");
        busFDD.getItems().addAll("SUNRAYS","SOCORRO","METROLINK");
        busFDD.setVisibleRowCount(3);
        busFDD.setEditable(true);
        busFDD.setPromptText("BUS");

        /**
         * These items are for configuring the Combo Box.
         * MINIBUS Combo Box
         */

        minibusFDD.getItems().add("CERES LINER");
        minibusFDD.getItems().addAll("JEGANS","CALVO","COROMINAS", "GABE TRANSIT", "CANONEO", "JHADE");
        minibusFDD.setVisibleRowCount(6);
        minibusFDD.setEditable(true);
        minibusFDD.setPromptText("MINIBUS");
    }
}