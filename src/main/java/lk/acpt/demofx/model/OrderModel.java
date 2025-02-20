package lk.acpt.demofx.model;/*Auther : Yasindu Sathsara
Place : ACPT's Lab*/

import lk.acpt.demofx.db.DbConnection;
import lk.acpt.demofx.dto.OrderDto;
import lk.acpt.demofx.tm.OrderTM;

import java.sql.*;

public class OrderModel {
    public static boolean placeOrder(OrderDto orderDto) throws SQLException, ClassNotFoundException {

        Connection connection = DbConnection.getDbConnection().getConnection();
        connection.setAutoCommit(false);

        PreparedStatement stm = connection.prepareStatement("insert into orders(order_date, amount) values(?,?)", Statement.RETURN_GENERATED_KEYS);
        stm.setObject(1, orderDto.getDate());
        stm.setObject(2, orderDto.getAmount());

        int orderAdded = stm.executeUpdate();

        if (orderAdded > 0) {

            ResultSet generatedKeys = stm.getGeneratedKeys();

            if (generatedKeys.next()) {

                int orderId = generatedKeys.getInt(1);

                for (OrderTM od : orderDto.getOrderDetails()) {
                    PreparedStatement stm2 = connection.prepareStatement("insert into order_details(oid,vid,qty,total) values (?,?,?,?)");
                    stm2.setObject(1, orderId);
                    stm2.setObject(2, od.getId());
                    stm2.setObject(3, od.getQty());
                    stm2.setObject(4, od.getTotal());

                    int orderDetailAdded = stm2.executeUpdate();

                    if (orderDetailAdded > 0) {
                        PreparedStatement stm3 = connection.prepareStatement("update vehicles set qty=qty-? where id=?");
                        stm3.setObject(1, od.getQty());
                        stm3.setObject(2, od.getId());

                        int itemUpdated = stm3.executeUpdate();

                        if (itemUpdated <= 0) {
                            connection.rollback();
                            connection.setAutoCommit(true);
                            return false;
                        }

                    } else {
                        connection.rollback();
                        connection.setAutoCommit(true);
                        return false;
                    }
                }
                connection.commit();
                connection.setAutoCommit(true);
                return true;

            }

        }
        connection.rollback();
        connection.setAutoCommit(true);
        return false;
    }
}
