package com.example.vaccinecollector;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by 15U560 on 2016-09-14.
 */
public class SubActivity extends Activity {

    LinearLayout dynamicLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Intent intent = getIntent();
        int getNumber = intent.getExtras().getInt("input");

        dynamicLayout = (LinearLayout)findViewById(R.id.dynamicLayout);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, 2.0f);
        for(int i = 0; i<getNumber; i++) {
            int R = new Random().nextInt(255);
            int G = new Random().nextInt(255);
            int B = new Random().nextInt(255);
            TextView newTextView = new TextView(this);
            newTextView.setText("안녕"+(i+1));
            LinearLayout dynamicHori = new LinearLayout(this);
            dynamicHori.setBackgroundColor(Color.rgb(R,G,B));
            dynamicHori.addView(newTextView);
            dynamicLayout.addView(dynamicHori);
        }
    }

    public void back(View view) {
        Intent intent = new Intent(SubActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
