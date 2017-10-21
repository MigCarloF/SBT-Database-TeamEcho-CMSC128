package com.cashier.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class FXMLVoidWindowController {
    Stage anotherStage = new Stage();

    @FXML
    private JFXButton voidWindowSendRequest;

    @FXML
    private JFXComboBox<?> voidWindowReasonVoid;

    @FXML
    private JFXCheckBox voidWindowArrivalFee1;

    @FXML
    private JFXCheckBox voidWindowLoadingFee1;

    @FXML
    private JFXTextField voidWindowOrNo;

    @FXML
    private JFXComboBox<?> voidWindowBusCompany1;

    @FXML
    private JFXComboBox<?> voidWindowBusCompany2;

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
        // TODO: fix error "java.lang.IllegalStateException: Cannot set style once stage has been set visible"
        FXMLLoader anotherLoader = new FXMLLoader(getClass().getResource("../../cashier/ui/FXMLVoidRequestWindow.fxml"));
        Parent anotherRoot = anotherLoader.load();
        //anotherStage.centerOnScreen();  //does not really work idk
        Scene anotherScene = new Scene(anotherRoot);
        anotherStage.setScene(anotherScene);
        anotherStage.initStyle(StageStyle.UNDECORATED); //removes the title bar of the window
        anotherStage.show();
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
}
