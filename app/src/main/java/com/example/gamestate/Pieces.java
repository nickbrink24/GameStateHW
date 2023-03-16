package com.example.gamestate;

public class Pieces {

    private String type; // type of the piece (regular or king)
    private String color; // color of the piece


    // Constructor
    public Pieces(String type, String color) {
        this.type = type;
        this.color = color;
    }

    // Getter and Setter methods for type
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }

    // Getter and Setter methods for color
    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    // toString method that prints the information of the piece
    @Override
    public String toString() {
        return ("Piece: " + type + ", Color: " + color);
    }
}

