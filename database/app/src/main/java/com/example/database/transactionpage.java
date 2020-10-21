package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.database.Data.DbHelper;
import com.example.database.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class transactionpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactionpage);
        ListView listView;
        listView = findViewById(R.id.idlistview);

        ArrayList<String> transactions = new ArrayList<>();
        DbHelper db = new DbHelper(transactionpage.this);
        List<Transaction> transactionList= db.getAllTransactions();
        for (Transaction transaction: transactionList){
            if(getIntent().hasExtra("Rname")) {
                String name_sender = getIntent().getStringExtra("Rname");
                if(name_sender.equals(transaction.getSource())||name_sender.equals(transaction.getReceiver())){
                    transactions.add("Transaction Successful \n" + "Sender : "+transaction.getSource()+"\nReceiver: "+transaction.getReceiver()+"\nAmount Paid: "+ transaction.getAmt()+"\nTime : "+transaction.getDatetime());
                }
            }
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,transactions);
        listView.setAdapter(arrayAdapter);
    }
}
