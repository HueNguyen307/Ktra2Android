package com.example.ktra2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ktra2.R;
import com.example.ktra2.model.Item;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.HomeViewHolder> {
    private List<Item> list;
    private ItemListener itemListener;
    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }
    public RecycleViewAdapter() {

        list=new ArrayList<>();
    }
    public void setList(List<Item> list) {
        this.list = list;
//        notifyDataSetChanged();
    }
    public Item getItem(int posititon){
        return list.get(posititon);
    }
    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spiner,parent,false);

        return new HomeViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Item item=list.get(position);
        holder.title.setText(item.getTitle());
        holder.des.setText(item.getDescription());
        holder.date.setText(item.getDate());
        holder.status.setText(item.getStatus());
        if (item.getTeam())
            holder.team.setText("1 minh");
        else
            holder.team.setText("chung");
    }

    @Override
    public int getItemCount() {

        return list.size();
    }
    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView title,des,date,status,team;
        public HomeViewHolder(@NonNull View view) {
            super(view);
            title=view.findViewById(R.id.tvTitle);
            des=view.findViewById(R.id.tvDes);
            date=view.findViewById(R.id.tvDate);
            status=view.findViewById(R.id.tvStatus);
            team=view.findViewById(R.id.tvTeam);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(itemListener!=null){
                itemListener.onItemClick(view,getAdapterPosition());
            }
        }
    }
    public interface ItemListener{
        void onItemClick(View view, int position);
    }
}
