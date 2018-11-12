package com.example.hieutm.game424;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Logic {
    static public void fReset_GamePlay(List<Button> mButtons_gamePlay){
        for (int i=0;i<mButtons_gamePlay.size();i++){
            mButtons_gamePlay.get(i).setBackgroundResource(R.drawable.welcome_button_background);
            mButtons_gamePlay.get(i).setVisibility(View.VISIBLE);
        }
    }
    static private int fGet_IntegerRandomly(int range){
        Random rd = new Random();
        return rd.nextInt(range);
    }
    static public void fSet_RandomNumber(List<Button> buttons_gamePlay, int range){
        int x;
        for (int i=0;i<buttons_gamePlay.size();i++){
            x = fGet_IntegerRandomly(range);
            if (x==0) i--;
            else{
                buttons_gamePlay.get(i).setText(String.valueOf(x));
                if (x<=5) buttons_gamePlay.get(i).setBackgroundResource(R.drawable.gameplay_button_under_5);
                if (x>5 && x<=10) buttons_gamePlay.get(i).setBackgroundResource(R.drawable.gameplay_button_under_10);
                if (x>10 && x<=15) buttons_gamePlay.get(i).setBackgroundResource(R.drawable.gameplay_button_under_15);
                if (x>15 && x<=20) buttons_gamePlay.get(i).setBackgroundResource(R.drawable.gameplay_button_under_20);
            }
        }
    }
    static public int fGet_SumNumberRandomly(List<Button> buttons_gamePlay,int move){
        List<Button> m_ls = new ArrayList<Button>();
        m_ls.addAll(buttons_gamePlay);
        if (buttons_gamePlay.size()==0) return 0;
        int result=0;
        int index;
        int m_move=fGet_IntegerRandomly(move);
        if (m_move>m_ls.size()) m_move=m_ls.size();
        if (m_move==0) m_move+=1;
        for (int i=0;i<m_move;i++){
            index=fGet_IntegerRandomly(m_ls.size());
            result+=Integer.parseInt(m_ls.get(index).getText().toString());
            m_ls.remove(index);
        }
        return result;
    }
    static public int fGet_SumList(List<Button> buttons_touched){
        int result=0;
        for (int i=0;i<buttons_touched.size();i++)
            result = result + Integer.parseInt(buttons_touched.get(i).getText().toString());
        return result;
    }
    static public void fSet_backgroundForButton(Button btn){
        int x= Integer.parseInt(btn.getText().toString());
        if (x<=5) btn.setBackgroundResource(R.drawable.gameplay_button_under_5);
        if (x>5 && x<=10) btn.setBackgroundResource(R.drawable.gameplay_button_under_10);
        if (x>10 && x<=15) btn.setBackgroundResource(R.drawable.gameplay_button_under_15);
        if (x>15 && x<=20) btn.setBackgroundResource(R.drawable.gameplay_button_under_20);
    }
    static public boolean isWin(List<Button> mButtons_gamePlay){
        for (int i=0;i<mButtons_gamePlay.size();i++)
            if (mButtons_gamePlay.get(i).getVisibility()==View.VISIBLE) return false;
        return true;
    }
}