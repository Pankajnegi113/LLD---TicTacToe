package com.java.ticTacToe.model;


import lombok.Data;
import com.java.ticTacToe.enums.PieceTypeEnum;
@Data
public class Piece {

    private PieceTypeEnum pieceType;

    public Piece(PieceTypeEnum pieceType){
        this.pieceType=pieceType;
    }
}
