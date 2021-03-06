package com.example.teamproject;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MyGridViewAdapter extends BaseAdapter {
    private ArrayList<item> mItems = new ArrayList<item>();
    private Context mContext;
    private int mResource;
    MainActivity act = new MainActivity();


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

        Calendar mCal = Calendar.getInstance();

        int td = mCal.get(Calendar.DAY_OF_WEEK);
        int today = mCal.get(Calendar.DAY_OF_MONTH);
        int curMonth = mCal.get(Calendar.MONTH)+1;
        //blank ????????? 8-blank?????? ?????? ????????? ????????? ?????? ??????
        //String sMonth = String.valueOf(curMonth);
        String sToday = String.valueOf(today);

        if (sToday.equals(mItems.get(i).day) && curMonth==mItems.get(i).month) { //?????? day ????????? ?????? ??????

            tv_day.setBackgroundColor(Color.rgb(222,182,174));
            tv_day.setTextColor(Color.WHITE);

        }
        int j=0;

        while(true)
        {
            if(mItems.get(j).day!=" ")
                break;
            j++;
        }

        for(int k=8-j;k<= mItems.size();k+=7)
        {
            if(String.valueOf(k).equals(mItems.get(i).day))
                tv_day.setTextColor(Color.rgb(198,77,107));
        }
        for(int k=7-j;k<= mItems.size();k+=7)
        {
            if(String.valueOf(k).equals(mItems.get(i).day))
                tv_day.setTextColor(Color.rgb(32,109,171));
        }

        int displayHeight = act.getGridviewHeight();
        LinearLayout layout = convertView.findViewById(R.id.eachItem);
        //GridView view = findViewById(R.id.gridview);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)layout.getLayoutParams();
        params.height = displayHeight/7;
        layout.setLayoutParams(params);
        return convertView;
    }


}
