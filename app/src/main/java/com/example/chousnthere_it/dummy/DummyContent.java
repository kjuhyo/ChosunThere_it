package com.example.chousnthere_it.dummy;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chousnthere_it.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent extends AppCompatActivity {
    private static int buildingNum = 33; //대학건물 수


    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = buildingNum;

    static {
        // Add some sample items.

        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position),buildingArr(position) , makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }
    private static String buildingArr(int position) {
        String output = null;
        String[] buildingArr2 = new String[]{
                "IT 융합대학","인문과학대학","자연과학대학","법과대학","사회과학대학","경상대학",
                "공과대학 제 1공학관","공과대학 제 2공학관","사범대학","외국어대학","체육대학",
                "의과대학","치과대학","약학대학","미술대학","기초교육대학","보건과학대학",
                "미래사회융합대학","중앙도서관","해오름관", "입석홀","글로벌하우스","서석홀",
                "백학학사","본관","솔마루","황금추관","학생회관","장황남 정보통신박물관","국제관",
                "법학도서관","선박해양공학관","항공우주공학관" };
       for(int i=0; i<buildingArr2.length-1; i++) {
           if(i==position) {
               output = buildingArr2[position];
           }
       }
        StringBuilder builder = new StringBuilder();
        builder.append(output);


        return builder.toString();
    }
    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
