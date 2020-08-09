package com.example.alumniapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Main2Activity extends AppCompatActivity {
    EditText rname1, remail1, rphone1, rpassword1, rbatch1, rinstitution1, raddress1, rprofession1;
    Button rsubmit1;
    Timer timer;





    DatabaseReference reff;
    UserHelperClass userhelper1;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    String userID;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rname1 = findViewById(R.id.reg_name1);
        remail1 = findViewById(R.id.reg_email1);
        rphone1 = findViewById(R.id.reg_phone1);
        timer= new Timer();





        rpassword1 = findViewById(R.id.reg_password1);
        rsubmit1 = findViewById(R.id.reg_button1);
        rbatch1 = findViewById(R.id.reg_batch1);
        rinstitution1 = findViewById(R.id.reg_IName1);
        raddress1 = findViewById(R.id.reg_address1);
        rprofession1 = findViewById(R.id.reg_profession1);
        userhelper1 = new UserHelperClass();
         FirebaseDatabase database = FirebaseDatabase.getInstance();
        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
        reff = database.getReference("UserHelperClass");


        rsubmit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String name = rname1.getText().toString();
                final String emailId = remail1.getText().toString();

                String Phone = rphone1.getText().toString();
                String Password = rpassword1.getText().toString();
           

                String batch = rbatch1.getText().toString();
                String insti = rinstitution1.getText().toString();
                String addr = raddress1.getText().toString();
                String prof = rprofession1.getText().toString();
                if (name.isEmpty()) {
                    rname1.setError("Name is empty");
                    rname1.requestFocus();
                }
                else if (emailId.isEmpty()) {
                    remail1.setError("email is empty");
                    rname1.requestFocus();
                } else if (Phone.isEmpty() && (Phone.length() < 10)) {
                    rphone1.setError("Invalid Phone Number");
                    rphone1.requestFocus();
                } else if (Password.isEmpty() && (Password.length() < 6)) {
                    rpassword1.setError("Password Length should be greater than 6 ");
                    rpassword1.requestFocus();
                }
                else if (batch.isEmpty()) {
                    rbatch1.setError("This field is empty");
                    rbatch1.requestFocus();
                } else if (insti.isEmpty()) {
                    rinstitution1.setError("This field is empty");
                    rinstitution1.requestFocus();
                } else if (addr.isEmpty()) {
                    raddress1.setError("This Field is empty");
                    raddress1.requestFocus();
                } else if (prof.isEmpty()) {
                    rprofession1.setError("This Field is empty");
                    rprofession1.requestFocus();
                } else if (!(name.isEmpty() && emailId.isEmpty() && Password.isEmpty() && Phone.isEmpty() && batch.isEmpty() && insti.isEmpty() && addr.isEmpty() && prof.isEmpty())) {

                    fAuth.createUserWithEmailAndPassword(emailId, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Main2Activity.this, "User Created", Toast.LENGTH_SHORT).show();
                                userID = fAuth.getCurrentUser().getEmail();



                                DocumentReference documentReference = fStore.collection("users").document(userID);
                                //get values
                                String personname = rname1.getText().toString().trim();
                                String phoneNo = rphone1.getText().toString().trim();
                                String email = remail1.getText().toString().trim();
                                String password = rpassword1.getText().toString().trim();


                                String Batch = rbatch1.getText().toString().trim();
                                String institu = rinstitution1.getText().toString().trim();
                                String addre = raddress1.getText().toString().trim();
                                String proff = rprofession1.getText().toString().trim();



                                userhelper1.setName(personname);
                                userhelper1.setPhoneNo(phoneNo);
                                userhelper1.setEmail(email);

                                userhelper1.setPassword(password);

                                userhelper1.setBatch(Batch);
                                userhelper1.setInstitution(institu);
                                userhelper1.setProfession(proff);
                                userhelper1.setAddress(addre);


                                reff.push().setValue(userhelper1);


                                documentReference.set(userhelper1).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d("TAG", "onSuccess: user profile is created for " + userID);
                                    }
                                });
                                Toast.makeText(Main2Activity.this, "data inserted sucessfully", Toast.LENGTH_LONG).show();

                            }
                        }
                    });

                }


                open4Activity();

            }


        });

    }

    public void open4Activity(){
        Intent created = new Intent(this, MainActivity.class);
        startActivity(created);
    }
}
