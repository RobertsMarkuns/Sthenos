package com.example.sthenos.mobility.lowerbody;

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

public class LowerBodySelection extends AppCompatActivity implements Adapter.OnSelectionListener {
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
        titles.add("Hamstring stretch"); //Novice lvl
        titles.add("Calves stretch");
        titles.add("Hamstring one leg in air stretch");
        titles.add("Hamstring one leg on the ground stretch");
        titles.add("Hamstring pike stretch");
        titles.add("Hamstring with palms on the floor stretch");
        titles.add("Hip flexor stretch");
        titles.add("Thigh stretch");
        //titles.add("");


        /*--------Image list---------*/
        images.add(R.drawable.hamstring);
        images.add(R.drawable.calves);
        images.add(R.drawable.hamstring_oneleginair);
        images.add(R.drawable.hamstring_onelegonground);
        images.add(R.drawable.hamstring_pike);
        images.add(R.drawable.hamstring_w_palmsonfloor);
        images.add(R.drawable.hipflexorstretch);
        images.add(R.drawable.thighstretch_standingononeleg);
        //images.add(R.drawable.);


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
                Intent hamstring = new Intent(this, Hamstring.class);
                startActivity(hamstring);
                break;
            case 1:
                Intent calves = new Intent(this, Calves.class);
                startActivity(calves);
                break;
            case 2:
                Intent hamstring_oneleginair = new Intent(this, HamStrLegInAir.class);
                startActivity(hamstring_oneleginair);
                break;
            case 3:
                Intent hamstring_onelegonground = new Intent(this, HamStrLegOnGround.class);
                startActivity(hamstring_onelegonground);
                break;
            case 4:
                Intent hamstring_pike = new Intent(this, HamStrPike.class);
                startActivity(hamstring_pike);
                break;
            case 5:
                Intent hamstring_w_palmsonfloor = new Intent(this, HamStrPalmOnFloor.class);
                startActivity(hamstring_w_palmsonfloor);
                break;
            case 6:
                Intent hipflexorstretch = new Intent(this, HipFexStretch.class);
                startActivity(hipflexorstretch);
                break;
            case 7:
                Intent thighstretch_standingononeleg = new Intent(this, ThighStretch.class);
                startActivity(thighstretch_standingononeleg);
                break;

        }
    }
}
