package com.example.database;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class displayContact extends AppCompatActivity {
    String name;
    String phone;
    String email;
    String balance;
    private Button transfer;
    private Button transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);

        if((getIntent().hasExtra("Rname")&&getIntent().hasExtra("Rphone"))
                &&(getIntent().hasExtra("Remail")&&getIntent().hasExtra("Rbalance")))
        {


            name=getIntent().getStringExtra("Rname");
            phone=getIntent().getStringExtra("Rphone");
            email=getIntent().getStringExtra("Remail");
            balance=String.valueOf(getIntent().getIntExtra("Rbalance", 0));


            TextView nameTextView=findViewById(R.id.displayName);
            nameTextView.setText(name);
            TextView phoneTextView=findViewById(R.id.displayPhone);
            phoneTextView.setText(phone);
            TextView emailTextView=findViewById(R.id.displayemail);
            emailTextView.setText(email);
            TextView balancedisplay=findViewById(R.id.displayBalance);
            balancedisplay.setText(balance);


        }

        transfer = findViewById(R.id.idtransfer);
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( displayContact.this , transfermoneypage.class);
                intent.putExtra("Rbalance",balance);
                intent.putExtra("Rname",name);
                startActivity(intent);
            }
        });


        transaction = findViewById(R.id.idtransaction);
        transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(displayContact.this ,transactionpage.class);
                intent.putExtra("Rname",name);
                startActivity(intent);
            }
        });
    }
}
