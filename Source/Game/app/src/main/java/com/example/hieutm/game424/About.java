package com.example.hieutm.game424;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class About extends Activity {
    TextView tv_about;

    @Override
    protected void onCreate(final Bundle savedState){
        super.onCreate(savedState);
        setContentView(R.layout.about);
        tv_about = (TextView) findViewById(R.id.tv_about);
        tv_about.setText("Game424 \n\n " +
                "This game is written by H2 team of University of Information Technology.\n\n" +
                "Members of team:\n" +
                "Hieu Tran Minh - Software Engineer (L)\n" +
                "-------------\n"+
                "Huy Vo Quoc - Software Engineer\n");
        tv_about.setBackgroundColor(Color.parseColor("#80ffffff"));
    }
}
