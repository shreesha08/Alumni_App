package com.example.alumniapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main7Activity extends AppCompatActivity {
   public Button butt1,butt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
       butt1=findViewById(R.id.pr_button);
        butt2=findViewById(R.id.sig_button);

        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fintent1=new Intent(Main7Activity.this,MainActivity.class);
                startActivity(fintent1);
            }
        });

        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fintent2=new Intent(Main7Activity.this,Main2Activity.class);
                startActivity(fintent2);
            }
        });
    }
}
