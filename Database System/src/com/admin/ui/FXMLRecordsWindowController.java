package com.admin.ui;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeTableColumn;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLRecordsWindowController implements Initializable {

    @FXML
    private TreeTableColumn<?, ?> recordsFranchise;

    @FXML
    private TreeTableColumn<?, ?> recordsBusType;

    @FXML
    private TreeTableColumn<?, ?> recordsPlateNo;

    @FXML
    private TreeTableColumn<?, ?> recordsRoute;

    @FXML
    private TreeTableColumn<?, ?> recordsStatus;

    @FXML
    private TreeTableColumn<?, ?> recordsArrivalTime;

    @FXML
    private TreeTableColumn<?, ?> recordsDepartureTime;

    @FXML
    private TreeTableColumn<?, ?> recordsArrivalFee;

    @FXML
    private TreeTableColumn<?, ?> recordsLoadingFee;

    @FXML
    private TreeTableColumn<?, ?> recordsORNum;

    @FXML
    private JFXButton recordsAdminButton;

    @FXML
    private JFXButton recordsLogoutButton;

    @FXML
    private JFXButton busProfilesCreateProfileButton;

    @FXML
    private ComboBox recordsMenu;

    @FXML
    private JFXButton recordsGoButton;

    @FXML
    void recordsAdminButton(ActionEvent event) {
        //TODO
    }

    @FXML
    void recordsGoButtonPressed(ActionEvent event) throws IOException {
        if(recordsMenu.getValue().equals("CURRENT")) {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLCurrentWindow.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        } else if(recordsMenu.getValue().equals("RECORDS")) {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLRecordsWindow.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        } else if(recordsMenu.getValue().equals("VOID REQUESTS")) {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLAdminVoidRequestsWindow.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        } else if(recordsMenu.getValue().equals("BUS PROFILES")) {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLBusProfiles.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        }
    }

    @FXML
    void recordsLogoutButtonPressed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../loginform/FXMLLoginFormWindow.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void initialize(URL url, ResourceBundle rb) {
        recordsMenu.getItems().addAll("CURRENT", "RECORDS", "VOID REQUESTS", "BUS PROFILES");
        recordsMenu.setVisibleRowCount(4);
        recordsMenu.setEditable(false);
        recordsMenu.setPromptText("RECORDS");
    }
}
