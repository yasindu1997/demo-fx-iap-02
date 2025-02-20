package lk.acpt.demofx.dto;/*Auther : Yasindu Sathsara
Place : ACPT's Lab*/

public class VehicleDto {
    private int id;
    private String brand;
    private String model;
    private int noOfGears;
    private double price;
    private int qty;

    public VehicleDto() {
    }

    public VehicleDto(String brand, String model, int noOfGears, double price, int qty) {
        this.brand = brand;
        this.model = model;
        this.noOfGears = noOfGears;
        this.price = price;
        this.qty = qty;
    }

    public VehicleDto(int id, String brand, String model, int noOfGears, double price, int qty) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.noOfGears = noOfGears;
        this.price = price;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNoOfGears() {
        return noOfGears;
    }

    public void setNoOfGears(int noOfGears) {
        this.noOfGears = noOfGears;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
