package lk.acpt.demofx.model;/*Auther : Yasindu Sathsara
Place : ACPT's Lab*/

import lk.acpt.demofx.db.DbConnection;
import lk.acpt.demofx.dto.VehicleDto;

import java.sql.*;
import java.util.ArrayList;

public class VehicleModel {
    public static boolean saveVehicle(VehicleDto dto) {
        try {
            Connection connection = DbConnection.getDbConnection().getConnection();

            //dynamic query
            PreparedStatement preparedStatement = connection.prepareStatement("insert into vehicles(brand, model, no_of_gerars, price, qty) values(?,?,?,?,?)");
            preparedStatement.setObject(1, dto.getBrand());
            preparedStatement.setObject(2, dto.getModel());
            preparedStatement.setObject(3, dto.getNoOfGears());
            preparedStatement.setObject(4, dto.getPrice());
            preparedStatement.setObject(5, dto.getQty());

            //execute query
            int i = preparedStatement.executeUpdate();

            return i > 0;

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean deleteVehicle(int id) {
        return false;
    }

    public static VehicleDto searchVehicle(int id) {
        try {
            Connection connection = DbConnection.getDbConnection().getConnection();

            //dynamic query
            PreparedStatement preparedStatement = connection.prepareStatement("select * from vehicles where id = ?");
            preparedStatement.setObject(1, id);

            //execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            VehicleDto vehicleDto = new VehicleDto();

            if (resultSet.next()) {
                vehicleDto.setBrand(resultSet.getString(2));
                vehicleDto.setModel(resultSet.getString(3));
                vehicleDto.setNoOfGears(resultSet.getInt(4));
                vehicleDto.setPrice(resultSet.getDouble(5));
                vehicleDto.setQty(resultSet.getInt(6));
            }

            return vehicleDto;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateVehicle(VehicleDto dto) {
        return false;
    }

    public ArrayList<VehicleDto> loadAllVehicle() {
        return null;
    }
}
