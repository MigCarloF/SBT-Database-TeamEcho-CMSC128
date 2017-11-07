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
    private JFXButton editProfilesCancelButton;

    @FXML
    private JFXButton editProfilesEditButton;

    @FXML
    private JFXButton editProfilesDeleteButton;

    @FXML
    private TextField editProfilesAccountNo;

    @FXML
    private TextField editProfilesCPerson;

    @FXML
    private TextField editProfilesCNumber;

    @FXML
    private TextField editProfilesFranchise;

    @FXML
    private TextField editProfilesPlateNo;

    @FXML
    private TextField editProfilesBusNo;

    @FXML
    private TextField editProfilesSize;

    @FXML
    private TextField editProfilesCapacity;

    @FXML
    private TextField editProfilesType;

    @FXML
    private TextField editProfilesRoute;

    @FXML
    private TextField editProfilesFare;

    @FXML
    void editProfilesCancelPressed(ActionEvent event) {
        Stage stage = (Stage) editProfilesCancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void editProfilesDeletePressed(ActionEvent event) {
        //DELETE SA DATABASE

    }

    @FXML
    void editProfilesEditPressed(ActionEvent event) {
        //EDITABLE TEXTFIELD RIGHT THEN ANG NEW KAY I REPLACE ANG OLD
        /**
         *  ahh i check na lang nako tanan if naa bay na change nila
         */
        String contactPerson = editProfilesCPerson.getText();
        String contactNumber = editProfilesCNumber.getText();
        String franchise = editProfilesFranchise.getText();
        String plateNo = editProfilesPlateNo.getText();
        String busNo = editProfilesBusNo.getText();
        String size = editProfilesSize.getText();
        String capacity = editProfilesCapacity.getText();
        String type = editProfilesType.getText();
        String route = editProfilesRoute.getText();
        String fare = editProfilesFare.getText();

        // IF ELSE??? TO COMPARE IF NAA BAY NA CHANGE?? THEN IN NAA KAY I REPLACE LIKE IF ANG CONTACT
        // NUMBER NA CHANGE THEN I REPLACE ANG CONTACT NUMBER SA DATABASE ATO NA BUS PROFILE WAAHHH

        //closes window
        Stage stage = (Stage) editProfilesCancelButton.getScene().getWindow();
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

        editProfilesAccountNo.setText("");  //the account number of the bus profile selected

        editProfilesCPerson.setText("Brandon Jay Flores");
        editProfilesCNumber.setText("09569081042");
        editProfilesFranchise.setText("CERES");
        editProfilesPlateNo.setText("ABC123");
        editProfilesBusNo.setText("454");
        editProfilesSize.setText("BUS");
        editProfilesCapacity.setText("120");
        editProfilesType.setText("AIRCON");
        editProfilesRoute.setText("CEBU - ARGAO");
        editProfilesFare.setText("76");
    }

}
