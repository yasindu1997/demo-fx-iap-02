package lk.acpt.demofx.controller;/*Auther : Yasindu Sathsara
Place : ACPT's Lab*/

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.acpt.demofx.dto.OrderDto;
import lk.acpt.demofx.dto.VehicleDto;
import lk.acpt.demofx.model.OrderModel;
import lk.acpt.demofx.model.VehicleModel;
import lk.acpt.demofx.tm.OrderTM;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class OrderController implements Initializable {
    @FXML
    private Label lblTotal;

    @FXML
    private TableView<OrderTM> tblItems;

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
    private TextField txtQty;

    @FXML
    private TextField txtQtyOnHand;

    private ArrayList<OrderTM> orderTMS;

    private double subTotal = 0;

    @FXML
    void addToCart(ActionEvent event) {
        int id = Integer.parseInt(txtId.getText());
        String brand = txtBrand.getText();
        String model = txtModel.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double unitPrice = Double.parseDouble(txtPrice.getText());
        double total = qty * unitPrice;

        OrderTM tm = new OrderTM(id, brand, model, qty, unitPrice, total);

        subTotal += total;
        lblTotal.setText(String.valueOf(subTotal));

        orderTMS.add(tm);
        tblItems.setItems(FXCollections.observableArrayList(orderTMS));
    }

    @FXML
    void placeOrder(ActionEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String curDate = dateFormat.format(date);

        OrderDto orderDto = new OrderDto(subTotal,curDate,orderTMS);

        OrderModel.placeOrder(orderDto);
    }

    @FXML
    void search(ActionEvent event) {
        int id = Integer.parseInt(txtId.getText());

        VehicleDto vehicleDto = VehicleModel.searchVehicle(id);
        txtBrand.setText(vehicleDto.getBrand());
        txtModel.setText(vehicleDto.getModel());
        txtQtyOnHand.setText(String.valueOf(vehicleDto.getQty()));
        txtGears.setText(String.valueOf(vehicleDto.getNoOfGears()));
        txtPrice.setText(String.valueOf(vehicleDto.getPrice()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblItems.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblItems.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("model"));
        tblItems.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblItems.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblItems.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));

        orderTMS = new ArrayList<>();
    }
}
