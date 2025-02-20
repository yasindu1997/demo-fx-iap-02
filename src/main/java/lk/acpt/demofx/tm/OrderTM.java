package lk.acpt.demofx.tm;/*Auther : Yasindu Sathsara
Place : ACPT's Lab*/

public class OrderTM {
    private int id;
    private String brand;
    private String model;
    private int qty;
    private double unitPrice;
    private double total;

    public OrderTM(int id, String brand, String model, int qty, double unitPrice, double total) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.total = total;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
