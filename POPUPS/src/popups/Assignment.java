/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popups;

/**
 *
 * @author Kyle Z
 */
public class Assignment {
    private String name;
    private int month, day, year, hour, minute, priority;
    private boolean popup;
    
    public Assignment(String n, int mo, int d, int y, int h, int mi, int pr, boolean po){
        //assign corresponding values
        name = n;
        month = mo;
        day = d;
        year = y;
        hour = h;
        minute = mi;
        priority = pr;
        popup = po;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String n){
        this.name = n;
    }
    
    public int getMonth(){
        return month;
    }
    
    public void setMonth(int mo){
        this.month = mo;
    }
    
    public int getDay(){
        return day;
    }
    
    public void setDay(int d){
        this.day = d;
    }
    
    public int getYear(){
        return year;
    }
    
    public void setYear(int y){
        year = y;
    }
    
    public int getHour(){
        return hour;
    }
    
    public void setHour(int h){
        this.hour = h;
    }
    
    public int getMinute(){
        return minute;
    }
    
    public void setMinute(int mi){
        this.minute = mi;
    }
    
    public int getPriority(){
        return priority;
    }
    
    public void setPriority(int pr){
        this.priority = pr;
    }
    
    public boolean getPopup(){
        return popup;
    }
    
    public void setPopup(boolean po){
        this.popup = po;
    }
}
