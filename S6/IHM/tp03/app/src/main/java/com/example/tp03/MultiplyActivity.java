package com.example.tp03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MultiplyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiply);

        int number = getIntent().getIntExtra("number", 0);

        TextView textView = findViewById(R.id.textView3);

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i <= 10; ++i){
            builder.append(i).append(" * ").append(number).append(" = ").append(i * number).append("\n");
        }

        textView.setText(builder);

        Button ret = findViewById(R.id.multReturn);

        ret.setOnClickListener(view -> finish());
        Log.i("TD03", "Mult::onCreate()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TD03", "Mult::onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TD03", "Mult::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TD03", "Mult::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TD03", "Mult::onStop()");
    }
}