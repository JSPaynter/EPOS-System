package Classes;

public class OrderStock {
    
    private int itemID, orderID, ingredientID, unitAmount;

    public OrderStock(int itemID, int orderID, int ingredientID, int unitAmount) {
        this.itemID = itemID;
        this.orderID = orderID;
        this.ingredientID = ingredientID;
        this.unitAmount = unitAmount;
    }
    
    public OrderStock(int ingredientID, int unitAmount) {
        this.ingredientID = ingredientID;
        this.unitAmount = unitAmount;
    }

    public int getItemID() {
        return itemID;
    }
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public int getIngredientID() {
        return ingredientID;
    }
    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }
    public int getUnitAmount() {
        return unitAmount;
    }
    public void setUnitAmount(int unitAmount) {
        this.unitAmount = unitAmount;
    }
}
