package lk.acpt.demofx;/*Auther : Yasindu Sathsara
Place : ACPT's Lab*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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

        try {
            //load the installed driver to this class
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database server and database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iap_2", "root", "acpt");

            //dynamic query
            PreparedStatement preparedStatement = connection.prepareStatement("select * from vehicles where id = ?");
            preparedStatement.setObject(1, id);

            //execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                txtBrand.setText(resultSet.getString(2));
                txtModel.setText(resultSet.getString(3));
                txtGears.setText(String.valueOf(resultSet.getInt(4)));
                txtPrice.setText(String.valueOf(resultSet.getDouble(5)));
            }


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
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
