package com.accountant.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label lblTotalEarnings;
    @FXML
    private TextField txtTotalArrivalFees;

    public void typed() {
        System.out.println("Waow");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
