package com.example.hieutm.game424;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class HighScore extends Activity {

    Context context;



    @Override
    protected void onCreate(final Bundle savedState){
        super.onCreate(savedState);
        setContentView(R.layout.high_score);
        context=this;

        DatabaseHelper dataHelper = new DatabaseHelper(context);

        TableLayout tl_tablehighscore= (TableLayout) findViewById(R.id.tl_tablehighscore);

        //Header row
        TableRow rowHeader = new TableRow(context);
        rowHeader.setBackgroundColor(Color.parseColor("#80c0c0c0"));
        rowHeader.setLayoutParams(
                new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.WRAP_CONTENT
        ));


        String[] headerText={"Rank","Name","Score"};
        for (String c:headerText){

            //Init a view
            TextView tv = new TextView(this);
            tv.setLayoutParams(
                    new TableRow.LayoutParams(
                            TableRow.LayoutParams.WRAP_CONTENT,
                            TableRow.LayoutParams.WRAP_CONTENT
                    )
            );
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(20);
            tv.setPadding(5,5,5,5);
            tv.setText(c);
            tv.setTextColor(Color.parseColor("#ff7f50"));

            rowHeader.addView(tv);
        }

        tl_tablehighscore.addView(rowHeader);

        //GetData from Sqlite
        Cursor cursor = dataHelper.loadAllPlayer();
        TextView textView;
        TableRow tablerow;
        cursor.moveToFirst();
        int count=1;
        do{
            tablerow = new TableRow(this);


            tablerow.setLayoutParams(
                    new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT)
            );
            String[] record = {String.valueOf(count),cursor.getString(1),String.valueOf(cursor.getInt(2))};
            for (String c:record){
                textView = new TextView(this);
                textView.setLayoutParams(
                        new TableRow.LayoutParams(
                                TableRow.LayoutParams.WRAP_CONTENT,
                                TableRow.LayoutParams.WRAP_CONTENT
                        )
                );
                textView.setGravity(Gravity.CENTER);
                textView.setTextSize(20);
                textView.setPadding(5,5,5,5);
                textView.setText(c);
                textView.setBackgroundColor(Color.parseColor("#80ffffff"));
                tablerow.addView(textView);
            }
            tl_tablehighscore.addView(tablerow);
            count++;
        } while (cursor.moveToNext());



    }
}
