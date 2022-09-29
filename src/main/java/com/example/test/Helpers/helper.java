package com.example.test.Helpers;
import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class helper {


    public static Date convertStringToDate(String dte) {
        Date d=null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
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

    public static String convertDateTimeToString(Timestamp date) {
        
    	SimpleDateFormat fmt = null;        
        fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm");   

        if(date!=null){
        	String myDate = fmt.format(date);
        	return myDate;
        }
        else
        	return "";
        
    }

    public static Date convertStringToDateTime(String dte) {
        Date d=null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
         try {
             d= formatter.parse(dte);
        } catch (ParseException e) {
            
            e.printStackTrace();
        }
        
         return d;
    }

    public static String getTypeS(int t){
        String tpe="";
        switch(t){
            case 1:tpe="Normal";
            break;
            case 2:tpe="VIP";
            break;
            case 3:tpe="VIVIP";

            default:
            break;

        }
        return tpe;

    }

    public static Integer getTypeInt(String t){
        int tpe=0;
        switch(t){
            case "Normal":tpe=1;
            break;
            case "VIP":tpe=2;
            break;
            case "VIVIP":tpe=3;

            default:
            break;

        }
        return tpe;

    }


    
}
