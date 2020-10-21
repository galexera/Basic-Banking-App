package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.database.Data.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class transfermoneypage extends AppCompatActivity {
    Spinner spinner;
    EditText inputamt;
    Button sendmoney;
    int amt ;
    int balance_from;
    int balance_to;
    String name_from;
    String name_to;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfermoneypage);

        spinner = (Spinner)findViewById(R.id.idspinner);
        inputamt = (EditText)findViewById(R.id.idamt);
        sendmoney = (Button)findViewById(R.id.idsendbtn);
        Intent intent = getIntent();
        balance_from = Integer.parseInt(intent.getStringExtra("Rbalance"));
        name_from =intent.getStringExtra("Rname");

        List<String> list = new ArrayList<>();
        list.add("PAY TO");
        list.add("Rutvik Raut");
        list.add("Varad Saudi");
        list.add("Akhil Mishra");
        list.add("Aarushi Advani");
        list.add("Rickson David");
        list.add("Trisha Jain");
        list.add("Viraj Prabhu");
        list.add("Rutuja Udeshi");
        list.add("Gurpreet singh");
        list.add("Sandeep Sejwal");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                name_to =spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sendmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amt=Integer.parseInt(inputamt.getText().toString());
                if (amt>balance_from)
                {
                    Toast.makeText(transfermoneypage.this,"Insufficient Balance",Toast.LENGTH_SHORT).show();
                }
                else if(name_to.equals("Click to select"))
                {
                    Toast.makeText(transfermoneypage.this,"Select a valid option",Toast.LENGTH_SHORT).show();
                }
                else if(name_to.equals(name_from)){
                    Toast.makeText(transfermoneypage.this,"Sender and receiver cannot be the same person",Toast.LENGTH_LONG).show();
                }

                else
                {
                    int updatedbal_from = balance_from - amt;
                    Log.d("MP","new current bal:"+balance_from);
                    DbHelper db = new DbHelper(transfermoneypage.this);
                    db.update(name_from,updatedbal_from,name_to,amt);
                    Toast.makeText(getApplicationContext(),"Transaction Successful",Toast.LENGTH_SHORT).show();
                    Intent back = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
                    back.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(back);
                }
            }
        });


    }
}
