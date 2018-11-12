package com.example.hieutm.game424;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Welcome extends Activity {
    RelativeLayout container;
    AnimationDrawable anim;
    Button btn_Play;
    Button btn_Guide;
    Button btn_HighScore;
    Button btn_About;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        container = (RelativeLayout) findViewById(R.id.container);
        anim =(AnimationDrawable) container.getBackground();
        anim.setEnterFadeDuration(6000);
        anim.setExitFadeDuration(3000);

        Mirror();
        Handle_Event();
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

    private void Mirror(){
        btn_Play= (Button) findViewById(R.id.btn_play);
        btn_About=(Button)findViewById(R.id.btn_about);
        btn_Guide=(Button) findViewById(R.id.btn_guide);
        btn_HighScore=(Button)findViewById(R.id.btn_highscore);
    }
    private void Handle_Event(){
        btn_Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Welcome.this, switchlevel.class);
                i.putExtra("level",1);
                Welcome.this.startActivity(i);
            }
        });
    }

}