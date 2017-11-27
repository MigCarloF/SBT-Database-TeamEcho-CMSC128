/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.ui;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLEditBusProfileController implements Initializable {
    @FXML
    private JFXButton cancelButton;

    @FXML
    private JFXButton editButton;

    @FXML
    private TextField contactPerson;

    @FXML
    private TextField contactNumber;

    @FXML
    private TextField cebuCity;

    @FXML
    private TextField franchise;

    @FXML
    private TextField plateNo;

    @FXML
    private TextField route;

    @FXML
    private TextField type;

    @FXML
    private TextField size;

    @FXML
    void cancelButtonPressed(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void editButtonPressed(ActionEvent event) {
        String contactPersonText = contactPerson.getText();
        String contactNumberText = contactNumber.getText();
        String franchiseText = franchise.getText();
        String plateNoText = plateNo.getText();
        String typeText = type.getText();
        String routeText = route.getText();
        String sizeText = size.getText();

        // closes the window
        Stage stage = (Stage) editButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO:
        /**
         * get the selected row sa tableview and then ang data needed duh
         */


    }

}
