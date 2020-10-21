package com.example.database.model;

public class Transaction {
    private int id1;
    private String source;
    private String receiver;
    private String datetime;
    private int amt;
    private int receiver_bal;
    private int source_bal;

    public Transaction(int id1, String source, String receiver, String datetime, int amt, int receiver_bal, int source_bal) {
        this.id1=id1;
        this.source=source;
        this.receiver=receiver;
        this.datetime=datetime;
        this.amt=amt;
        this.receiver_bal=receiver_bal;
        this.source_bal=source_bal;
    }

    public Transaction(String source, String receiver, String datetime, int amt, int receiver_bal, int source_bal) {
        this.source=source;
        this.receiver=receiver;
        this.datetime=datetime;
        this.amt=amt;
        this.receiver_bal=receiver_bal;
        this.source_bal=source_bal;
    }

    public Transaction() {
        this.source=source;
        this.receiver=receiver;
        this.datetime=datetime;
        this.amt=amt;
        this.receiver_bal=receiver_bal;
        this.source_bal=source_bal;

    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1=id1;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source=source;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver=receiver;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime=datetime;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt( int amt) {
        this.amt=amt;
    }

    public int getReceiver_bal() {
        return receiver_bal;
    }

    public void setReceiver_bal(int receiver_bal) {
        this.receiver_bal=receiver_bal;
    }

    public int getSource_bal() {
        return source_bal;
    }

    public void setSource_bal(int source_bal) {
        this.source_bal=source_bal;
    }
}
