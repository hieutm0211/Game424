package com.example.admin.game;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SwitchLevel extends Activity {
    RelativeLayout
            container;
    AnimationDrawable
            anim;
    TextView
            tv_countdown;
    int
            score,
            counter=5,
            level;
    Intent
            intent;


    private void initView(){
        container=findViewById(R.id.container);
        tv_countdown=findViewById(R.id.tv_countdown);
        intent = getIntent();
        level=intent.getIntExtra("level",1);
        score=intent.getIntExtra("score",0);
        anim =(AnimationDrawable) container.getBackground();
        anim.setEnterFadeDuration(6000);
        anim.setExitFadeDuration(3000);
    }



    @Override
    protected void onCreate(final Bundle savedstate){
        super.onCreate(savedstate);
        setContentView(R.layout.switch_layout);
        initView();
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
                SwitchIntent();
            }
        }.start();
    }


        private void SwitchIntent(){
            Intent intent;
            if (level==1)
            {
                intent = new Intent(this, GamePlay_1.class);
                this.startActivity(intent);
                this.finish();
            }
            if (level==2)
            {
                intent = new Intent(this, GamePlay_2.class);
                intent.putExtra("score",score);
                this.startActivity(intent);
                this.finish();
            }
            if (level==3)
            {
                intent = new Intent(this, GamePlay_3.class);
                intent.putExtra("score",score);
                this.startActivity(intent);
                this.finish();
            }
            if (level==4)
            {
                intent = new Intent(this, GamePlay_4.class);
                intent.putExtra("score",score);
                this.startActivity(intent);
                this.finish();
            }
            if (level==5)
            {
                intent = new Intent(this, GamePlay_5.class);
                intent.putExtra("score",score);
                this.startActivity(intent);
                this.finish();
            }
        }
}
