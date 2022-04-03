package com.example.teamproject;        //재전송

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    static MyGridViewAdapter adapter;
    int[] info = new int[4];
    public static int[] current = new int[3];

    MonthViewActivity mva = new MonthViewActivity();
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent myIntent = getIntent();
        int weightVal = myIntent.getIntExtra("month", 0);

        if(weightVal == 0)
            current = mva.calcCal();

        current[1] = current[1] + weightVal;
        System.out.println("current 값은 :"+current[1]+ "  weight값은: " + weightVal);
        //System.out.println("count 값은 "+flag);

        info = mva.calcInfo(current);

        TextView nowDate;
        nowDate = (TextView)findViewById(R.id.YearMonth);


        ArrayList<item> data = new ArrayList<item>();
        for (int i=0; i <info[0]-1; i++) {
            data.add(new item(" ","","",""));
        }
        for (int i=0; i < info[1]; i++) {
            data.add(new item(""+(i+1),"","",""));
        }
        for (int i=0; i<(43-(info[0]+info[1])); i++) {
            data.add(new item(" ","","",""));
        }
        nowDate.setText(current[0] + "년 " + current[1] + "월");

        adapter = new MyGridViewAdapter(this, R.layout.item_layout, data);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(adapter);


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

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View vClicked, int position, long id)
            {
                String day = ((item) adapter.getItem(position)).day;
                Toast.makeText(MainActivity.this, day + " selected",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}