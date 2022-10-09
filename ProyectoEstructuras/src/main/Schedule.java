/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Usuario
 */
public class Schedule {
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;
    private int saturday;
    private int sunday;
    
    public Schedule() {
        
    }
    
    public Schedule(int monday, int tuesday, int wednesday, int thursday, int friday, int saturday, int sunday) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    public int getMonday() {
        return monday;
    }

    public void setMonday(int monday) {
        this.monday = monday;
    }

    public int getTuesday() {
        return tuesday;
    }

    public void setTuesday(int tuesday) {
        this.tuesday = tuesday;
    }

    public int getWednesday() {
        return wednesday;
    }

    public void setWednesday(int wednesday) {
        this.wednesday = wednesday;
    }

    public int getThursday() {
        return thursday;
    }

    public void setThursday(int thursday) {
        this.thursday = thursday;
    }

    public int getFriday() {
        return friday;
    }

    public void setFriday(int friday) {
        this.friday = friday;
    }

    public int getSaturday() {
        return saturday;
    }

    public void setSaturday(int saturday) {
        this.saturday = saturday;
    }

    public int getSunday() {
        return sunday;
    }

    public void setSunday(int sunday) {
        this.sunday = sunday;
    } 
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Schedule other = (Schedule)obj;
        if (this.monday != other.getMonday()) {
            return false;
        }
        if (this.tuesday != other.getTuesday()) {
            return false;
        }
        if (this.wednesday != other.getWednesday()) {
            return false;
        }
        if (this.thursday != other.getThursday()) {
            return false;
        }
        if (this.friday != other.getFriday()) {
            return false;
        }
        if (this.saturday != other.getSaturday()) {
            return false;
        }
        return this.sunday == other.getSunday();
    }
}
