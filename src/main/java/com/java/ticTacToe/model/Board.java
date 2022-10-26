package com.java.ticTacToe.model;

import lombok.Data;

@Data
public class Board {
    private int size;
    private Piece[][]board;

    public Board(int size) {
        this.size = size;
        this.board = new Piece[size][size];
    }
}
