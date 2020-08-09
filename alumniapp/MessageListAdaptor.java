package com.example.alumniapp;

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

public class MessageListAdaptor extends ArrayAdapter<message> {
    private Context mContext;
    private int mResoures;
    private  int lasPosition=-1;
    static class ViewHolder {
        TextView messagee;
        TextView Datee;

    }

    public MessageListAdaptor(@NonNull Context context, int resource, @NonNull ArrayList<message> objects) {
        super(context, resource, objects);
        mContext = context;
        mResoures=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String messa=getItem(position).getMssg();
        String datte=getItem(position).getDate();
        message nmessage= new message(messa,datte);
        final View result;
        ViewHolder holder;
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResoures, parent, false);
            holder = new ViewHolder();
            holder.messagee = convertView.findViewById(R.id.prici);
            holder.Datee = convertView.findViewById(R.id.date);
            result = convertView;
            convertView.setTag(holder);
        }
        else
        {
            holder=(ViewHolder)convertView.getTag();
            result=convertView;
        }

        Animation animation= AnimationUtils.loadAnimation(mContext,
                (position>lasPosition)? R.anim.load_down_anim:R.anim.load_up_anim);
        result.startAnimation(animation);
        lasPosition=position;

        holder.messagee.setText(messa);
        holder.Datee.setText(datte);


        return convertView;

    }
}
