package com.example.sthenos.mobility;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sthenos.Adapter;
import com.example.sthenos.R;
import com.example.sthenos.mobility.upperbody.NeckStretch;
import com.example.sthenos.mobility.upperbody.PalmStretch;
import com.example.sthenos.mobility.upperbody.ShoulderMobility;
import com.example.sthenos.mobility.upperbody.SideStretch;
import com.example.sthenos.mobility.upperbody.WristStretch;

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
        titles.add("Neck stretch");
        titles.add("Shoulder stretch");
        titles.add("Palm stretch");
        titles.add("Wrist stretch");
        titles.add("Side stretch");


        /*--------Image list---------*/
        images.add(R.drawable.neckstretch);
        images.add(R.drawable.shouldermobility);
        images.add(R.drawable.palmstretch);
        images.add(R.drawable.wriststretch);
        images.add(R.drawable.sidestreach);


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
                Intent neck = new Intent(this, NeckStretch.class);
                startActivity(neck);
                break;
            case 1:
                Intent shoulder = new Intent(this, ShoulderMobility.class);
                startActivity(shoulder);
                break;
            case 2:
                Intent palm = new Intent(this, PalmStretch.class);
                startActivity(palm);
                break;
            case 3:
                Intent wrist = new Intent(this, WristStretch.class);
                startActivity(wrist);
                break;
            case 4:
                Intent side = new Intent(this, SideStretch.class);
                startActivity(side);
                break;

        }
    }
}
