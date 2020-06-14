package com.example.cardviewdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private SportsAdapter sportsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.myRecyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        sportsAdapter = new SportsAdapter(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(sportsAdapter);

        String[] sportsTitle = getResources().getStringArray(R.array.sports_titles);
        String[] sportsInfo = getResources().getStringArray(R.array.sports_info);

        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_images);

        for(int i=0;i<sportsTitle.length;i++) {
            Sport sport1 = new Sport(sportsTitle[i], sportsInfo[i], sportsImageResources.getResourceId(i, 0));
            sportsAdapter.addSportsToList(sport1);
        }
    }
}

