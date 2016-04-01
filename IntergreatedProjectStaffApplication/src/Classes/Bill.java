package Classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bill {
    
    private int billID, noOfItems, tableNo, active;
    private LocalDate billDate;
    private double total, paidCash, paidCard;
    private ArrayList<BillOrder> billOrders;

    public Bill(int billID, LocalDate billDate, int noOfItems, double total, int tableNo, int active, double paidCash, double paidCard) {
        this.billID = billID;
        this.noOfItems = noOfItems;
        this.tableNo = tableNo;
        this.active = active;
        this.billDate = billDate;
        this.total = total;
        this.paidCash = paidCash;
        this.paidCard = paidCard;
        this.billOrders = new ArrayList<>();
    }
    public Bill(int noOfItems, double total, int tableNo, int active, double paidCash, double paidCard) {
        this.noOfItems = noOfItems;
        this.tableNo = tableNo;
        this.active = active;
        this.total = total;
        this.paidCash = paidCash;
        this.paidCard = paidCard;
        this.billOrders = new ArrayList<>();
    }
        public Bill(int tableNo) {
        this.noOfItems = 0;
        this.tableNo = tableNo;
        this.active = 0;
        this.billDate = LocalDate.now();
        this.total = 0;
        this.paidCash = 0;
        this.paidCard = 0;
        this.billOrders = new ArrayList<>();
    }

    public int getBillID() {
        return billID;
    }
    public void setBillID(int billID) {
        this.billID = billID;
    }
    public int getNoOfItems() {
        return noOfItems;
    }
    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }
    public int getTableNo() {
        return tableNo;
    }
    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }
    public int getActive() {
        return active;
    }
    public void setActive(int active) {
        this.active = active;
    }
    public LocalDate getBillDate() {
        return billDate;
    }
    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public ArrayList<BillOrder> getBillOrders() {
        return billOrders;
    }
    public void setBillOrders(ArrayList<BillOrder> billOrders) {
        this.billOrders = billOrders;
    }
    public double getPaidCash() {
        return paidCash;
    }
    public void setPaidCash(double paidCash) {
        this.paidCash = paidCash;
    }
    public double getPaidCard() {
        return paidCard;
    }
    public void setPaidCard(double paidCard) {
        this.paidCard = paidCard;
    }
}
