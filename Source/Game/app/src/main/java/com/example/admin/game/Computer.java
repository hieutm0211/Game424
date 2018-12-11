package com.example.admin.game;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    static private int fGet_IntegerRandomly(int range){
        Random rd = new Random();
        return rd.nextInt(range);
    }
}
