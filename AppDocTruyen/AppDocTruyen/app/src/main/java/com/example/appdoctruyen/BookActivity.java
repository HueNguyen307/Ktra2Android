package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appdoctruyen.adapter.RecycleViewAdapter;
import com.example.appdoctruyen.adapter.RecycleViewAdapterChapList;
import com.example.appdoctruyen.model.Book;
import com.example.appdoctruyen.model.Chap;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity implements RecycleViewAdapterChapList.ItemListener,RecycleViewAdapter.ItemListener{
    private RecyclerView recyclerView,
            recycleBook;
    RecycleViewAdapterChapList adapter;
    RecycleViewAdapter adapterbook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        recyclerView=findViewById(R.id.recycleChap);
        recycleBook=findViewById(R.id.recycleBook);

        List<Chap> list=new ArrayList<>();
        adapter=new RecycleViewAdapterChapList();
        Chap c=new Chap("Chuong 1");
        list.add(c);
        adapter.setList(list);

        Context context = recyclerView.getContext();
        LinearLayoutManager manager=new LinearLayoutManager(context,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setItemListener(this);

        List<Book> listbook=new ArrayList<>();
        adapterbook=new RecycleViewAdapter();
        Book b1 = new Book("Truyen tuong tu 1");
        Book b2 = new Book("Truyen tuong tu 2");
        Book b3 = new Book("Truyen tuong tu 3");
        listbook.add(b1);
        listbook.add(b2);
        listbook.add(b3);
        adapterbook.setList(listbook);
//
        Context contextbook = recycleBook.getContext();
        LinearLayoutManager managerbook=new LinearLayoutManager(context,RecyclerView.VERTICAL,false);
        recycleBook.setLayoutManager(managerbook);
        recycleBook.setAdapter(adapterbook);
        adapterbook.setItemListener(this);
    }

    @Override
//    public void onItemClick(View view, int position) {
//
//    }
    public void onItemClick(View view, int position) {
//        //adapter de click vao dc
        Chap chap=adapter.getItem(position);
        Intent intent=new Intent(BookActivity.this, ChapActivity.class);
//        intent.putExtra("book",book);
        startActivity(intent);

//        Book book=adapterbook.getItem(position);
//        Intent intent1=new Intent(BookActivity.this,BookActivity.class);
//        startActivity(intent1);
    }



}