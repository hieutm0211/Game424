package com.example.hieutm.game424;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GameOver extends Activity {

    DatabaseHelper databaseHelper;


    Intent
            intent;
    Button
            btn_backtomainmenu,
            btn_replay,
            btn_save;

    EditText
            et_inputName;

    TextView
            tv_score,
            tv_level,
            tv_highscore;

    int
            score,
            currentlevel;

    Player player;


    private void initView(){
        intent= getIntent();
        btn_backtomainmenu=(Button) findViewById(R.id.btn_backtomainmenu);
        btn_replay = (Button) findViewById(R.id.btn_replay);
        btn_save = (Button) findViewById(R.id.btn_save);
        et_inputName = (EditText) findViewById(R.id.et_inputName);
        tv_score= (TextView) findViewById(R.id.tv_score);
        tv_highscore =(TextView) findViewById(R.id.tv_highscore);
        tv_level = (TextView)findViewById(R.id.tv_level);
        player = new Player();
    }


    @Override
    protected void onCreate(final Bundle savedstate){
        super.onCreate(savedstate);
        setContentView(R.layout.gameover);
        initView();

        databaseHelper = new DatabaseHelper(this);

        if (databaseHelper.getFirst()==null) tv_highscore.setText("0");
        else{
            tv_highscore.setText(String.valueOf(databaseHelper.getFirst().getScore()));
        }



        currentlevel=intent.getIntExtra("level",1);
        score=intent.getIntExtra("score",0);

        String temp;
        temp="Level "+currentlevel;

        tv_level.setText(temp);
        tv_score.setText(String.valueOf(score));



        handlerEvent();


    }

    @Override
    public void onBackPressed() {
        return;
    }

    private void handlerEvent(){
        btn_replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(GameOver.this,SwitchLevel.class);
                intent.putExtra("level", currentlevel);
                intent.putExtra("score",0);
                GameOver.this.finish();
                GameOver.this.startActivity(intent);
            }
        });

        btn_backtomainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(GameOver.this,Welcome.class);
                GameOver.this.finish();
                GameOver.this.startActivity(intent);
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
                Toast.makeText(GameOver.this,
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
