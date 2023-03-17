package com.example.gamestate;

import android.graphics.ColorSpace;

public class Pieces {

    public enum Colors {
        BLACK, RED, EMPTY
    }
    private int type; // type of the piece (regular-0 or king-1)
    private Colors color; // color of the piece
    private int x; // x coord of piece
    private int y; // y coord of piece


    // Constructor
    public Pieces(int type, Colors color, int x, int y) {
        this.type = type;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    // Deep constructor
    public Pieces(Pieces p) {
        this.type = p.type;
        this.color = p.color;
    }

    // Getter and Setter methods for type
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }

    // Getter and Setter methods for color
    public Colors getColors() {
        return this.color;
    }
    public void setColor(Colors color) {
        this.color = color;
    }

    public int getX() { return this.x; }

    public void setX(int x) {this.x = x; }

    public int getY() { return this.y; }

    public void setY(int x) {this.x = y; }

    // toString method that prints the information of the piece
    @Override
    public String toString() {
        if (color == Colors.RED) {
            return "R\t";
        }
        else if (color == Colors.BLACK) {
            return "B\t";
        }
            return "E\t";
    }
}

