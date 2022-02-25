package com.example.tp03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {

    private final ArrayList<String> states = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        states.add("onCreate");
        Log.i("TD03", "onCreate()");

        TextView textView = findViewById(R.id.textView2);
        textView.setText(states.toString());

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        states.add("onRestart");
        Log.i("TD03", "onRestart()");

        TextView textView = findViewById(R.id.textView);
        textView.setText(states.toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        states.add("onResume");
        Log.i("TD03", "onResume()");

        TextView textView = findViewById(R.id.textView);
        textView.setText(states.toString());
    }

    @Override
    protected void onPause() {
        super.onPause();
        states.add("onPause");
        Log.i("TD03", "onPause()");

        TextView textView = findViewById(R.id.textView);
        textView.setText(states.toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
        states.add("onStop");
        Log.i("TD03", "onStop()");

        TextView textView = findViewById(R.id.textView);
        textView.setText(states.toString());
    }
}