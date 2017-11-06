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
    void createProfileCancelPressed(ActionEvent event) {
        Stage stage = (Stage) createProfileCancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void createProfileCreatePressed(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
