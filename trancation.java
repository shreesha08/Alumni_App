package com.example.alumniapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class trancation extends AppCompatActivity {
    Button bsub,btretry;
    String num;
    EditText ttname,ttemail,ttbatch,tttrans,ttphone,ttamount;
    FirebaseFirestore firebaseFirestore;
    DocumentReference documentReference;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trancation);
        bsub=findViewById(R.id.submit);
        num="1";
        btretry=findViewById(R.id.retry);
        ttname=findViewById(R.id.tname);
        ttemail=findViewById(R.id.temail);
        ttbatch=findViewById(R.id.tbatch);
        ttamount=findViewById(R.id.tamount);
        tttrans=findViewById(R.id.ttransaction);
        ttemail.setText(MainActivity.eemail);
        ttamount.setText(Main5Activity.amountET);
        ttphone=findViewById(R.id.tphone);
        firebaseFirestore=FirebaseFirestore.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Transaction");
        documentReference=firebaseFirestore.collection("transaction").document(MainActivity.eemail);

        btretry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent re= new Intent(trancation.this,Main5Activity.class);
                startActivity(re);
            }
        });
        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wname=ttname.getText().toString().trim();
                String wemail=ttemail.getText().toString().trim();
                String wbatch=ttbatch.getText().toString().trim();
                String wtrans=tttrans.getText().toString().trim();
                String wphone=ttphone.getText().toString().trim();
                String wamount=ttamount.getText().toString().trim();
                if(wname.isEmpty()){
                    ttname.setError("Name is Empty");
                    ttname.requestFocus();
                }
                else if((wbatch.length()<4)&& wbatch.isEmpty()){
                    ttbatch.setError("Batch Length is Less than 4 or Batch Field is Empty");
                    ttbatch.requestFocus();
                }
                else if((wtrans.isEmpty()) && (wtrans.length()<12) && (wtrans.length()>18)){
                    tttrans.setError("Transaction Id Entered Is Wrong");
                    tttrans.requestFocus();

                }else if(wphone.isEmpty() && (wphone.length()<10)){
                    ttphone.setError("Length of Phone Number is 10 digits");
                    ttphone.requestFocus();
                }
                else if(!(wname.isEmpty() &&(wbatch.length()<4)&& wbatch.isEmpty()&&(wtrans.isEmpty()) && (wtrans.length()<12) && (wtrans.length()>18) &&wphone.isEmpty() && (wphone.length()<10))){
                    trans t= new trans();
                    t.setName(wname);
                    t.setEmail(wemail);
                    t.setBatch(wbatch);
                    t.setTransactionid(wtrans);
                    t.setAmount(wamount);
                    t.setPhone(wphone);


                    databaseReference.push().setValue(t);

                    documentReference.set(t).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(trancation.this,"Transaction Details Have Been Sucessfully Sumbited",Toast.LENGTH_SHORT).show();
                                openproFile();

                            }
                            else if(!(task.isSuccessful()))
                            {
                                Toast.makeText(trancation.this,"Transaction Details Not Updated Please Try Again",Toast.LENGTH_SHORT).show();


                            }
                        }
                    });

                }



            }
        });
    }
    public void openproFile(){
        Intent op= new Intent(trancation.this,Main4Activity.class);
        startActivity(op);

    }


}
