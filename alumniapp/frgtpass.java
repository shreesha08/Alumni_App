package com.example.alumniapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class frgtpass extends AppCompatActivity {


    //ProgressBar progressBar;
    EditText userEmail;
    Button userPass;

    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frgtpass);


        userEmail = findViewById(R.id.etUserEmail);
        userPass = findViewById(R.id.btnfrgtpass);


        firebaseAuth = FirebaseAuth.getInstance();
        userPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String forgot = userEmail.getText().toString();
                firebaseAuth.sendPasswordResetEmail(forgot).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {


                        if (task.isSuccessful()) {
                            Toast.makeText(frgtpass.this, "Password sent to your email", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(frgtpass.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
                openforgot();
            }
        });

    }

    public void openforgot() {
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
    }
}