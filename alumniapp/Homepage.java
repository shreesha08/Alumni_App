package com.example.alumniapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Main4Activity extends AppCompatActivity {
    Button butt1,butt2,butt3,butt4,btran,bmsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        //butt1=findViewById(R.id.button4);
        //butt2=findViewById(R.id.button3);
        butt3=findViewById(R.id.button5);
        bmsg=findViewById(R.id.button20);
        //butt4=findViewById(R.id.button6);
        //btran=findViewById(R.id.butran);
       /* butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openprofile();
            }
        });
        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });*/
       bmsg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openmessage();
           }
       });
        butt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendonation();
            }
        });
       /* btran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentran();
            }
        });*/
       /* butt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu){
            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.example_menu,menu);
        return true;
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.item1:
                openprofile();
                return  true;
            case R.id.item2:
                logout();
                return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openprofile(){
        Intent profile=new Intent(this,Main6Activity.class);
        startActivity(profile);
        }

        public void logout(){
        Intent log= new Intent(this,MainActivity.class);
        startActivity(log);
        }

        public void opendonation()
        {
            Intent don= new Intent(this,Main5Activity.class);
            startActivity(don);
        }
        public void opentran() {
            Intent oot = new Intent(this, trancation.class);
            startActivity(oot);
        }
        public void openmessage() {
            Intent oms = new Intent(Main4Activity.this, Main8Activity.class);
            startActivity(oms);
        }


    }


