package com.example.chousnthere_it;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ClassrmLoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classrm_lo_detail);
    }

    ImageView floorImg;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_classrm_lo_detail, container, false);

        ((TextView) rootView.findViewById(R.id.classrm_floor)).setText("1층");
        Drawable drawable=getResources().getDrawable(R.drawable.floor_1);
        floorImg = (ImageView) rootView.findViewById(R.id.floor_img);
        floorImg.setImageDrawable(drawable);

        return rootView;
    }
}
