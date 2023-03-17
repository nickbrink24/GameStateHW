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
        firstInstance = new GameState();
        secondInstance = new GameState(firstInstance);
        thirdInstance = new GameState();
        fourthInstance = new GameState(thirdInstance);
    }

    public void onClick(View view) {
        // Empties
        if (view.getId() == runTest.getId()) {
            textView.setText("");
        }

        textView.append("Board is made.");
        // First player will move piece in first instance
        int who = firstInstance.getTurn(); // who is whoever's turn it is
        String player;
        if (who == 1) {
            player = "AI";
        } else {
            player = "Player";
        }
            textView.append(player + "'s Turn\n");
            textView.append(player + "will move checker piece.\n");

        // CAPTURE PIECE //
        boolean belongs = firstInstance.checkPiece(who,firstInstance.getPieces(3,3));
        boolean canMove = firstInstance.checkMove(who,firstInstance.getPieces(3,3));
        if (canMove == true) {
            // Move piece
            textView.append(player + " has moved checker piece");
        }
        textView.append(String.valueOf(firstInstance) + "\n\n");


        textView.append(secondInstance.toString());
        textView.append(fourthInstance.toString());
    }
}
