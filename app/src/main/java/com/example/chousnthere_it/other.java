package com.example.chousnthere_it;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

public class other extends AppCompatActivity {

    ListView listView; //목록 보여줌
    ImageView imageView;
    EditText editSearch; //검색창
    SearchAdapter adapter; //검색 위한 어댑터
    ArrayList<String> arraylist2; //데이터 복사본 담을 리스트
    List<String> list2; //데이터 담을 리스트

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        editSearch = (EditText) findViewById(R.id.editSearch);
        listView = (ListView) findViewById(R.id.listview);
        imageView=(ImageView)findViewById(R.id.searchbar);

        list2 = new ArrayList<>();

        other_List();

        // 리스트의 모든 데이터를 arraylist에 복사한다.
        arraylist2 = new ArrayList<>();
        arraylist2.addAll(list2);

        adapter = new SearchAdapter(list2, this);
        listView.setAdapter(adapter);


        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editSearch.getText().toString();
                search(text);
            }
        });


    }

    // 검색 수행하는 메소드
    public void search(String charText) {

        list2.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list2.addAll(arraylist2);
        }

        else {
            for (int i = 0; i < arraylist2.size(); i++) {
                if (arraylist2.get(i).toLowerCase().contains(charText)) {
                    list2.add(arraylist2.get(i));
                }
            }
        }

        adapter.notifyDataSetChanged();
    }

    public void other_List() {

        list2.add("◆솔마루학식\n중앙도서관 뒷편/ 해오름관 왼편 / 솔마루 2층");
        list2.add("◆글로벌학식\n법과대학 뒷편 / 글로벌하우스 2층");
        list2.add("◆백학사학식\n학생회관 왼편 / 백학학사 1층");
        list2.add("◆입석홀학식\n공대1호관 1층");
        list2.add("◆생활협동조합\n솔마루 1층");
        list2.add("◆보건진료소\n국제관 1층");
        list2.add("◆조대사진관\n솔마루 1층");
        list2.add("◆우체국\n체육대학 1층");
        list2.add("◆미용실\n솔마루 1층");
        list2.add("◆카페(마셔)\n솔마루푸드코트");
        list2.add("◆카페(엔젤말고)\n국제관 1층");
        list2.add("◆카페(엔젤말고)\n공대1호관 1층");
        list2.add("◆카페(블루팟_bluepot)\n글로벌하우스 2층");
        list2.add("◆은행(신협-atm)\n체육대학 1층");
        list2.add("◆은행(광주은행-창구)\n본관 북측");
        list2.add("◆중도복사\n중앙도서관 1층");
        list2.add("◆생협서점\n중앙도서관 1층");
    }


}



