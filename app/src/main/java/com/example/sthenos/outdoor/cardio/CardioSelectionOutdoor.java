package com.example.sthenos.outdoor.cardio;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sthenos.Adapter;
import com.example.sthenos.R;
import com.example.sthenos.indoor.cardio.JumpRope;
import com.example.sthenos.indoor.cardio.Swimming;

import java.util.ArrayList;
import java.util.List;

public class CardioSelectionOutdoor extends AppCompatActivity implements Adapter.OnSelectionListener {

    //Variables
    RecyclerView outdoorDataList;
    List<String> titles;
    List<Integer> images;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This Line will make the status bar from the screen see through
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_selection_outdoor);

        /*--------Hooks---------*/
        outdoorDataList = findViewById(R.id.recyclerOutdoorDataList);

        /*--------Creating Lists---------*/
        titles = new ArrayList<>();
        images = new ArrayList<>();

        /*--------Title list---------*/
        titles.add("Running"); //Novice lvl
        titles.add("Jump rope");
        titles.add("Swimming");
        titles.add("Bike riding");
        //titles.add("");


        /*--------Image list---------*/
        images.add(R.drawable.runing);
        images.add(R.drawable.jumprope);
        images.add(R.drawable.swiming);
        images.add(R.drawable.bikeriding);
        //images.add(R.drawable.);


        /*--------Adapter---------*/
        adapter = new Adapter(this, titles, images, this);

        /*--------Creating the grid Layout---------*/
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);

        /*--------Setting the RecyclerView---------*/
        outdoorDataList.setLayoutManager(gridLayoutManager);
        outdoorDataList.setAdapter(adapter);

    }

    @Override
    public void onSelectionClick(int position) {
        switch (position){
            case 0:
                Intent run = new Intent(this, Runing.class);
                startActivity(run);
                break;
            case 1:
                Intent jumprope = new Intent(this, JumpRopeOutdoor.class);
                startActivity(jumprope);
                break;
            case 2:
                Intent swiming = new Intent(this, SwimmingOutdoor.class);
                startActivity(swiming);
                break;
            case 3:
                Intent bikeriding = new Intent(this, BikeRiding.class);
                startActivity(bikeriding);
                break;

        }
    }
}
