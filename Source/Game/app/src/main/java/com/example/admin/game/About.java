package com.example.admin.game;

import android.app.Activity;
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
                "This game is written by H2 team of University of Information Technology.\n" +
                "The minimum system requirements for android 0S: 5.0+\n\n\n"+
                "Members of team:\n\n" +
                "Hieu Tran Minh - Software Engineer\n" +
                "-+-+-+-+-+-\n"+
                "Huy Vo Quoc - Software Engineer\n" +
                "\n\n\n\n\n\n"+
                "-+-+-+-+-+-\n"+
                "Contact: (+84)976086911\n" +
                "Email: hieutranminh211@gmail.com\n");
    }
}
