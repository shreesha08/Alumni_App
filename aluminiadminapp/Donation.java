package com.example.aluminiadminapp;

public class Donation {

    private String batch;
    private String email;
    private String name;
    private String transactionid;


    public Donation(){

    }
    public Donation(String batch, String email, String name, String transactionid) {
        this.batch = batch;
        this.email = email;
        this.name = name;
        this.transactionid = transactionid;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }
}
