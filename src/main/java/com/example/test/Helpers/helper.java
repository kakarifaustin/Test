package com.example.test.Helpers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class helper {


    public static Date convertStringToDate(String dte) {
        Date d=null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");
         try {
             d= formatter.parse(dte);
        } catch (ParseException e) {
            
            e.printStackTrace();
        }
        
         return d;
    }

    public static String convertDateToString(java.util.Date date) {
        
    	SimpleDateFormat fmt = null;        
        fmt = new SimpleDateFormat("dd/MM/yyyy");   

        if(date!=null){
        	String myDate = fmt.format(date);
        	return myDate;
        }
        else
        	return "";
        
    }

    
}
