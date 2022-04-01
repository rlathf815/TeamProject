package com.example.teamproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyGridViewAdapter extends BaseAdapter {
    private ArrayList<item> mItems = new ArrayList<item>();
    private Context mContext;
    private int mResource;

    public MyGridViewAdapter(Context context, int resource,ArrayList<item> items)
    {
        mContext = context;
        mItems = items;
        mResource = resource;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mResource,parent,false);

        }
        TextView tv_day = convertView.findViewById(R.id.textView_day);
        tv_day.setText(mItems.get(i).day);

        TextView tv_schedule1 = convertView.findViewById(R.id.textView_schedule1);
        tv_schedule1.setText(mItems.get(i).schedule1);

        TextView tv_schedule2 = convertView.findViewById(R.id.textView_schedule2);
        tv_schedule2.setText(mItems.get(i).schedule2);

        TextView tv_schedule3 = convertView.findViewById(R.id.textView_schedule3);
        tv_schedule3.setText(mItems.get(i).schedule3);
        return convertView;
    }
}
