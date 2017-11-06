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

public class FXMLCreateProfileController implements Initializable {

    @FXML
    private JFXButton createProfileCancelButton;

    @FXML
    private JFXButton createProfileCreateButton;

    @FXML
    private TextField createProfileAccountNo;

    @FXML
    private TextField createProfileCPerson;

    @FXML
    private TextField createProfileCNumber;

    @FXML
    private TextField createProfileFranchise;

    @FXML
    private TextField createProfilePlateNo;

    @FXML
    private TextField createProfileBusNo;

    @FXML
    private TextField createProfileSize;

    @FXML
    private TextField createProfileCapacity;

    @FXML
    private TextField createProfileType;

    @FXML
    private TextField createProfileRoute;

    @FXML
    private TextField createProfileFare;

    @FXML
    void createProfileCancelPressed(ActionEvent event) {
        Stage stage = (Stage) createProfileCancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void createProfileCreatePressed(ActionEvent event) {
        //TODO: get inputs
        String contactPerson = createProfileCPerson.getText();
        String contactNumber = createProfileCNumber.getText();
        String franchise = createProfileFranchise.getText();
        String plateNumber = createProfilePlateNo.getText();
        String busNumber = createProfileBusNo.getText();
        String size = createProfileSize.getText();
        String capacity = createProfileCapacity.getText();
        String type = createProfileType.getText();
        String route = createProfileRoute.getText();
        String fare = createProfileFare.getText();

        System.out.println("Contact person: " + contactPerson + "\nContact Number: " + contactNumber + "\nFranchise: "
        + franchise + "\nPlate number: " + plateNumber + "\nBus number: " + busNumber + "\nSize: " + size +
        "\nCapacity: " + capacity + "\nType: " + type + "\nRoute: " + route + "\nFare: " + fare);

        /**
         * Add data to database
         */

         // closes the window
        Stage stage = (Stage) createProfileCreateButton.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int latestNumberOfBusProfiles = 71; //TODO: get the current number of bus profiles in the database
        createProfileAccountNo.setText(String.valueOf(latestNumberOfBusProfiles + 1));
    }    
    
}
