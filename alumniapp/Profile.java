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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Main6Activity extends AppCompatActivity {
    private ImageView profilePic;
    private TextView rvname,rvemail,rvbatch,rvstudent,rvcollege,rvpone,rvaddress;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore fstore;
    DocumentReference documentReference;
    FirebaseDatabase database;

    Button editbutt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        rvname=findViewById(R.id.textView11);
        rvemail=findViewById(R.id.textView12);
        rvbatch=findViewById(R.id.textView13);
        rvstudent=findViewById(R.id.textView14);
        rvcollege=findViewById(R.id.textView15);
        rvpone=findViewById(R.id.textView16);
        rvaddress=findViewById(R.id.textView17);
        profilePic=findViewById(R.id.imageView);
        editbutt=findViewById(R.id.button9);


        firebaseAuth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();

        database=FirebaseDatabase.getInstance();
        documentReference=fstore.collection("users").document(MainActivity.eemail);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                                                  @Override
                                                  public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                                                      String sname = documentSnapshot.getData().get("name").toString();
                                                      String semail = documentSnapshot.getData().get("email").toString();
                                                      String sbatch = documentSnapshot.getData().get("batch").toString();
                                                      String sprofession = documentSnapshot.getData().get("profession").toString();
                                                      String sinstitution = documentSnapshot.getData().get("institution").toString();
                                                      String sphoneNo = documentSnapshot.getData().get("phoneNo").toString();
                                                      String saddress = documentSnapshot.getData().get("address").toString();
                                                      rvname.setText(sname);
                                                      rvemail.setText(semail);
                                                      rvbatch.setText(sbatch);
                                                      rvstudent.setText(sprofession);
                                                      rvcollege.setText(sinstitution);
                                                      rvpone.setText(sphoneNo);
                                                      rvaddress.setText(saddress);
                                                  }
                                              });


        editbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openeditprofile();
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
                Intent c= new Intent(Main6Activity.this,Main4Activity.class);
                startActivity(c);
                return  true;
            case R.id.item2:
                Intent d=new Intent(Main6Activity.this,Main7Activity.class);
                startActivity(d);
                return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openeditprofile(){
        Intent openprofile = new Intent(Main6Activity.this,editprofileActivity.class);
        startActivity(openprofile);
    }
}
