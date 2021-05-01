package com.example.sthenos.indoor.weights;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sthenos.Adapter;
import com.example.sthenos.R;
import com.example.sthenos.indoor.squats.SquatsWeighted;

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
        titles.add("Bicep curls");
        titles.add("Dead lift");
        titles.add("Weighted Dips");
        titles.add("Weighted pull-ups");
        titles.add("Weighted push-ups");
        titles.add("Weighted squat");
        //titles.add("");

        /*--------Image list---------*/
        images.add(R.drawable.benchpress);
        images.add(R.drawable.crulbarbicepcurls);
        images.add(R.drawable.deadlift);
        images.add(R.drawable.weighteddips);
        images.add(R.drawable.weightedpullups);
        images.add(R.drawable.weightedpushup);
        images.add(R.drawable.weightedsquat);
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
            case 1:
                Intent crulbarbicepcurls = new Intent(this, BicepCurls.class);
                startActivity(crulbarbicepcurls);
                break;
            case 2:
                Intent deadlift = new Intent(this, Deadlift.class);
                startActivity(deadlift);
                break;
            case 3:
                Intent weighteddips = new Intent(this, WeightedDips.class);
                startActivity(weighteddips);
                break;
            case 4:
                Intent weightedpullups = new Intent(this, WeightedPullUps.class);
                startActivity(weightedpullups);
                break;
            case 5:
                Intent weightedpushup = new Intent(this, WeightedPushUps.class);
                startActivity(weightedpushup);
                break;
            case 6:
                Intent weightedsquat = new Intent(this, SquatsWeighted.class);
                startActivity(weightedsquat);
                break;
        }
    }
}
