package com.cashier.ui;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLVoidRequestWindowController implements Initializable {
    @FXML
    private JFXButton voidRequestWindowCancel;

    @FXML
    private JFXButton voidRequestWindowSend;

    @FXML
    private Text voidRequestWindowText1;    //OR NO

    @FXML
    private Text voidRequestWindowText2;    //Requested by

    @FXML
    private Text voidRequestWindowText3;    //Reason for avoiding

    @FXML
    void voidRequestWindowCancelPressed(ActionEvent event) throws IOException {
        Stage stage = (Stage) voidRequestWindowCancel.getScene().getWindow();
        CashierMain.cancelPressed = true;
        stage.close();
    }

    @FXML
    void voidRequestWindowSendPressed(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
