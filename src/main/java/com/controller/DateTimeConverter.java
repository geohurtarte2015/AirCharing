
package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class DateTimeConverter {
    
    public String getDateTimeIso8601(){
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("yyyyMMdd'T'HH:mm:ss.SSS");  
        String text = sdf.format(date);
        return text;
    }
    
}
