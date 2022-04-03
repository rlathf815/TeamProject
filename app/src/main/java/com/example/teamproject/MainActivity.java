package com.example.teamproject;        //재입력

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static MyGridViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 데이터 원본 준비
        //String[] items = new String[42];
        //for(int i=0;i<42;i++)
        //{
        //    items[i] = "1\n\n\n\n";
        //}

        //GridView gridview = findViewById(R.id.gridview);
        //MyGridViewAdapter adapter= new MyGridViewAdapter();
        ArrayList<item> data = new ArrayList<item>();
        for(int i=0;i<42;i++)
         {
            data.add(new item("1","","",""));
         }
        //gridview.setAdapter(adapter);


        adapter = new MyGridViewAdapter(this, R.layout.item_layout, data);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(adapter);
        //어댑터 준비 (배열 객체 이용, simple_list_item_1 리소스 사용

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View vClicked,
                                    int position, long id) {
                //   String name = (String) ((TextView)vClicked.findViewById(R.id.textItem1)).getText();
                String day = ((item) adapter.getItem(position)).day;
                Toast.makeText(MainActivity.this, day + " selected",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}