/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLCreateProfileController implements Initializable {
    //BRANDON!!!!!
    final ToggleGroup sizeGroup = new ToggleGroup();
    final ToggleGroup typeGroup = new ToggleGroup();

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
    private TextField createProfileCapacity;

    @FXML
    private TextField createProfileRoute1;

    @FXML
    private TextField createProfileFare;

    @FXML
    private JFXRadioButton radioBoxMiniBus;

    @FXML
    private JFXRadioButton radioBoxBus;

    @FXML
    private JFXRadioButton radioBoxAircon;

    @FXML
    private JFXRadioButton radioBoxNonAircon;

    @FXML
    private TextField createProfileRoute2;

    //THIS
    @FXML
    private TextField createProfileAlert;

    @FXML
    void createProfileCancelPressed(ActionEvent event) {
        Stage stage = (Stage) createProfileCancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void createProfileCreatePressed(ActionEvent event) {
        String contactPerson = createProfileCPerson.getText();
        String contactNumber = createProfileCNumber.getText();
        String franchise = createProfileFranchise.getText();
        String plateNumber = createProfilePlateNo.getText();
        String busNumber = createProfileBusNo.getText();
        String size = "";
        String capacity = createProfileCapacity.getText();
        String type = "";
        String route1 = createProfileRoute1.getText();
        String route2 = createProfileRoute2.getText();
        String fare = createProfileFare.getText();

        //BRANDON!!!!!

        //ahhhhhhhhhhhh 
        typeGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            String value = observable.getValue().toString();
            System.out.println(value);
        });
        System.out.println("Contact person: " + contactPerson + "\nContact Number: " + contactNumber + "\nFranchise: "
        + franchise + "\nPlate number: " + plateNumber + "\nBus number: " + busNumber + "\nSize: " + size +
        "\nCapacity: " + capacity + "\nType: " + type + "\nRoute: " + route1 + " - " + route2 + "\nFare: " + fare);

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

        //BRANDON!!!!!
        radioBoxMiniBus.setToggleGroup(sizeGroup);
        radioBoxBus.setToggleGroup(sizeGroup);

        radioBoxAircon.setToggleGroup(typeGroup);
        radioBoxNonAircon.setToggleGroup(typeGroup);
    }    
    
}
