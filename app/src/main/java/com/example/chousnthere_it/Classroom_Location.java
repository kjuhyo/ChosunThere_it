package com.example.chousnthere_it;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class Classroom_Location extends AppCompatActivity {

    //강의실 리스트 선언
    public List<Classr> classrList;

    //테이블의 데이터를 받는 메소드
    private void initLoadDB(){

        DataAdapter mdbhelper = new DataAdapter(getApplicationContext());
        mdbhelper.createDatabase();
        mdbhelper.open();

        classrList=mdbhelper.getClassrData();

        mdbhelper.close();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ListView listView;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom_location);

        listView = (ListView) findViewById(R.id.listview);

        //classrList를 이용해 listview 보여주면 됨!
    }

}
