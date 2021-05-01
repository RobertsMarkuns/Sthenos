package com.example.sthenos.indoor.balance;

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

public class BalanceSelection extends AppCompatActivity implements Adapter.OnSelectionListener {

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
        titles.add("Pike handstand");
        titles.add("Crow handstand");
        titles.add("Tiger bend");
        titles.add("Forearm handstand");
        titles.add("Wall handstand");
        titles.add("Bent leg handstand");
        titles.add("Handstand");
        titles.add("Straddle handstand");
        titles.add("Diamond handstand");
        titles.add("Scorpion handstand");
        titles.add("One arm straddle");
        titles.add("One arm diamond");
        titles.add("One arm straight");
        titles.add("One arm flag");
        titles.add("Handstand on a bar");
        //titles.add("");

        /*--------Image list---------*/
        images.add(R.drawable.hs_pike_assisted);
        images.add(R.drawable.crow_hs);
        images.add(R.drawable.tigerbendhs);
        images.add(R.drawable.forearmhs);
        images.add(R.drawable.walllassistedhspu);
        images.add(R.drawable.bentleghs);
        images.add(R.drawable.handstandpng);
        images.add(R.drawable.hs_straddle);
        images.add(R.drawable.diamondhs);
        images.add(R.drawable.scorpionhs);
        images.add(R.drawable.oahs_straddle);
        images.add(R.drawable.oahs_diamond);
        images.add(R.drawable.onearmhs_w_legstogether);
        images.add(R.drawable.oahs_flag);
        images.add(R.drawable.handstandonbar);
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
                Intent hs_pike_assisted = new Intent(this, PikeHS.class);
                startActivity(hs_pike_assisted);
                break;
            case 1:
                Intent crow_hs = new Intent(this, CrowHS.class);
                startActivity(crow_hs);
                break;
            case 2:
                Intent tigerbendhs = new Intent(this, TigerBendHS.class);
                startActivity(tigerbendhs);
                break;
            case 3:
                Intent forearmhs = new Intent(this, ForearmHS.class);
                startActivity(forearmhs);
                break;
            case 4:
                Intent walllassistedhspu = new Intent(this, WallAssistedHS.class);
                startActivity(walllassistedhspu);
                break;
            case 5:
                Intent bentleghs = new Intent(this, BentLegHS.class);
                startActivity(bentleghs);
                break;
            case 6:
                Intent handstand = new Intent(this, Handstand.class);
                startActivity(handstand);
                break;
            case 7:
                Intent hs_straddle = new Intent(this, StraddleHS.class);
                startActivity(hs_straddle);
                break;
            case 8:
                Intent diamondhs = new Intent(this, DiamondHS.class);
                startActivity(diamondhs);
                break;
            case 9:
                Intent scorpionhs = new Intent(this, ScorpionHS.class);
                startActivity(scorpionhs);
                break;
            case 10:
                Intent oahs_straddle = new Intent(this, OAStraddleHS.class);
                startActivity(oahs_straddle);
                break;
            case 11:
                Intent oahs_diamond = new Intent(this, OADiamondHS.class);
                startActivity(oahs_diamond);
                break;
            case 12:
                Intent onearmhs_w_legstogether = new Intent(this, OAStraightHS.class);
                startActivity(onearmhs_w_legstogether);
                break;
            case 13:
                Intent oahs_flag = new Intent(this, OAFlagHS.class);
                startActivity(oahs_flag);
                break;
            case 14:
                Intent handstandonbar = new Intent(this, HSOnABar.class);
                startActivity(handstandonbar);
                break;
        }
    }
}
