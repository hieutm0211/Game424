package com.example.hieutm.game424;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class switchlevel extends Activity {
    RelativeLayout container;
    AnimationDrawable anim;
    TextView tv_countdown;
    private int progress=5;
    private Handler handler = new Handler();

    int counter=5;
    int level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switchlevel);
        container = (RelativeLayout) findViewById(R.id.container);
        anim =(AnimationDrawable) container.getBackground();
        tv_countdown= (TextView) findViewById(R.id.tv_countdown);
        anim.setEnterFadeDuration(6000);
        anim.setExitFadeDuration(3000);

        //GetInformation Before Activity
        Intent i = getIntent();
        level=i.getIntExtra("level",0);
        //
        CountDown();
    }
    @Override
    protected void onResume(){
        super.onResume();
        if (anim!=null && !anim.isRunning()) anim.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        if (anim!=null && anim.isRunning()) anim.stop();
    }

    private void CountDown(){
        new CountDownTimer(6000,1000){
            public void onTick(long milisUntilFinised){
                tv_countdown.setText(String.valueOf(counter));
                if (counter==0) tv_countdown.setText("Go!");
                else
                counter--;
            }
            public void onFinish(){
//Switch level
                CreateIntent();

            }
        }.start();
    }

    private void CreateIntent(){
        Intent intent;
        if (level==1)
        {
            intent = new Intent(switchlevel.this, level1.class);
            switchlevel.this.startActivity(intent);
            switchlevel.this.finish();
        }
        if (level==2){
            intent = new Intent(switchlevel.this, level2.class);
            switchlevel.this.startActivity(intent);
            switchlevel.this.finish();
        }

        if (level==3){
            intent = new Intent(switchlevel.this, level3.class);
            switchlevel.this.startActivity(intent);
            switchlevel.this.finish();
        }

        if (level==4){
            intent = new Intent(switchlevel.this, level4.class);
            switchlevel.this.startActivity(intent);
            switchlevel.this.finish();
        }

        if (level==5){
            intent = new Intent(switchlevel.this, level5.class);
            switchlevel.this.startActivity(intent);
            switchlevel.this.finish();
        }

        if (level==6){
            intent = new Intent(switchlevel.this, level6.class);
            switchlevel.this.startActivity(intent);
            switchlevel.this.finish();
        }

        if (level==7){
            intent = new Intent(switchlevel.this, level7.class);
            switchlevel.this.startActivity(intent);
            switchlevel.this.finish();
        }

        if (level==8){
            intent = new Intent(switchlevel.this, level8.class);
            switchlevel.this.startActivity(intent);
            switchlevel.this.finish();
        }

        if (level==9){
            intent = new Intent(switchlevel.this, level9.class);
            switchlevel.this.startActivity(intent);
            switchlevel.this.finish();
        }

        if (level==10){
            intent = new Intent(switchlevel.this, level10.class);
            switchlevel.this.startActivity(intent);
            switchlevel.this.finish();
        }
    }
}
