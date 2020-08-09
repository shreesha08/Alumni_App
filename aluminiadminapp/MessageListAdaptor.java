package com.example.aluminiadminapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MessageListAdaptor extends ArrayAdapter<message1> {
    private Context mContext;
    private int mResoures;
    private  int lasPosition=-1;
    static class ViewHolder {
        TextView rname;
        TextView remail;
        TextView rtid;
        TextView rbatch;
        TextView ramt;



    }

    public MessageListAdaptor(@NonNull Context context, int resource, @NonNull ArrayList<message1> objects) {
        super(context, resource, objects);
        mContext = context;
        mResoures=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String sname=getItem(position).getName();
        String semail=getItem(position).getEmail();
        String stid=getItem(position).getTransactionid();
        String sbat=getItem(position).getBatch();
        String samt=getItem(position).getAmount();
       // message1 nmessage= new message1(sname,semail,stid,sbat,);
        final View result;
        ViewHolder holder;
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResoures, parent, false);
            holder = new ViewHolder();
            holder.rname = convertView.findViewById(R.id.name);
            holder.remail = convertView.findViewById(R.id.email);
            holder.rtid = convertView.findViewById(R.id.tid);
            holder.rbatch = convertView.findViewById(R.id.batch);
            holder.ramt = convertView.findViewById(R.id.amount);
            result = convertView;
            convertView.setTag(holder);
        }
        else
        {
            holder=(ViewHolder)convertView.getTag();
            result=convertView;
        }

        Animation animation= AnimationUtils.loadAnimation(mContext,
                (position>lasPosition)? R.anim.load_down:R.anim.load_up);
        result.startAnimation(animation);
        lasPosition=position;

        holder.rname.setText(sname);
        holder.remail.setText(semail);
        holder.rtid.setText(stid);
        holder.rbatch.setText(sbat);
        holder.ramt.setText(samt);


        return convertView;

    }
}