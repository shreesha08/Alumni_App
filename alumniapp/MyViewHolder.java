package com.example.alumniapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView Name,Email,Phone,Batch,Profession,Institution,Address;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        Name=itemView.findViewById(R.id.namess);
        Email=itemView.findViewById(R.id.emailss);
        Phone=itemView.findViewById(R.id.phoness);
        Batch=itemView.findViewById(R.id.batchss);
        Profession=itemView.findViewById(R.id.professionss);
        Institution=itemView.findViewById(R.id.addressss);
    }
}
