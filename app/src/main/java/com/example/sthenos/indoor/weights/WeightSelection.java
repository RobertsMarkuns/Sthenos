package com.example.sthenos.indoor.weights;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sthenos.Adapter;
import com.example.sthenos.R;

import java.util.ArrayList;
import java.util.List;

public class WeightSelection extends AppCompatActivity implements Adapter.OnSelectionListener {

    //Variables
    RecyclerView indoorDataList;
    List<String> titles;
    List<Integer> images;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This Line will make the status bar from the screen see through
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_selection);

        /*--------Hooks---------*/
        indoorDataList = findViewById(R.id.recyclerIndoorDataList);

        /*--------Creating Lists---------*/
        titles = new ArrayList<>();
        images = new ArrayList<>();

        /*--------Title list---------*/
        titles.add("Bench press");
        //titles.add("");

        /*--------Image list---------*/
        images.add(R.drawable.benchpress);
        //images.add(R.drawable.);


        /*--------Adapter---------*/
        adapter = new Adapter(this, titles, images, this);

        /*--------Creating the grid Layout---------*/
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);

        /*--------Setting the RecyclerView---------*/
        indoorDataList.setLayoutManager(gridLayoutManager);
        indoorDataList.setAdapter(adapter);

    }

    @Override
    public void onSelectionClick(int position) {
        switch (position){
            case 0:
                Intent benchpress = new Intent(this, Benchpress.class);
                startActivity(benchpress);
                break;
        }
    }
}
