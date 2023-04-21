package com.example.ktra2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ktra2.R;
import com.example.ktra2.UpdateDeleteActivity;
import com.example.ktra2.adapter.RecycleViewAdapter;
import com.example.ktra2.dal.SQLiteHelper;
import com.example.ktra2.model.Item;

import java.util.ArrayList;
import java.util.List;


public class FragmentList extends Fragment implements RecycleViewAdapter.ItemListener{
    private RecyclerView recyclerView;
    RecycleViewAdapter adapter;
    private SQLiteHelper db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recycleView);
        recyclerView.removeAllViews();
        adapter=new RecycleViewAdapter();
        db=new SQLiteHelper(getContext());
        List<Item> list= db.getAll();
//        Item i = new Item("Don nha","Don tang 3 va 4","12/02/2023","chua xong",false);
//        list.add(i);
        adapter.setList(list);
        adapter.notifyDataSetChanged();
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setItemListener(this);


    }

    @Override
    public void onItemClick(View view, int position) {

        Item item=adapter.getItem(position);
        Intent intent=new Intent(getActivity(), UpdateDeleteActivity.class);
        intent.putExtra("item",item);
        startActivity(intent);

    }
}
