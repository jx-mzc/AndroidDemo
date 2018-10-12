package com.example.administrator.listviewtest;


import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SetAdapter extends ArrayAdapter<Set> {
    private int resourceId;
    public SetAdapter(Context context, int textViewResourceId, List<Set> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Set set = getItem(position);//获取当前项的Set实例
        View view;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }else {
            view = convertView;
        }
        ImageView setImage = (ImageView)view.findViewById(R.id.set_image);
        TextView setName = (TextView)view.findViewById(R.id.set_name);
        setImage.setImageResource(set.getImageId());
        setName.setText(set.getName());
        return view;
    }
}
