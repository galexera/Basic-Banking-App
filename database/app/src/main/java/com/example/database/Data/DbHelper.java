package com.example.database.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;

import com.example.database.model.Contact;
import com.example.database.model.Transaction;
import com.example.database.parameters.Params;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = " CREATE TABLE " + Params.TABLE_NAME +
                "(" + Params.KEY_ID + " INTEGER PRIMARY KEY ," +
                      Params.KEY_NAME + " TEXT ," +
                      Params.KEY_PHONE + " TEXT ," +
                      Params.KEY_EMAIL + " TEXT ,"  +
                      Params.KEY_BALANCE + " TEXT" + " )";
        Log.d("Database","Query being run is : "+ create);
        db.execSQL(create);

        String create1 = "CREATE TABLE " + Params.TABLE_NAME1 +"(" +
                Params.KEY_ID1 + " INTEGER PRIMARY KEY, " +
                Params.KEY_SOURCE + " TEXT, " +
                Params.KEY_RECEIVER + " TEXT, " +
                Params.KEY_AMT + " TEXT, " +
                Params.KEY_DATETIME + " TEXT, " +
                Params.KEY_RECEIVER_BAL + " TEXT, " +
                Params.KEY_SOURCE_BAL + " TEXT" + ")";
        db.execSQL(create1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Params.TABLE_NAME );
        onCreate(db);
    }
    public void addContact(Contact contact)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME, contact.getName());
        values.put(Params.KEY_PHONE, contact.getPhoneNumber());
        values.put(Params.KEY_EMAIL, contact.getEmail());
        values.put(Params.KEY_BALANCE, contact.getBalance());
        db.insert(Params.TABLE_NAME,null, values);
        Log.d("Database","successfully inserted");
        db.close();

    }

    public void update(String name_from, int balance,String name_to, int amount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME, name_from);
        values.put(Params.KEY_BALANCE, balance);
        db.update(Params.TABLE_NAME,values,Params.KEY_NAME+"=?",new String[]{name_from});
        Log.d("userdb","successfully updated from");

        String[] projections ={Params.KEY_ID,Params.KEY_NAME,Params.KEY_PHONE,Params.KEY_EMAIL,Params.KEY_BALANCE};
        String selection = Params.KEY_NAME+" LIKE ?";
        String[] selection_args = {name_to};
        Cursor cursor = db.query(Params.TABLE_NAME,projections,selection,selection_args,null,null,null);
        if(cursor.moveToFirst()){
            Log.d("YES","send to: "+cursor.getString(1));
            int bal = Integer.parseInt(cursor.getString(4))+ amount;
            ContentValues value = new ContentValues();
            value.put(Params.KEY_NAME, name_to);
            value.put(Params.KEY_BALANCE, bal);
            db.update(Params.TABLE_NAME,value,Params.KEY_NAME+"=?",new String[]{name_to});
            Log.d("userdb","successfully updated to");
            addTransaction(name_from,name_to,amount,bal,balance);
        }

        db.close();
    }
    public void addTransaction(String sender, String receiver, int amount,int rec_bal,int sender_bal){
        Date currentTime = Calendar.getInstance().getTime();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_SOURCE,sender);
        values.put(Params.KEY_RECEIVER,receiver);
        values.put(Params.KEY_AMT,amount);
        values.put(Params.KEY_DATETIME, String.valueOf(currentTime));
        values.put(Params.KEY_RECEIVER_BAL,rec_bal);
        values.put(Params.KEY_SOURCE_BAL,sender_bal);
        db.insert(Params.TABLE_NAME1,null, values);
        Log.d("transaction_db","successfully inserted");
        db.close();
    }


    public List<Contact> getallcontacts(){
        List<Contact> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        //query to read data from database

        String qry = " SELECT * FROM " + Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(qry,null);
        if (cursor.moveToFirst()){
            do{
                Contact contact = new Contact();
                contact.setId(cursor.getInt(0));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                contact.setEmail(cursor.getString(3));
                contact.setBalance(cursor.getInt(4));
                contactList.add(contact);
            }
            while(cursor.moveToNext());
        }
        return contactList;
    }

    public List<Transaction> getAllTransactions(){
        List<Transaction> transactionList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        //Generate query to read from the database
        String select = "SELECT * FROM " + Params.TABLE_NAME1;
        Cursor cursor = db.rawQuery(select, null);


        if(cursor.moveToFirst()){
            do {
                Transaction transaction = new Transaction();
                transaction.setSource(cursor.getString(1));
                transaction.setReceiver(cursor.getString(2));
                transaction.setAmt(cursor.getInt(3));
                transaction.setDatetime(cursor.getString(4));
                transaction.setReceiver_bal(Integer.parseInt(cursor.getString(5)));
                transaction.setSource_bal(Integer.parseInt(cursor.getString(6)));

                transactionList.add(transaction);
            }while (cursor.moveToNext());
        }
        return transactionList;
    }

}
