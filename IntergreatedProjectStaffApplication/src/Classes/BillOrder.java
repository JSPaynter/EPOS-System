package Classes;

public class BillOrder {
    
    private int itemID, billID, mealID, complete, course;

    public BillOrder(int itemID, int billID, int mealID, int complete, int course) {
        this.itemID = itemID;
        this.billID = billID;
        this.mealID = mealID;
        this.complete = complete;
        this.course = course;
    }
    public BillOrder(int billID, int mealID, int complete, int course) {
        this.billID = billID;
        this.mealID = mealID;
        this.complete = complete;
        this.course = course;
    }

    public int getItemID() {
        return itemID;
    }
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    public int getBillID() {
        return billID;
    }
    public void setBillID(int billID) {
        this.billID = billID;
    }
    public int getMealID() {
        return mealID;
    }
    public void setMealID(int mealID) {
        this.mealID = mealID;
    }
    public int getComplete() {
        return complete;
    }
    public void setComplete(int complete) {
        this.complete = complete;
    }
    public int getCourse() {
        return course;
    }
    public void setCourse(int course) {
        this.course = course;
    }
}
