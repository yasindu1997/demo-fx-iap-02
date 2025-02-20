package lk.acpt.demofx.controller;/*Auther : Yasindu Sathsara
Place : ACPT's Lab*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.acpt.demofx.dto.VehicleDto;
import lk.acpt.demofx.model.VehicleModel;

import java.sql.*;

public class UpdateViewController {
    @FXML
    private TextField txtBrand;

    @FXML
    private TextField txtGears;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtPrice;

    @FXML
    void cancle(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {
        int id = Integer.parseInt(txtId.getText());

        VehicleDto vehicleDto = VehicleModel.searchVehicle(id);
        txtBrand.setText(vehicleDto.getBrand());
        txtModel.setText(vehicleDto.getModel());
        txtGears.setText(String.valueOf(vehicleDto.getNoOfGears()));
        txtPrice.setText(String.valueOf(vehicleDto.getPrice()));
    }

    @FXML
    void update(ActionEvent event) {
        int id = Integer.parseInt(txtId.getText());
        String brand = txtBrand.getText();
        String model = txtModel.getText();
        int gears = Integer.parseInt(txtGears.getText());
        double price = Double.parseDouble(txtPrice.getText());

        try {
            //load the installed driver to this class
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database server and database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iap_2", "root", "acpt");

            //dynamic query
            PreparedStatement preparedStatement = connection.prepareStatement("update vehicles set brand=?, model=?, no_of_gerars=?, price=? where id=?");
            preparedStatement.setObject(1, brand);
            preparedStatement.setObject(2, model);
            preparedStatement.setObject(3, gears);
            preparedStatement.setObject(4, price);
            preparedStatement.setObject(5, id);

            //execute query
            int i = preparedStatement.executeUpdate();

            if (i > 0) {
                System.out.println("Data Updated Successfully !");
            } else {
                System.out.println("Failed !");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
