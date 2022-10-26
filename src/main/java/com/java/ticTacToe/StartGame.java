package com.java.ticTacToe;

import com.java.ticTacToe.enums.PieceTypeEnum;
import com.java.ticTacToe.model.*;

import java.util.*;

public class StartGame {

    public static void displayBoard(Board board){
        for(int i=0;i<board.getSize();i++){
            for(int j=0;j<board.getSize();j++){
                if(board.getBoard()[i][j]!=null) {
                    System.out.print("|" + board.getBoard()[i][j].getPieceType());
                }
                else{
                    System.out.print("|" + " ");
                }
            }
            System.out.println("|");
        }
    }

    public static void startTicTacToeGame(Game game){
        boolean noWinner = true;
        Board board = game.getBoard();
        Scanner s = new Scanner(System.in);
        while (noWinner){
           displayBoard(board);
           Player player =  game.getPlayers().removeFirst();
           System.out.println(player.getName()+" turn");
           System.out.println("Enter row: ");
           int row = s.nextInt();
           System.out.println("Enter col: ");
           int col = s.nextInt();
           if(row>=board.getSize() || row <0 || col<0 || col>= board.getSize()){
               System.out.println("Invalid row col selection, re-choose");
               game.getPlayers().addFirst(player);
               continue;
           }
           board.getBoard()[row][col] = player.getPiece();
           boolean wonGame= playerWinCheck(player,row,col,board);
           if(wonGame){
               noWinner=false;
               System.out.println(player.getName()+" has won the game");
               break;
           }
           boolean tieMatch = checkAllFilledTieMatch(board);
           if(tieMatch){
               System.out.println("Match Tie");
               break;
           }
           game.getPlayers().add(player);

        }

    }

    private static boolean checkAllFilledTieMatch(Board board) {
        boolean allFilled = true;
        for(int i=0;i< board.getSize();i++){
            for(int j=0;j<board.getSize();j++){
                if(board.getBoard()[i][j]==null){
                    allFilled = false;
                }
            }
        }
        return  allFilled;
    }

    private static boolean playerWinCheck(Player player, int row, int col, Board board) {
        boolean rowCheck=true;
        boolean colCheck=true;
        boolean diagCheck=true;
        boolean antiDiagCheck=true;

        for(int i=0;i<board.getSize();i++){
            if(board.getBoard()[row][i]!=player.getPiece()){
                rowCheck = false;
            }
        }

        for(int i=0;i<board.getSize();i++){
            if(board.getBoard()[i][col]!=player.getPiece()){
                colCheck = false;
            }
        }

        for(int i=0,j=0;i<board.getSize();i++,j++){
            if(board.getBoard()[i][j]!=player.getPiece()){
                diagCheck = false;
            }
        }

        for(int i=0,j=board.getSize()-1;i<board.getSize();i++,j--){
            if(board.getBoard()[i][col]!=player.getPiece()){
                antiDiagCheck = false;
            }
        }

        return rowCheck || colCheck || diagCheck || antiDiagCheck;
    }

}
