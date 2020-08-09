package com.example.alumniapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main9Activity extends AppCompatActivity {
    EditText e1,e2;
    Button bb1;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        e1=findViewById(R.id.editText2);
        e2=findViewById(R.id.editText4);
        bb1=findViewById(R.id.button2);

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Message");
        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pe1=e1.getText().toString().trim();
                String pe2=e2.getText().toString().trim();

                message m = new message();
                m.setMssg(pe1);
                m.setDate(pe2);
                databaseReference.push().setValue(m);
            }
        });

    }
}
