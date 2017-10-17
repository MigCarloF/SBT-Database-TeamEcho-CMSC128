/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashier.ui;


import com.database.Bus;
import com.database.Database;
import com.database.Fee;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    /**
     * When this method is called, a new window will appear.
     * The pop up window is the void window.
     * @param event
     * @throws IOException
     */
    public void voidButtonPushed(ActionEvent event) throws IOException {
        Parent voidWindowParent = FXMLLoader.load(getClass().getResource("FXMLVoidWindow.fxml"));
        Scene voidWindowScene = new Scene(voidWindowParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(voidWindowScene);
        window.show();
    }

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
        System.out.println("Franchise: " + franchiseSelected + ", Type Of Fee: " + typeOfFee
                + ", and Bus number: " + busNum + ", Time: " + dateFormat + ", Date: " + localDate);

        database.addBus(new Bus("ABC213", "Smolbus"));
        Fee forDatabase =  new Fee(paidArrival, paidLoading, dateFormat, "", "Cashier 01", localDate, busNum);
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
        Fee forDatabase =  new Fee(true, false, dateFormat, "", "Cashier 01", localDate, plateNum);
        Database database = Database.database;
        database.addFee(forDatabase);
        Database.database.displayFees();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /**
         * These items are for configuring the Combo Box.
         * BUS Combo Box
         */

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
