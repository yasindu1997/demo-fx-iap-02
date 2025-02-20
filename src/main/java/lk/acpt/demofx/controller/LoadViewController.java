package lk.acpt.demofx.controller;/*Auther : Yasindu Sathsara
Place : ACPT's Lab*/

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.acpt.demofx.tm.VehicleTM;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadViewController implements Initializable {
    @FXML
    private TableView<VehicleTM> tblVehicles;

    public ArrayList<VehicleTM> loadData() {
        try {
            //load the installed driver to this class
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database server and database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iap_2", "root", "acpt");

            //dynamic query
            PreparedStatement preparedStatement = connection.prepareStatement("select * from vehicles");

            //execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<VehicleTM> list = new ArrayList();

            while (resultSet.next()) {
                VehicleTM vehicleTM = new VehicleTM();

                vehicleTM.setId(resultSet.getInt(1));
                vehicleTM.setBrand(resultSet.getString(2));
                vehicleTM.setModel(resultSet.getString(3));
                vehicleTM.setNoOfGears(resultSet.getInt(4));
                vehicleTM.setPrice(resultSet.getDouble(5));

                list.add(vehicleTM);
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void load(ActionEvent event) {

        //fx table config
        tblVehicles.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblVehicles.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblVehicles.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("model"));
        tblVehicles.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("noOfGears"));
        tblVehicles.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));

        ArrayList<VehicleTM> vehicles = loadData();
        tblVehicles.setItems(FXCollections.observableArrayList(vehicles));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //fx table config
        tblVehicles.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblVehicles.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblVehicles.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("model"));
        tblVehicles.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("noOfGears"));
        tblVehicles.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));

        ArrayList<VehicleTM> vehicleTMS = loadData();
        tblVehicles.setItems(FXCollections.observableArrayList(vehicleTMS));
    }
}
