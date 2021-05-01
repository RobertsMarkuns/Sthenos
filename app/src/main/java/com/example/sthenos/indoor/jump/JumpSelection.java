package com.example.sthenos.indoor.jump;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sthenos.Adapter;
import com.example.sthenos.R;
import com.example.sthenos.indoor.cardio.JumpRope;

import java.util.ArrayList;
import java.util.List;

public class JumpSelection extends AppCompatActivity implements Adapter.OnSelectionListener {

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
        titles.add("Star jumps");
        titles.add("Box Jumps");
        titles.add("Jump Rope");
        titles.add("Depth Jumps");
        //titles.add("");

        /*--------Image list---------*/
        images.add(R.drawable.star_jumps_exercise);
        images.add(R.drawable.boxjumps);
        images.add(R.drawable.jumprope);
        images.add(R.drawable.boxjumps);
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
                Intent starjumps = new Intent(this, StarJumps.class);
                startActivity(starjumps);
                break;
            case 1:
                Intent boxjumps = new Intent(this, BoxJumps.class);
                startActivity(boxjumps);
                break;
            case 2:
                Intent jumprope = new Intent(this, JumpRope.class);
                startActivity(jumprope);
                break;
            case 3:
                Intent depthjumps = new Intent(this, DepthJumps.class);
                startActivity(depthjumps);
                break;
        }
    }
}
