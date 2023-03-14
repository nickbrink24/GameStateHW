package com.example.gamestate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Button run = (Button)findViewById(R.id.button);
    run.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

        }
    });
}