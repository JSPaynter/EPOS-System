package Classes;

public class Ingredient {
    
    private int ingredientID, supplierID;
    private String name;
    private double unitValue, currentStock, buyInLimit, costPerUnit;

    public Ingredient(int ingredientID, int supplierID, String name, double unitValue, double currentStock, double buyInLimit, double costPerUnit) {
        this.ingredientID = ingredientID;
        this.supplierID = supplierID;
        this.name = name;
        this.unitValue = unitValue;
        this.currentStock = currentStock;
        this.buyInLimit = buyInLimit;
        this.costPerUnit = costPerUnit;
    }
    
        public Ingredient(int supplierID, String name, double unitValue, double buyInLimit, double costPerUnit) {
        this.supplierID = supplierID;
        this.name = name;
        this.unitValue = unitValue;
        this.buyInLimit = buyInLimit;
        this.costPerUnit = costPerUnit;
    }

    public int getIngredientID() {
        return ingredientID;
    }
    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }
    public int getSupplierID() {
        return supplierID;
    }
    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getUnitValue() {
        return unitValue;
    }
    public void setUnitValue(double unitValue) {
        this.unitValue = unitValue;
    }
    public double getCurrentStock() {
        return currentStock;
    }
    public void setCurrentStock(double currentStock) {
        this.currentStock = currentStock;
    }
    public double getBuyInLimit() {
        return buyInLimit;
    }
    public void setBuyInLimit(double buyInLimit) {
        this.buyInLimit = buyInLimit;
    }
    public double getCostPerUnit() {
        return costPerUnit;
    }
    public void setCostPerUnit(double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }    
}
