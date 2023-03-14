package com.example.gamestate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button runTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.editText);
        runTest = findViewById(R.id.runTest);
        runTest.setOnClickListener(this::onClick);
    }

    public void onClick(View view) {
        if (view.getId() == runTest.getId()) {
            textView.setText("");
        }
    }
}
