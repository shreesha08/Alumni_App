package com.example.alumniapp;

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

public class Main8Activity extends AppCompatActivity {
    DatabaseReference databaseReference;
    message smessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        final ListView mlistview=findViewById(R.id.Listview);
        databaseReference= FirebaseDatabase.getInstance().getReference("Message");
        smessage=new message();




        final ArrayList<message> messagelist= new ArrayList<>();


        final MessageListAdaptor adaptor= new MessageListAdaptor(Main8Activity.this,R.layout.adapter_view,messagelist);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    smessage=ds.getValue(message.class);
                    message m1=new message(smessage.getMssg(),smessage.getDate());
                    messagelist.add(m1);
                }
                mlistview.setAdapter(adaptor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
                Intent c= new Intent(Main8Activity.this,Main4Activity.class);
                startActivity(c);
                return  true;
            case R.id.item2:
                Intent d=new Intent(Main8Activity.this,Main7Activity.class);
                startActivity(d);
                return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}
