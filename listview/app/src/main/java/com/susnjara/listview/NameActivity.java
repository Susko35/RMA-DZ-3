package com.susnjara.listview;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class NameActivity extends Activity {

    private TextView textView;
    private Button buttonName;

    private View.OnClickListener onClickListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        setupData();
    }

    private void setupData(){
        textView = findViewById(R.id.textViewName);
        buttonName = findViewById(R.id.buttonName);
        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked();
            }
        };

        Intent startIntent = this.getIntent();
        if(startIntent.hasExtra(MainActivity.KEY_INPUT)){
            textView.setText(startIntent.getStringExtra(MainActivity.KEY_INPUT));
        }

        buttonName.setOnClickListener(onClickListener);
    }

    private void clicked(){
        Intent backIntent = new Intent(getApplicationContext(), MainActivity.class);
        this.startActivity(backIntent);
    }

}
