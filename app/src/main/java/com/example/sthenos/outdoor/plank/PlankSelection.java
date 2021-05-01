package com.example.sthenos.outdoor.plank;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sthenos.Adapter;
import com.example.sthenos.R;
import com.example.sthenos.indoor.abs.AbsSidePlank;

import java.util.ArrayList;
import java.util.List;

public class PlankSelection extends AppCompatActivity implements Adapter.OnSelectionListener {

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
        titles.add("Regular plank"); //Novice lvl
        titles.add("Side plank");
        titles.add("Tuck planche");
        titles.add("Straddle planche");
        titles.add("Full planche");
        //titles.add("");


        /*--------Image list---------*/
        images.add(R.drawable.regularplank);
        images.add(R.drawable.sideplank);
        images.add(R.drawable.tuckplanche);
        images.add(R.drawable.straddleplanche);
        images.add(R.drawable.fullplanche);
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
                Intent regular = new Intent(this, RegularPlank.class);
                startActivity(regular);
                break;
            case 1:
                Intent sideplank = new Intent(this, AbsSidePlank.class);
                startActivity(sideplank);
                break;
            case 2:
                Intent tuckplanche = new Intent(this, TuckPlanche.class);
                startActivity(tuckplanche);
                break;
            case 3:
                Intent straddleplanche = new Intent(this, StraddlePlanche.class);
                startActivity(straddleplanche);
                break;
            case 4:
                Intent fullplanche = new Intent(this, FullPlanche.class);
                startActivity(fullplanche);
                break;

        }
    }
}
