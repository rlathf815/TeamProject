package com.example.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 데이터 원본 준비
        //String[] items = new String[42];
       // for(int i=0;i<42;i++)
      //  {
      //      items[i] = "1\n\n\n\n";
       // }
        GridView gridview = findViewById(R.id.gridview);
        MyGridViewAdapter adapter= new MyGridViewAdapter();

        for(int i=0;i<42;i++)
        {
            adapter.addItem(new item(1,"","","",""));
        }
        gridview.setAdapter(adapter);


        //어댑터 준비 (배열 객체 이용, simple_list_item_1 리소스 사용
     //   ArrayAdapter<String> adapt
      //          = new ArrayAdapter<String>(
     //           this,
     //           android.R.layout.simple_list_item_1,
     //           items);

        // id를 바탕으로 화면 레이아웃에 정의된 GridView 객체 로딩
        //GridView gridview = (GridView) findViewById(R.id.gridview);
        // 어댑터를 GridView 객체에 연결
       // gridview.setAdapter(adapt);

    }
}