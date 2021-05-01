package com.example.sthenos.indoor.cardio;

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

public class CardioSelection extends AppCompatActivity implements Adapter.OnSelectionListener {

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
        titles.add("Jump rope");
        titles.add("Boxing");
        titles.add("Dancing");
        titles.add("Rowing");
        titles.add("Running on a treadmill");
        titles.add("Swimming");
        //titles.add("");

        /*--------Image list---------*/
        images.add(R.drawable.jumprope);
        images.add(R.drawable.boxing);
        images.add(R.drawable.dancing);
        images.add(R.drawable.rowing);
        images.add(R.drawable.runingontreadmill);
        images.add(R.drawable.swiming);
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
                Intent jumprope = new Intent(this, JumpRope.class);
                startActivity(jumprope);
                break;
            case 1:
                Intent boxing = new Intent(this, Boxing.class);
                startActivity(boxing);
                break;
            case 2:
                Intent dancing = new Intent(this, Dancing.class);
                startActivity(dancing);
                break;
            case 3:
                Intent rowing = new Intent(this, Rowing.class);
                startActivity(rowing);
                break;
            case 4:
                Intent runingontreadmill = new Intent(this, RuningOnATreadmill.class);
                startActivity(runingontreadmill);
                break;
            case 5:
                Intent swiming = new Intent(this, Swimming.class);
                startActivity(swiming);
                break;

        }
    }
}
