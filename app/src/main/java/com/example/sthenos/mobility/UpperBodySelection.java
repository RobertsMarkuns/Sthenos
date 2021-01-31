package com.example.sthenos.mobility;

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

public class UpperBodySelection extends AppCompatActivity implements Adapter.OnSelectionListener {
    //Variables
    RecyclerView mobilityDataList;
    List<String> titles;
    List<Integer> images;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This Line will make the status bar from the screen see through
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_selection_mobility);

        /*--------Hooks---------*/
        mobilityDataList = findViewById(R.id.recyclerMobilityDataList);

        /*--------Creating Lists---------*/
        titles = new ArrayList<>();
        images = new ArrayList<>();

        /*--------Title list---------*/
        titles.add("Neck and Abs extensions"); //Novice lvl
        //titles.add("");


        /*--------Image list---------*/
        images.add(R.drawable.ic_name);
        //images.add();


        /*--------Adapter---------*/
        adapter = new Adapter(this, titles, images, this);

        /*--------Creating the grid Layout---------*/
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);

        /*--------Setting the RecyclerView---------*/
        mobilityDataList.setLayoutManager(gridLayoutManager);
        mobilityDataList.setAdapter(adapter);

    }

    @Override
    public void onSelectionClick(int position) {
        switch (position){
            case 0:
                //Intent incline = new Intent(this, InclinePushUp.class);
                //startActivity(incline);
                break;

        }
    }
}
