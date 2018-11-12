package com.example.hieutm.game424;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gameover extends Activity {
    Button btn_replay;
    Button btn_highScore;
    TextView tv_score;
    int currentlevel;
    int score;

    private void Mirror(){
        btn_replay=(Button) findViewById(R.id.btn_replay);
        btn_highScore = (Button) findViewById(R.id.btn_highscore);
        tv_score = (TextView) findViewById(R.id.tv_score);
    }

    @Override
    protected void onCreate(final Bundle savedInstancestate){
        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_gameover);
        Mirror();
        //Get Information
        Intent i = getIntent();
        currentlevel=i.getIntExtra("currentlevel",0);
        score=i.getIntExtra("score",0);
        tv_score.setText(String.valueOf(score));

        Handle_Event();
    }
    private void Handle_Event(){
        btn_replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handle_CurrentLevel();
            }
        });
    }
    private void Handle_CurrentLevel(){
        //Level1
        if (currentlevel==1){
            Intent i = new Intent(gameover.this,switchlevel.class);
            i.putExtra("level",1);
            gameover.this.startActivity(i);
            gameover.this.finish();
        }
        if (currentlevel==2){
            Intent i = new Intent(gameover.this,switchlevel.class);
            i.putExtra("level",2);
            gameover.this.startActivity(i);
            gameover.this.finish();
        }

    }
}
