package com.example.swipetodelete;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.*;

public class MainActivity extends AppCompatActivity{

    RecyclerView recyclerView;
    MyAdapter adapter;
    List<String> countryList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =findViewById(R.id.recyclerview);
        countryList = new ArrayList<>();
        countryList.add("China");
        countryList.add("India");
        countryList.add("Bhutan");
        countryList.add("America");
        countryList.add("Brazil");
        countryList.add("Russia");
        countryList.add("Japan");
        countryList.add("Australia");
        countryList.add("France");
        countryList.add("South Africa");
        countryList.add("Canada");
        countryList.add("Pakistan");
        countryList.add("Oman");
        countryList.add("Qatar");
        countryList.add("Thailand");
        countryList.add("Nepal");
        countryList.add("Chad");
        countryList.add("Congo");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MyAdapter(countryList);


        ItemTouchHelper.SimpleCallback itemTouchHelper = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                Toast.makeText(MainActivity.this, countryList.get(position)+" item removed.", Toast.LENGTH_SHORT).show();
                adapter.deleteItem(position);
            }
        };
        new ItemTouchHelper(itemTouchHelper).attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(adapter);
    }


}
