package com.cashier.ui;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLMainCashierWindowController implements Initializable {
    //These items are for the buttons in arrival window
    @FXML
    private Text cashierUserText;

    @FXML
    private JFXButton logoutButton;

    @FXML
    private JFXButton busPrintButton;

    @FXML
    private TextField plateNumber;

    @FXML
    private JFXCheckBox arrivalFee;

    @FXML
    private JFXCheckBox loadingFee;

    @FXML
    private TextField totalCashier;

    @FXML
    private TextField quantity1;

    @FXML
    private TextField quantity2;

    @FXML
    private TextField quantity3;

    @FXML
    private TextField quantity4;

    @FXML
    private TextField quantity5;

    @FXML
    private TextField quantity6;

    @FXML
    private TextField quantity7;

    @FXML
    private TextField quantity8;

    @FXML
    private TextField quantity9;

    @FXML
    private TextField amount1;

    @FXML
    private TextField amount2;

    @FXML
    private TextField amount3;

    @FXML
    private TextField amount4;

    @FXML
    private TextField amount5;

    @FXML
    private TextField amount6;

    @FXML
    private TextField amount7;

    @FXML
    private TextField amount8;

    @FXML
    private TextField amount9;

    @FXML
    private JFXButton voidButton;

    @FXML
    private JFXButton transactionsButton;

    @FXML
    void busPrintButtonPressed(ActionEvent event) {
        String plateNum = plateNumber.getText();

        boolean arrival = false;
        boolean loading = false;
        if (arrivalFee.isSelected()) {
            arrival = true;
        }
        if (loadingFee.isSelected()) {
            loading = true;
        }


    }

    @FXML
    void transactionsButtonPressed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../cashier/ui/FXMLTransactions.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }


    @FXML
    void arrivalWindowLogoutPressed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../loginform/FXMLLoginFormWindow.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }



    @FXML
    void arrivalWindowVoidPressed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../cashier/ui/FXMLVoidWindow.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void initialize(URL url, ResourceBundle rb) {
        cashierUserText.setText("JJuan");

        /**
         *   CASH COUNT VARIABLES
         */
        String one = quantity1.getText();
        String two = quantity2.getText();
        String three = quantity3.getText();
        String four = quantity4.getText();
        String five = quantity5.getText();
        String six = quantity6.getText();
        String seven = quantity7.getText();
        String eight = quantity8.getText();
        String nine = quantity9.getText();

        amount1.setText("3000");
        amount2.setText("500");
        amount3.setText("200");
        amount4.setText("100");
        amount5.setText("50");
        amount6.setText("20");
        amount7.setText("10");
        amount8.setText("5");
        amount9.setText("1");

        totalCashier.setText("1886");
    }
}