package Utilities;

import IngredientForms.AddIngredient;
import IngredientForms.AddProduce;
import IngredientForms.AddToProduce;
import IngredientForms.ViewEditIngredients;
import IngredientForms.ViewEditProduce;
import MealForms.AddMeal;
import MealForms.ViewMenu;
import MealForms.AddIngredientMeal;
import MealForms.ViewEditMeal;
import OrderForms.AddEditOrder;
import OrderForms.AddToOrder;
import OrderForms.PrintOrder;
import OrderForms.ViewOrders;
import StaffForms.AddStaff;
import StaffForms.ChangePassword;
import StaffForms.ViewEditStaff;
import SupplierForms.AddSupplier;
import UtilityForms.EmailForm;
import SupplierForms.ViewEditSupplier;
import UtilityForms.BillSplit;
import UtilityForms.MainInterface;
import UtilityForms.ManagerOptions;
import UtilityForms.NumberPad;

public class IntergratedProjectStaffApplication {
    
    public static JSPPageConnector JSPConnector = new JSPPageConnector();
    
    //**********************************//
    //forms
    //**********************************//
    
    //ingredient forms
    public static AddIngredient addIngredient = null;
    public static AddProduce addProduce = null;
    public static AddToProduce addToProduce = null;
    public static ViewEditIngredients viewEditIngredient = null;
    public static ViewEditProduce viewEditProduce = null;
    
    //meal forms
    public static AddMeal addMeal = null;
    public static ViewMenu viewMenu = null;
    public static AddIngredientMeal addIngredientMeal = null;
    public static ViewEditMeal viewEditMeal = null;
        
    //order forms
    public static AddEditOrder addEditOrder = null;
    public static AddToOrder addToOrder = null;
    public static PrintOrder printOrder = null;
    public static ViewOrders viewOrders = null;
    
    //staff forms
    public static AddStaff addStaff = null;
    public static ChangePassword changePassword = null;
    public static ViewEditStaff viewEditStaff = null;
    
    //supplier forms
    public static AddSupplier addSupplier = null;
    public static ViewEditSupplier viewEditSupplier = null;
    
    //utility forms
    public static BillSplit billSplit = null;
    public static MainInterface mainInterface = null;
    public static ManagerOptions managerOptions = null;
    public static EmailForm email = null;
    public static NumberPad numPad = null;
        
    //**********************************//
    //end of forms
    //**********************************//
    
    public static void main(String[] args) {
        mainInterface = new MainInterface();
        mainInterface.setVisible(true);        
    }
    
}
