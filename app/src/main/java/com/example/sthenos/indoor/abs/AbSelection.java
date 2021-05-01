package com.example.sthenos.indoor.abs;

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

public class AbSelection extends AppCompatActivity implements Adapter.OnSelectionListener {

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
        titles.add("Crunches");
        titles.add("Side crunches");
        titles.add("Plank");
        titles.add("Side plank");
        titles.add("Mountain Climbers");
        titles.add("Windshield wipers");
        titles.add("L-Sit");
        titles.add("Hanging L-sit");
        titles.add("Toes to bar");
        titles.add("V-Sit");
        titles.add("Front-lever");

        /*--------Image list---------*/
        images.add(R.drawable.crunches);
        images.add(R.drawable.sidecrunches);
        images.add(R.drawable.regularplank);
        images.add(R.drawable.sideplank);
        images.add(R.drawable.mountainclimbers);
        images.add(R.drawable.windshieldwipers);
        images.add(R.drawable.l_sitholdonfloor);
        images.add(R.drawable.hangingl_sit);
        images.add(R.drawable.toestobar);
        images.add(R.drawable.v_sitholdonfloor);
        images.add(R.drawable.frontlever);


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
                Intent crunches = new Intent(this, Crunches.class);
                startActivity(crunches);
                break;
            case 1:
                Intent sidecrunches = new Intent(this, SideCrunches.class);
                startActivity(sidecrunches);
                break;
            case 2:
                Intent regularplank = new Intent(this, AbsPlank.class);
                startActivity(regularplank);
                break;
            case 3:
                Intent sideplank = new Intent(this, AbsSidePlank.class);
                startActivity(sideplank);
                break;
            case 4:
                Intent mountainclimbers = new Intent(this, MountainClimbers.class);
                startActivity(mountainclimbers);
                break;
            case 5:
                Intent windshieldwipers = new Intent(this, WindshieldWipers.class);
                startActivity(windshieldwipers);
                break;
            case 6:
                Intent l_sitholdonfloor = new Intent(this, L_Sit.class);
                startActivity(l_sitholdonfloor);
                break;
            case 7:
                Intent hangingl_sit = new Intent(this, HangingL_Sit.class);
                startActivity(hangingl_sit);
                break;
            case 8:
                Intent toestobar = new Intent(this, LegsToBar.class);
                startActivity(toestobar);
                break;
            case 9:
                Intent v_sitholdonfloor = new Intent(this, V_Sit.class);
                startActivity(v_sitholdonfloor);
                break;
            case 10:
                Intent frontlever = new Intent(this, Front_lever.class);
                startActivity(frontlever);
                break;

        }
    }
}
