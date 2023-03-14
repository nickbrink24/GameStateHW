package com.example.gamestate;

import android.widget.Button;

public class GameState {
    private final int PLAYER_ONE = 1;
    private final int PLAYER_AI = 2;

    private Button[][] gameButtons;
    private int playerRemainingPieces;
    private int playerKings;
    private int AIRemainingPieces;
    private int AIKings;
    private int turn;

    public GameState() {
        // initialize number of pieces each player has remaining
        playerRemainingPieces = 12;
        playerKings = 0;
        AIRemainingPieces = 12;
        AIKings = 0;

        // set the turn
        turn = PLAYER_ONE;

        // create the buttons
        fillButtons();
    }

    // deep constructor
    public GameState(GameState GS) {
        /* we only have a shallow constructor because we only have primitive types */
        this.playerRemainingPieces = GS.playerRemainingPieces;
        this.playerKings = GS.playerKings;
        this.AIRemainingPieces = GS.AIRemainingPieces;
        this.AIKings = GS.AIKings;
        this.turn = GS.turn;
    }

    public void fillButtons() {
        /* this method will initialize the game-board with all the buttons
           by setting certain buttons to be clickable, making them a certain
           color, etc.
        */
    }

    @Override
    public String toString() {
        String playerTurn;
        if(turn == PLAYER_ONE) {
            playerTurn = "Human";
        } else {
            playerTurn = "AI";
        }
        System.out.println("Turn: " + playerTurn);

        System.out.println("AI pieces remaining: " + AIRemainingPieces);
        System.out.println("AI kings: " + AIKings);
        System.out.println("Player pieces remaining: " + playerRemainingPieces);
        System.out.println("Player kings: " + playerKings);

        // not sure if we should print out information for each button since we have 64
        // if we need to print out each button, what button relevant info should we print?
        return "";
    }

    public boolean showPossibleMoves(int player, Button b) {
       return true;
    }


}
