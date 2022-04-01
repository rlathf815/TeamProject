package com.example.teamproject;

public class item {
    int day;
    String schedule1;
    String schedule2;
    String schedule3;
    String schedule4;

    item(int day, String schedule1, String schedule2, String schedule3, String schedule4)
    {
        this.day = day;
        this.schedule1 = schedule1;
        this.schedule2 = schedule2;
        this.schedule3 = schedule3;
        this.schedule4 = schedule4;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setSchedule1(String schedule1) {
        this.schedule1 = schedule1;
    }

    public void setSchedule2(String schedule2) {
        this.schedule2 = schedule2;
    }

    public void setSchedule3(String schedule3) {
        this.schedule3 = schedule3;
    }

    public void setSchedule4(String schedule4) {
        this.schedule4 = schedule4;
    }

    public String getSchedule1() {
        return schedule1;
    }

    public String getSchedule2() {
        return schedule2;
    }

    public String getSchedule3() {
        return schedule3;
    }

    public String getSchedule4() {
        return schedule4;
    }

    public int getDay() {
        return day;
    }
}
