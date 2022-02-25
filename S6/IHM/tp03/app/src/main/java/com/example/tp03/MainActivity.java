package com.example.tp03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<String> states = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        states.add("onCreate");
        Log.i("TD03", "Main::onCreate()");

        TextView textView = findViewById(R.id.textView);
        textView.setText(states.toString());

        Button button = findViewById(R.id.multButton);

        button.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, MultiplyActivity.class);

            EditText editText = findViewById(R.id.numberView);

            try {
                int number = Integer.parseInt(editText.getText().toString());

                i.putExtra("number", number);

                startActivity(i);
            } catch (NumberFormatException e){
                e.printStackTrace();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        states.add("onRestart");
        Log.i("TD03", "Main::onRestart()");

        TextView textView = findViewById(R.id.textView);
        textView.setText(states.toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        states.add("onResume");
        Log.i("TD03", "Main::onResume()");

        TextView textView = findViewById(R.id.textView);
        textView.setText(states.toString());
    }

    @Override
    protected void onPause() {
        super.onPause();
        states.add("onPause");
        Log.i("TD03", "Main::onPause()");

        TextView textView = findViewById(R.id.textView);
        textView.setText(states.toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
        states.add("onStop");
        Log.i("TD03", "Main::onStop()");

        TextView textView = findViewById(R.id.textView);
        textView.setText(states.toString());
    }
}