package com.example.hieutm.game424;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class wingame extends Activity {
    Button btn_replay;
    Button btn_nextLevel;
    Button btn_highScore;
    TextView tv_score;
    int nextlevel;
    int currentlevel;
    int score;

    private void Mirror(){
        btn_replay= (Button) findViewById(R.id.btn_replay);
        btn_highScore=(Button) findViewById(R.id.btn_highscore);
        btn_nextLevel=(Button) findViewById(R.id.btn_nextLevel);
        tv_score = (TextView) findViewById(R.id.tv_score);
    }

    @Override
    protected void onCreate(final Bundle savedInstancestate){
        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_wingame);
        Mirror();

        //Get information
        Intent i = getIntent();
        nextlevel = i.getIntExtra("nextlevel",0);
        currentlevel = i.getIntExtra("currentlevel",0);
        score = i.getIntExtra("score",0);

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
        btn_nextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handle_NextLevel();
            }
        });
    }
    private void Handle_CurrentLevel(){
        //Level1
        if (currentlevel==1){
            Intent i = new Intent(wingame.this,switchlevel.class);
            i.putExtra("level",1);
            wingame.this.startActivity(i);
            wingame.this.finish();
        }

        if (currentlevel==2){
            Intent i = new Intent(wingame.this,switchlevel.class);
            i.putExtra("level",2);
            wingame.this.startActivity(i);
            wingame.this.finish();
        }
        if (currentlevel==3){
            Intent i = new Intent(wingame.this,switchlevel.class);
            i.putExtra("level",3);
            wingame.this.startActivity(i);
            wingame.this.finish();
        }
        if (currentlevel==4){
            Intent i = new Intent(wingame.this,switchlevel.class);
            i.putExtra("level",4);
            wingame.this.startActivity(i);
            wingame.this.finish();
        }
        if (currentlevel==5){
            Intent i = new Intent(wingame.this,switchlevel.class);
            i.putExtra("level",5);
            wingame.this.startActivity(i);
            wingame.this.finish();
        }
        if (currentlevel==6){
            Intent i = new Intent(wingame.this,switchlevel.class);
            i.putExtra("level",6);
            wingame.this.startActivity(i);
            wingame.this.finish();
        }
        if (currentlevel==7){
            Intent i = new Intent(wingame.this,switchlevel.class);
            i.putExtra("level",7);
            wingame.this.startActivity(i);
            wingame.this.finish();
        }
        if (currentlevel==8){
            Intent i = new Intent(wingame.this,switchlevel.class);
            i.putExtra("level",8);
            wingame.this.startActivity(i);
            wingame.this.finish();
        }
        if (currentlevel==9){
            Intent i = new Intent(wingame.this,switchlevel.class);
            i.putExtra("level",9);
            wingame.this.startActivity(i);
            wingame.this.finish();
        }
        if (currentlevel==10){
            Intent i = new Intent(wingame.this,switchlevel.class);
            i.putExtra("level",10);
            wingame.this.startActivity(i);
            wingame.this.finish();
        }
    }

    private void Handle_NextLevel(){
        if (nextlevel==2){
            Intent i = new Intent(wingame.this,switchlevel.class);
            i.putExtra("level",2);
            wingame.this.startActivity(i);
            wingame.this.finish();
        }
        if (nextlevel==3){
            Intent i = new Intent(wingame.this,switchlevel.class);
            i.putExtra("level",3);
            wingame.this.startActivity(i);
            wingame.this.finish();
        }
        if (nextlevel==4){
            Intent i = new Intent(wingame.this,switchlevel.class);
            i.putExtra("level",4);
            wingame.this.startActivity(i);
            wingame.this.finish();
        }
        if (nextlevel==5){
            Intent i = new Intent(wingame.this,switchlevel.class);
            i.putExtra("level",5);
            wingame.this.startActivity(i);
            wingame.this.finish();
        }
        if (nextlevel==6){
            Intent i = new Intent(wingame.this,switchlevel.class);
            i.putExtra("level",6);
            wingame.this.startActivity(i);
            wingame.this.finish();
        }
        if (nextlevel==7){
            Intent i = new Intent(wingame.this,switchlevel.class);
            i.putExtra("level",7);
            wingame.this.startActivity(i);
            wingame.this.finish();
        }
        if (nextlevel==8){
            Intent i = new Intent(wingame.this,switchlevel.class);
            i.putExtra("level",8);
            wingame.this.startActivity(i);
            wingame.this.finish();
        }
        if (nextlevel==9){
            Intent i = new Intent(wingame.this,switchlevel.class);
            i.putExtra("level",9);
            wingame.this.startActivity(i);
            wingame.this.finish();
        }
        if (nextlevel==10){
            Intent i = new Intent(wingame.this,switchlevel.class);
            i.putExtra("level",10);
            wingame.this.startActivity(i);
            wingame.this.finish();
        }
    }
}
