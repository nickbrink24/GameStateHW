package com.example.gamestate;

import android.widget.Button;

public class GameState {

    /**
     * @Ethan
     *
     * I don't think we need to be implementing the players and AI for this assignment, but rather just
     * show that we can make a game board with pieces and that they are capable of being moved. However, keep the
     * turn variable to determine whose turn it is
     *
     * In terms of the board itself, we could make an 8x8 2d array of Pieces where each index of the array
     * represents a square on the board so that it is easier to manipulate the pieces. This will also make it easier to
     * initialize and place the pieces in the constructor
     *
     * For the deep copy, pass through a game state parameter into the constructor, and use the information of that
     * said parameter to create a new game state using that info
     *
     * getter and setter for a piece at a specific coord of the 2d array
     *
     * getter and setter for whose move it is
     *
     * Two arraylists can be used to store the pieces that have been captured
     *
     * Important methods to consider (work in progress) :
     *      -Check to make sure the selected piece belongs to the player
     *      -Check if a space is a valid move
     *      -Check if a piece can be captured
     *      -Check if a piece is promoted to a king
     *      -Check winner
     *      + anything else needed to be considered
     *
     * I don't know which class to put this in, either main activity or game state, but an example simulation should be
     * created to show that all the above methods can be used. I don't think it needs to be intuitive and think we can just
     * hard code specific pieces to move to show all the methods work. Also need to display the action made to the screen and it must
     * be an appended string (doesn't replace old text)
     *
     * Any other comments or ideas add below:
     *
     *
     *
     */
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
        // we only have a shallow constructor because we only have primitive types
        this.playerRemainingPieces = GS.playerRemainingPieces;
        this.playerKings = GS.playerKings;
        this.AIRemainingPieces = GS.AIRemainingPieces;
        this.AIKings = GS.AIKings;
        this.turn = GS.turn;
    }

    public void fillButtons() {
        // this method will initialize the game-board with all the buttons
        // by setting certain buttons to be clickable, making them a certain
        // color, etc.
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

        System.out.println("Player pieces remaining: " + playerRemainingPieces);
        System.out.println("Player kings: " + playerKings);
        System.out.println("AI pieces remaining: " + AIRemainingPieces);
        System.out.println("AI kings: " + AIKings);

        // not sure if we should print out information for each button since we have 64
        // if we need to print out each button, what button relevant info should we print?
        return "";
    }

    public boolean showPossibleMoves(int player, Button b) {
       return true;
    }
}
