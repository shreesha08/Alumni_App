package com.example.aluminiadminapp;

public class message {

    String mssg;
    String date;

    public message(String mssg, String date) {
        this.mssg = mssg;
        this.date = date;
    }

    public message() {

    }

    public String getMssg() {
        return mssg;
    }

    public void setMssg(String mssg) {
        this.mssg = mssg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}