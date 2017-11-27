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
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLMainCashierWindowController implements Initializable {
    //These items are for the buttons in arrival window
    Stage anotherStage = new Stage();
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
    private JFXButton voidButton;

    @FXML
    private JFXButton transactionsButton;

    @FXML
    private JFXButton rangeButton;

    @FXML
    private Text currentORNumber;

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
    void rangeButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader anotherLoader = new FXMLLoader(getClass().getResource("../../cashier/ui/FXMLGetRange.fxml"));
        Parent anotherRoot = anotherLoader.load();
        //anotherStage.centerOnScreen();  //does not really work idk
        Scene anotherScene = new Scene(anotherRoot);
        anotherStage.setScene(anotherScene);
        anotherStage.initStyle(StageStyle.UNDECORATED);

        voidWindowVoidPressed(event);
        anotherStage.show();
    }

    @FXML
    void arrivalWindowVoidPressed(ActionEvent event) throws IOException {
        FXMLLoader anotherLoader = new FXMLLoader(getClass().getResource("../../cashier/ui/FXMLVoidWindow.fxml"));
        Parent anotherRoot = anotherLoader.load();
        //anotherStage.centerOnScreen();  //does not really work idk
        Scene anotherScene = new Scene(anotherRoot);
        anotherStage.setScene(anotherScene);
        anotherStage.initStyle(StageStyle.UNDECORATED);

        voidWindowVoidPressed(event);
        anotherStage.show();
    }

    @FXML
    void voidWindowVoidPressed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../cashier/ui/FXMLMainCashierWindow.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void initialize(URL url, ResourceBundle rb) {
        cashierUserText.setText("JJuan");

        currentORNumber.setText("000142");
    }
}