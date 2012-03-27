package com.xu.zhu;
import java.util.ArrayList;
import java.util.List;

import cardgame.*;

public class ThreeBS {
	private Deck deck;
	private List<ThreeBSPlayer> players = new ArrayList<ThreeBSPlayer>();
	private List<Thread> playerThreads = new ArrayList<Thread>();
	private boolean isWaitingForPlayers;
	private boolean isRunning;
	
	private ThreeBS(int numCards) {
		deck = new Deck();
		deck.shuffle();
		
		isWaitingForPlayers = true;
		isRunning = true;
		startGame(numCards);
	}

	public static void main(String[] args) {
		// Start a game of 3-card BS with 2 players
		new ThreeBS(3);
	}
	
	public void startGame(int numCards) {
		while (isWaitingForPlayers) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		// players have joined; start game
		deck.deal(players, numCards);
		
		while (isRunning) {
			
		}
	}
	
	public void addPlayer(ThreeBSPlayer player) {
		players.add(player);
	}
}
