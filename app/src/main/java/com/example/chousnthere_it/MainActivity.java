package com.example.chousnthere_it;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick_other(View view){
        Intent intent =new Intent(this, other.class);
        startActivity(intent);
    }

    public void onClick_classroom(View view){
        Intent intent=new Intent(this, Classroom.class);
        startActivity(intent);
    }

    public void onClick_univ(View view) {
        Intent intent=new Intent(this, UnivListActivity.class);
        startActivity(intent);
    }

    public void onClick_prof(View view) {
        Intent intent=new Intent(this, ProfActivity.class);
        startActivity(intent);
    }

}
