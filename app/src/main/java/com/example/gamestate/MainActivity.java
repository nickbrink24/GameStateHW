package com.example.gamestate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button runTest;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runTest = findViewById(R.id.runTest);
        textView = findViewById(R.id.editText);
        runTest.setOnClickListener(this::onClick);
    }


    public void onClick(View view) {
        if (view.getId() == runTest.getId()) {
            textView.setText("");
        }

    }


}