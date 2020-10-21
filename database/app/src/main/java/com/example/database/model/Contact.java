package com.example.database.model;

public class Contact {
    private int id;
    private String name;
    private  String phoneNumber;
    private String email;
    private int balance;

    public Contact(int id, String name, String phoneNumber, int balance, String email) {
        this.id=id;
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.balance=balance;

    }

    public Contact(String name, String phoneNumber, String email, int balance) {
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.balance=balance;
    }

    public Contact() {
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.balance = balance;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }


    public void setId(int id) {
        this.id=id;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber=phoneNumber;
    }


    public void setEmail(String email) {
        this.email=email;
    }

    public void setBalance(int balance) {
        this.balance=balance;
    }

}
