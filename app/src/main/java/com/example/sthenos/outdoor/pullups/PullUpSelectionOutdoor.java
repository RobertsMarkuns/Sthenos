package com.example.sthenos.outdoor.pullups;

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

public class PullUpSelectionOutdoor extends AppCompatActivity implements Adapter.OnSelectionListener {

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
        //Taken from Daniels Laizans Video https://www.youtube.com/watch?v=T_XFUuwoj6E
        titles.add("Australian Pull Ups (bent knees)"); //Rookie
        titles.add("Negative Pull Ups"); //Rookie
        titles.add("Jump Pull Ups"); //Rookie
        titles.add("Negative-Explosive Australian Pull Ups"); //Rookie
        titles.add("Negative-Explosive Decline Pull Ups"); //Novice
        titles.add("Regular Pull Ups"); //Novice
        titles.add("Close Grip Pull Ups"); //Novice
        titles.add("Wide Grip Pull Ups"); //Novice
        titles.add("Commando Pull Ups"); //Novice
        titles.add("Pull Up + Hold + 90 Degree Hold"); //Intermediate
        titles.add("Explosive Pull Ups"); //Intermediate
        titles.add("Archer Pull Ups"); //Intermediate
        titles.add("L-Sit Pull Ups"); //Intermediate
        titles.add("Grip Switch Pull Ups"); //Advanced
        titles.add("Inverted L-Sit Pull Ups"); //Advanced
        titles.add("One Arm Pull Ups"); //Advanced
        titles.add("Tuck to Front Lever Pull Ups"); //Advanced
        titles.add("Human Flag Pull Ups"); //Pro
        titles.add("Back Lever Pull Ups"); //Pro
        titles.add("Front Lever Pull Ups"); //Pro

        /*--------Image list---------*/
        images.add(R.drawable.australianpullups);
        images.add(R.drawable.negativepullups);
        images.add(R.drawable.jumppullups);
        images.add(R.drawable.negative_explosiveau_pullups);
        images.add(R.drawable.negative_explosivedecline_pullups);
        images.add(R.drawable.regularpullups);
        images.add(R.drawable.closegrippullups);
        images.add(R.drawable.widegrippullups);
        images.add(R.drawable.commandopullups);
        images.add(R.drawable.pullup_hold_nintydegree_hold);
        images.add(R.drawable.explosivepullups);
        images.add(R.drawable.archerpullups);
        images.add(R.drawable.l_sitpullups);
        images.add(R.drawable.gripswitchpullups);
        images.add(R.drawable.inverted_lsit_pullup);
        images.add(R.drawable.onearmpullup);
        images.add(R.drawable.tucktofrontleverpullups);
        images.add(R.drawable.humanflagpullups);
        images.add(R.drawable.backleverpullups);
        images.add(R.drawable.frontleverpullups);

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
                Intent aupullupsbk = new Intent(this, AustralianBKPullUpOutdoor.class);
                startActivity(aupullupsbk);
                break;
            case 1:
                Intent negative = new Intent(this, NegativePullUpOutdoor.class);
                startActivity(negative);
                break;
            case 2:
                Intent jumppullup = new Intent(this, JumpPullUpOutdoor.class);
                startActivity(jumppullup);
                break;
            case 3:
                Intent negativeexplosiveau = new Intent(this, NegExplosiveAUPullUpOutdoor.class);
                startActivity(negativeexplosiveau);
                break;
            case 4:
                Intent negativeexplosivedecline = new Intent(this, NegExploDecPullUpOutdoor.class);
                startActivity(negativeexplosivedecline);
                break;
            case 5:
                Intent regularpullup = new Intent(this, RegularPullUpOutdoor.class);
                startActivity(regularpullup);
                break;
            case 6:
                Intent closegrip = new Intent(this, CloseGripPullUpOutdoor.class);
                startActivity(closegrip);
                break;
            case 7:
                Intent widegrip = new Intent(this, WideGripPUOutdoor.class);
                startActivity(widegrip);
                break;
            case 8:
                Intent commmando = new Intent(this, CommandoPullUpOutdoor.class);
                startActivity(commmando);
                break;
            case 9:
                Intent ninetyhold = new Intent(this, PUHoldNinetyHoldOutdoor.class);
                startActivity(ninetyhold);
                break;
            case 10:
                Intent explosivepullup = new Intent(this, ExplosivePullUpOutdoor.class);
                startActivity(explosivepullup);
                break;
            case 11:
                Intent archer = new Intent( this, ArcherPullUpOutdoor.class);
                startActivity(archer);
                break;
            case 12:
                Intent lsit = new Intent(this, LSitPullUpOutdoor.class);
                startActivity(lsit);
                break;
            case 13:
                Intent gripswitch = new Intent(this, GripSwitchPullUpOutdoor.class);
                startActivity(gripswitch);
                break;
            case 14:
                Intent invertedlsit = new Intent(this, InvertedLSitPullUpOutdoor.class);
                startActivity(invertedlsit);
                break;
            case 15:
                Intent onearm = new Intent(this, OneArmPullUpOutdoor.class);
                startActivity(onearm);
                break;
            case 16:
                Intent tuck = new Intent(this, TuckToFLPUOutdoor.class);
                startActivity(tuck);
                break;
            case 17:
                Intent humanflag = new Intent(this, HumanFlagPullUpOutdoor.class);
                startActivity(humanflag);
                break;
            case 18:
                Intent back = new Intent(this, BackLeverPullUpOutdoor.class);
                startActivity(back);
                break;
            case 19:
                Intent front = new Intent(this, FrontLeverPullUpOutdoor.class);
                startActivity(front);
                break;
        }
    }
}
