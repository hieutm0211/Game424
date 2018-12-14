package com.example.hieutm.game424;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WinGame extends Activity {
    TextView
            tv_score,
            tv_highscore,
            tv_level;

    Button
            btn_nextlevel,
            btn_replay,
            btn_backtomainmenu,
            btn_save;


    int
            score,
            currentlevel,
            nextlevel;

    EditText
            et_inputName;

    Animation
            animation;

    BounceInterpolator
            interpolator;


    Intent intent;

    DatabaseHelper databaseHelper;

    Player player;

    private void initView(){
        {
            tv_score = (TextView) findViewById(R.id.tv_score);
            tv_highscore= (TextView) findViewById(R.id.tv_highscore);
            et_inputName = (EditText) findViewById(R.id.et_inputName);
            tv_level = (TextView) findViewById(R.id.tv_level);
            player = new Player();
        }

        {
            btn_nextlevel = (Button) findViewById(R.id.btn_nextlevel);
            btn_backtomainmenu = (Button) findViewById(R.id.btn_backtomainmenu);
            btn_replay = (Button) findViewById(R.id.btn_replay);
            btn_save= (Button) findViewById(R.id.btn_save);
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

        databaseHelper = new DatabaseHelper(this);

        if (databaseHelper.getFirst()==null) tv_highscore.setText("0");
        else{
            tv_highscore.setText(String.valueOf(databaseHelper.getFirst().getScore()));
        }

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


        String temp;
        temp="Level "+currentlevel;

        tv_level.setText(temp);
        tv_score.setText(String.valueOf(score));

        handleEvent();
    }

    @Override
    public void onBackPressed() {
        return;
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

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(et_inputName.getText().toString())) return;
                player.setName(et_inputName.getText().toString());
                player.setScore(Integer.parseInt(tv_score.getText().toString()));
                databaseHelper.addPlayer(player);
                databaseHelper.sortPlayer();
                Toast.makeText(WinGame.this,
                        "Add player successfully", Toast.LENGTH_LONG).show();
                btn_save.setVisibility(View.INVISIBLE);
                if (databaseHelper.getFirst()==null) tv_highscore.setText("0");
                else{
                    tv_highscore.setText(String.valueOf(databaseHelper.getFirst().getScore()));
                }
            }
        });
    }

}
