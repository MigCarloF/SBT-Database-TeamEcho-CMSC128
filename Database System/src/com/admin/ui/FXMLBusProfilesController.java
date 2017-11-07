/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.ui;

import com.jfoenix.controls.JFXButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLBusProfilesController implements Initializable {
    Stage createProfileStage = new Stage();
    //BRANDON!!!!!
    Stage createAccountStage = new Stage();

    //THIS
    Stage currentStage = new Stage();

    @FXML
    private JFXButton busProfilesAdminButton;

    @FXML
    private JFXButton busProfilesLogoutButton;

    @FXML
    private TreeTableView busProfilesTable;
    
    @FXML
    private JFXButton busProfilesCreateProfileButton;
    
    @FXML
    private ComboBox busProfilesMenu;

    //BRANDON!!!!!
    @FXML
    private JFXButton busProfilesEditButton;

    @FXML
    void busProfilesAdminButton(ActionEvent event) throws IOException {
        //BRANDON!!!!!
        FXMLLoader anotherLoader = new FXMLLoader(getClass().getResource("../../admin/ui/FXMLCreateAccount.fxml"));
        Parent anotherRoot = anotherLoader.load();
        Scene anotherScene = new Scene(anotherRoot);
        createAccountStage.setScene(anotherScene);
        createAccountStage.initStyle(StageStyle.UNDECORATED); //removes the title bar of the window

        /**
         *  The bus profiles window is "refreshed" every time the create profile
         *  button is pressed due to an error. The error is caused from removing
         *  the title bar of the window. The same as what I did in void request.
         */

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../admin/ui/FXMLBusProfiles.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

        createAccountStage.show();
    }

    @FXML
    void busProfilesLogoutButtonPressed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../loginform/FXMLLoginFormWindow.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void busProfilesEditProfileButtonPressed(ActionEvent event) throws IOException {
        //BRANDON!!!!!
        FXMLLoader anotherLoader = new FXMLLoader(getClass().getResource("../../admin/ui/FXMLEditBusProfile.fxml"));
        Parent anotherRoot = anotherLoader.load();
        Scene anotherScene = new Scene(anotherRoot);
        createProfileStage.setScene(anotherScene);
        createProfileStage.initStyle(StageStyle.UNDECORATED); //removes the title bar of the window

        /**
         *  The bus profiles window is "refreshed" every time the create profile
         *  button is pressed due to an error. The error is caused from removing
         *  the title bar of the window. The same as what I did in void request.
         */

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../admin/ui/FXMLBusProfiles.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

        createProfileStage.show();
    }
    
    @FXML
    void busProfilesCreateProfilePressed(ActionEvent event) throws IOException {
        FXMLLoader anotherLoader = new FXMLLoader(getClass().getResource("../../admin/ui/FXMLCreateProfile.fxml"));
        Parent anotherRoot = anotherLoader.load();
        Scene anotherScene = new Scene(anotherRoot);
        createProfileStage.setScene(anotherScene);
        createProfileStage.initStyle(StageStyle.UNDECORATED); //removes the title bar of the window

        /**
         *  The bus profiles window is "refreshed" every time the create profile
         *  button is pressed due to an error. The error is caused from removing
         *  the title bar of the window. The same as what I did in void request.
         */

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../admin/ui/FXMLBusProfiles.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

        createProfileStage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /**
         * This part is for the initialization of the Combo Box.
         * TODO: Every item in the menu when chosen, another scene will be 
         * opened to the item's corresponding scene (change scene/stage).
         */
        
        busProfilesMenu.getItems().addAll("CURRENT", "RECORDS", "VOID REQUESTS", "BUS PROFILES");
        busProfilesMenu.setVisibleRowCount(4);
        busProfilesMenu.setEditable(false);
        busProfilesMenu.setPromptText("BUS PROFILES");

        //THIS
        busProfilesMenu.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                Stage stage = (Stage) busProfilesAdminButton.getScene().getWindow();
                if(busProfilesMenu.getItems().get((Integer) number2).equals("CURRENT")) {
                    FXMLLoader anotherLoader = new FXMLLoader(getClass().getResource("../../admin/ui/FXMLCurrentWindow.fxml"));
                    Parent anotherRoot = null;
                    try {
                        anotherRoot = anotherLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene anotherScene = new Scene(anotherRoot);
                    currentStage.setScene(anotherScene);
                } else if (busProfilesMenu.getItems().get((Integer) number2).equals("RECORDS")) {
                    FXMLLoader anotherLoader = new FXMLLoader(getClass().getResource("../../admin/ui/FXMLRecordsWindow.fxml"));
                    Parent anotherRoot = null;
                    try {
                        anotherRoot = anotherLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene anotherScene = new Scene(anotherRoot);
                    currentStage.setScene(anotherScene);
                } else if (busProfilesMenu.getItems().get((Integer) number2).equals("VOID REQUESTS")) {
                    FXMLLoader anotherLoader = new FXMLLoader(getClass().getResource("../../admin/ui/FXMLAdminVoidRequestsWindow.fxml"));
                    Parent anotherRoot = null;
                    try {
                        anotherRoot = anotherLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene anotherScene = new Scene(anotherRoot);
                    currentStage.setScene(anotherScene);
                } else if (busProfilesMenu.getItems().get((Integer) number2).equals("BUS PROFILES")) {
                    FXMLLoader anotherLoader = new FXMLLoader(getClass().getResource("../../admin/ui/FXMLBusProfiles.fxml"));
                    Parent anotherRoot = null;
                    try {
                        anotherRoot = anotherLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene anotherScene = new Scene(anotherRoot);
                    currentStage.setScene(anotherScene);
                }
                stage.close();
                currentStage.show();
            }
        });
    }
}
