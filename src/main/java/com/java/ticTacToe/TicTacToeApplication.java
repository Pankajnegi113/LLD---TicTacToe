package com.java.ticTacToe;

import com.java.ticTacToe.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

@SpringBootApplication
public class TicTacToeApplication {

	public static void main(String[] args) {
//		SpringApplication.run(TicTacToeApplication.class, args);

		System.out.println("Enter Game Board size: ");
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		Board board = new Board(size);
		Player player1 = new Player("Player1", new PieceO());
		Player player2 = new Player("Player2", new PieceX());

		Deque<Player> playersListDeque = new LinkedList<>();
		playersListDeque.add(player1);
		playersListDeque.add(player2);
		Game game = new Game(playersListDeque,board);

		StartGame.startTicTacToeGame(game);
	}

}
