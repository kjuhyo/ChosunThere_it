package com.example.chousnthere_it;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

/*import com.bumptech.glide.Glide;*/
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.fragment.app.Fragment;


import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import android.widget.TextView;

import com.example.chousnthere_it.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a single Univ detail screen.
 * This fragment is either contained in a {@link UnivListActivity}
 * in two-pane mode (on tablets) or a {@link UnivDetailActivity}
 * on handsets.
 */
public class UnivDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public UnivDetailFragment() {
    }

    ImageView U_image;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.

            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.univ_detail, container, false);

        // Show the dummy content as text in a TextView.
        /*"IT 융합대학","인문과학대학","자연과학대학","법과대학","사회과학대학","경상대학",
                "공과대학 제 1공학관","공과대학 제 2공학관","사범대학","외국어대학","체육대학",
                "의과대학","치과대학","약학대학","미술대학","기초교육대학","보건과학대학",

                "미래사회융합대학","중앙도서관","해오름관", "입석홀","글로벌하우스","서석홀",
                "백학학사","본관","솔마루","황금추관","학생회관","장황남 정보통신박물관","국제관",
                "법학도서관","선박해양공학관","항공우주공학관"*/
        if (mItem != null) {
            if(mItem.content.equals("IT 융합대학")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_it_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
                ((TextView) rootView.findViewById(R.id.univ_detail)).setText("★교학팀 1층 062-230-6036\n★SW융합교육원 4층 062-230-6264 \n★전자공학부\n   학과실 1층 062-230-7070\n   학생회실 9202호 062-230-2693\n★컴퓨터공학과\n   학과실 4층 062-230-3781\n   학생회실 4020호 062-230-3345\n★정보통신공학과\n   학과실 3층 062-230-7081\n   학생회실 3049호 062-223-3838\n★매점 5층\n★프린트 2,5층\n★자판기,식수대 2,7,8,9,10층");

            }
            else if(mItem.content.equals("인문과학대학") || mItem.content.equals("본관")  || mItem.content.equals("외국어대학")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_main_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
                if(mItem.content.equals("인문과학대학")){
                    ((TextView) rootView.findViewById(R.id.univ_detail)).setText("★교학팀 4층 062-230-2036\n★국어국문학과\n   학과실 1층 062-230-6514\n   학생회실 9202호 062-230-2693\n★영어영문과\n   학과실 4층 062-230-6559\n   학생회실 4020호 062-230-3345\n★역사문화학과\n   학과실 3층 062-230-6557\n   학생회실 3049호 062-223-3838\n★매점 2층\n★프린트 3,4층\n★식수대 3층");
                }else if(mItem.content.equals("본관")){
                    ((TextView) rootView.findViewById(R.id.univ_detail)).setText("인문과학대학/외국어대학\n★매점 5층\n★프린트 3층\n★식수대 4층");
                }else if(mItem.content.equals("외국어대학")){
                    ((TextView) rootView.findViewById(R.id.univ_detail)).setText("★교학팀 2층 062-230-4436\n★아랍어과\n   학과실 1층 062-230-7261\n   학생회실 9202호 062-230-2693\n★영어과\n   학과실 4층 062-230-6942\n   학생회실 4020호 062-230-3345\n★러시아어과\n   학과실 3층 062-230-7273\n   학생회실 3049호 062-223-3838\n★매점 3층\n★프린트 3,5,7층\n");
                }
            }
            else if(mItem.content.equals("법과대학")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_law_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
                ((TextView) rootView.findViewById(R.id.univ_detail)).setText("★법학과\n   학과실 2층 062-230-6747\n   학생회실 9203호 062-230-2693\n★경찰행정학과\n   학과실 4층 062-230-6783\n   학생회실 4020호 062-230-3345\n★매점 4층\n★프린트 3층\n★식수대 2,3,4층");
            }

            else if(mItem.content.equals("사회과학대학") || mItem.content.equals("사범대학")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_edu_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
                if(mItem.content.equals("사회과학대학")){
                    ((TextView) rootView.findViewById(R.id.univ_detail)).setText("★교학팀 3층 062-230-7302\n★정치외교학부\n   학과실 1층 062-230-6808\n   학생회실 9202호 062-230-6821\n★행정복지학부\n   학과실 4층 062-230-6828\n   학생회실 4020호 062-230-3345\n★신문방송학과\n   학과실 3층 062-230-6809\n   학생회실 3049호 062-223-3838\n★매점 2층\n★프린트 3층\n★식수대 2,3,4층");
                }else if(mItem.content.equals("사범대학")){
                    ((TextView) rootView.findViewById(R.id.univ_detail)).setText("★교학팀 3층 062-230-7302\n★국어교육학과\n   학과실 5층 062-230-6823\n   학생회실 9202호 062-230-1211\n★수학교육학과\n   학과실 4층 062-230-6828\n   학생회실 4020호 062-230-3345\n★영어교육학과\n   학과실 3층 062-230-6809\n   학생회실 3049호 062-223-3838\n★매점 5층\n★프린트 4층\n★식수대 2,3,4층");
                }
            }

            else if(mItem.content.equals("경상대학")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_kyeong_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
                ((TextView) rootView.findViewById(R.id.univ_detail)).setText("★교학팀 1층 062-230-6036\n★경제학과\n   학과실 1층 062-230-6808\n   학생회실 9202호 062-230-6821\n★경영학부\n   학과실 4층 062-230-6828\n   학생회실 4020호 062-230-3345\n★무역학과\n   학과실 3층 062-230-6809\n   학생회실 3049호 062-223-3838\n★매점 5층\n★프린트 3층\n★식수대 2,3,4층");
            }

            else if(mItem.content.equals("중앙도서관")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_library_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
                ((TextView) rootView.findViewById(R.id.univ_detail)).setText("★중앙도서관 062-230-7522\n★매점 1층\n★프린트 3층");
            }
            else if(mItem.content.equals("학생회관")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_student_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
                ((TextView) rootView.findViewById(R.id.univ_detail)).setText("★자판기 3층\n★프린트 3층\n★식수대 2,3,4층");
            }
            else if(mItem.content.equals("체육대학")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_physical_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
                ((TextView) rootView.findViewById(R.id.univ_detail)).setText("★교학팀 1층 062-230-6036\n★체육학과\n   학과실 1층 062-230-7402\n   학생회실 9202호 062-230-2693\n★태권도학과\n   학과실 4층 062-230-7415\n   학생회실 4020호 062-230-3345\n★공연예술무용학과\n   학과실 3층 062-230-7422\n   학생회실 3049호 062-223-3838\n★매점 5층\n★프린트 3층\n★식수대 4층");
            }
            else if(mItem.content.equals("미술대학")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_art_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
                ((TextView) rootView.findViewById(R.id.univ_detail)).setText("★교학팀 1층 062-230-6036\n★미술학과\n   학과실 1층 062-230-7805\n   학생회실 9202호 062-230-2693\n★시각디자인학과\n   학과실 4층 062-230-7834\n   학생회실 4020호 062-230-3345\n★회화학과\n   학과실 3층 062-230-7804\n   학생회실 3049호 062-223-3838\n★매점 5층\n★프린트 3층\n★식수대 4층");
            }
            else if(mItem.content.equals("치과대학")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_den_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
                ((TextView) rootView.findViewById(R.id.univ_detail)).setText("★교학팀 1층 062-230-6036\n★치의예과\n   학과실 1층 062-230-6866\n   학생회실 9202호 062-230-2693\n★치의학과\n   학과실 4층 062-230-6868\n   학생회실 4020호 062-230-3345\n★매점 4층\n★프린트 6층\n★식수대 4층");
            }
            else if(mItem.content.equals("의과대학")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_doc_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
                ((TextView) rootView.findViewById(R.id.univ_detail)).setText("★의예과\n   학과실 5층 062-230-6393\n   학생회실 9202호 062-230-2693\n★의학과\n   학과실 3037호 062-230-6393\n   학생회실 4020호 062-230-3345\n★간호학과\n   학과실 2024호 062-230-6334\n   학생회실 3049호 062-223-3838\n★매점 5층\n★프린트 3층\n★식수대 2,3,4층 ");
            }

            //이미지 없는 단과대학
            else if(mItem.content.equals("공과대학 제 1공학관")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_chosun);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
                ((TextView) rootView.findViewById(R.id.univ_detail)).setText("★교학팀 2층 062-230-7003, 7071\n" +
                        "건축공학전공/건축학전공(5년) \n" +
                        "광기술공학과 \n" +
                        "금속재료공학과 \n" +
                        "기계공학과 \n" +
                        "기계설계공학과 \n" +
                        "기계시스템미래자동차공학부 \n" +
                        "메카트로닉스공학과 \n" +
                        "산업공학과 \n");
            }
            else if(mItem.content.equals("공과대학 제 2공학관")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_chosun);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
                ((TextView) rootView.findViewById(R.id.univ_detail)).setText("★교학팀 2층 062-230-7003, 7071\n" +
                        "생명화학고분자공학과 \n" +
                        "생명화학공학과 \n" +
                        "선박해양공학과 \n" +
                        "신소재공학과 \n" +
                        "에너지자원공학과 \n" +
                        "용접접합과학공학과 \n" +
                        "원자력공학과 \n" +
                        "응용화학소재공학과 \n" +
                        "재료공학과 \n" +
                        "전기공학과 \n" +
                        "토목공학과 \n" +
                        "환경공학과 \n");
            }
            else if(mItem.content.equals("자연과학대학")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_chosun);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
                ((TextView) rootView.findViewById(R.id.univ_detail)).setText("★수학과\n   학과실  062-230-6393\n   학생회실 9202호 062-230-2693\n★컴퓨터통계학과\n   학과실 3037호 062-230-6393\n   학생회실 4020호 062-230-3345\n★식품영양학과\n   학과실 2024호 062-230-6334\n   학생회실 3049호 062-223-3838\n★매점 지하 1층\n★프린트 3층\n★식수대 2,3,4층 ");
            }
            else{
                Drawable drawable=getResources().getDrawable(R.drawable.u_chosun);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
                ((TextView) rootView.findViewById(R.id.univ_detail)).setText("업데이트를 기다려주세용");
            }


        }

        return rootView;
    }
}
