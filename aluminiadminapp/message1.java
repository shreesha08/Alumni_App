package com.example.aluminiadminapp;

public class message1 {
    private  String name;
    private String email;
    private String transactionid;
    private String batch;
    private String amount;

    public message1() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public message1(String name, String email, String transactionid, String batch, String amount) {
        this.name = name;
        this.email = email;
        this.transactionid = transactionid;
        this.batch = batch;
        this.amount = amount;
    }
}