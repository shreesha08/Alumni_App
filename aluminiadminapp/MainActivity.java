package com.example.aluminiadminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDonationList();
            }

            private void openDonationList() {
                Intent intent = new Intent(MainActivity.this,TransactionTable.class);
                startActivity(intent);
            }
        });

        b2=findViewById(R.id.button1);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMessage();
            }
            private void openMessage(){
                Intent i1=new Intent(MainActivity.this,MessageActivity.class);
                startActivity(i1);
            }
        });

    }

}
