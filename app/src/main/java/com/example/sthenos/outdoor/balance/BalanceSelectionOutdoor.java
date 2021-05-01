package com.example.sthenos.outdoor.balance;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sthenos.Adapter;
import com.example.sthenos.R;
import com.example.sthenos.indoor.balance.BentLegHS;
import com.example.sthenos.indoor.balance.CrowHS;
import com.example.sthenos.indoor.balance.DiamondHS;
import com.example.sthenos.indoor.balance.ForearmHS;
import com.example.sthenos.indoor.balance.HSOnABar;
import com.example.sthenos.indoor.balance.Handstand;
import com.example.sthenos.indoor.balance.OADiamondHS;
import com.example.sthenos.indoor.balance.OAFlagHS;
import com.example.sthenos.indoor.balance.OAStraddleHS;
import com.example.sthenos.indoor.balance.OAStraightHS;
import com.example.sthenos.indoor.balance.PikeHS;
import com.example.sthenos.indoor.balance.ScorpionHS;
import com.example.sthenos.indoor.balance.StraddleHS;
import com.example.sthenos.indoor.balance.TigerBendHS;
import com.example.sthenos.indoor.balance.WallAssistedHS;

import java.util.ArrayList;
import java.util.List;

public class BalanceSelectionOutdoor extends AppCompatActivity implements Adapter.OnSelectionListener {

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
                Intent hs_pike_assisted = new Intent(this, PikeHSOutdoor.class);
                startActivity(hs_pike_assisted);
                break;
            case 1:
                Intent crow_hs = new Intent(this, CrowHSOutdoor.class);
                startActivity(crow_hs);
                break;
            case 2:
                Intent tigerbendhs = new Intent(this, TigerBHSOutdoor.class);
                startActivity(tigerbendhs);
                break;
            case 3:
                Intent forearmhs = new Intent(this, ForearmHSOutdoor.class);
                startActivity(forearmhs);
                break;
            case 4:
                Intent walllassistedhspu = new Intent(this, WallAHSOutdoor.class);
                startActivity(walllassistedhspu);
                break;
            case 5:
                Intent bentleghs = new Intent(this, BLegHSOutdoor.class);
                startActivity(bentleghs);
                break;
            case 6:
                Intent handstand = new Intent(this, HandstandOutdoor.class);
                startActivity(handstand);
                break;
            case 7:
                Intent hs_straddle = new Intent(this, StradHSOutdoor.class);
                startActivity(hs_straddle);
                break;
            case 8:
                Intent diamondhs = new Intent(this, DiamondHSOutdoor.class);
                startActivity(diamondhs);
                break;
            case 9:
                Intent scorpionhs = new Intent(this, ScorpHSOutdoor.class);
                startActivity(scorpionhs);
                break;
            case 10:
                Intent oahs_straddle = new Intent(this, OAStradHSOutdoor.class);
                startActivity(oahs_straddle);
                break;
            case 11:
                Intent oahs_diamond = new Intent(this, OADHSOutdoor.class);
                startActivity(oahs_diamond);
                break;
            case 12:
                Intent onearmhs_w_legstogether = new Intent(this, OAStraightHSOutdoor.class);
                startActivity(onearmhs_w_legstogether);
                break;
            case 13:
                Intent oahs_flag = new Intent(this, OAFHSOutdoor.class);
                startActivity(oahs_flag);
                break;
            case 14:
                Intent handstandonbar = new Intent(this, HSOABOutdoor.class);
                startActivity(handstandonbar);
                break;

        }
    }
}
