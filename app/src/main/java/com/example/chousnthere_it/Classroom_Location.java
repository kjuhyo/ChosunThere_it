package com.example.chousnthere_it;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.chousnthere_it.db_adapter.c_Adapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;

public class Classroom_Location extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    c_Adapter adapter;

    MaterialSearchBar materialSearchBar;
    List<String> suggestList=new ArrayList<>();
    dbhelper dbhelper;

    // 층 안내도 띄워주기_소영
    private void upFloorView() {
        Intent transferIntent = new Intent(getApplicationContext(), ClassrmLoDetailActivity.class);
        startActivityForResult(transferIntent, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom_location);

        // 층 안내도 띄워주기 위한 FAB_소영
        FloatingActionButton fabFloor = (FloatingActionButton) findViewById(R.id.fab_floor);
        fabFloor.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       upFloorView();
                                   }
        });

        recyclerView=(RecyclerView)findViewById(R.id.recycler_search);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        materialSearchBar=(MaterialSearchBar)findViewById(R.id.search_bar);

        dbhelper=new dbhelper(this);

        materialSearchBar.setHint("강의실 검색");
        materialSearchBar.setCardViewElevation(10);
        loadSuggestList();

        materialSearchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                List<String> suggest=new ArrayList<>();
                for(String search:suggestList){
                    if(search.toLowerCase().contains(materialSearchBar.getText().toLowerCase())){
                        suggest.add(search);
                    }
                }
                materialSearchBar.setLastSuggestions(suggest);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        materialSearchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {
                if(!enabled){
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onSearchConfirmed(CharSequence text) {
                startSearch(text.toString());
            }

            @Override
            public void onButtonClicked(int buttonCode) {

            }
        });

        adapter=new c_Adapter(this, dbhelper.getClassr());
        recyclerView.setAdapter(adapter);
    }

    private void loadSuggestList() {

        suggestList=dbhelper.getClassrName();
        materialSearchBar.setLastSuggestions(suggestList);
    }

    private void startSearch(String text){
        adapter=new c_Adapter(this, dbhelper.getClassrByName(text));
        recyclerView.setAdapter(adapter);
    }

}
