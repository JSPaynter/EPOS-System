package Classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Orders {
    
    private int orderID, supplierID, noOfItems, arrived, cancelled;
    private double total;
    private LocalDate dateOrdered, dateArrival, dateEstimateArrival;
    private ArrayList<OrderStock> orderStocks = new ArrayList<>();;

    public Orders(int orderID, int supplierID, int noOfItems, double total, LocalDate dateOrdered, LocalDate dateArrival, int arrived, int cancelled, LocalDate dateEstimateArrival) {
        this.orderID = orderID;
        this.supplierID = supplierID;
        this.noOfItems = noOfItems;
        this.arrived = arrived;
        this.cancelled = cancelled;
        this.total = total;
        this.dateOrdered = dateOrdered;
        this.dateArrival = dateArrival;
        this.dateEstimateArrival = dateEstimateArrival;
    }

    public Orders(int supplierID, int noOfItems, double total, LocalDate dateEstimateArrival) {
        this.supplierID = supplierID;
        this.noOfItems = noOfItems;
        this.total = total;
        this.dateEstimateArrival = dateEstimateArrival;
        this.arrived = 0;
        this.cancelled = 0;
        this.dateOrdered = LocalDate.now();
    }

    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public int getSupplierID() {
        return supplierID;
    }
    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }
    public int getNoOfItems() {
        return noOfItems;
    }
    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }
    public int getArrived() {
        return arrived;
    }
    public void setArrived(int arrived) {
        this.arrived = arrived;
    }
    public int getCancelled() {
        return cancelled;
    }
    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public LocalDate getDateOrdered() {
        return dateOrdered;
    }
    public void setDateOrdered(LocalDate dateOrdered) {
        this.dateOrdered = dateOrdered;
    }
    public LocalDate getDateArrival() {
        return dateArrival;
    }
    public void setDateArrival(LocalDate dateArrival) {
        this.dateArrival = dateArrival;
    }
    public LocalDate getDateEstimateArrival() {
        return dateEstimateArrival;
    }
    public void setDateEstimateArrival(LocalDate dateEstimateArrival) {
        this.dateEstimateArrival = dateEstimateArrival;
    }
    public ArrayList<OrderStock> getOrderStocks() {
        return orderStocks;
    }
    public void setOrderStocks(ArrayList<OrderStock> orderStocks) {
        this.orderStocks = orderStocks;
    }
}
