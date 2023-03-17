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

        // set the turn
        turn = 0;


    }

    // deep constructor
    public GameState(GameState GS) {
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
        if (num == 0) {
            turn = 1;
        } else {
            turn = 0;
        }
    }

    //check if selected piece belongs to player
    public boolean checkPiece(int num, Pieces piece) {
        return true;
    }

    //check if piece can move to square
    //num indicates player
    public boolean checkMove(int num, Pieces selectedPiece) {
        if (selectedPiece.getType() == 0) {
            int x_coord = selectedPiece.getX();
            int y_coord = selectedPiece.getY();

            /********** FOR THE PLAYER **********/

            // if the y is 0, and it's the player's turn, the piece can only move
            // diagonally up and to the right
            if (y_coord == 0 && num == 0) {
                // if the only possible move is occupied (not null), the piece can't move
                if (this.pieces[x_coord + 1][y_coord - 1] != null || x_coord != 0) {
                    return false;
                } else {
                    return true;
                }

                // if the y is 7 and and it's the player's turn, the piece can only move
                // diagonally up and to the left
            } else if (y_coord == 7 && num == 0) {
                // if the only possible move is occupied (not null), the piece can't move
                if (this.pieces[x_coord - 1][y_coord - 1] != null || x_coord != 0) {
                    return false;
                } else {
                    return true;
                }

                // the piece can move either up/right or up/left
            } else if (num == 0) {
                if (this.pieces[x_coord - 1][y_coord + 1] != null && this.pieces[x_coord + 1][y_coord + 1] != null) {
                    // both possible moves are occupied
                    return false;
                } else {
                    return true;
                }
            }

            /******** FOR THE AI ********/

            // if the x is 0, and it's the AI's turn, the piece can only move
            // diagonally down and to the right
            if (x_coord == 0 && num == 1) {
                // if the only possible move is occupied (not null), the piece can't move
                if (this.pieces[x_coord + 1][y_coord - 1] != null) {
                    return false;
                } else {
                    return true;
                }

                // if the x is 7 and it's the AI's turn, the piece can only move
                // diagonally down and to the left
            } else if (x_coord == 7 && num == 1) {
                // if the only possible move is occupied (not null), the piece can't move
                if (this.pieces[x_coord - 1][y_coord - 1] != null) {
                    return false;
                } else {
                    return true;
                }

                // the piece can move either down/right or down/left
            } else if (num == 1) {
                if (this.pieces[x_coord - 1][y_coord - 1] != null
                        && this.pieces[x_coord + 1][y_coord - 1] != null) {
                    // both possible moves are occupied
                    return false;
                } else {
                    return true;
                }
            }


        } else {
            // the piece is a king
        }

        return false;
    }

    public boolean movePiece(Pieces currPos, Pieces newPos, Pieces.Colors colors) {
        if (colors == Pieces.Colors.BLACK) {
            if (currPos.getY() == 0) {
                if (newPos.getY() == currPos.getY() + 1 && newPos.getX() == currPos.getX() - 1) {
                    return true;
                } else if (currPos.getY() == 7) {
                    if (newPos.getY() == currPos.getY() - 1 && newPos.getX() == currPos.getX() - 1) {
                        return true;
                    }
                } else {
                    if ((newPos.getY() == currPos.getY() + 1 && newPos.getX() == currPos.getX() - 1) || (newPos.getY() == currPos.getY() - 1 && newPos.getX() == currPos.getX() - 1)) {
                        return true;
                    }
                }
            } else if (colors == Pieces.Colors.RED) {
                if (currPos.getY() == 0) {
                    if (newPos.getY() == currPos.getY() + 1 && newPos.getX() == currPos.getX() + 1) {
                        return true;
                    } else if (currPos.getY() == 7) {
                        if (newPos.getY() == currPos.getY() - 1 && newPos.getX() == currPos.getX() + 1) {
                            return true;
                        }
                    } else {
                        if ((newPos.getY() == currPos.getY() + 1 && newPos.getX() == currPos.getX() + 1) || (newPos.getY() == currPos.getY() - 1 && newPos.getX() == currPos.getX() + 1)) {
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }


    //check if piece can be promoted at its current position
    public boolean checkPromotion(Pieces pieces) {
        return true;
    }

    //check if a piece can be captured
    //num indicates player
    public boolean checkCapture(int num, Pieces selectedPiece, Pieces capturePiece) {
        // make sure the pieces are different in color, or else they can't capture
        // because they belong to the same player
        if (selectedPiece.getColor() == capturePiece.getColor()) {
            return false;
        }

        // now we know the pieces are different players
        int x_coord_selected = selectedPiece.getX();
        int y_coord_selected = selectedPiece.getY();
        int x_coord_captured = capturePiece.getX();
        int y_coord_captured = capturePiece.getY();

        // if the x coordinate of the captured piece is 0 or 7, the piece can't be captured
        if (x_coord_captured == 7 || x_coord_captured == 0) {
            return false;
        }

        // if the y coordinate of the captured piece is 0 or 7, the piece can't be captured
        if (y_coord_captured == 7 || y_coord_captured == 0) {
            return false;
        }

        // now just make sure the space to jump to isn't occupied
        // first check if the selected piece is just a regular piece vs a king
        if (selectedPiece.getType() == 0) {
            if (num == 0) {
                // the player is trying to capture
                if (x_coord_captured > x_coord_selected) {
                    // direction capture is up and to the right
                    if (this.pieces[x_coord_selected + 2][y_coord_selected + 2] != null) {
                        // capture space is occupied
                        return false;
                    } else {
                        // capture space isn't occupied
                        return true;
                    }
                } else {
                    // direction capture is up and to the left
                    if (this.pieces[x_coord_selected - 2][y_coord_selected + 2] != null) {
                        return false;
                    } else {
                        return true;
                    }
                }
            } else {
                // the AI is trying to capture
                if (x_coord_captured > x_coord_selected) {
                    // direction capture is down and to the right
                    if (this.pieces[x_coord_selected + 2][y_coord_selected - 2] != null) {
                        // capture space is occupied
                        return false;
                    } else {
                        // capture space isn't occupied
                        return true;
                    }
                } else {
                    // direction capture is down and to the left
                    if (this.pieces[x_coord_selected - 2][y_coord_selected - 2] != null) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }

        } else {
            // this piece is a king
            return false;
        }
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


}
