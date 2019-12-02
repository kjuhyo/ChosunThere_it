package com.example.chousnthere_it.db_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.chousnthere_it.Model.Classr;
import com.example.chousnthere_it.R;

import java.util.List;

class SearchViewHolder extends RecyclerView.ViewHolder{
    public TextView cname, u_id, floor, com;


    public SearchViewHolder(View itemView){
        super(itemView);
        cname=(TextView)itemView.findViewById(R.id.cname);
        u_id=(TextView)itemView.findViewById(R.id.u_id);
        floor=(TextView)itemView.findViewById(R.id.floor);
        com=(TextView)itemView.findViewById(R.id.com);
    }
}
public class c_Adapter extends RecyclerView.Adapter<SearchViewHolder> {

    private Context context;
    private List<Classr> classrs;

    public c_Adapter(Context context, List<Classr> classrs){
        this.context=context;
        this.classrs=classrs;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.c_lo_item, parent, false);

        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position){
        holder.cname.setText(classrs.get(position).getCname());
        holder.u_id.setText(classrs.get(position).getU_id());
        holder.floor.setText(classrs.get(position).getFloor());
        holder.com.setText(classrs.get(position).getCom());

    }

    @Override
    public int getItemCount(){
        return classrs.size();
    }
}

