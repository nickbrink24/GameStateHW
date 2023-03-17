package com.example.gamestate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textView;
    private Button runTest;
    private int clicks;
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

        if (clicks == 0) {
            textView.append("Initial Board:\n" + firstInstance);
        }
        textView.append("Board is made.\n");
        // First player will move piece in first instance
        int who = firstInstance.getTurn(); // who is whoever's turn it is
        String player = "";
        if (who == 1) {
            player = "AI";
        } else {
            player = "Player";
        }
        textView.append(player + "'s Turn\n");
        textView.append(player + " will move checker piece.\n");
        // Capture a piece

        clicks++;
        firstInstance.setTurn(who);
        textView.append(String.valueOf(firstInstance) + "\n\n");
        if (clicks == 3) {
            textView.append("Click again.\n");
        }
        if (clicks > 3) {
            textView.append("" + secondInstance);
            textView.append("\n");
            textView.append("" + fourthInstance);
            textView.append("\n");
        }
        //textView.append(secondInstance.toString());
        //textView.append(fourthInstance.toString());
    }

    public boolean canMove() {
        boolean move = false;
        if (clicks == 0) {
            move = firstInstance.checkPiece(firstInstance.getTurn(),firstInstance.getPieces(4,6))
            && firstInstance.checkMove(firstInstance.getTurn(),firstInstance.getPieces(4,6), firstInstance.getPieces(4,4));
        } else if (clicks == 1) {
            move = firstInstance.checkPiece(firstInstance.getTurn(),firstInstance.getPieces(3,1))
            && firstInstance.checkMove(firstInstance.getTurn(),firstInstance.getPieces(3,1), firstInstance.getPieces(3,3));
        } else if (clicks == 2) {
            move = firstInstance.checkPiece(firstInstance.getTurn(),firstInstance.getPieces(4,4))
            && firstInstance.checkMove(firstInstance.getTurn(),firstInstance.getPieces(4,4), firstInstance.getPieces(4,3));
        }
        return move;
    }

    public void movePiece() {
        if (clicks == 0) {
            firstInstance.setPieces(4, 4, firstInstance.getPieces(4, 6));
            firstInstance.setPieces(4, 6, firstInstance.emptyPiece);
        } else if (clicks == 1) {
            firstInstance.setPieces(3, 3, firstInstance.getPieces(3, 1));
            firstInstance.setPieces(3, 1, firstInstance.emptyPiece);
        } else if (clicks == 2) {
            firstInstance.setPieces(4, 4, firstInstance.getPieces(3, 3));
            firstInstance.setPieces(3, 3, firstInstance.emptyPiece);
        }
    }

    public void makeCapture() {
        int currPlayer = firstInstance.getTurn();
        if (currPlayer == 0) {
            firstInstance.capturedRed().add(firstInstance.getPieces(3,3));
        }
    }

    public boolean canCapture() {
        boolean capture = false;
        if (clicks == 0) {
            capture = firstInstance.checkCapture(firstInstance.getTurn(),firstInstance.getPieces(4,6),firstInstance.getPieces(4,4));
        } else if (clicks == 1) {
            capture = firstInstance.checkCapture(firstInstance.getTurn(),firstInstance.getPieces(3,1),firstInstance.getPieces(3,3));
        } else if (clicks == 3) {
            capture = firstInstance.checkCapture(firstInstance.getTurn(),firstInstance.getPieces(4,4),firstInstance.getPieces(3,3));
        }
        return capture;
    }
}
