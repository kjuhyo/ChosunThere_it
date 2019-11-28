package com.example.chousnthere_it;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Classroom_Location extends AppCompatActivity {

    Context context;
    private ListView listView =null; //목록 보여줌
    //ImageView imageView;
    //EditText editSearch; //검색창
    //ListViewAdapter adapter; //어댑터
    List<Classr> classrList; //강의실 리스트 선언


    //테이블의 데이터를 받는 메소드
    private void initLoadDB(){

        DataAdapter mdbhelper = new DataAdapter(getApplicationContext());
        mdbhelper.createDatabase();
        mdbhelper.open();

        //classrList에 데이터를 받아왔다
        classrList=mdbhelper.getClassrData();

        mdbhelper.close();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom_location);

       // editSearch = (EditText) findViewById(R.id.editSearch);
        //imageView=(ImageView)findViewById(R.id.searchbar);

        initLoadDB();

        listView=(ListView)findViewById(R.id.c_lo_view);
        ListViewAdapter oAdapter=new ListViewAdapter(classrList, context);
        listView.setAdapter(oAdapter);

      /*  adapter=new ListViewAdapter(classrList, context);
        //listView 객체에 adapter 객체를 연결.
        listView.setAdapter(adapter);*/



        /*//classrList를 ArrayAdapter 객체에 연결.
        ArrayAdapter<Classr> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, classrList);

        initLoadDB();

        //listView 객체에 adapter 객체를 연결.
        listView.setAdapter(adapter);*/


     /*   super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom_location);
        context=this.getBaseContext();

        listView=(RecyclerView)findViewById(R.id.recyview);
        listView.setHasFixedSize(true);

        initLoadDB();

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listView.setLayoutManager(layoutManager);

        searchAdapter=new SearchAdapter(classrList,this);
        listView.setAdapter(searchAdapter);*/
    }

}
