 package Utilities;

import Classes.Bill;
import Classes.BillOrder;
import Classes.Ingredient;
import Classes.MadeIngredient;
import Classes.MadeProduce;
import Classes.Meal;
import Classes.MealIngredient;
import Classes.MealType;
import Classes.OrderStock;
import Classes.Orders;
import Classes.Staff;
import Classes.Supplier;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSPPageConnector {        

    //number of collums in each table for read alls    
    int billCollums = 8;
    int billOrderCollums = 5;    
    int ingredientCollums = 7;
    int madeIngredientCollums = 4;
    int madeProduceCollums = 3;
    int mealCollums = 6;
    int mealTypeCollums = 2;
    int mealIngredientCollums = 6;
    int orderStockCollums = 4;
    int orderCollums = 9;    
    int staffCollums = 8;
    int supplierCollums = 8;
    
    //********************************************//
    //Bill functions
    //********************************************//
    public int addBill(Bill bill) {
        try {
            StringBuilder result = new StringBuilder();
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/BillJSP/AddBill.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("tableNo");
            values.add(String.valueOf(bill.getTableNo()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("GET");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            return Integer.parseInt(resultString[0]);
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int addBillSplit(Bill bill) {
        try {
            StringBuilder result = new StringBuilder();
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/BillJSP/AddBillSplit.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("noOfItems");
            key.add("total");
            key.add("tableNo");
            key.add("cash");
            key.add("card");
            values.add(String.valueOf(bill.getNoOfItems()));
            values.add(String.valueOf(bill.getTotal()));
            values.add(String.valueOf(bill.getTableNo()));
            values.add(String.valueOf(bill.getPaidCash()));
            values.add(String.valueOf(bill.getPaidCard()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("GET");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            return Integer.parseInt(resultString[0]);
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public void addBillOrder(BillOrder bill) {
        
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/BillOrderJSP/AddBillOrder.jsp"); //set URL
            
                //2 arraylists for key and values
                ArrayList<String> key = new ArrayList<>();
                ArrayList<String> values = new ArrayList<>();

                //add keys and values to list
                key.add("billID");
                key.add("mealID");
                key.add("complete");
                key.add("course");
                values.add(String.valueOf(bill.getBillID()));
                values.add(String.valueOf(bill.getMealID()));
                values.add(String.valueOf(bill.getComplete()));
                values.add(String.valueOf(bill.getCourse()));

                //send to function to convert to a parameter string query
                String postData = parameterString(key, values);

                //set header
                con.setDoOutput(true);
                con.setDoInput(true);
                con.setRequestMethod("POST");

                //output data to request
                OutputStream os = con.getOutputStream();
                os.write(postData.getBytes());            
                os.close();

                //response code for error checking            
                responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteBill(Bill bill) {
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/BillJSP/DeleteBill.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("billID");
            values.add(String.valueOf(bill.getBillID()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void deleteBillOrder(BillOrder billOrder) {
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/BillOrderJSP/DeleteBillOrder.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("billOrderID");
            values.add(String.valueOf(billOrder.getItemID()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public Bill getTableBill (int tableNo) {
        
        Bill bill = null;
        
        try {
            StringBuilder result = new StringBuilder();
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/BillJSP/ReadGetTable.jsp");
            
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("GET");
            
            key.add("tableNo");
            values.add(String.valueOf(tableNo));
            String postData = parameterString(key, values);
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            for (int i = 0; i < resultString.length/billCollums; i++) {
                bill = new Bill(Integer.parseInt(resultString[(i*billCollums)]), LocalDate.parse(resultString[(i*billCollums)+1]),
                        Integer.parseInt(resultString[(i*billCollums)+2]), Double.parseDouble(resultString[(i*billCollums)+3]),
                        Integer.parseInt(resultString[(i*billCollums)+4]),Integer.parseInt(resultString[(i*billCollums)+5]),                 
                        Double.parseDouble(resultString[(i*billCollums)+6]), Double.parseDouble(resultString[(i*billCollums)+7]));
            }
            
            if (bill != null)
                bill.setBillOrders(getTableBillOrder(bill.getBillID()));
            
            return bill; //return list of orders
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bill;
    }
    
    public ArrayList<BillOrder> getTableBillOrder (int billID) {
        
        ArrayList<BillOrder> order = new ArrayList<>();
        
        try {
            StringBuilder result = new StringBuilder();
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/BillOrderJSP/ReadTableBillOrder.jsp");
            
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("GET");
            
            key.add("billID");
            values.add(String.valueOf(billID));
            String postData = parameterString(key, values);
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            for (int i = 0; i < resultString.length/billOrderCollums; i++) {
                order.add(new BillOrder(Integer.parseInt(resultString[(i*billOrderCollums)]), Integer.parseInt(resultString[(i*billOrderCollums)+1]),
                Integer.parseInt(resultString[(i*billOrderCollums)+2]), Integer.parseInt(resultString[(i*billOrderCollums)+3]),
                Integer.parseInt(resultString[(i*billOrderCollums)+4])));
            }            
            return order; //return list of orders
            
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return order;
    }
    
    public void updateBill(Bill bill) {        
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/BillJSP/UpdateBill.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("billID");
            key.add("noOfItems");
            key.add("total");
            key.add("cash");
            key.add("card");
            
            values.add(String.valueOf(bill.getBillID()));
            values.add(String.valueOf(bill.getNoOfItems()));
            values.add(String.valueOf(bill.getTotal()));
            values.add(String.valueOf(bill.getPaidCash()));
            values.add(String.valueOf(bill.getPaidCard()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void updateBillActive(Bill bill) {        
        try {
            
            String url = "";
            if (bill.getActive() == 0)
                url = "http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/BillJSP/UpdateActive0.jsp";
            else if (bill.getActive() == 1)
                url = "http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/BillJSP/UpdateActive1.jsp";
            
            HttpURLConnection con = getURLConnection(url); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("billID");
            
            values.add(String.valueOf(bill.getBillID()));

            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void updateBillOrderComplete(BillOrder bill) {        
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/BillOrderJSP/UpdateComplete.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("itemID");
            
            values.add(String.valueOf(bill.getItemID()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    //********************************************//
    //Ingredient functions
    //********************************************//
    public void addIngredient (Ingredient ingredient) {
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/IngredientJSP/AddIngredient.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("supplierID");
            key.add("name");
            key.add("unitValue");
            key.add("buyInLimit");
            key.add("costPerUnit");
            values.add(String.valueOf((ingredient.getSupplierID())));
            values.add(ingredient.getName());
            values.add(String.valueOf(ingredient.getUnitValue()));
            values.add(String.valueOf(ingredient.getBuyInLimit()));
            values.add(String.valueOf(ingredient.getCostPerUnit()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Ingredient> getAllIngredient () {
        
        ArrayList<Ingredient> ingredient = new ArrayList<>();
        
        try {
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/IngredientJSP/ReadIngredient.jsp");
            
            con.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            for (int i = 0; i < resultString.length/ingredientCollums; i++) {
                ingredient.add(new Ingredient(Integer.parseInt(resultString[i*ingredientCollums]), Integer.parseInt(resultString[(i*ingredientCollums) + 1]),
                        resultString[(i*ingredientCollums) + 2], Double.parseDouble(resultString[(i*ingredientCollums) + 3]),
                        Double.parseDouble(resultString[(i*ingredientCollums) + 4]), Double.parseDouble(resultString[(i*ingredientCollums) + 5]),
                        Double.parseDouble(resultString[(i*ingredientCollums) + 6])));
            }            
            return ingredient; //return list of staff
            
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ingredient;
    }
    
    public void deleteIngredient(Ingredient ingredient) {
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/IngredientJSP/DeleteIngredient.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("ingredientID");
            values.add(String.valueOf(ingredient.getIngredientID()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void updateIngredient(Ingredient ingredient) {        
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/IngredientJSP/UpdateIngredient.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("ingredientID");
            key.add("supplierID");
            key.add("name");
            key.add("unitValue");
            key.add("currentStock");
            key.add("buyInLimit");
            key.add("costPerUnit");
                        
            values.add(String.valueOf(ingredient.getIngredientID()));
            values.add(String.valueOf(ingredient.getSupplierID()));
            values.add(ingredient.getName());
            values.add(String.valueOf(ingredient.getUnitValue()));
            values.add(String.valueOf(ingredient.getCurrentStock()));
            values.add(String.valueOf(ingredient.getBuyInLimit()));
            values.add(String.valueOf(ingredient.getCostPerUnit()));

            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void updateStock(int ingredientID, double currentStock) {        
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/IngredientJSP/UpdateStockLevels.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("ingredientID");
            key.add("currentStock");
                        
            values.add(String.valueOf(ingredientID));
            values.add(String.valueOf(currentStock));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    //********************************************//
    //Produce and Produce Ingredient funtions
    //********************************************//
    public void addProduce (MadeProduce produce) {
        try {
            
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Made_ProduceJSP/AddMadeProduce.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("name");
            key.add("amountMade");

            values.add(produce.getName());
            values.add(String.valueOf(produce.getAmountMade()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();                    
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode()); 
            
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            String produceID = resultString[0];
            
            for (MadeIngredient ingredient : produce.getMadeIngredients()) {
                ingredient.setMadeProduceID(Integer.parseInt(produceID));
                addMadeIngredient(ingredient);
            }
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void addMadeIngredient (MadeIngredient madeIngredient) {
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Made_IngredientJSP/AddMade_Ingredient.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("madeProduceID");
            key.add("ingredientID");
            key.add("stockUsed");
            values.add(String.valueOf(madeIngredient.getMadeProduceID()));
            values.add(String.valueOf(madeIngredient.getIngredientID()));
            values.add(String.valueOf(madeIngredient.getStockUsed()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteProduce(MadeProduce produce) {
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Made_ProduceJSP/DeleteMadeProduce.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("madeProduceID");
            values.add(String.valueOf(produce.getMadeProduceID()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void deleteMadeIngredient(MadeIngredient ingredient) {
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Made_IngredientJSP/DeleteMade_Ingredient.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("madeIngredientID");
            values.add(String.valueOf(ingredient.getMadeIngredientID()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public ArrayList<MadeProduce> getAllProduce () {
        
        ArrayList<MadeProduce> produce = new ArrayList<>();
        
        try {
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Made_ProduceJSP/ReadMadeProduce.jsp");
            
            con.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            for (int i = 0; i < resultString.length/madeProduceCollums; i++) {
                produce.add(new MadeProduce(Integer.parseInt(resultString[i*madeProduceCollums]), resultString[(i*madeProduceCollums)+1],
                                    Double.parseDouble(resultString[(i*madeProduceCollums)+2])));
            }            
            return produce; //return list of produce
            
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produce;
    }
    
    public ArrayList<MadeIngredient> getAllProduceIngredient () {
        
        ArrayList<MadeIngredient> ingredient = new ArrayList<>();
        
        try {
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Made_IngredientJSP/ReadMade_Ingredient.jsp");
            
            con.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            for (int i = 0; i < resultString.length/madeIngredientCollums; i++) {
                ingredient.add(new MadeIngredient(Integer.parseInt(resultString[(i*madeIngredientCollums)]), Integer.parseInt(resultString[(i*madeIngredientCollums)+1]),
                                    Integer.parseInt(resultString[(i*madeIngredientCollums)+2]), Double.parseDouble(resultString[(i*madeIngredientCollums)+3])));
            }            
            return ingredient; //return list of produce ingredients
            
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ingredient;
    }
    
    public void updateProduce (MadeProduce produce) {
        try {
            
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Made_ProduceJSP/UpdateMadeProduce.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("name");
            key.add("amountMade");
            key.add("madeProduceID");

            values.add(produce.getName());
            values.add(String.valueOf(produce.getAmountMade()));
            values.add(String.valueOf(produce.getMadeProduceID()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode()); 
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void updateProduceIngredient (MadeIngredient ingredient) {
        try {
            
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Made_ProduceJSP/UpdateMadeProduce.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("madeIngredientID");
            key.add("madeProduceID");
            key.add("ingredientID");
            key.add("stockUsed");

            values.add(String.valueOf(ingredient.getMadeIngredientID()));
            values.add(String.valueOf(ingredient.getMadeProduceID()));
            values.add(String.valueOf(ingredient.getIngredientID()));
            values.add(String.valueOf(ingredient.getStockUsed()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();            
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public MadeProduce getProduce (int produceID) {
        
        MadeProduce produce = null;
        
        try {
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Made_ProduceJSP/ReadSpecificMadeProduce.jsp");
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            key.add("produceID");
            values.add(String.valueOf(produceID));
            
            String postData = parameterString(key, values);
            
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("GET");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();     
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            produce = new MadeProduce(Integer.parseInt(resultString[0]), resultString[1],
                                    Double.parseDouble(resultString[2]));
                      
            return produce; //return list of produce
            
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produce;
    }
    
    public ArrayList<MadeIngredient> getSpecificProduceIngredient (int produceID) {
        
        ArrayList<MadeIngredient> ingredient = new ArrayList<>();
        
        try {
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Made_IngredientJSP/ReadSpecificMade_Ingredient.jsp");
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            key.add("produceID");
            values.add(String.valueOf(produceID));            
            
            String postData = parameterString(key, values);
            
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("GET");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close(); 
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            for (int i = 0; i < resultString.length/madeIngredientCollums; i++) {
                ingredient.add(new MadeIngredient(Integer.parseInt(resultString[(i*madeIngredientCollums)]), Integer.parseInt(resultString[(i*madeIngredientCollums)+1]),
                                    Integer.parseInt(resultString[(i*madeIngredientCollums)+2]), Double.parseDouble(resultString[(i*madeIngredientCollums)+3])));
            }            
            return ingredient; //return list of produce ingredients
            
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ingredient;
    }
    
    //********************************************//
    //Meal and Meal Ingredient functions
    //********************************************//
    public void addMeal (Meal meal) {
        try {
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/MealJSP/AddMeal.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("name");
            key.add("price");
            key.add("description");
            key.add("mealTypeID");
            key.add("menu");
            values.add(meal.getName());
            values.add(String.valueOf(meal.getPrice()));
            values.add(meal.getDescription());
            values.add(String.valueOf(meal.getMealTypeID()));
            values.add(String.valueOf(meal.getMenu()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader            
            
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            int mealID = Integer.parseInt(resultString[0]);
            
            for (MealIngredient ingredient : meal.getMealIngredients()) {
                ingredient.setMealID(mealID);
                addMealIngredient(ingredient);
            }
            
            } catch (MalformedURLException ex) {
                Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ProtocolException ex) {
                Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void addMealIngredient (MealIngredient mealIngredient) {
        try {
            String url = "";
            String id = "";
            
            switch (mealIngredient.getProduceIngredient()) {
                case 0:
                    url = "http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Meal_IngredientJSP/AddMeal_IngredientProduce.jsp";
                    id = String.valueOf(mealIngredient.getProduceID());
                    break;
                case 1:
                    url = "http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Meal_IngredientJSP/AddMeal_IngredientIngredient.jsp";
                    id = String.valueOf(mealIngredient.getIngredientID());
                    break;
                default: //problem
                    break;
            }
            
            HttpURLConnection con = getURLConnection(url); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("mealID");            
            key.add("stockUsed");
            key.add("produceIngredient");
            key.add("ingredientID");
            
            values.add(String.valueOf(mealIngredient.getMealID()));            
            values.add(String.valueOf(mealIngredient.getStockUsed()));
            values.add(String.valueOf(mealIngredient.getProduceIngredient()));
            values.add(id);
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteMeal(Meal meal) {
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/MealJSP/DeleteMeal.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("mealID");
            values.add(String.valueOf(meal.getMealID()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void deleteMealIngredient(MealIngredient ingredient) {
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Meal_IngredientJSP/DeleteMeal_Ingredient.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("mealIngredientID");
            values.add(String.valueOf(ingredient.getItemID()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public ArrayList<Meal> getAllMeal () {
        
        ArrayList<Meal> meals = new ArrayList<>();
        
        try {
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/MealJSP/ReadMeal.jsp");
            
            con.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            for (int i = 0; i < resultString.length/mealCollums; i++) {
                meals.add(new Meal(Integer.parseInt(resultString[(i*mealCollums)]), resultString[(i*mealCollums)+1],
                                    Double.parseDouble(resultString[(i*mealCollums)+2]), resultString[(i*mealCollums)+3],
                                    Integer.parseInt(resultString[(i*mealCollums)+4]), Integer.parseInt(resultString[(i*mealCollums)+5])));
            }            
            return meals; //return list of meals
            
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return meals;
    }
    
    public ArrayList<MealIngredient> getAllMealIngredients () {
        
        ArrayList<MealIngredient> ingredients = new ArrayList<>();
        
        try {
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Meal_IngredientJSP/ReadMeal_Ingredient.jsp");
            
            con.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            for (int i = 0; i < resultString.length/mealIngredientCollums; i++) {
                ingredients.add(new MealIngredient(Integer.parseInt(resultString[(i*mealIngredientCollums)]), Integer.parseInt(resultString[(i*mealIngredientCollums)+1]),
                                                    Integer.parseInt(resultString[(i*mealIngredientCollums)+2]), Double.parseDouble(resultString[(i*mealIngredientCollums)+3]),
                                                    Integer.parseInt(resultString[(i*mealIngredientCollums)+4]), Integer.parseInt(resultString[(i*mealIngredientCollums)+5])));
            }            
            return ingredients; //return list of meals
            
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ingredients;
    }
    
    public ArrayList<MealIngredient> getSpecificMealIngredients (Meal meal) {
        
        ArrayList<MealIngredient> ingredients = new ArrayList<>();
        
        try {
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Meal_IngredientJSP/ReadSpecificMeal_Ingredient.jsp");
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            key.add("mealID");
            values.add(String.valueOf(meal.getMealID()));
            
            String postData = parameterString(key, values);
            
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("GET");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            for (int i = 0; i < resultString.length/mealIngredientCollums; i++) {
                ingredients.add(new MealIngredient(Integer.parseInt(resultString[(i*mealIngredientCollums)]), Integer.parseInt(resultString[(i*mealIngredientCollums)+1]),
                                                    Integer.parseInt(resultString[(i*mealIngredientCollums)+2]), Double.parseDouble(resultString[(i*mealIngredientCollums)+3]),
                                                    Integer.parseInt(resultString[(i*mealIngredientCollums)+4]), Integer.parseInt(resultString[(i*mealIngredientCollums)+5])));
            }            
            return ingredients; //return list of meals
            
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ingredients;
    }
    
    public void updateMeal (Meal meal) {
        try {            
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/MealJSP/UpdateMeal.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("mealID");
            key.add("name");
            key.add("price");
            key.add("description");
            key.add("mealTypeID");
            key.add("menu");

            values.add(String.valueOf(meal.getMealID()));
            values.add(meal.getName());
            values.add(String.valueOf(meal.getPrice()));
            values.add(meal.getDescription());
            values.add(String.valueOf(meal.getMealTypeID()));
            values.add(String.valueOf(meal.getMenu()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode()); 
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void updateMealIngredient (MealIngredient ingredient) {
        try {
            
            String url = "";
            String id = "";
            
            switch (ingredient.getProduceIngredient()) {
                case 0:
                    url = "http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Meal_IngredientJSP/UpdateMeal_IngredientProduce.jsp";
                    id = String.valueOf(ingredient.getProduceID());
                    break;
                case 1:
                    url = "http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Meal_IngredientJSP/UpdateMeal_IngredientIngredient.jsp";
                    id = String.valueOf(ingredient.getIngredientID());
                    break;
                default: //problem
                    break;
            }
            
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection(url); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("itemID");
            key.add("mealID");
            key.add("ingredientID");
            key.add("stockUsed");
            key.add("produceIngredient");

            values.add(String.valueOf(ingredient.getItemID()));
            values.add(String.valueOf(ingredient.getMealID()));
            values.add(id);
            values.add(String.valueOf(ingredient.getStockUsed()));
            values.add(String.valueOf(ingredient.getProduceIngredient()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //********************************************//
    //Meal Type
    //********************************************//
    
     public ArrayList<MealType> getAllMealType () {
        
        ArrayList<MealType> mealTypes = new ArrayList<>();
        
        try {
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/MealTypeJSP/ReadMealType.jsp");
            
            con.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            for (int i = 0; i < resultString.length/mealTypeCollums; i++) {
                mealTypes.add(new MealType(Integer.parseInt(resultString[i*mealTypeCollums]),
                                            resultString[(i*mealTypeCollums)+1]));
            }            
            return mealTypes; //return list of staff
            
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mealTypes;
    }
    
    //********************************************//
    //Order functions
    //********************************************//
    public int addOrder (Orders order) {
        
        int orderID = 0;
        
        try {
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/OrdersJSP/AddOrders.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("supplierID");            
            key.add("noOfItems");
            key.add("total");
            key.add("dateEstimateArrival");            
            values.add(String.valueOf(order.getSupplierID()));
            values.add(String.valueOf(order.getNoOfItems()));
            values.add(String.valueOf(order.getTotal()));
            values.add(order.getDateEstimateArrival().toString());
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode()); 
            
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            orderID = Integer.parseInt(resultString[0]);
            
            for (OrderStock stock : order.getOrderStocks()) {
                stock.setOrderID(orderID);      
                addOrderStock(stock);
            }
            
            
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderID;
    }
    
    public void addOrderStock (OrderStock stock) {
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Order_StockJSP/AddOrder_Stock.jsp"); //set URL
            
                //2 arraylists for key and values
                ArrayList<String> key = new ArrayList<>();
                ArrayList<String> values = new ArrayList<>();

                //add keys and values to list
                key.add("orderID");
                key.add("ingredientID");
                key.add("unitAmount");
                values.add(String.valueOf(stock.getOrderID()));
                values.add(String.valueOf(stock.getIngredientID()));
                values.add(String.valueOf(stock.getUnitAmount()));

                //send to function to convert to a parameter string query
                String postData = parameterString(key, values);

                //set header
                con.setDoOutput(true);
                con.setDoInput(true);
                con.setRequestMethod("POST");

                //output data to request
                OutputStream os = con.getOutputStream();
                os.write(postData.getBytes());            
                os.close();

                //response code for error checking            
                responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteOrder(Orders order) {
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/OrdersJSP/DeleteOrders.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("orderID");
            values.add(String.valueOf(order.getOrderID()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void deleteOrderStock(OrderStock stock) {
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Order_StockJSP/DeleteOrder_Stock.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("orderStockID");
            values.add(String.valueOf(stock.getItemID()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void updateOrder (Orders order) {
        try {            
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/OrdersJSP/UpdateOrders.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("orderID");
            key.add("supplierID");
            key.add("noOfItems");
            key.add("total");
            key.add("cancelled");
            key.add("dateEstimateArrival");
            
            values.add(String.valueOf(order.getOrderID()));
            values.add(String.valueOf(order.getSupplierID()));
            values.add(String.valueOf(order.getNoOfItems()));
            values.add(String.valueOf(order.getTotal()));
            values.add(String.valueOf(order.getCancelled()));
            values.add(String.valueOf(order.getDateEstimateArrival()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode()); 
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateOrderStock (OrderStock stock) {
        try {            
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Order_StockJSP/UpdateOrder_Stock.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("itemID");
            key.add("unitAmount");
            
            values.add(String.valueOf(stock.getItemID()));
            values.add(String.valueOf(stock.getUnitAmount()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode()); 
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void orderSetArrived0 (int orderID) {
        try {            
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/OrdersJSP/UpdateArrived0.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("orderID");
            
            values.add(String.valueOf(orderID));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode()); 
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void orderSetArrived1 (int orderID) {
        try {            
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/OrdersJSP/UpdateArrived1.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("orderID");
            
            values.add(String.valueOf(orderID));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode()); 
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void orderSetCancelled1 (int orderID) {
        try {            
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/OrdersJSP/UpdateCancelled1.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("orderID");
            
            values.add(String.valueOf(orderID));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode()); 
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void orderSetCancelled0 (int orderID) {
        try {            
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/OrdersJSP/UpdateCancelled0.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("orderID");
            
            values.add(String.valueOf(orderID));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode()); 
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Orders> getAllOrders () {
        
        ArrayList<Orders> orders = new ArrayList<>();
        
        try {
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/OrdersJSP/ReadOrders.jsp");
            
            con.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            for (int i = 0; i < resultString.length/orderCollums; i++) {
                LocalDate date = null;
                try {
                     date = LocalDate.parse(resultString[(i*orderCollums)+5]);
                } catch (Exception e) {}
                
                orders.add(new Orders(Integer.parseInt(resultString[(i*orderCollums)]), Integer.parseInt(resultString[(i*orderCollums)+1]),
                        Integer.parseInt(resultString[(i*orderCollums)+2]), Double.parseDouble(resultString[(i*orderCollums)+3]),
                        LocalDate.parse(resultString[(i*orderCollums)+4]), date,
                        Integer.parseInt(resultString[(i*orderCollums)+6]), Integer.parseInt(resultString[(i*orderCollums)+7]),
                        LocalDate.parse(resultString[(i*orderCollums)+8])));
            }            
            return orders; //return list of orders
            
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return orders;
    }
    
    public ArrayList<OrderStock> getAllOrderStock () {
        
        ArrayList<OrderStock> stock = new ArrayList<>();
        
        try {
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/Order_StockJSP/ReadOrder_Stock.jsp");
            
            con.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            for (int i = 0; i < resultString.length/orderStockCollums; i++) {
                stock.add(new OrderStock(Integer.parseInt(resultString[(i*orderStockCollums)]), Integer.parseInt(resultString[(i*orderStockCollums)+1]),
                        Integer.parseInt(resultString[(i*orderStockCollums)+2]), Integer.parseInt(resultString[(i*orderStockCollums)+3])));
            }            
            return stock; //return list of orders
            
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return stock;
    }
    
    //********************************************//
    //Staff functions
    //********************************************//
    public void addStaff (Staff staff) {
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/StaffJSP/AddStaff.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("firstName");            
            key.add("surname");
            key.add("phoneNo");
            key.add("email");
            key.add("password");
            key.add("manager");
            key.add("salt");
            values.add(staff.getFirstName());
            values.add(staff.getSurname());
            values.add(staff.getPhoneNo());
            values.add(staff.getEmail());
            values.add(staff.getPassword());
            values.add(String.valueOf(staff.getManager()));
            values.add(staff.getSalt());
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateStaff(Staff staff) {        
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/StaffJSP/UpdateStaff.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("staffID");
            key.add("firstName");            
            key.add("surname");
            key.add("phoneNo");
            key.add("email");
            key.add("manager");
            values.add(String.valueOf(staff.getStaffID()));
            values.add(staff.getFirstName());
            values.add(staff.getSurname());
            values.add(staff.getPhoneNo());
            values.add(staff.getEmail());
            values.add(String.valueOf(staff.getManager()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void updatePassword(Staff staff) {        
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/StaffJSP/UpdatePassword.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("staffID");
            key.add("password");            
            key.add("salt");

            values.add(String.valueOf(staff.getStaffID()));
            values.add(staff.getPassword());
            values.add(staff.getSalt());
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void deleteStaff(Staff staff) {
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/StaffJSP/DeleteStaff.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("ID");
            values.add(String.valueOf(staff.getStaffID()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public ArrayList<Staff> getAllStaff () {
        
        ArrayList<Staff> staff = new ArrayList<>();
        
        try {
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/StaffJSP/ReadStaff.jsp");
            
            con.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            for (int i = 0; i < resultString.length/staffCollums; i++) {
                staff.add(new Staff(Integer.parseInt(resultString[i*staffCollums]),
                        resultString[(i*staffCollums)+1], resultString[(i*staffCollums)+2],
                        resultString[(i*staffCollums)+3], resultString[(i*staffCollums)+4],
                        resultString[(i*staffCollums)+5], Integer.parseInt(resultString[(i*staffCollums)+6]),
                        resultString[(i*staffCollums)+7]));
            }            
            return staff; //return list of staff
            
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return staff;
    }
    
    public Staff checkLogin(int id) {
        Staff staff = null;
        try {                        
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/StaffJSP/CheckLogin.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("staffID");
            values.add(String.valueOf(id));

            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader            
            
            String[] resultString = readBreaker(result.toString()); //convert for breaking
            
            for (int i = 0; i < resultString.length / staffCollums; i++) {
                staff = new Staff(Integer.parseInt(resultString[i*staffCollums]), resultString[i*staffCollums +1],
                resultString[i*staffCollums+2], resultString[i*staffCollums+3], resultString[i*staffCollums+4],
                resultString[i*staffCollums+5], Integer.parseInt(resultString[i*staffCollums+6]), resultString[i*staffCollums+7]);
            }
            return staff;
        } catch (IOException | NumberFormatException e) {
            
        }
        return staff;
        
    }
        
    //********************************************//
    //Supplier functions
    //********************************************//
    public void addSupplier (Supplier supplier) {
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/SupplierJSP/AddSupplier.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("supplierName");
            key.add("address1");
            key.add("address2");
            key.add("city");
            key.add("postcode");
            key.add("phoneNo");
            key.add("email");
            values.add(supplier.getSupplierName());
            values.add(supplier.getAddress1());
            values.add(supplier.getAddress2());
            values.add(supplier.getCity());
            values.add(supplier.getPostcode());
            values.add(supplier.getPhoneNo());
            values.add(supplier.getEmail());
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    public ArrayList<Supplier> getAllSupplier () {
        
        ArrayList<Supplier> supplier = new ArrayList<>();
        
        try {
            StringBuilder result = new StringBuilder();
            
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/SupplierJSP/ReadSupplier.jsp");
            
            con.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line); //all data into 1 line
            }            
            rd.close(); //close reader
            String[] resultString = readBreaker(result.toString()); //convert for breaking                      
            
            for (int i = 0; i < resultString.length/supplierCollums; i++) {
                supplier.add(new Supplier(Integer.parseInt(resultString[i*supplierCollums]),
                        resultString[(i*supplierCollums)+1], resultString[(i*supplierCollums)+2],
                        resultString[(i*supplierCollums)+3], resultString[(i*supplierCollums)+4],
                        resultString[(i*supplierCollums)+5], resultString[(i*supplierCollums)+6],
                        resultString[(i*supplierCollums)+7]));
            }            
            return supplier; //return list of staff
            
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return supplier;
    }
    
    public void deleteSupplier(Supplier supplier) {
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/SupplierJSP/DeleteSupplier.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("supplierID");
            values.add(String.valueOf(supplier.getSupplierID()));
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void updateSupplier(Supplier supplier) {        
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/SupplierJSP/UpdateSupplier.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("supplierID");
            key.add("supplierName");            
            key.add("address1");
            key.add("address2");
            key.add("city");
            key.add("postcode");
            key.add("phoneNo");
            key.add("email");
            
            values.add(String.valueOf(supplier.getSupplierID()));
            values.add(supplier.getSupplierName());
            values.add(supplier.getAddress1());
            values.add(supplier.getAddress2());
            values.add(supplier.getCity());
            values.add(supplier.getPostcode());
            values.add(supplier.getPhoneNo());
            values.add(supplier.getEmail());
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    //********************************************//
    // Other functions / helper functions
    //********************************************//
    
    public HttpURLConnection getURLConnection(String url) throws IOException {
     
        URL obj = new URL(url); //create URL object
        return (HttpURLConnection) obj.openConnection(); //open conection
        
    }
    
    public String parameterString(ArrayList<String> key, ArrayList<String> values) {
        
        String postData = "";
        
        for(int i = 0; i < key.size(); i++) {
            postData += key.get(i);
            postData += "=";
            postData += values.get(i);
            postData += "&";
        }
        
        return postData;
    }
    
    public void responseCodeChecker(int responseCode) {
        
        if (responseCode == 200) { //200 is OK response
            } else if (responseCode > 200 && responseCode < 300) { //Success with more data, can be processed if needed
        } else if (responseCode >= 300 && responseCode < 400) {
            Utilities.infoBox( String.valueOf(responseCode), "Action taken to fulfil request : " + String.valueOf(responseCode));
        } else if (responseCode >= 400 && responseCode < 500) { //client side errors
            Utilities.infoBox( String.valueOf(responseCode), "Client side error : " + String.valueOf(responseCode));
        } else if (responseCode >= 500 && responseCode < 600) { //server side errors
            Utilities.infoBox( String.valueOf(responseCode), "Server side error : " + String.valueOf(responseCode));
        }
    }
    
    public String[] readBreaker(String results) {
        
            String[] newResults = results.split("break");
            for (int i = 0; i < newResults.length; i++) {
                newResults[i] = newResults[i].trim().replaceAll("\\s{2,}", "");
            }
            return newResults;
    }
    
    
    public void AddMealType(String mealType) { //this is a test function for creating conection template
        
        try {
            HttpURLConnection con = getURLConnection("http://localhost:8080/IntergratedProjectPHPPages/JSP_Pages/MealTypeJSP/AddMealType.jsp"); //set URL
            
            //2 arraylists for key and values
            ArrayList<String> key = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            
            //add keys and values to list
            key.add("mealType");
            values.add(mealType);
            
            //send to function to convert to a parameter string query
            String postData = parameterString(key, values);
            
            //set header
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            
            //output data to request
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());            
            os.close();
            
            //response code for error checking            
            responseCodeChecker(con.getResponseCode());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSPPageConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
