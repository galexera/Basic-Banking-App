package com.example.database.parameters;


public class Params {
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "BANK_DATA";
    public static final String TABLE_NAME = "USER_DATA";

    //KEYS OF OUR TABLE IN DB
    public static final String KEY_ID =" id";
    public static final String  KEY_NAME ="name";
    public static final String  KEY_PHONE=" phone_number";
    public static final String KEY_BALANCE ="balance";
    public  static final String KEY_EMAIL = "email";


    public static final String TABLE_NAME1 = "USER_TRANSACTION";
    public static final String KEY_ID1= "id";
    public static final String KEY_SOURCE = "sender";
    public static final String KEY_RECEIVER = "receiver";
    public static final String KEY_AMT = "amount";
    public static final String KEY_DATETIME = "datetime";
    public static final String KEY_SOURCE_BAL = "sender_bal";
    public static final String KEY_RECEIVER_BAL = "rec_bal";




}
