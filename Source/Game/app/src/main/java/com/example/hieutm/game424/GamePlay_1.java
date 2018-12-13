package com.example.hieutm.game424;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.john.waveview.WaveView;

import java.util.ArrayList;
import java.util.List;


public class GamePlay_1 extends Activity {

    Button
            btn_0,
            btn_1,
            btn_2,
            btn_3,
            btn_4,
            btn_5,
            btn_6,
            btn_7,
            btn_8,
            btn_9,
            btn_10,
            btn_11,
            btn_12,
            btn_13,
            btn_14,
            btn_15;

    TextView
            tv_score,
            tv_motion,
            tv_specialNumber;

    Handler
            handler;

    WaveView
            background_percent;
    int
            background_int = 0,
            score=0,
            range=3;

    List<Button>
            buttons_gamePlay,
            buttons_touched,
            buttons_default;

    Intent
            intent;


    Animation
            animation,
            animation_in,
            animation_out;

    BounceInterpolator
            interpolator;

    private void initView() {

        //GamePlay

        {
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
        }

        //Score

        {
            tv_score = (TextView) findViewById(R.id.score);
            tv_score.setText("0");
            tv_motion = (TextView) findViewById(R.id.tv_motion);
            tv_motion.setText("");
            tv_motion.setTextColor(this.getResources().getColor(R.color.UFOGreen));
            tv_motion.setTypeface(Typeface.DEFAULT_BOLD);
            tv_specialNumber = (TextView) findViewById(R.id.tv_specialNumber);
        }

        //Thread

        {
            handler = new Handler();
            background_percent = (WaveView) findViewById(R.id.background_percent);
        }

        //Game Rules

        {
            buttons_default = new ArrayList<Button>();
            buttons_gamePlay = new ArrayList<Button>();
            buttons_touched = new ArrayList<Button>();
            buttons_default.add(btn_0);
            buttons_default.add(btn_1);
            buttons_default.add(btn_2);
            buttons_default.add(btn_3);
            buttons_default.add(btn_4);
            buttons_default.add(btn_5);
            buttons_default.add(btn_6);
            buttons_default.add(btn_7);
            buttons_default.add(btn_8);
            buttons_default.add(btn_9);
            buttons_default.add(btn_10);
            buttons_default.add(btn_11);
            buttons_default.add(btn_12);
            buttons_default.add(btn_13);
            buttons_default.add(btn_14);
            buttons_default.add(btn_15);
            buttons_gamePlay.addAll(buttons_default);
        }

        //Animation

        {
        animation = AnimationUtils.loadAnimation(this,R.anim.animation_bounce);
        interpolator = new BounceInterpolator(0.2,20);


        animation_in = new AlphaAnimation(0.0f, 1.0f);
        animation_in.setDuration(3000);

        animation_out = new AlphaAnimation(1.0f, 0.0f);
        animation_out.setDuration(3000);
        }
    }


    @Override
    protected void onCreate(final Bundle savedstate) {
        super.onCreate(savedstate);
        setContentView(R.layout.gameplay_level_1);
        initView();

        Computer.setValueForButtons(buttons_default,10);
        Computer.setColorForButtons(buttons_default);

        Computer.setSpecialNumber(buttons_gamePlay,range,tv_specialNumber);

        catch_thread();

        handlerEventButton();
    }




    public void catch_thread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (background_int <= 100) {
                    background_int++;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            background_percent.setProgress(background_int);
                            if (background_int==100 && !Computer.isWin(buttons_gamePlay)){
                                intent = new Intent(GamePlay_1.this,GameOver.class);

                                intent.putExtra("level",1);
                                intent.putExtra("score",Integer.parseInt(tv_score.getText().toString()));
                                GamePlay_1.this.finish();
                                GamePlay_1.this.startActivity(intent);
                            }
                        }
                    });
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }


    //Event
    private void handlerEventButton(){

        for (int i=0;i<buttons_default.size();i++){

            final Button vir_btn = buttons_default.get(i);






            vir_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    animation.setInterpolator(interpolator);
                    vir_btn.startAnimation(animation);


                    handleEachButton(vir_btn);

                    if (Computer.isWin(buttons_gamePlay)) {
                        intent = new Intent(GamePlay_1.this,WinGame.class);
                        intent.putExtra("level",1);
                        intent.putExtra("nextlevel",2);
                        intent.putExtra("score",Integer.parseInt(tv_score.getText().toString()));
                        GamePlay_1.this.finish();
                        GamePlay_1.this.startActivity(intent);
                    }

                }

            });

        }



    }
        private void handleEachButton(Button vir_btn){
            if (buttons_touched.contains(vir_btn)){
                Computer.setColorForButtons(vir_btn);
                buttons_touched.remove(vir_btn);
                return;
            }

            vir_btn.setBackgroundResource(R.drawable.button_gameplay_default);
            buttons_touched.add(vir_btn);

            if (Computer.calculate(buttons_touched,tv_score,Integer.parseInt(tv_specialNumber.getText().toString()))&&buttons_touched.size()<=range){
                buttons_gamePlay.removeAll(buttons_touched);
                buttons_touched.clear();
                background_int*=0.6;

                tv_motion.startAnimation(animation_in);
                tv_motion.setText(Computer.getCongraturation());
                tv_motion.startAnimation(animation_out);

                Computer.setSpecialNumber(buttons_gamePlay,range,tv_specialNumber);
            }

            if (Computer.isBigger(buttons_touched,Integer.parseInt(tv_specialNumber.getText().toString()))){
                Computer.setColorForButtons(buttons_gamePlay);
                buttons_touched.clear();
            }
            if (buttons_touched.size()>range){
                Computer.setColorForButtons(buttons_gamePlay);
                buttons_touched.clear();
            }
        }
}
