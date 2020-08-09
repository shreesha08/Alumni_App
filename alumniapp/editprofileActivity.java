package com.example.alumniapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

public class editprofileActivity extends AppCompatActivity {
    private EditText editname,editemail,editbatch,editprofession,editInstitution,editphone,editaddress;
    private Button editbutt;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseFirestore fstore, fstore1;
     DocumentReference documentReference;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        editname=findViewById(R.id.re_name1);
        //editemail=findViewById(R.id.re_email1);
        editbatch=findViewById(R.id.re_batch1);
        editprofession=findViewById(R.id.re_profession1);
        editInstitution=findViewById(R.id.re_IName1);
        editphone=findViewById(R.id.re_phone1);
        editaddress=findViewById(R.id.re_address1);
        editbutt=findViewById(R.id.re_button1);

        firebaseAuth= FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();
        fstore=FirebaseFirestore.getInstance();
        documentReference=fstore.collection("users").document(MainActivity.eemail);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                    String Rname = documentSnapshot.getData().get("name").toString();
                   // String Remail = documentSnapshot.getData().get("email").toString();
                    String Rbatch = documentSnapshot.getData().get("batch").toString();
                    String Rprofession = documentSnapshot.getData().get("profession").toString();
                    String Rinstitution = documentSnapshot.getData().get("institution").toString();
                    String RphoneNo = documentSnapshot.getData().get("phoneNo").toString();
                    String Raddress = documentSnapshot.getData().get("address").toString();
                    editname.setText(Rname);
                    //editemail.setText(Remail);
                    editbatch.setText(Rbatch);
                    editprofession.setText(Rprofession);
                    editInstitution.setText(Rinstitution);
                    editphone.setText(RphoneNo);
                    editaddress.setText(Raddress);
                }

            }




        );
        editbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=editname.getText().toString().trim();
                String ubatch=editbatch.getText().toString().trim();
                String uprofession=editprofession.getText().toString().trim();
                String uinstitution=editInstitution.getText().toString().trim();
                String uphone=editphone.getText().toString().trim();
                String uaddress=editaddress.getText().toString().trim();
                documentReference=fstore.collection("users").document(MainActivity.eemail);
                documentReference.update("name",uname,"batch",ubatch,"profession",uprofession,"institution",uinstitution,"phoneNo",uphone,"address",uaddress).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(editprofileActivity.this,"data updated sucessfully",Toast.LENGTH_SHORT).show();
                        }



                    }
                });
                openProfile();
            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.example_menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.item1:
                Intent c= new Intent(editprofileActivity.this,Main4Activity.class);
                startActivity(c);
                return  true;
            case R.id.item2:
                Intent d=new Intent(editprofileActivity.this,Main7Activity.class);
                startActivity(d);
                return  true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void openProfile(){
        Intent i2= new Intent(editprofileActivity.this,Main4Activity.class);
        startActivity(i2);
    }
    }

