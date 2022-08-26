package com.example.test.Helpers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class helper {


    public static String convertDateToString(Date date){
        String dateS="";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        dateS = dateFormat.format(date);

    return dateS;
    }

    public static Date convertStringToDate(String dateS){
        Date date=null;
       try {
        date= new SimpleDateFormat("dd/MM/yyyy").parse(dateS);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    
    return date;
    }
    
}
