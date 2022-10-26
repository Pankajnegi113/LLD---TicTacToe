package com.java.ticTacToe.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Deque;

@Data
@AllArgsConstructor
public class Game {

    private Deque<Player> players;
    private Board board;
}
