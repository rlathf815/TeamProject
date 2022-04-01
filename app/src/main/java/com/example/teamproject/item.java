package com.example.teamproject;

public class item {
    String day;
    String schedule1;
    String schedule2;
    String schedule3;



    item(String day, String schedule1, String schedule2, String schedule3) {
        this.day = day;
        this.schedule1 = schedule1;
        this.schedule2 = schedule2;
        this.schedule3 = schedule3;

    }

    public void setDay(String day) {
        this.day = day;
    }
}

