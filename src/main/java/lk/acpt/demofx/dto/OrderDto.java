package lk.acpt.demofx.dto;/*Auther : Yasindu Sathsara
Place : ACPT's Lab*/

import lk.acpt.demofx.tm.OrderTM;

import java.util.ArrayList;

public class OrderDto {
    private double amount;
    private String date;
    private ArrayList<OrderTM> orderDetails;

    public OrderDto(double amount, String date, ArrayList<OrderTM> orderDetails) {
        this.amount = amount;
        this.date = date;
        this.orderDetails = orderDetails;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<OrderTM> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderTM> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
