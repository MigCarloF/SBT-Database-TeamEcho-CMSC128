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
import javafx.scene.control.TreeTableColumn;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLRecordsWindowController implements Initializable {
    //BRANDON!!!!!
    Stage createAccountStage = new Stage();
    //THIS
    Stage currentStage = new Stage();

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
    void recordsAdminButtonPressed(ActionEvent event) throws IOException {
        //BRANDON!!!!!
        FXMLLoader anotherLoader = new FXMLLoader(getClass().getResource("../../admin/ui/FXMLCreateAccount.fxml"));
        Parent anotherRoot = anotherLoader.load();
        Scene anotherScene = new Scene(anotherRoot);
        createAccountStage.setScene(anotherScene);
        createAccountStage.initStyle(StageStyle.UNDECORATED); //removes the title bar of the window

        /**
         *  The bus profiles window is "refreshed" every time the create profile
         *  button is pressed due to an error. The error is caused from removing
         *  the title bar of the window.
         */

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../admin/ui/FXMLRecordsWindow.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

        createAccountStage.show();
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

        //THIS
        recordsMenu.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                Stage stage = (Stage) recordsAdminButton.getScene().getWindow();
                if(recordsMenu.getItems().get((Integer) number2).equals("CURRENT")) {
                    FXMLLoader anotherLoader = new FXMLLoader(getClass().getResource("../../admin/ui/FXMLCurrentWindow.fxml"));
                    Parent anotherRoot = null;
                    try {
                        anotherRoot = anotherLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene anotherScene = new Scene(anotherRoot);
                    currentStage.setScene(anotherScene);
                } else if (recordsMenu.getItems().get((Integer) number2).equals("RECORDS")) {
                    FXMLLoader anotherLoader = new FXMLLoader(getClass().getResource("../../admin/ui/FXMLRecordsWindow.fxml"));
                    Parent anotherRoot = null;
                    try {
                        anotherRoot = anotherLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene anotherScene = new Scene(anotherRoot);
                    currentStage.setScene(anotherScene);
                } else if (recordsMenu.getItems().get((Integer) number2).equals("VOID REQUESTS")) {
                    FXMLLoader anotherLoader = new FXMLLoader(getClass().getResource("../../admin/ui/FXMLAdminVoidRequestsWindow.fxml"));
                    Parent anotherRoot = null;
                    try {
                        anotherRoot = anotherLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene anotherScene = new Scene(anotherRoot);
                    currentStage.setScene(anotherScene);
                } else if (recordsMenu.getItems().get((Integer) number2).equals("BUS PROFILES")) {
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
