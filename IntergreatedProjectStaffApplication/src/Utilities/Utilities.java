package Utilities;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Utilities {
    
    //***************************************//
    //Feedback messages
    //***************************************//
    
     public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "Error : " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }    
     
    //***************************************//
    //Field Checkers
    //***************************************//
    
    public static boolean nullCheck(JTextField textBox, String feedback, String title) {
        
        String text = textBox.getText();
        String newFeedback = feedback +  " can not be null.";
        if (text.isEmpty()) {
            infoBox(newFeedback, title);
            textBox.requestFocus();
            return false;
        }
        else {
            return true;
        }
    }
    
    public static boolean numericDecimal(String text, String feedback, String title) { 
        
        if (text.matches("^[0-9]\\d*(\\.\\d+)?$")) {            
            return true;
        }
        else {
            infoBox(feedback + " must be a positive number.", title);
            return false;
        }
    }
    
    public static boolean numericWhole(String text, String feedback, String title) { 
        
        if (text.matches("[0-9]+")) {            
            return true;
        }
        else {
            infoBox(feedback + " must be a whole positive number.", title);
            return false;
        }
    }
    
    public static boolean phoneNoCheck(String text) {
                
        if (text.matches("[0-9]+")) {            
            if (text.length() == 11 || text.length() == 10) {
                return true;
            } else {
                infoBox("Phone number must be 10 or 11 digits.", "Phone Number Length");
                return false;
            }
        }
        else {
            infoBox("Phone number must contain only numbers.", "Phone Number contains");
            return false;
        }
    }
    
    public static boolean greaterThan(int in, int min ,String feedback, String title) {
        
        if (in >= min) {
            return true;
        }
        else {
            infoBox(feedback + " must be at least " + min, title);
            return false;
        }
    }

    public static boolean alphbetic (String text, String feedback, String title) {
        
        if (text.matches("[a-zA-Z ]+")) {
            return true;
        }
        else {
            infoBox(feedback + " must contain letters only.", title);
            return false;
        }
    }    
    public static boolean alphanumeric (String text, String feedback, String title) {
        
        if (text.matches("[a-zA-Z0-9 ]+")) {
            return true;
        }
        else {
            infoBox(feedback + " must contain only numbers and letters.", title);
            return false;
        }
    }    
    public static boolean emailCheck (JTextField textBox) {
        String text = textBox.getText();
        String newFeedback = "Email format is wrong please use Example@Example.co.uk / .com";
        boolean check;
        String emailFormat = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";        
        check = text.matches(emailFormat);
        
        if (check == false) {
            infoBox(newFeedback, "Email format");
        }
        
        return check;
    }
    
    public static boolean lengthCheckerGreater (JTextField textbox, int length, String feedback, String title) {
        String text = textbox.getText();
        int textLength = text.length();
        
        if (textLength >= length) {
            return true;
        } else {
            infoBox(feedback + " must be at least " + length + " characters long.", title);
            return false;            
        }
    }
    
        public static boolean lengthCheckerLess (JTextField textbox, int length, String feedback, String title) {
        String text = textbox.getText();
        int textLength = text.length();
        
        if (textLength <= length) {
            return true;
        } else {
            infoBox(feedback + " must be at most " + length + " characters long.", title);
            return false;            
        }
    }
    
    public static boolean fieldMatch (String text1, String text2, String info, String title) {
        if (text1.equals(text2)) {
            return true;
        }
        else {
            Utilities.infoBox(info, title);
            return false;
        }
    }
    public static boolean dateCheck (JTextField textBox) {
        String text = textBox.getText();
        String newFeedback = "date format is wrong please use yyy/mm/dd";
        boolean check;
        String emailFormat = "^\\d{4}-\\d{2}-\\d{2}$";        
        check = text.matches(emailFormat);
        
        if (check == false) {
            infoBox(newFeedback, "date format");
        }
        
        return check;
    }
    
    public static boolean dateAfter (LocalDate date1, LocalDate date2, String date1Name, String date2Name) {
        
        if (date1.isAfter(date2))
            return true;
        else {
            Utilities.infoBox(date1Name + " needs to be after " + date2Name, "Date after check");
            return false;
        }
        
    }
    
    //******************************************//
    //password hashing                          //
    //******************************************//
    public static String getSecurePassword(String passwordToHash, String salt) throws NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException
    {
        String generatedPassword;

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt.getBytes("UTF-8"));
        byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        generatedPassword = sb.toString();

        return generatedPassword;
    }
     
    //Add salt
    public static String getSalt() throws NoSuchAlgorithmException, NoSuchProviderException
    {
        java.security.SecureRandom sr = java.security.SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }
}
