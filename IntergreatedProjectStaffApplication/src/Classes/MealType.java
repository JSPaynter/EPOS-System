package Classes;

public class MealType {
    
    private int mealTypeID;
    private String mealType;

    public MealType(int mealTypeID, String mealType) {
        this.mealTypeID = mealTypeID;
        this.mealType = mealType;
    }

    public int getMealTypeID() {
        return mealTypeID;
    }
    public void setMealTypeID(int mealTypeID) {
        this.mealTypeID = mealTypeID;
    }
    public String getMealType() {
        return mealType;
    }
    public void setMealType(String mealType) {
        this.mealType = mealType;
    }
}
