package com.example.chousnthere_it;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Classroom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom);
    }

    public void onClick_C_location(View view){
        Intent intent = new Intent(this, Classroom_Location.class);
        startActivity(intent);
    }

    public void onClick_C_empty(View view){
        Intent intent = new Intent(this, Classroom_empty.class);
        startActivity(intent);
    }
}
