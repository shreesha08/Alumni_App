package com.example.alumniapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.FieldPosition;

public class Main10Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();

    CollectionReference reference=firebaseFirestore.collection("users");
    FirestoreRecyclerOptions<details>options;
    FirestoreRecyclerAdapter<details,MyViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        recyclerView=findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        ReadData();

    }

    private void ReadData() {



        options= new FirestoreRecyclerOptions.Builder<details>().setQuery(reference,details.class).build();
        adapter= new FirestoreRecyclerAdapter<details, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull details model) {
                holder.Name.setText(model.getName());
                holder.Email.setText(model.getEmail());
                holder.Phone.setText(model.getPhoneNo());
                holder.Batch.setText(model.getBatch());
                holder.Profession.setText(model.getProfession());
                holder.Institution.setText(model.getInstitution());
                holder.Address.setText(model.getAddress());

            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view,parent,false);
                return new MyViewHolder(view);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}
