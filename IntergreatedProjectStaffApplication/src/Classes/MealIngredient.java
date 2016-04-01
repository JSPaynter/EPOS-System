package Classes;

public class MealIngredient {
   
    private int itemID, mealID, ingredientID, produceIngredient, produceID;
    private double stockUsed;

    public MealIngredient(int itemID, int mealID, int ingredientID, double stockUsed, int produceIngredient, int produceID) {
        this.itemID = itemID;
        this.mealID = mealID;        
        this.produceIngredient = produceIngredient;
        this.stockUsed = stockUsed;
        
        if (produceIngredient == 0) {
            this.produceID = produceID;
            this.ingredientID = 0;
        } else {
            this.ingredientID = ingredientID;
            this.produceID = 0;
        }        
    }    
    
    public MealIngredient(int ingredientID, int produceIngredient, double stockUsed) {       
        this.produceIngredient = produceIngredient;
        this.stockUsed = stockUsed;
        
        if (produceIngredient == 0) {
            this.produceID = ingredientID;
            this.ingredientID = 0;
        } else {
            this.ingredientID = ingredientID;
            this.produceID = 0;
        }        
    }

    public int getItemID() {
        return itemID;
    }
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    public int getMealID() {
        return mealID;
    }
    public void setMealID(int mealID) {
        this.mealID = mealID;
    }
    public int getIngredientID() {
        return ingredientID;
    }
    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }
    public int getProduceIngredient() {
        return produceIngredient;
    }
    public void setProduceIngredient(int produceIngredient) {
        this.produceIngredient = produceIngredient;
    }
    public int getProduceID() {
        return produceID;
    }
    public void setProduceID(int produceID) {
        this.produceID = produceID;
    }
    public double getStockUsed() {
        return stockUsed;
    }
    public void setStockUsed(double stockUsed) {
        this.stockUsed = stockUsed;
    }    
}
