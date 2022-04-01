package com.example.teamproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyGridViewAdapter extends BaseAdapter {
    ArrayList<item> items = new ArrayList<item>();
    Context context;


    public void addItem(item item)
    {
        items.add(item);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        context = parent.getContext();
        item item = items.get(i);

        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_layout, parent, false);

        }
        TextView tv_day = view.findViewById(R.id.textView_day);
        tv_day.setText(item.day);

        TextView tv_schedule1 = view.findViewById(R.id.textView_schedule1);
        tv_schedule1.setText(item.schedule1);

        TextView tv_schedule2 = view.findViewById(R.id.textView_schedule2);
        tv_schedule2.setText(item.schedule2);

        TextView tv_schedule3 = view.findViewById(R.id.textView_schedule3);
        tv_schedule3.setText(item.schedule3);

        TextView tv_schedule4 = view.findViewById(R.id.textView_schedule4);
        tv_schedule4.setText(item.schedule4);

        return view;
    }
}
