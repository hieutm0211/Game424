package com.example.hieutm.game424;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Welcome extends Activity {



    //View
    RelativeLayout
            container;
    Button
            btn_Play,
            btn_Guide,
            btn_HighScore,
            btn_About;
    Intent
            intent;

    BounceInterpolator
            interpolator;
    Animation
            animation;



    private void initView(){
        btn_Play= (Button) findViewById(R.id.btn_play);
        btn_About=(Button)findViewById(R.id.btn_about);
        btn_Guide=(Button) findViewById(R.id.btn_guide);
        btn_HighScore=(Button)findViewById(R.id.btn_highscore);
        container = (RelativeLayout) findViewById(R.id.container);
        animation = AnimationUtils.loadAnimation(this, R.anim.animation_bounce);
        interpolator = new BounceInterpolator(0.2,20);
        animation.setInterpolator(interpolator);
    }














    @Override
    protected void onCreate(final Bundle savedstate) {
        super.onCreate(savedstate);
        setContentView(R.layout.welcome);
        initView();
    }

















    //Event


    public void click_play(View view) {
        btn_Play.startAnimation(animation);
        intent = new Intent(this,SwitchLevel.class);
        intent.putExtra("level",1);
        this.finish();
        this.startActivity(intent);
    }

    public void click_highscore(View view) {
        btn_HighScore.startAnimation(animation);
        intent = new Intent(this,HighScore.class);
        this.startActivity(intent);
    }

    public void click_guide(View view) {
        btn_Guide.startAnimation(animation);
        intent = new Intent(this, Guide.class);
        this.startActivity(intent);
    }

    public void click_about(View view) {
        btn_About.startAnimation(animation);
        intent = new Intent(this, About.class);
        this.startActivity(intent);
    }
}
