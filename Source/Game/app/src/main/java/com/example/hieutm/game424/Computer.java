package com.example.hieutm.game424;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.john.waveview.WaveView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {

    public static void ResetStatusButtons(List<Button> ls_default,int range){
        for(int i=0;i<ls_default.size();i++){
            ls_default.get(i).setVisibility(View.VISIBLE);
        }
        setValueForButtons(ls_default,range);
        setColorForButtons(ls_default);
    }


    public static void setValueForButtons(List<Button> ls_btn,int range){
        Random rd = new Random();
        int value;
        for (int i=0;i<ls_btn.size();i++){
            value = rd.nextInt(range);
            while (value ==0){
                value= rd.nextInt(range);
            }
            ls_btn.get(i).setText(String.valueOf(value));
        }
    }

        public static void setColorForButtons(List<Button> ls_btn){
            int value;
            for (int i=0;i<ls_btn.size();i++){
                value = Integer.parseInt(ls_btn.get(i).getText().toString());
                if (value<=5) ls_btn.get(i).setBackgroundResource(R.drawable.button_gameplay_under_5);
                else
                    if (value<=10) ls_btn.get(i).setBackgroundResource(R.drawable.button_gameplay_under_10);
                    else
                        if (value<=15) ls_btn.get(i).setBackgroundResource(R.drawable.button_gameplay_under_15);
                        else
                            if (value <=20) ls_btn.get(i).setBackgroundResource(R.drawable.button_gameplay_under_20);
            }
    }

        public static void setColorForButtons(Button btn){
            int value;
            value = Integer.parseInt(btn.getText().toString());
            if (value<=5) btn.setBackgroundResource(R.drawable.button_gameplay_under_5);
            else
            if (value<=10) btn.setBackgroundResource(R.drawable.button_gameplay_under_10);
            else
            if (value<=15) btn.setBackgroundResource(R.drawable.button_gameplay_under_15);
            else
            if (value <=20) btn.setBackgroundResource(R.drawable.button_gameplay_under_20);
        }

        public static void setSpecialNumber(List<Button> ls_gamePlay, int maxstep, TextView tv_specialNumber){
            List<Button>
                    m_ls = new ArrayList<Button>();
            int
                    result=0,
                    index,
                    m_move=fGet_IntegerRandomly(maxstep);



            m_ls.addAll(ls_gamePlay);
            if (ls_gamePlay.size()==0) return;
            if (m_move>m_ls.size()) m_move=m_ls.size();
            if (m_move==0) m_move+=1;
            for (int i=0;i<m_move;i++){
                index=fGet_IntegerRandomly(m_ls.size());
                result+=Integer.parseInt(m_ls.get(index).getText().toString());
                m_ls.remove(index);
            }



            tv_specialNumber.setText(String.valueOf(result));
        }


    public static void setValueForButtons(List<Button> ls_btn,int range, int start,int end){
        int value;
        for (int i=0;i<ls_btn.size();i++){
            value = fGet_IntergerRandomly(range,start,end);
            while (value ==0){
                value= fGet_IntergerRandomly(range,start,end);
            }
            ls_btn.get(i).setText(String.valueOf(value));
        }
    }








    public static boolean isWin(List<Button> buttons_gamePlay){
        for (int i=0;i<buttons_gamePlay.size();i++){
            if (buttons_gamePlay.get(i).getVisibility()==View.VISIBLE) return false;
        }
        return true;
    }

    public static String getCongraturation(){
        List<String> ls_congraturation = new ArrayList<String>();
        ls_congraturation.add("Nice!");
        ls_congraturation.add("Good!");
        ls_congraturation.add("Excellent!");
        ls_congraturation.add("Super!");
        ls_congraturation.add("God Like!");
        ls_congraturation.add("Legendary!");
        ls_congraturation.add("Rampage!");
        Random rd = new Random();
        return ls_congraturation.get(rd.nextInt(ls_congraturation.size()));
    }

    public static boolean calculate(List<Button> ls_touched,TextView tv_score, int specialNumber){
        int
                result=0,
                score=Integer.parseInt(tv_score.getText().toString());

        for (int i=0;i<ls_touched.size();i++)
            result = result + Integer.parseInt(ls_touched.get(i).getText().toString());


        if (result==specialNumber) {
            score = score + result * 100;
            tv_score.setText(String.valueOf(score));

            for (int i=0;i<ls_touched.size();i++){
                ls_touched.get(i).setVisibility(View.INVISIBLE);
            }
            return true;
        }
        return false;
    }

    public static boolean isBigger(List<Button> ls_touched,int specialNumber){
            int
                    result=0;

            for (int i=0;i<ls_touched.size();i++){
                result= result+ Integer.parseInt(ls_touched.get(i).getText().toString());
            }

            if (result>specialNumber) return true;

            return false;
        }

    private static  int fGet_IntegerRandomly(int range){
        Random rd = new Random();
        return rd.nextInt(range);
    }
    private static int fGet_IntergerRandomly(int range,int start, int end){
        Random rd = new Random();
        int result;
        result = rd.nextInt(end);
        while (result<start){
            result=rd.nextInt(end);
        }
        return result;
    }


    public static int findLucky(){
        Random rd = new Random();
        int value = rd.nextInt(10);
        //lucky 1/5
        if (value ==0||value==1) return 0;
        //unlucky 1/5
        if (value ==2||value==3) return 1;
        //Normal 3/5
        return 2;
    }

    public static boolean calculate_lucky(List<Button> ls_touched, TextView tv_score, int specialNumber, int Lucky, int background_int){
        int
                result=0,
                score=Integer.parseInt(tv_score.getText().toString());

        for (int i=0;i<ls_touched.size();i++)
            result = result + Integer.parseInt(ls_touched.get(i).getText().toString());


        if (result==specialNumber) {
            score = score + result * 100;
            tv_score.setText(String.valueOf(score));

            for (int i=0;i<ls_touched.size();i++){
                ls_touched.get(i).setVisibility(View.INVISIBLE);
            }

            //Execute Lucky

            if (Lucky==0) background_int-=10;
            else {
                score *=fGet_IntegerRandomly(10)/10;
                tv_score.setText(String.valueOf(score));
            }


            return true;
        }
        return false;
    }

    public static void calculate_unlucky(List<Button> ls_Default,List<Button> ls_GamePlay, int UnLucky,int background_int){

        //Increase background_int :15
        if (UnLucky==0){
            background_int+=15;
        }


        if (UnLucky==1){
            int count=0;
            for (int i=0;i<ls_Default.size()&&count<2;i++){
                if (ls_Default.get(i).getVisibility()==View.INVISIBLE)
                {
                    ls_Default.get(i).setVisibility(View.VISIBLE);
                    ls_GamePlay.add(ls_Default.get(i));
                    count++;
                }
            }
            setValueForButtons(ls_Default,20);
            setColorForButtons(ls_GamePlay);
            //setSpecialNumber(ls_GamePlay,maxstep,TextView tv_specialNumber);
        }
    }


}
