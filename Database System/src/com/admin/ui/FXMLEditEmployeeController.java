package com.admin.ui;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLEditEmployeeController {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField userName;

    @FXML
    private TextField password;

    @FXML
    private JFXButton enter;

    @FXML
    private JFXButton cancel;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    void cancelPressed(ActionEvent event) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void enterPressed(ActionEvent event) {
        //CODE HERE
    }

}
