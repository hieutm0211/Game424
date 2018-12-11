package com.example.admin.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class WinGame extends Activity {
    TextView
            tv_score,
            tv_highscore;

    Button
            btn_nextlevel,
            btn_replay,
            btn_backtomainmenu;

    int
            score,
            currentlevel,
            nextlevel;



    Animation
            animation;

    BounceInterpolator
            interpolator;


    Intent intent;


    private void initView(){
        {
            tv_score = (TextView) findViewById(R.id.tv_score);
            tv_highscore= (TextView) findViewById(R.id.tv_highscore);
        }

        {
            btn_nextlevel = (Button) findViewById(R.id.btn_nextlevel);
            btn_backtomainmenu = (Button) findViewById(R.id.btn_backtomainmenu);
            btn_replay = (Button) findViewById(R.id.btn_replay);
        }

        {
            animation = AnimationUtils.loadAnimation(this,R.anim.animation_bounce);
            interpolator = new BounceInterpolator(0.2,20);
        }

        {
            intent = getIntent();
        }
    }



    @Override
    protected void onCreate(final Bundle savedState){
        super.onCreate(savedState);
        setContentView(R.layout.wingame);
        initView();


        //Get value from intent and set back to view
        {
            String title_level;

            title_level = "Level" + String.valueOf(intent.getIntExtra("level", 1));
            tv_score.setText(title_level);
        }

        {
            tv_score.setText(String.valueOf(intent.getIntExtra("score",0)));
            score=intent.getIntExtra("score",0);
        }


        //Get Level
        {
            currentlevel=intent.getIntExtra("level",1);
            nextlevel=intent.getIntExtra("nextlevel",1);
        }



        handleEvent();
    }


    private void handleEvent(){
        intent = new Intent();

        btn_nextlevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_nextlevel.startAnimation(animation);
                intent = new Intent(WinGame.this, SwitchLevel.class);
                intent.putExtra("score",score);
                intent.putExtra("level",nextlevel);
                WinGame.this.finish();
                WinGame.this.startActivity(intent);
            }
        });

        btn_replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_replay.startAnimation(animation);
                intent = new Intent(WinGame.this, SwitchLevel.class);
                intent.putExtra("level",currentlevel);
                WinGame.this.finish();
                WinGame.this.startActivity(intent);
            }
        });

        btn_backtomainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_backtomainmenu.startAnimation(animation);
                intent = new Intent(WinGame.this,Welcome.class);
                WinGame.this.finish();
                WinGame.this.startActivity(intent);
            }
        });
    }

}
