package com.example.chousnthere_it;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {
/*
    LayoutInflater inflater = null;
    private List<Classr> mclassr = null;
    private int nListCnt = 0;

    public ListViewAdapter(List<Classr> classr) {
        mclassr = classr;
        nListCnt = mclassr.size();
    }

    @Override
    public int getCount() {
        Log.i("TAG", "getCount");
        return nListCnt;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int postion, View convertView, ViewGroup parent) {
        if (convertView == null) {
            final Context context = parent.getContext();
            if (inflater == null) {
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            convertView = inflater.inflate(R.layout.c_lo_item, parent, false);
        }

        TextView oTextCid = (TextView) convertView.findViewById(R.id.textCid);
        TextView oTextCname = (TextView) convertView.findViewById(R.id.textCname);
        TextView oTextU_id = (TextView) convertView.findViewById(R.id.textU_id);
        TextView oTextCom = (TextView) convertView.findViewById(R.id.textCom);

        oTextCid.setText(mclassr.get(postion).cid);
        oTextCname.setText(mclassr.get(postion).cname);
        oTextU_id.setText(mclassr.get(postion).u_id);
        oTextCom.setText(mclassr.get(postion).com);
        return convertView;
    }
}*/
        Context context;
        List<Classr> list;
        LayoutInflater inflate;
        ListViewAdapter.ViewHolder viewHolder;
     /*   TextView txtcid;
        TextView txtcname;
        TextView txtu_id;
        TextView txtcom;*/

    public ListViewAdapter(List < Classr > list, Context context) {
            this.list = list;
            this.context = context;
            this.inflate = LayoutInflater.from(context);
        }
       /* public void bind(String cid, String cname, int u_id, int com){
            txtcid.setText(cid);
            txtcname.setText(cname);
            txtu_id.setText(u_id);
            txtcom.setText(com);
        }*/

        @Override
        public int getCount () {
            return list.size();
        }

        @Override
        public Object getItem ( int i){
            return null;
        }

        @Override
        public long getItemId ( int i){
            return 0;
        }

        @Override
        public View getView ( int position, View convertView, ViewGroup viewGroup){
            if (convertView == null) {
                convertView = inflate.inflate(R.layout.c_lo_item, null);

                viewHolder = new ListViewAdapter.ViewHolder();
                viewHolder.c_label = convertView.findViewById(R.id.c_lo_view);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ListViewAdapter.ViewHolder) convertView.getTag();
            }

            //viewHolder.bind(list.get(position).getCid(), list.get(position).getCname(), list.get(position).getU_id(), list.get(position).getCom());

            return convertView;
        }

        class ViewHolder {
            public TextView c_label;
        }
    }

    /*Context mContext;
    List<Classr> IvList;
    int Position;
    RecyclerView.ViewHolder viewHolder;

    public ListViewAdapter(List<Classr> items, Context context){
        IvList=items;
        mContext=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_listview, parent, false);
        return new RecyclerView.ViewHolder(view);
    }

   *//* public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
        //ListView의 getView 부분을 담당하는 메소드
        ((ViewHolder) holder).onBind(IvList.get(position));
    }*//*

    @Override
    public int getItemCount(){
        return IvList.size();//데이터 갯수 리턴
    }

    *//*public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mcid;
        public TextView mcname;
        public TextView mu_id;
        public TextView mcom;

        public ViewHolder(View itemView){
            super(itemView);
            //화면에 표시될 View로부터 위젯에 대한 참조 획득
            mcid=itemView.findViewById(R.id.label);
            mcname=itemView.findViewById(R.id.label);
            mu_id=itemView.findViewById(R.id.label);
            mcom=itemView.findViewById(R.id.label);
        }

        public void onBind(Classr item){
            mcid.setText(item.getCid());
            mcname.setText(item.getCname());
            mu_id.setText(item.getU_id());
            mcom.setText(item.getCom());
        }
    }*//*
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            convertView = inflate.inflate(R.layout.sub_listview,null);

            viewHolder = new RecyclerView.ViewHolder();
            viewHolder.label = convertView.findViewById(R.id.label);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (SearchAdapter.ViewHolder)convertView.getTag();
        }

        viewHolder.label.setText(list.get(position));

        return convertView;
    }

    class ViewHolder{
        public TextView label;
    }
*/

