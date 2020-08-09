package com.example.alumniapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;

import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    public Button button1;
    //public Button buttn2;
    public Button pass;
    public static String eemail;
    public EditText email,passwrd;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.editText);
        passwrd=findViewById(R.id.editText3);
        button1 = findViewById(R.id.button);

        fAuth = FirebaseAuth.getInstance();
       // buttn2 = findViewById(R.id.button2);

        pass=findViewById(R.id.button7);






        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eMail = email.getText().toString();
                String pswd = passwrd.getText().toString();

                if (eMail.isEmpty()) {
                    email.setError("Error");
                    email.requestFocus();
                } else if (pswd.isEmpty() && passwrd.length() < 6) {
                    passwrd.setError("Password is empty");
                    passwrd.requestFocus();
                } else if (!(eMail.isEmpty() && pswd.isEmpty() && (pswd.length() == 0))) {


                    fAuth.signInWithEmailAndPassword(eMail, pswd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                                Intent home = new Intent(MainActivity.this, Main4Activity.class);
                                startActivity(home);
                                finish();
                            } else if (!(task.isSuccessful())) {
                                Toast.makeText(MainActivity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });


                }

                eemail=email.getText().toString();
            }
        });

       /* buttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup= new Intent(MainActivity.this, Main2Activity.class);
                startActivity(signup);
            }
        });*/

        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openforgot();
            }
        });


    }






    public void openforgot() {
        Intent intent2 = new Intent(this, frgtpass.class);
        startActivity(intent2);
    }
}
