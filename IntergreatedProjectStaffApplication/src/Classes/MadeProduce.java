package Classes;

import java.util.ArrayList;

public class MadeProduce {
    
    private int madeProduceID;
    private String name;
    private double amountMade;
    private ArrayList<MadeIngredient> madeIngredients;

    public MadeProduce(int madeProduceID, String name, double amountMade) {
        this.madeProduceID = madeProduceID;
        this.name = name;
        this.amountMade = amountMade;
        this.madeIngredients = new ArrayList<>();
    }
    
    public MadeProduce(String name, double amountMade) {
        this.name = name;
        this.amountMade = amountMade;
        this.madeIngredients = new ArrayList<>();
    }

    public int getMadeProduceID() {
        return madeProduceID;
    }
    public void setMadeProduceID(int madeProduceID) {
        this.madeProduceID = madeProduceID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getAmountMade() {
        return amountMade;
    }
    public void setAmountMade(double amountMade) {
        this.amountMade = amountMade;
    }
    public ArrayList<MadeIngredient> getMadeIngredients() {
        return madeIngredients;
    }
    public void setMadeIngredients(ArrayList<MadeIngredient> madeIngredients) {
        this.madeIngredients = madeIngredients;
    }
}
