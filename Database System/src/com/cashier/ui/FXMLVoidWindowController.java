package com.cashier.ui;

import com.database.Database;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLVoidWindowController implements Initializable {
    Stage anotherStage = new Stage();
    static String orNo = "";
    static String reasonVoid = "";
    static String busCompany1 = "";
    static String busCompany2 = "";

    @FXML
    private JFXButton voidWindowSendRequest;

    @FXML
    private ComboBox voidWindowReasonVoid;

    @FXML
    private JFXCheckBox voidWindowArrivalFee1;

    @FXML
    private JFXCheckBox voidWindowLoadingFee1;

    @FXML
    private JFXTextField voidWindowOrNo;

    @FXML
    private JFXComboBox voidWindowBusCompany1;

    @FXML
    private JFXComboBox voidWindowBusCompany2;

    @FXML
    private JFXTextField voidWindowBusNumber1;

    @FXML
    private JFXTextField voidWindowBusNumber2;

    @FXML
    private JFXCheckBox voidWindowArrivalFee2;

    @FXML
    private JFXCheckBox voidWindowLoadingFee2;

    @FXML
    private JFXButton voidWindowTransact;

    @FXML
    private JFXButton voidWindowVoid;

    @FXML
    private JFXButton voidWindowCashier;

    @FXML
    private JFXButton voidWindowLogout;

    private Database database;

    @FXML
    void voidWindowCashierPressed(ActionEvent event) {
        /*Parent tableViewParent = FXMLLoader.load(getClass().getResource(""));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();*/
    }

    @FXML
    void voidWindowLogoutPressed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../loginform/LoginFormLayout.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void voidWindowSendRequestPressed(ActionEvent event) throws IOException {
        FXMLLoader anotherLoader = new FXMLLoader(getClass().getResource("../../cashier/ui/FXMLVoidRequestWindow.fxml"));
        Parent anotherRoot = anotherLoader.load();
        //anotherStage.centerOnScreen();  //does not really work idk
        Scene anotherScene = new Scene(anotherRoot);
        anotherStage.setScene(anotherScene);
        anotherStage.initStyle(StageStyle.UNDECORATED); //removes the title bar of the window

        /**s
         * Insert here:
         * 1. Check if all inputs needed are inputted
         * 2. Get all the inputs of the void window
         * 3. Check if request is in the database
         * 4. Store OR No, Cashier Name, and reason of void
         *    for the confirmation void request window
         * 5. The next step will be in the FXMLVoidRequestWindowController class
         */

        // -------------------------------------------------------------------------------------------------------------
        /**
         * 1. Inputs needed:
         *      Or no (Textfield)   ^^
         *      Reason for voiding (Combo box) ^^
         *      Bus Company 1 (Combo box) ^^
         *      Bus Company 2 (Combo box) ^^
         *      Bus Number 1 (Combo box) ^^
         *      Bus Number 2 (Combo box) ^^
         *      Payment (Check box) ^^
         *      Refund (Check box) ^^
         *
         *      if else, try catch statements to check if all needed inputs are given
         */

        orNo = voidWindowOrNo.getText();
        String busNumber1 = voidWindowBusNumber1.getText();
        String busNumber2 = voidWindowBusNumber2.getText();

        boolean paidArrival1 = false;
        boolean paidLoading1 = false;
        boolean paidArrival2 = false;
        boolean paidLoading2 = false;

        boolean check = false;

        try {
            reasonVoid = voidWindowReasonVoid.getValue().toString();
            busCompany1 = voidWindowBusCompany1.getValue().toString();
            busCompany2 = voidWindowBusCompany2.getValue().toString();
        } catch(NullPointerException e) {
            check = true;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("INCOMPLETE INFORMATION");
            alert.setHeaderText("Please complete all needed inputs.");
            alert.setContentText("");
            alert.showAndWait();
        }

        if (voidWindowArrivalFee1.isSelected()) {
            paidArrival1 = true;
        }

        if (voidWindowLoadingFee1.isSelected()) {
            paidLoading1 = true;
        }

        if (voidWindowArrivalFee2.isSelected()) {
            paidArrival2 = true;
        }
        if (voidWindowLoadingFee2.isSelected()) {
            paidLoading2 = true;
        }

        if(orNo.equals("") || busNumber1.equals("") || busNumber2.equals("")) {
            if(check == false) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("INCOMPLETE INFORMATION");
                alert.setHeaderText("Please complete all needed inputs.");
                alert.setContentText("");
                alert.showAndWait();
            }
            check = true;
        } else if(reasonVoid.equals("") || busCompany1.equals("") || busCompany2.equals("")){

        } else if(busNumber1.equals(busNumber2)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("SAME BUS NUMBER");
            alert.setHeaderText("Please input the correct bus numbers.");
            alert.setContentText("");
            alert.showAndWait();
        } else if(!paidArrival1 && !paidLoading1 || (!paidArrival2 && !paidLoading2)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("NO TYPE OF PAYMENT/REDUND SELECTED");
            alert.setHeaderText("Select type of fee.");
            alert.setContentText("");
            alert.showAndWait();
        } else{
            voidWindowVoidPressed(event);
            anotherStage.show();
        }

    }

    @FXML
    void voidWindowTransactPressed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../cashier/ui/FXMLArrivalWindow.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void voidWindowVoidPressed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../cashier/ui/FXMLVoidWindow.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /**
         * These items are for configuring the Combo Box.
         * Reason for voiding Combo box:
         */

        voidWindowReasonVoid.getItems().addAll("Wrong type of fee", "Wrong bus account", "No reason at all");
        voidWindowReasonVoid.setVisibleRowCount(3);
        voidWindowReasonVoid.setEditable(false);
        voidWindowReasonVoid.setPromptText("REASON FOR VOIDING");

        voidWindowBusCompany1.getItems().addAll("CERES", "SUNRAYS");
        voidWindowBusCompany1.setVisibleRowCount(3);
        voidWindowBusCompany1.setEditable(false);
        voidWindowBusCompany1.setPromptText("SELECT BUS/MINIBUS");

        voidWindowBusCompany2.getItems().addAll("CERES", "SUNRAYS");
        voidWindowBusCompany2.setVisibleRowCount(3);
        voidWindowBusCompany2.setEditable(false);
        voidWindowBusCompany2.setPromptText("SELECT BUS/MINIBUS");

        //TODO DELETE THIS AFTER DATABASE IS DONE
        database = Database.database;

    }
}
