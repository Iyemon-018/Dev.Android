package com.example.iyemon018.listviewsample;

import java.util.Date;

/**
 * Created by iyemon018 on 2018/01/20.
 */
public class DataForHour {
    
    public Date getDateTime() {
        
        return dateTime;
    }
    
    public float getValue() {
        
        return value;
    }
    
    private final Date dateTime;
    
    private final float value;
    
    public DataForHour(Date dateTime, float value) {
        
        this.dateTime = dateTime;
        this.value = value;
    }
    
}
