package Classes;

import java.util.ArrayList;

public class Meal {
    
    private int mealID, mealTypeID, menu;
    private String name, description;
    private double price;
    private ArrayList<MealIngredient> mealIngredients = new ArrayList<>();;

    public Meal(int mealID, String name, double price, String description, int mealTypeID, int menu) {
        this.mealID = mealID;
        this.mealTypeID = mealTypeID;
        this.menu = menu;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    
    public Meal(int mealTypeID, int menu, String name, String description, double price) {
        this.mealTypeID = mealTypeID;
        this.menu = menu;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getMealID() {
        return mealID;
    }
    public void setMealID(int mealID) {
        this.mealID = mealID;
    }
    public int getMealTypeID() {
        return mealTypeID;
    }
    public void setMealTypeID(int mealTypeID) {
        this.mealTypeID = mealTypeID;
    }
    public int getMenu() {
        return menu;
    }
    public void setMenu(int menu) {
        this.menu = menu;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public ArrayList<MealIngredient> getMealIngredients() {
        return mealIngredients;
    }
    public void setMealIngredients(ArrayList<MealIngredient> mealIngredients) {
        this.mealIngredients = mealIngredients;
    }
    
}
