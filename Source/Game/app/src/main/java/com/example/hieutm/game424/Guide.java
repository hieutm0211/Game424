package com.example.hieutm.game424;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class Guide extends Activity {
    TextView tv_guide;
    @Override
    protected void onCreate(final Bundle savedState){
        super.onCreate(savedState);
        setContentView(R.layout.guide);
        tv_guide = (TextView)findViewById(R.id.tv_guide);

        tv_guide.setText("Players will have a table of random numbers on the screen.\n\n" +
                "The task of the player is to sum up the numbers so that they equal the blue numbers." +
                " If the player select boxes correctly, those numbers will be disappear and the player will gain points and increase the playing time.\n\n" +
                "But from level 5, the game will have the probability of appearing bad luck box. If the player chooses bad luck box, the remaining boxes will have the probability of randomly changing the value or adding new boxes or reducing playing time by 15%.\n\n" +
                "In return, there are lucky boxes to help players increase score or increase the playing time by 10%.");
        tv_guide.setBackgroundColor(Color.parseColor("#80ffffff"));
    }
}
