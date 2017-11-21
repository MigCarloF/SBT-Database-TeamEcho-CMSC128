package com.admin.ui;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLRecordsWindowController implements Initializable {
    Stage anotherStage = new Stage();
    @FXML
    private Text adminUserText;

    @FXML
    private JFXButton logoutButton;

    @FXML
    private TextField search;

    @FXML
    private JFXButton currentButton;

    @FXML
    private JFXButton recordsButton;

    @FXML
    private JFXButton employeeViewButton;

    @FXML
    private JFXButton employeeCreateButton;

    @FXML
    private JFXButton employeeEditButton;

    @FXML
    private JFXButton busViewButton;

    @FXML
    private JFXButton busCreateButton;

    @FXML
    private JFXButton busEditButton;

    @FXML
    private DatePicker dateTo;

    @FXML
    private DatePicker dateFrom;

    @FXML
    private TextField quantityAF;

    @FXML
    private TextField quantityLF;

    @FXML
    private TextField amountAF;

    @FXML
    private TextField amountLF;

    @FXML
    private TextField totalRevenue;

    @FXML
    private TextField totalVoid;

    @FXML
    private TableColumn<?, ?> date;

    @FXML
    private TableColumn<?, ?> time;

    @FXML
    private TableColumn<?, ?> orNo;

    @FXML
    private TableColumn<?, ?> company;

    @FXML
    private TableColumn<?, ?> busType;

    @FXML
    private TableColumn<?, ?> plateNo;

    @FXML
    private TableColumn<?, ?> route;

    @FXML
    private TableColumn<?, ?> arrival;

    @FXML
    private TableColumn<?, ?> feeType;

    @FXML
    private TableColumn<?, ?> amount;

    @FXML
    private TableColumn<?, ?> status;

    @FXML
    void busCreateButtonPressed(ActionEvent event) {

    }

    @FXML
    void busEditButtonPressed(ActionEvent event) {

    }

    @FXML
    void busViewButtonPressed(ActionEvent event) {

    }

    @FXML
    void currentButtonPressed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../admin/ui/FXMLCurrentWindow.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void employeeCreateButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader anotherLoader = new FXMLLoader(getClass().getResource("../../admin/ui/FXMLCreateAccount.fxml"));
        Parent anotherRoot = anotherLoader.load();
        //anotherStage.centerOnScreen();  //does not really work idk
        Scene anotherScene = new Scene(anotherRoot);
        anotherStage.setScene(anotherScene);
        anotherStage.initStyle(StageStyle.UNDECORATED);

        refreshWindow(event);
        anotherStage.show();
    }

    @FXML
    void refreshWindow(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../admin/ui/FXMLRecordsWindow.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void employeeEditButtonPressed(ActionEvent event) {

    }

    @FXML
    void employeeViewButtonPressed(ActionEvent event) {

    }

    @FXML
    void logoutButtonPressed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../loginform/FXMLLoginFormWindow.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void recordsButtonPressed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../admin/ui/FXMLRecordsWindow.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void initialize(URL url, ResourceBundle rb) {
        adminUserText.setText("Sir Joey");
        totalRevenue.setText("1600");
        quantityAF.setText("9");
        quantityLF.setText("9");
        amountAF.setText("450");
        amountLF.setText("1050");
        totalVoid.setText("10");

        /**
         *  TODO: implement search text field
         */

        search.getText();
    }
}
