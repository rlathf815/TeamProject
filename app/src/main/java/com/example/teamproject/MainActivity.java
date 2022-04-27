package com.example.teamproject;        //재전송

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import android.content.res.ColorStateList;
import android.graphics.Color;


public class MainActivity extends AppCompatActivity {
    static MyGridViewAdapter adapter;
    int[] info = new int[4];
    public static int[] current = new int[3];

    MonthViewActivity mva = new MonthViewActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setWindowAnimations(0); //화면전환효과 삭제
        setGridviewHeight();
        Intent myIntent = getIntent();
        int weightVal = myIntent.getIntExtra("month", 0);

        if(weightVal == 0)
            current = mva.calcCal();

        if(current[1]==1 && weightVal==-1)
        {
            current[0] = current[0]+weightVal;
            current[1]=12;
        }
        else if(current[1]==12 && weightVal==1)
        {
            current[0] = current[0]+weightVal;
            current[1]=1;
        }
        else
        {
            current[1] = current[1] + weightVal;
        }

        System.out.println("current 값은 :"+current[1]+ "  weight값은: " + weightVal);

        info = mva.calcInfo(current);

        TextView nowDate;
        nowDate = (TextView)findViewById(R.id.YearMonth);


        ArrayList<item> data = new ArrayList<item>();
        for (int i=0; i <info[0]-1; i++) {
            data.add(new item(" ","","","",current[1]));
        }
        for (int i=0; i < info[1]; i++) {
            data.add(new item(""+(i+1),"","","",current[1]));
        }
        for (int i=0; i<(43-(info[0]+info[1])); i++) {
            data.add(new item(" ","","","",current[1]));
        }
        nowDate.setText(current[0] + "년 " + current[1] + "월");

        adapter = new MyGridViewAdapter(this, R.layout.item_layout, data);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(adapter);
        System.out.println("--------------------------------------------------------------------month값은 "+current[1]);


        Button btn = findViewById(R.id.next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                //flag = true;
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("month",1);
                System.out.println("current값은"+current[1]);
                startActivity(intent);
                finish();
            }
        });

        Button btn2 = findViewById(R.id.previous);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                //flag = true;
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("month",-1);
                System.out.println("current값은"+current[1]);
                startActivity(intent);
                finish();
            }
        });
        //View view ;
        ArrayList<View> view = new ArrayList<View>();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View vClicked, int position, long id)
            {
                if(!view.isEmpty()) {
                    view.get(0).setBackgroundResource(R.drawable.none);
                    view.clear();
                }
                String day = ((item) adapter.getItem(position)).day;
                String year = String.valueOf(current[0]);
                String month = String.valueOf(current[1]);
                Toast.makeText(MainActivity.this, year + "." + month + "." + day,
                        Toast.LENGTH_SHORT).show();

                vClicked.setBackgroundResource(R.drawable.border);
                view.add(vClicked);
                System.out.println("-------------------view 추가됨?"+ !view.isEmpty());
            }
        });
    }
    private void setGridviewHeight(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getRealSize(size);
        int displayHeight = size.y;
        LinearLayout layout = findViewById(R.id.eachItem);
        //GridView view = findViewById(R.id.gridview);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)layout.getLayoutParams();
        params.height = displayHeight/7;
        layout.setLayoutParams(params);

    }
}