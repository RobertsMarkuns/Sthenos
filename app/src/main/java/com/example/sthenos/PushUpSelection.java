package com.example.sthenos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class PushUpSelection extends AppCompatActivity implements Adapter.OnSelectionListener{

    //Variables
    RecyclerView pushUpDataList;
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
        pushUpDataList = findViewById(R.id.pushUpDataList);

        /*--------Creating Lists---------*/
        titles = new ArrayList<>();
        images = new ArrayList<>();

        /*--------Title list---------*/
        //Taken from Daniels Laizans Video https://www.youtube.com/watch?v=oqBiZ_YV1ps
        titles.add("Incline push-ups (Level 1)"); //Novice lvl
        titles.add("Knee push-ups (Level 2)"); // Novice lvl
        titles.add("Regular push-ups (Level 5)"); //Novice lvl
        titles.add("Decline push-ups (Level 8)"); //Novice lvl
        titles.add("Diamond push-ups (Level 12)"); //Novice lvl
        titles.add("Deep P-bar push-ups (Level 15)"); //Novice lvl
        titles.add("Slow push-ups (Level 20)"); //Intermediate lvl
        titles.add("Explosive clap push-ups (Level 25)"); //Intermediate lvl
        titles.add("Pike push-ups (Level 30)"); //Intermediate lvl
        titles.add("Archer push-ups (Level 35)"); //Intermediate lvl
        titles.add("Pseudo push-ups (Level 40)"); //Intermediate lvl
        titles.add("Wide pseudo push-ups (Level 45)"); //Advanced lvl
        titles.add("W/A handstand push-ups (Level 50)"); //Advanced lvl
        titles.add("Back clap push-ups (Level 55)"); //Advanced lvl
        titles.add("Superman push-ups (Level 60)"); //Advanced lvl
        titles.add("One arm push-ups (Level 65)"); //Advanced lvl
        titles.add("Tuck planche push-ups (Level 70)"); //Advanced lvl
        titles.add("Handstand push-ups (Level 75)"); //Advanced lvl
        titles.add("Deep handstand push-ups (Level 77)"); //Pro lvl
        titles.add("Handstand clap push-ups (Level 80)"); //Pro lvl
        titles.add("90 Degree handstand push-ups (Level 85)"); //Pro lvl
        titles.add("Straddle planche push-ups (Level 90)"); //Pro lvl
        titles.add("Full planche push-ups (Level 95)"); //Pro lvl
        titles.add("Archer full planche push-ups (Level 97"); //Pro lvl
        titles.add("Full planche push-ups from the ground (Level 98)");//Pro lvl
        titles.add("Deep full planche push-ups (Level 100)");//Pro lvl




        /*--------Image list---------*/
        images.add(R.drawable.inclinepushups);
        images.add(R.drawable.kneepushups);
        images.add(R.drawable.regularpushups);
        images.add(R.drawable.declinepushups);
        images.add(R.drawable.diamondpushups);
        images.add(R.drawable.deeppbarpushups);
        images.add(R.drawable.slowpushups);
        images.add(R.drawable.explosiveclappushups);
        images.add(R.drawable.pikepushups);
        images.add(R.drawable.archerpushups);
        images.add(R.drawable.pseudopushups);
        images.add(R.drawable.widepseudopushups);
        images.add(R.drawable.walllassistedhspu);
        images.add(R.drawable.explosiveclappushups);
        images.add(R.drawable.supermanpushups);
        images.add(R.drawable.onearmpushups);
        images.add(R.drawable.tuckplanchepushups);
        images.add(R.drawable.hspu);
        images.add(R.drawable.deephspu);
        images.add(R.drawable.hspu);
        images.add(R.drawable._0degreepushups);
        images.add(R.drawable.straddleplanchepushups);
        images.add(R.drawable.fullplanchepushups);
        images.add(R.drawable.archerfullplanchepushups);
        images.add(R.drawable.fullplanchepushupsftg);
        images.add(R.drawable.deepfullplanchepushups);


        /*--------Adapter---------*/
        adapter = new Adapter(this, titles, images, this);

        /*--------Creating the grid Layout---------*/
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);

        /*--------Setting the RecyclerView---------*/
        pushUpDataList.setLayoutManager(gridLayoutManager);
        pushUpDataList.setAdapter(adapter);

    }

    @Override
    public void onSelectionClick(int position) {
        switch (position){
            case 0:
                Intent incline = new Intent(this, InclinePushUp.class);
                startActivity(incline);
                break;

        }
    }
}