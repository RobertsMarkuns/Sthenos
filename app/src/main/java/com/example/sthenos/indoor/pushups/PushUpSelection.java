package com.example.sthenos.indoor.pushups;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.sthenos.Adapter;
import com.example.sthenos.R;
import com.example.sthenos.indoor.pushups.InclinePushUp;
import com.example.sthenos.indoor.weights.WeightedDips;
import com.example.sthenos.indoor.weights.WeightedPushUps;

import java.util.ArrayList;
import java.util.List;

public class PushUpSelection extends AppCompatActivity implements Adapter.OnSelectionListener {

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

        //From weights
        titles.add("Weighted push-ups");
        titles.add("Weighted Dips");


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

        //From weights
        images.add(R.drawable.weightedpushup);
        images.add(R.drawable.weighteddips);

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
                Intent incline = new Intent(this, InclinePushUp.class);
                startActivity(incline);
                break;
            case 1:
                Intent knee = new Intent(this, KneePushUp.class);
                startActivity(knee);
                break;
            case 2:
                Intent regular = new Intent(this, RegularPushUp.class);
                startActivity(regular);
                break;
            case 3:
                Intent decline = new Intent(this, DeclinePushUp.class);
                startActivity(decline);
                break;
            case 4:
                Intent diamond = new Intent(this, DiamondPushUp.class);
                startActivity(diamond);
                break;
            case 5:
                Intent deeppbar = new Intent(this, DeepPbarPushUp.class);
                startActivity(deeppbar);
                break;
            case 6:
                Intent slow = new Intent(this, SlowPushUp.class);
                startActivity(slow);
                break;
            case 7:
                Intent explosivepushup = new Intent(this, ExplosiveClapPushUp.class);
                startActivity(explosivepushup);
                break;
            case 8:
                Intent pike = new Intent(this, PikePushUp.class);
                startActivity(pike);
                break;
            case 9:
                Intent archerpushup = new Intent(this, ArcherPushUps.class);
                startActivity(archerpushup);
                break;
            case 10:
                Intent pseudopushup = new Intent(this, PseudoPushUp.class);
                startActivity(pseudopushup);
                break;
            case 11:
                Intent widepseudo = new Intent(this, WidePseudoPushUps.class);
                startActivity(widepseudo);
                break;
            case 12:
                Intent wahspu = new Intent(this, WAHandstandPushUp.class);
                startActivity(wahspu);
                break;
            case 13:
                Intent backclap = new Intent(this, BackClapPushUp.class);
                startActivity(backclap);
                break;
            case 14:
                Intent superman = new Intent(this, SupermanPushUp.class);
                startActivity(superman);
                break;
            case 15:
                Intent onearm = new Intent(this, OneArmPushUp.class);
                startActivity(onearm);
                break;
            case 16:
                Intent tuck = new Intent(this, TuckPlanchePushUp.class);
                startActivity(tuck);
                break;
            case 17:
                Intent hspu = new Intent(this, HandstandPushUp.class);
                startActivity(hspu);
                break;
            case 18:
                Intent deephspu = new Intent(this, DeepHSPU.class);
                startActivity(deephspu);
                break;
            case 19:
                Intent claphspu = new Intent(this, ClapHSPU.class);
                startActivity(claphspu);
                break;
            case 20:
                Intent ninty = new Intent(this, NintyDegreeHSPU.class);
                startActivity(ninty);
                break;
            case 21:
                Intent straddle = new Intent(this, StraddlePlanchePushUp.class);
                startActivity(straddle);
                break;
            case 22:
                Intent fullplanche = new Intent( this, FullPlanchePushUp.class );
                startActivity(fullplanche);
                break;
            case 23:
                Intent fullarcher = new Intent(this, ArcherFullPlanchePushUp.class);
                startActivity(fullarcher);
                break;
            case 24:
                Intent fullplancheftg = new Intent(this, FullPlanchePushUpFTG.class);
                startActivity(fullplancheftg);
                break;
            case 25:
                Intent deepfullplanche = new Intent(this, DeepFullPlanchePushUp.class);
                startActivity(deepfullplanche);
                break;
            case 26:
                Intent weightedpushup = new Intent(this, WeightedPushUps.class);
                startActivity(weightedpushup);
            case 27:
                Intent weighteddips = new Intent(this, WeightedDips.class);
                startActivity(weighteddips);

        }
    }
}