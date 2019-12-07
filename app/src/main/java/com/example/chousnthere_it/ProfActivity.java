package com.example.chousnthere_it;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;

import com.example.chousnthere_it.db_adapter.p_Adapter;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;

public class ProfActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ImageView imageView;
    p_Adapter adapter;

    MaterialSearchBar materialSearchBar;
    List<String> suggestList=new ArrayList<>();
    dbhelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof);

        imageView = (ImageView)findViewById(R.id.prof_image);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_search);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        materialSearchBar=(MaterialSearchBar)findViewById(R.id.search_bar);


        dbhelper=new dbhelper(this);

        materialSearchBar.setHint("교수님 검색");
        materialSearchBar.setCardViewElevation(3);
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

        adapter=new p_Adapter(this, dbhelper.getProf());
        recyclerView.setAdapter(adapter);
    }

    private void loadSuggestList() {
        suggestList=dbhelper.getProfName();
        materialSearchBar.setLastSuggestions(suggestList);
    }

    private void startSearch(String text){
        adapter=new p_Adapter(this, dbhelper.getProfByName(text));
        recyclerView.setAdapter(adapter);
    }

}
