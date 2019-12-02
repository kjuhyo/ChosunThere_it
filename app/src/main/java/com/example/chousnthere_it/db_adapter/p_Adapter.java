package com.example.chousnthere_it.db_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.chousnthere_it.Model.Prof;
import com.example.chousnthere_it.R;

import java.util.List;

class SearchViewHolderForP extends RecyclerView.ViewHolder {
    public TextView name, call, location, u_id;


    public SearchViewHolderForP(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.name);
        call = (TextView) itemView.findViewById(R.id.call);
        location = (TextView) itemView.findViewById(R.id.location);
        u_id = (TextView) itemView.findViewById(R.id.u_id);
    }
}
    public class p_Adapter extends RecyclerView.Adapter<SearchViewHolderForP> {

        private Context context;
        private List<Prof> prof;

        public p_Adapter(Context context, List<Prof> prof){
            this.context=context;
            this.prof=prof;
        }

        @Override
        public SearchViewHolderForP onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater inflater=LayoutInflater.from(parent.getContext());
            View itemView=inflater.inflate(R.layout.prof_item, parent, false);

            return new SearchViewHolderForP(itemView);
        }

        @Override
        public void onBindViewHolder(SearchViewHolderForP holder, int position){
            holder.name.setText(prof.get(position).getName());
            holder.call.setText(prof.get(position).getCall());
            holder.location.setText(prof.get(position).getLocation());
            holder.u_id.setText(prof.get(position).getU_id());

        }

        @Override
        public int getItemCount(){
            return prof.size();
        }
    }


