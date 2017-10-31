package com.cashier.ui;


import com.database.Bus;
import com.database.Database;
import com.database.Fee;
import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * @author alboresallyssa
 */
public class FXMLArrivalWindowController implements Initializable {
    //These items are for the buttons in arrival window
    @FXML
    private Button busPrintButton;
    @FXML
    private Button minibusPrintButton;

    @FXML
    private Button transactButton;
    @FXML
    private JFXButton voidButton;
    @FXML
    private Button cashierButton;
    @FXML
    private Button logoutButton;

    //These items are for the combo boxes in arrival window
    @FXML
    private ComboBox busFDD;
    @FXML
    private ComboBox minibusFDD;

    //These items are for the check boxes in arrival window
    @FXML
    private CheckBox arrivalFee;
    @FXML
    private CheckBox loadingFee;

    //These items are for the text fields in arrival window
    @FXML
    private TextField busNumber;
    @FXML
    private TextField plateNumber;

    @FXML
    private ObservableList<Fee> fees;
    @FXML
    private Database database;

    private int currentOrNum;

    /**
     * When this method is called, a pop up window will appear.
     * The pop up window is the confirmation window for the BUS.
     *
     * @param event
     * @throws IOException
     */
    public void busConfirmButtonPushed(ActionEvent event) throws IOException, InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String dateFormat = sdf.format(date.getTime());

        try {
            String typeOfFee = "";
            boolean paidArrival = false;
            boolean paidLoading = false;
            if (arrivalFee.isSelected()) {
                paidArrival = true;
            }
            if (loadingFee.isSelected()) {
                paidLoading = true;
            }

            String busNum = busNumber.getText();

            if (loadingFee.isSelected() == false && arrivalFee.isSelected() == false) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("No Fee type");
                alert.setHeaderText("Select Fee to be paid");
                alert.setContentText("");

                alert.showAndWait();

            } else {
                String franchiseSelected = busFDD.getValue().toString();
                String orNumber = "#" + String.valueOf(currentOrNum);

                //Find bus based on franchise and busNum
                ArrayList<String> desc = new ArrayList<String>();
                ArrayList<String> value = new ArrayList<String>();
                desc.add("busNumber");
                desc.add("company");
                value.add(busNum);
                value.add(franchiseSelected);
                try {
                    Bus bus = database.getBus(desc, value).get(0);

                    //check if bus plate number exists in database
                    ArrayList<Bus> buses = database.getAllBuses();
                    boolean busExists = false;
                    for(Bus b : buses) {
                        if(b.getPlateNo().equals(bus.getPlateNo())) {
                            busExists = true;
                            break;
                        }
                    }
                    if(busExists && bus.isMinibus() == false) {
                        /**
                         * database interaction is here
                         */
                        Fee forDatabase = new Fee(paidArrival, paidLoading, dateFormat, orNumber, "Cashier 01", localDate, bus.getPlateNo());
                        currentOrNum++;
                        Database database = Database.database;
                        database.addFee(forDatabase);
                        Database.database.displayFees();
                        database.displayAll();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("INCORRECT DATA");
                        alert.setHeaderText("Please check your data");
                        alert.setContentText("");

                        alert.showAndWait();
                    }
                }catch (NullPointerException er) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("NO BUS");
                    alert.setHeaderText("No buses on record");
                    alert.setContentText("Contact admin");

                    alert.showAndWait();
                }catch (IndexOutOfBoundsException er1) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("NO BUS");
                    alert.setHeaderText("No buses on record");
                    alert.setContentText("Contact admin");

                    alert.showAndWait();
                }

            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("INCOMPLETE DATA");
            alert.setHeaderText("Please fill in all data.");
            alert.setContentText("");

            alert.showAndWait();
        }


    }

    /**
     * When this method is called, a pop up window will appear.
     * The pop up window is the confirmation window for the MINIBUS.
     *
     * @param event
     * @throws IOException
     */
    public void minibusConfirmButtonPushed(ActionEvent event) throws IOException, InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String dateFormat = sdf.format(date.getTime());

        try {
            String franchiseSelected = minibusFDD.getValue().toString();
            String plateNum1 = plateNumber.getText();
            // autocaps the plate number inputted
            String plateNum = plateNum1.toUpperCase();


            try {
                Bus bus = database.getBus("plateNo", plateNum).get(0);

                //check if bus plate number exists in database
                ArrayList<Bus> buses = database.getAllBuses();
                boolean busExists = false;
                for(Bus b : buses) {
                    if(b.getPlateNo().equals(bus.getPlateNo())) {
                        busExists = true;
                        break;
                    }
                }

                if(busExists && bus.isMinibus()) {
                    /**
                     * database interaction is here
                     */
                    //Bus temp = new Bus(plateNum, franchiseSelected);
                    String orNumber = "#" + String.valueOf(currentOrNum);
                    Fee forDatabase = new Fee(true, false, dateFormat, orNumber, "Cashier 01", localDate, plateNum);
                    currentOrNum++;
                    database.addFee(forDatabase);
                    Database.database.displayFees();
                    database.displayAll();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("INCORRECT DATA");
                    alert.setHeaderText("Check input");
                    alert.setContentText("");

                    alert.showAndWait();
                }
            }catch (NullPointerException er) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("NO BUS");
                alert.setHeaderText("No buses on record");
                alert.setContentText("Please contact the admin.");

                alert.showAndWait();
            }catch (IndexOutOfBoundsException er2) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("INCORRECT DATA");
                alert.setHeaderText("Check input");
                alert.setContentText("Possible Cause:\n-Incorrect bus details");

                alert.showAndWait();
            }
        } catch(NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("INCOMPLETE DATA");
            alert.setHeaderText("Please fill in all data.");
            alert.setContentText(" ");

            alert.showAndWait();
        }
    }


    @FXML
    void arrivalWindowCashierPressed(ActionEvent event) {
        /*Parent tableViewParent = FXMLLoader.load(getClass().getResource(""));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();*/
    }

    @FXML
    void arrivalWindowLogoutPressed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../loginform/FXMLLoginFormWindow.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void arrivalWindowTransactPressed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../cashier/ui/FXMLArrivalWindow.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void arrivalWindowVoidPressed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../cashier/ui/FXMLVoidWindow.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void initialize(URL url, ResourceBundle rb) {
        /**
         * These items are for configuring the Combo Box.
         * BUS Combo Box
         */
        currentOrNum = 0;
        ArrayList<Fee> listOfFees;
        try {
            listOfFees = database.getAllFees();
        } catch (NullPointerException e) {
            listOfFees = new ArrayList<Fee>();
        }
        for (Fee f : listOfFees) {
            if (Integer.parseInt(f.getOrNum()) > currentOrNum) {
                currentOrNum = Integer.parseInt(f.getOrNum());
            }
        }
        currentOrNum++;

        busFDD.getItems().add("CERES LINER");
        busFDD.getItems().addAll("SUNRAYS", "SOCORRO", "METROLINK");
        busFDD.setVisibleRowCount(3);
        busFDD.setEditable(true);
        busFDD.setPromptText("BUS");

        /**
         * These items are for configuring the Combo Box.
         * MINIBUS Combo Box
         */

        minibusFDD.getItems().add("CERES LINER");
        minibusFDD.getItems().addAll("JEGANS", "CALVO", "COROMINAS", "GABE TRANSIT", "CANONEO", "JHADE");
        minibusFDD.setVisibleRowCount(6);
        minibusFDD.setEditable(true);
        minibusFDD.setPromptText("MINIBUS");


        //TODO DELETE THIS AFTER DATABASE IS DONE
        database = Database.database;
    }
}