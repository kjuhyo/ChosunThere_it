package com.example.chousnthere_it;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

/*import com.bumptech.glide.Glide;*/
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chousnthere_it.dummy.DummyContent;

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
            }
            else if(mItem.content.equals("인문과학대학") || mItem.content.equals("본관")  || mItem.content.equals("외국어대학")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_main_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
            }
            else if(mItem.content.equals("법과대학")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_law_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
            }

            else if(mItem.content.equals("사회과학대학") || mItem.content.equals("사범대학")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_edu_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
            }

            else if(mItem.content.equals("경상대학")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_kyeong_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
            }

            else if(mItem.content.equals("중앙도서관")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_library_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
            }
            else if(mItem.content.equals("학생회관")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_student_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
            }
            else if(mItem.content.equals("체육대학")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_physical_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
            }
            else if(mItem.content.equals("미술대학")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_art_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
            }
            else if(mItem.content.equals("치과대학")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_den_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
            }
            else if(mItem.content.equals("의과대학")) {
                Drawable drawable=getResources().getDrawable(R.drawable.u_doc_hall);
                U_image = (ImageView) rootView.findViewById(R.id.univ_image);
                U_image.setImageDrawable(drawable);
            }

            ((TextView) rootView.findViewById(R.id.univ_detail)).setText(mItem.details);
        }

        return rootView;
    }
}
