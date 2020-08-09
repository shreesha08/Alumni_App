package com.example.aluminiadminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MessageActivity extends AppCompatActivity {
    EditText e1,e2;
    Button bb1;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
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



                Toast.makeText(MessageActivity.this, "Message sent successfully", Toast.LENGTH_SHORT).show();
                    
                    

            }
        });

    }
}