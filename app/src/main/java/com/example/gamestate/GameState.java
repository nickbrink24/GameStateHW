package com.example.gamestate;

import android.widget.Button;

import java.util.ArrayList;

public class GameState {

    /**
     * @Ethan I don't think we need to be implementing the players and AI for this assignment, but rather just
     * show that we can make a game board with pieces and that they are capable of being moved. However, keep the
     * turn variable to determine whose turn it is
     * <p>
     * In terms of the board itself, we could make an 8x8 2d array of Pieces where each index of the array
     * represents a square on the board so that it is easier to manipulate the pieces. This will also make it easier to
     * initialize and place the pieces in the constructor
     * <p>
     * For the deep copy, pass through a game state parameter into the constructor, and use the information of that
     * said parameter to create a new game state using that info
     * <p>
     * getter and setter for a piece at a specific coord of the 2d array
     * <p>
     * getter and setter for whose move it is
     * <p>
     * Two arraylists can be used to store the pieces that have been captured
     * <p>
     * Important methods to consider (work in progress) :
     * -Check to make sure the selected piece belongs to the player
     * -Check if a space is a valid move
     * -Check if a piece can be captured
     * -Check if a piece is promoted to a king
     * -Check winner
     * + anything else needed to be considered
     * <p>
     * I don't know which class to put this in, either main activity or game state, but an example simulation should be
     * created to show that all the above methods can be used. I don't think it needs to be intuitive and think we can just
     * hard code specific pieces to move to show all the methods work. Also need to display the action made to the screen and it must
     * be an appended string (doesn't replace old text)
     * <p>
     * Any other comments or ideas add below:
     */
   /* private final int PLAYER_ONE = 1;
    private final int PLAYER_AI = 2;

    private Button[][] gameButtons;
    private int playerRemainingPieces;
    private int playerKings;
    private int AIRemainingPieces;
    private int AIKings;
    private int turn;*/


    private Pieces[][] pieces; //2D array to represent board
    private ArrayList<Pieces> capturedBlack; //arrayList for captured Black pieces
    private ArrayList<Pieces> capturedRed; //arrayList for captured Red pieces
    private int turn; //indicate who's turn it is


    public GameState() {
        //make 8x8 array of pieces
        pieces = new Pieces[8][8];

        //make arrayLists for captured pieces
        capturedBlack = new ArrayList<Pieces>();
        capturedRed = new ArrayList<Pieces>();

        for (int row = 0; row < pieces.length; row++) {
            for (int col = 0; col < pieces[row].length; col++) {

                //fill first and third row with black pieces
                if (col == 0 || col == 2) {
                    if (row % 2 == 0) {
                        pieces[row][col] = new Pieces(0, Pieces.Colors.BLACK, row, col);
                    }
                }

                //fill second row with black pieces
                if (col == 1) {
                    if (row % 2 != 0) {
                        pieces[row][col] = new Pieces(0, Pieces.Colors.BLACK, row, col);
                    }
                }

                //fill sixth and eighth row with red pieces
                if (col == 5 || col == 7) {
                    if (row % 2 == 0) {
                        pieces[row][col] = new Pieces(0, Pieces.Colors.RED, row, col);
                    }
                }

                //fill seventh row with red pieces
                if (col == 6) {
                    if (row % 2 != 0) {
                        pieces[row][col] = new Pieces(0, Pieces.Colors.RED, row, col);
                    }
                }
            }
        }




       /* // initialize number of pieces each player has remaining
        playerRemainingPieces = 12;
        playerKings = 0;
        AIRemainingPieces = 12;
        AIKings = 0;*/

        // set the turn
        turn = 0;

        // create the buttons
        //fillButtons();
    }

    // deep constructor
    public GameState(GameState GS) {
        // we only have a shallow constructor because we only have primitive types
        /*this.playerRemainingPieces = GS.playerRemainingPieces;
        this.playerKings = GS.playerKings;
        this.AIRemainingPieces = GS.AIRemainingPieces;
        this.AIKings = GS.AIKings;
        this.turn = GS.turn;*/

        //transfer board to new gameState
        pieces = new Pieces[8][8];
        for (int row = 0; row < pieces.length; row++) {
            for (int col = 0; col < pieces[row].length; col++) {
                pieces[row][col] = GS.pieces[row][col];
            }
        }

        turn = GS.turn;

    }

    //return piece at certain index of board
    public Pieces getPieces(int row, int col) {
        return pieces[row][col];
    }

    //set piece at a certain point in board
    public void setPieces(int row, int col, Pieces piece) {
        piece.setX(row);
        piece.setY(col);
        pieces[row][col] = piece;
    }

    //get turn of player
    public int getTurn(){
        return turn;
    }

    //set move of player
    public void setTurn(int num) {
        turn = num;
    }

    //check if selected piece belongs to player
    public boolean checkPiece(int num, Pieces piece){
        return true;
    }

    //check if piece can move to square
    public boolean checkMove(int num, Pieces pieces){
        return true;
    }

    //check if piece can be promoted at its current position
    public boolean checkPromotion(Pieces pieces) {
        return true;
    }

    //check if a piece can be captured
    //num indicates player
    public boolean checkCapture(int num, Pieces selectedPiece, Pieces capturePiece){
        return true;
    }

    public void fillButtons() {
        // this method will initialize the game-board with all the buttons
        // by setting certain buttons to be clickable, making them a certain
        // color, etc.
    }

    @Override
    public String toString() {
      /*  String playerTurn;
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
        return "";*/
        return "test";
    }

    public boolean showPossibleMoves(int player, Button b) {
        return true;
    }
}
