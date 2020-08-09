package com.example.aluminiadminapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class TransactionTable extends AppCompatActivity {
    DatabaseReference databaseReference;
    message1 smessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_table);
        final ListView mlistview=findViewById(R.id.Listview);
        databaseReference= FirebaseDatabase.getInstance().getReference("Transaction");

        smessage=new message1();




        final ArrayList<message1> messagelist= new ArrayList<>();


        final MessageListAdaptor adaptor= new MessageListAdaptor(TransactionTable.this,R.layout.simple_view,messagelist);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    smessage=ds.getValue(message1.class);
                    message1 m1=new message1(smessage.getName(),smessage.getEmail(),smessage.getTransactionid(),smessage.getBatch(),smessage.getAmount());
                    messagelist.add(m1);
                }
                mlistview.setAdapter(adaptor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}