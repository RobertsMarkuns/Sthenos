package com.example.sthenos.outdoor.abs;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sthenos.Adapter;
import com.example.sthenos.R;
import com.example.sthenos.indoor.abs.Front_lever;
import com.example.sthenos.indoor.abs.HangingL_Sit;
import com.example.sthenos.indoor.abs.L_Sit;
import com.example.sthenos.indoor.abs.LegsToBar;
import com.example.sthenos.indoor.abs.MountainClimbers;
import com.example.sthenos.indoor.abs.V_Sit;
import com.example.sthenos.indoor.abs.WindshieldWipers;

import java.util.ArrayList;
import java.util.List;

public class AbSelectionOutdoor extends AppCompatActivity implements Adapter.OnSelectionListener {

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
        //images.add();


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
                Intent crunches = new Intent(this, CrunchesOutdoor.class);
                startActivity(crunches);
                break;
            case 1:
                Intent sidecrunches = new Intent(this, SideCrunchOutdoor.class);
                startActivity(sidecrunches);
                break;
            case 2:
                Intent regularplank = new Intent(this, AbsPlankOutdoor.class);
                startActivity(regularplank);
                break;
            case 3:
                Intent sideplank = new Intent(this, AbsSidePlankOutdoor.class);
                startActivity(sideplank);
                break;
            case 4:
                Intent mountainclimbers = new Intent(this, MountClimbOutdoor.class);
                startActivity(mountainclimbers);
                break;
            case 5:
                Intent windshieldwipers = new Intent(this, WindShildWipeOutdoor.class);
                startActivity(windshieldwipers);
                break;
            case 6:
                Intent l_sitholdonfloor = new Intent(this, L_SitOutdoor.class);
                startActivity(l_sitholdonfloor);
                break;
            case 7:
                Intent hangingl_sit = new Intent(this, HangingL_SitOutdoor.class);
                startActivity(hangingl_sit);
                break;
            case 8:
                Intent toestobar = new Intent(this, LegsToBarOutdoor.class);
                startActivity(toestobar);
                break;
            case 9:
                Intent v_sitholdonfloor = new Intent(this, VSitOutdoor.class);
                startActivity(v_sitholdonfloor);
                break;
            case 10:
                Intent frontlever = new Intent(this, Front_leverOutdoor.class);
                startActivity(frontlever);
                break;

        }
    }
}
