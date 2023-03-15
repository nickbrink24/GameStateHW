package com.example.gamestate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textView;
    private Button runTest;
    private GameState firstInstance;
    private GameState secondInstance;
    private GameState thirdInstance;
    private GameState fourthInstance;


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
        firstInstance = new GameState();
        secondInstance = new GameState(firstInstance);
        // Call each method in the game state at least once
        firstInstance.fillButtons();
        //firstInstance.showPossibleMoves()
        textView.append("Board is made."); // will fix later
        // Needs more methods from Piece Class

        thirdInstance = new GameState();
        fourthInstance = new GameState(thirdInstance);

        textView.append(secondInstance.toString());
        textView.append(fourthInstance.toString());
    }
}
