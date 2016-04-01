package Classes;

public class MadeIngredient {
    
    private int madeIngredientID, madeProduceID, ingredientID;
    private double stockUsed;

    public MadeIngredient(int madeIngredientID, int madeProduceID, int ingredientID, double stockUsed) {
        this.madeIngredientID = madeIngredientID;
        this.madeProduceID = madeProduceID;
        this.ingredientID = ingredientID;
        this.stockUsed = stockUsed;
    }
    
    public MadeIngredient(int madeProduceID, int ingredientID, double stockUsed) {
        this.madeProduceID = madeProduceID;
        this.ingredientID = ingredientID;
        this.stockUsed = stockUsed;
    }
    
        public MadeIngredient(int ingredientID, double stockUsed) {
        this.ingredientID = ingredientID;
        this.stockUsed = stockUsed;
    }

    public int getMadeIngredientID() {
        return madeIngredientID;
    }
    public void setMadeIngredientID(int madeIngredientID) {
        this.madeIngredientID = madeIngredientID;
    }
    public int getMadeProduceID() {
        return madeProduceID;
    }
    public void setMadeProduceID(int madeProduceID) {
        this.madeProduceID = madeProduceID;
    }
    public int getIngredientID() {
        return ingredientID;
    }
    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }
    public double getStockUsed() {
        return stockUsed;
    }
    public void setStockUsed(double stockUsed) {
        this.stockUsed = stockUsed;
    }    
}
