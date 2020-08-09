package com.example.alumniapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class gateway extends AppCompatActivity {
    EditText text;
    Button button;
    Float amont;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gateway);
        text=findViewById(R.id.raz_text);
        button=findViewById(R.id.raz_butt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amont=Float.parseFloat(text.getText().toString().trim());
            }
        });

    }
}
