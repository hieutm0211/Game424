package com.example.hieutm.game424;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class level2 extends Activity {
    ProgressBar progressbar;
    private int progressStatus=0;
    private Handler handler = new Handler();
    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_10;
    private Button btn_11;
    private Button btn_12;
    private Button btn_13;
    private Button btn_14;
    private Button btn_15;
    private Button btn_16;
    private Button btn_17;
    private Button btn_18;
    private Button btn_19;
    private Button btn_20;
    private Button btn_21;
    private Button btn_22;
    private Button btn_23;
    private Button btn_24;
    private List<Button> buttons_gamePlay  =new ArrayList<Button>();
    private List<Button> mButtons_gamePlay= new ArrayList<Button>();

    private Button btn_start;
    private Button btn_next;

    private TextView tv_score;
    private TextView tv_number;

    private int sumNumber;
    private List<Button> buttons_touched = new ArrayList<Button>();

    private int score;

    private RelativeLayout gamePlay;



    private void mirror(){
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_10 = (Button) findViewById(R.id.btn_10);
        btn_11 = (Button) findViewById(R.id.btn_11);
        btn_12 = (Button) findViewById(R.id.btn_12);
        btn_13 = (Button) findViewById(R.id.btn_13);
        btn_14 = (Button) findViewById(R.id.btn_14);
        btn_15 = (Button) findViewById(R.id.btn_15);
        btn_16 = (Button) findViewById(R.id.btn_16);
        btn_17 = (Button) findViewById(R.id.btn17);
        btn_18 = (Button) findViewById(R.id.btn_18);
        btn_19 = (Button) findViewById(R.id.btn_19);
        btn_20 = (Button) findViewById(R.id.btn_20);
        btn_21 = (Button) findViewById(R.id.btn_21);
        btn_22 = (Button) findViewById(R.id.btn_22);
        btn_23 = (Button) findViewById(R.id.btn_23);
        btn_24 = (Button) findViewById(R.id.btn_24);
        btn_start=(Button) findViewById(R.id.btn_play);
        btn_next=(Button) findViewById(R.id.btn_next);
        tv_score=(TextView) findViewById(R.id.tv_score);
        tv_number=(TextView) findViewById(R.id.tv_number);
        progressbar= (ProgressBar) findViewById(R.id.pb_process);
        gamePlay=(RelativeLayout) findViewById(R.id.GamePlay);
    }

    private void initListButton(){
        buttons_gamePlay.add(btn_0);
        buttons_gamePlay.add(btn_1);
        buttons_gamePlay.add(btn_2);
        buttons_gamePlay.add(btn_3);
        buttons_gamePlay.add(btn_4);
        buttons_gamePlay.add(btn_5);
        buttons_gamePlay.add(btn_6);
        buttons_gamePlay.add(btn_7);
        buttons_gamePlay.add(btn_8);
        buttons_gamePlay.add(btn_9);
        buttons_gamePlay.add(btn_10);
        buttons_gamePlay.add(btn_11);
        buttons_gamePlay.add(btn_12);
        buttons_gamePlay.add(btn_13);
        buttons_gamePlay.add(btn_14);
        buttons_gamePlay.add(btn_15);
        buttons_gamePlay.add(btn_16);
        buttons_gamePlay.add(btn_17);
        buttons_gamePlay.add(btn_18);
        buttons_gamePlay.add(btn_19);
        buttons_gamePlay.add(btn_20);
        buttons_gamePlay.add(btn_21);
        buttons_gamePlay.add(btn_22);
        buttons_gamePlay.add(btn_23);
        buttons_gamePlay.add(btn_24);
        mButtons_gamePlay.clear();
        mButtons_gamePlay.addAll(buttons_gamePlay);
    }

    private void Game(){
        initListButton();

        //Reset visiblity, reset color
        Logic.fReset_GamePlay(mButtons_gamePlay);

        //Set random number
        Logic.fSet_RandomNumber(buttons_gamePlay,10);

        //Calculate the number that we have to compute.
        sumNumber = Logic.fGet_SumNumberRandomly(buttons_gamePlay, 4);
        tv_number.setText(String.valueOf(sumNumber));
    }
    @Override
    protected void onCreate(final Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);
        mirror();
        Game();
        Handle_Event();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus<=100){
                    progressStatus++;
                    progressbar.setProgress(progressStatus);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (!isWin()&&progressStatus==100){
                                Intent i = new Intent(level2.this, gameover.class);
                                i.putExtra("currentlevel",2);
                                i.putExtra("score",score);
                                level2.this.startActivity(i);
                                level2.this.finish();
                            }
                        }
                    });
                    try{
                        Thread.sleep(200);
                    } catch (InterruptedException e ){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }


    //For Button
    private void Handle_Event(){
        for (int i=0;i<mButtons_gamePlay.size();i++){
            final Button Virtualbtn=mButtons_gamePlay.get(i);
            Virtualbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Event_Click(Virtualbtn);
                    //xu ly win game!
                    Intent i;
                    if (isWin()){
                        i= new Intent(level2.this, wingame.class);
                        i.putExtra("nextlevel",3);
                        i.putExtra("currentlevel",2);
                        i.putExtra("score",score);
                        level2.this.startActivity(i);
                        level2.this.finish();
                    }
                }
            });
        }
    }
    private void Event_Click(Button virtualbtn) {
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        // Button in GamePlay
        if (buttons_touched.contains(virtualbtn)){
            Logic.fSet_backgroundForButton(virtualbtn);
            buttons_touched.remove(virtualbtn);
        }
        else{
            buttons_touched.add(virtualbtn);
            if (buttons_touched.size()>2){
                if(Logic.fGet_SumList(buttons_touched)==sumNumber) {
                    for (int i = 0; i < buttons_touched.size(); i++)
                        buttons_touched.get(i).setVisibility(View.INVISIBLE);
                    //
                    score=score+sumNumber*100;
                    //
                    tv_score.setText(String.valueOf(score)+".pts");
                    buttons_gamePlay.removeAll(buttons_touched);
                    buttons_touched.clear();
                    sumNumber=Logic.fGet_SumNumberRandomly(buttons_gamePlay,4);
                    tv_number.setText(String.valueOf(sumNumber));
                    //
                    progressStatus=progressStatus*80/100;
                    //
                }
                else{
                    for (int i=0;i<buttons_touched.size();i++){
                        Logic.fSet_backgroundForButton(buttons_touched.get(i));
                    }
                    buttons_touched.clear();
                }
            }
            else{
                if (Logic.fGet_SumList(buttons_touched)==sumNumber){
                    for (int i=0;i<buttons_touched.size();i++)
                        buttons_touched.get(i).setVisibility(View.INVISIBLE);
                    //
                    score=score+sumNumber*100;
                    //
                    tv_score.setText(String.valueOf(score)+".pts");
                    buttons_gamePlay.removeAll(buttons_touched);
                    buttons_touched.clear();
                    sumNumber=Logic.fGet_SumNumberRandomly(buttons_gamePlay,4);
                    tv_number.setText(String.valueOf(sumNumber));
                    //
                    progressStatus=progressStatus*80/100;
                    //
                }else
                    virtualbtn.setBackgroundResource(R.drawable.gameplay_button_choose);
            }
        }

    }
    private boolean isWin(){
        return Logic.isWin(buttons_gamePlay);
    }

}
