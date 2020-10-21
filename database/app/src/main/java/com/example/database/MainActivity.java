package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.PreferenceManager;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.database.Data.DbHelper;
import com.example.database.adapter.RecyclerviewAdapter;
import com.example.database.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.PreferenceChangeEvent;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerviewAdapter recyclerviewAdapter;
    private ArrayList<Contact> contactarraylist;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DbHelper mydb= new DbHelper(MainActivity.this);

        SharedPreferences prefs =  PreferenceManager.getDefaultSharedPreferences(this);
        if(!prefs.getBoolean("firsttime",false)) {

            Contact user1=new Contact();
            user1.setName("Rutvik Raut");
            user1.setPhoneNumber("9930412579");
            user1.setEmail("Rutvik@gmail.com");
            user1.setBalance(5000);
           // mydb.addContact(user1);

            Contact user2=new Contact();
            user2.setName("Varad Saudi");
            user2.setPhoneNumber("99819856874");
            user2.setEmail("Varad@gmail.com");
            user2.setBalance(4000);
           // mydb.addContact(user2);


            Contact user3=new Contact();
            user3.setName("Akhil Mishra");
            user3.setPhoneNumber("9917352486");
            user3.setEmail("Akhil@gmail.com");
            user3.setBalance(9000);
            //mydb.addContact(user3);

            Contact user4=new Contact();
            user4.setName("Aarushi Advani");
            user4.setPhoneNumber("7842658613");
            user4.setEmail("Aarushi@gmail.com");
            user4.setBalance(8500);
            //mydb.addContact(user4);

            Contact user5=new Contact();
            user5.setName("Rickson David");
            user5.setPhoneNumber("8820412695");
            user5.setEmail("Rickson@gmail.com");
            user5.setBalance(6500);
            //mydb.addContact(user5);

            Contact user6=new Contact();
            user6.setName("Trisha Jain");
            user6.setPhoneNumber("7596241258");
            user6.setEmail("Trisha@gmail.com");
            user6.setBalance(9000);
            //mydb.addContact(user6);

            Contact user7=new Contact();
            user7.setName("Viraj Prabhu");
            user7.setPhoneNumber("8652485967");
            user7.setEmail("Viraj@gmail.com");
            user7.setBalance(10000);
            //mydb.addContact(user7);

            Contact user8=new Contact();
            user8.setName("Rutuja Udeshi");
            user8.setPhoneNumber("9465289659");
            user8.setEmail("Rutuja@gmail.com");
            user8.setBalance(8900);
            //mydb.addContact(user8);

            Contact user9=new Contact();
            user9.setName("Gurpreet singh");
            user9.setPhoneNumber("9819843896");
            user9.setEmail("Gurpreet@gmail.com");
            user9.setBalance(2000);
            //mydb.addContact(user9);

            Contact user10=new Contact();
            user10.setName("Sandeep Sejwal");
            user10.setPhoneNumber("9833245289");
            user10.setEmail("Sandeep@gmail.com");
            user10.setBalance(8000);
            //mydb.addContact(user10);

        }
        contactarraylist  = new ArrayList<>();

        List<Contact> contactList = mydb.getallcontacts();
        for(Contact contact: contactList) {
            Log.d("Database", "ID :" + contact.getId() + "Name:" + contact.getName() + " Phone Number : " + contact.getPhoneNumber()+"Email :" +contact.getEmail() + "Balance : " + contact.getBalance());
            contactarraylist.add(contact);
        }

        recyclerviewAdapter = new RecyclerviewAdapter(MainActivity.this, contactarraylist);
        recyclerView.setAdapter(recyclerviewAdapter);










    }

}
